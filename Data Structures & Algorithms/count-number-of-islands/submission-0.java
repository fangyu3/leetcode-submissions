class Solution {
    private int[][] directions;
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        // traverse 2d array, whenever encounter 1 do dfs/bfs to get all connected lands
        // mark the lands seen as visited so we dont traverse does again
        // increment count as we exit the if

        m = grid.length;
        n = grid[0]. length;
        directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int res = 0;
        boolean[][] seen = new boolean[m][n];

        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (grid[row][col] == '1' && !seen[row][col]) {
                    dfs(grid, seen, row, col);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, boolean[][] seen, int row, int col) {
        if (seen[row][col]) return;

        seen[row][col] = true;

        for (int[] dir:directions) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];

            if (newRow >=0 && newRow<m && newCol >=0 && newCol < n && grid[newRow][newCol]=='1' && !seen[newRow][newCol]) {
                dfs(grid,seen,newRow,newCol);
            }
        }

        return;
    }
}
