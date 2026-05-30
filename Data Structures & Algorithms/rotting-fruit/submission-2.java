class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int freshCount = 0;
        int res = -1;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                int status = grid[i][j];

                if (status == 1) freshCount++;
                if (status == 2) q.offer(new int[]{i,j});
            }
        }

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i=0;i<n;i++) {
                int[] coord = q.poll();
                for (int[] dir:directions) {
                    int newRow = coord[0] + dir[0];
                    int newCol = coord[1] + dir[1];

                    if (newRow >=0 && newRow < grid.length && newCol>=0 && newCol <grid[0].length && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        q.offer(new int[]{newRow, newCol});
                        freshCount--;
                    }
                }
            }
            res++;
        }

        if (freshCount == 0) {
            return Math.max(res,0);
        }

        return -1;
    }
}
