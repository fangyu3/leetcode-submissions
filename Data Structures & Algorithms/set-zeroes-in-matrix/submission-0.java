class Solution {
    public void setZeroes(int[][] matrix) {
        // top row and leftmost column used to track which row & col to set to 0
        // traverse 2d arr and populate the tracker mentioned above
        // base on the tracker, traverse 2d arr again and update cells accordingly
        // need to update leftmost column and top row last, also need care for topleft cell as it duplicates


        int m = matrix.length;
        int n = matrix[0].length;

        boolean row1 = false;

        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0) {
                        row1 = true;
                    } else {
                        matrix[row][0] = 0 ;
                    }

                    matrix[0][col] = 0;
                }
            }
        }

        // traverse again, update base on row/col trackers

        for (int row=1; row<m; row++) {
            for (int col=1; col<n; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] ==0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // update row/col trackers arrays
        if (matrix[0][0] == 0) {
            for (int row=0; row<m; row++) {
                matrix[row][0] = 0;
            }
        } 

        if (row1) {
            for (int col=0; col<n; col++) {
                matrix[0][col] = 0;
            }
        }

    }
}
