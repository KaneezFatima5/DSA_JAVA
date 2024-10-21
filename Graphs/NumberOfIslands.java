import java.util.ArrayList;
import java.util.*;
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numOdIsland=0;
        Boolean[][] visited= new Boolean[grid.length][grid[0].length];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i, j});
                }
            }
        }
        return numOdIsland;
    }
    public static void main(String args[]){
        String[][] grid = {
            {"1","1","1","1","0"},
            {"1","1","0","1","0"},
            {"1","1","0","0","0"},
            {"0","0","0","0","0"}
          };
        String[][] grid2 = {
            {"1","1","0","0","0"},
            {"1","1","0","0","0"},
            {"0","0","1","0","0"},
            {"0","0","0","1","1"}
          };
    }
}
