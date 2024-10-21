package Arrays;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int[][] neighbours={{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int perimeter=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    int max_x=grid[0].length-1;
                    int max_y=grid.length-1;
                    for(int[] neighbour: neighbours){
                        int x=j+neighbour[1];
                        int y=i+neighbour[0];
                        if(x<0 || x>max_x || y<0 || y>max_y){
                            perimeter++;
                        }else if(grid[y][x]==0){
                            perimeter++;
                        }
                    }
                    
                }
            }
        }
        return perimeter;
    }
}
