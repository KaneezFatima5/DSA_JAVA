import java.util.ArrayList;
import java.util.*;
public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int numOfIsland=0;
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    countIslands(visited, grid, i, j);
                    System.out.println(numOfIsland);
                    numOfIsland++;
                }
            }
        }
        
        return numOfIsland;
    }
    public static void countIslands(boolean[][] visited, char[][] grid, int i, int j){
        if(grid[i][j]=='0' || visited[i][j]){
            return;
        }
        visited[i][j]=true;
        int[][] directions= {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int[] direction: directions){
            int x=i+direction[0];
            int y=j+direction[1];
            if(x>=0 && y>=0 && x<=grid.length && y<=grid[0].length && grid[x][y]=='1' && !visited[x][y]){
                System.out.println("printing axis"+ x +" "+y);
                countIslands(visited, grid, x, y);
            }
        }
    }
    public static void main(String args[]){
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
          };
        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
          };
        int numOfIsland=numIslands(grid);
        System.out.println(numOfIsland);

    }
}
