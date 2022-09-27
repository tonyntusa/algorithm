package binary_search;

/**
 https://leetcode.com/problems/search-a-2d-matrix/

 Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.


 Example 1:


 Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 Output: true
 Example 2:


 Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 Output: false


 Constraints:

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 100
 -104 <= matrix[i][j], target <= 104
 */
public class Medium_74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        IDEA: Just imaging we searching target in sorted 1D array. It will do the same for 2D
            - Use Binary Search
                left = 0
                right = rows*cols - 1
                middle = left + (right - left)/2

                How to caculate middle value in 2D array
                    int mid_value = matrix[mid/cols][mid%cols]; // value at mid pointer
        */


        // define pointer
        int rows = matrix.length, cols = matrix[0].length; // Number of rows and columns
        int left = 0, right = rows*cols - 1; // left and right pointers

        while(left <= right){
            int mid = left + (right - left)/2; // mid pointer

            // Let assum as we do binary search for 1D array, if we want to get value for 2D array, use the below line of code
            // It means: mid_value = arr[mid] (1D Array) = matrix[mid/cols][mid%cols] (2D Array)
            // int mid_value = arr[mid];
            int mid_value = matrix[mid/cols][mid%cols]; // value at mid pointer

            if(target == mid_value){
                return true;
            } else if (target > mid_value){
                left = mid + 1;
            } else if (target < mid_value){
                right = mid - 1;
            }
        }

        return false;
    }
}
