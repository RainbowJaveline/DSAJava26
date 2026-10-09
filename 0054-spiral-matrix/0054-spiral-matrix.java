class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return answer;
        // Define boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // 1. Move Right across the top row
            for (int j = left; j <= right; j++) {
                answer.add(matrix[top][j]);
            }
            top++; // Move the top boundary down
            
            // 2. Move Down along the right column
            for (int i = top; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--; // Move the right boundary left
            
            // 3. Move Left across the bottom row (Check if row still exists)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    answer.add(matrix[bottom][j]);
                }
                bottom--; // Move the bottom boundary up
            }
            
            // 4. Move Up along the left column (Check if column still exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        return answer;
    }
}