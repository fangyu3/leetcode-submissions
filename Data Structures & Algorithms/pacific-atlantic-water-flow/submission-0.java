class Solution {
    private int[][] directions;
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // traverse 2d arr and bfs at each cell
        Set<List<Integer>> p = new HashSet<>();
        Set<List<Integer>> a = new HashSet<>();
        directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        m = heights.length;
        n = heights[0].length;

        for (int col=0; col<n; col++) {
            dfs(heights, 0, col, p);
            dfs(heights, m-1, col, a);
        }

        for (int row=0; row<m; row++) {
            dfs(heights, row, 0, p);
            dfs(heights, row, n-1, a);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                List<Integer> coord = List.of(row,col);
                if (p.contains(coord) && a.contains(coord)) {
                    res.add(coord);
                }
            }
        }

        return res;

    }

    public void dfs(int[][] heights, int row, int col, Set<List<Integer>> set) {
        set.add(List.of(row,col));

        for (int[] dir:directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !set.contains(List.of(newRow,newCol)) && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, newRow, newCol, set);
            }
        }
    }

}
