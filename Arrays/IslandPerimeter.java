package Arrays;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter=0;
        boolean[][] visisted=new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1 && !visisted[i][j]){
                    perimeter=countPerimeter(grid, i, j, visisted, perimeter);
                }            
            }
        }
        return perimeter;
    }
    public static int countPerimeter(int[][] grid, int i, int j, boolean[][] visisted, int perimeter){
        if(grid[i][j]==0 || visisted[i][j]){
            return perimeter;
        }
        visisted[i][j]=true;
        int[][] neighbours={{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int[] neighbour: neighbours){
            int x=i+neighbour[0];
            int y=j+neighbour[1];
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0){
                perimeter++;
            }else if(grid[x][y]==1 && !visisted[x][y]){
                perimeter=countPerimeter(grid, x, y, visisted, perimeter);
            }
        }
        return perimeter;
        
    }
}
