
class Solution {
	public void dfs(int i, int j, char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') return;

        grid[i][j] = '0';

        int[][] directions = new int[][] {{-1,0}, {1,0}, {0,1}, {0,-1}}; // up, down, right, left
 

        for(int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            dfs(newRow, newCol, grid);
        }
    }
	
	public int solve(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
 
        for(int i =0; i < rows; i++) {
            for(int j =0; j < cols; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i,j, grid);
                }
            }
        }

        return count;
    }
}

public class NumberOfIslands {

	
	public static void main(String[] args) {
		
	}

}
