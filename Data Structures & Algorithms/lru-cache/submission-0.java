class LRUCache {

    private Map<Integer,Node> mapping;
    private int capacity;
    private Node head;
    private Node tail;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mapping = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!mapping.containsKey(key)) return -1;

        Node node = mapping.get(key);
        remove(node);
        addToTail(node);
        // remove node
        // move node to tail

        return node.value;
        
    }
    
    public void put(int key, int value) {
        Node node = mapping.get(key);

        if (node != null) {
            node.value = value;
            remove(node);
        } else {
            node = new Node(key, value);
            mapping.put(key, node);
        }

        addToTail(node);

        if (mapping.size() > capacity) {
            Node toBeRemoved = head.next;
            remove(toBeRemoved);

            mapping.remove(toBeRemoved.key);
        }
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public void addToTail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(){};
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


