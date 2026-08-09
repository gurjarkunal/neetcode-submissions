class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];

        for (int i = 0; i < n; i++){
            if (matrix[i][m - 1] == target) return true;
            if (matrix[i][m - 1]  > target){
                arr = matrix[i];
                break;
            }
        }
        n = 0;
        m = m - 1;
        while (n <= m){
            int mid = n + (m - n) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] > target) m--;
            else n++;
        }
        return false;
    }
}
