public class Q4 {

    //二维数组的查找
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        if(matrix[0].length==0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / m, j = mid % m;
            if(matrix[i][j] < target) left = mid + 1;
            else right = mid - 1;
        }
        int i= left / m, j = left % m;
        return left>0 && left < m*n-1 && matrix[i][j] == target;
    }
}
