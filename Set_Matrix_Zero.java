/** Leetcode-73: Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place. **/



class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col = false;
        boolean row = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                col = true;
                break;
            }
        }
        
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                    row = true;
                    break;
                }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (col) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (row) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
} 