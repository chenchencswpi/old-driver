package mediumcompany;

/**
 * Question: Unique Path
 * https://docs.google.com/document/d/1KEHDDODcowzt-_7_b3I4Aj7RTGbpS7szsQPWAKwOIg8/edit 
 *
 * @author Jian Xu
 *
 */
public class Maze {
	
	public int uniquePaths(int m, int n) {
        int[][] mat = new int[m + 1][n + 1];
        mat[m - 1][n] = 1;
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                mat[r][c] = mat[r + 1][c] + mat[r][c + 1];
            } 
        }
        return mat[0][0];
    }
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int[][] res = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        res[obstacleGrid.length-1][obstacleGrid[0].length] = 1;
        for(int i = obstacleGrid.length - 1; i >= 0; i--){
            for(int j = obstacleGrid[0].length - 1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i+1][j] + res[i][j+1];
                }
            }
        }
        
        return res[0][0];
    }

}
