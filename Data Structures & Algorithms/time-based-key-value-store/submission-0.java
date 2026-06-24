class TimeMap {

    private Map<String, List<MyObj>> mapping;

    public TimeMap() {
        mapping = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mapping.computeIfAbsent(key, x->new ArrayList()).add(new MyObj(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<MyObj> list = mapping.get(key);
        String res = "";


        if (list == null) {
            return res;
        }

        int l = 0;
        int r = list.size()-1;

        while (l<=r) {
            int mid = l+(r-l)/2;
            MyObj obj = list.get(mid);

            if (obj.timestamp > timestamp) {
                r = mid-1;
            } else {
                res = obj.value;
                l = mid+1;
            }
        }

        return res;
    }
}

class MyObj {
    private String value;
    private int timestamp;

    public MyObj(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
