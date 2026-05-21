class Solution {
    private int[][] directions;
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // traverse 2d arr and bfs at each cell
        m = heights.length;
        n = heights[0].length;

        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

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
                if (p[row][col] && a[row][col]) {
                    res.add(List.of(row, col));
                }
            }
        }

        return res;

    }

    public void dfs(int[][] heights, int row, int col, boolean[][] seen) {
        seen[row][col] = true;

        for (int[] dir:directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !seen[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, newRow, newCol, seen);
            }
        }
    }

}
