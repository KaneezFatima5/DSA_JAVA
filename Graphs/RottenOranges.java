import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int minutes=0;
        int fresh=0;
        int rotten=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    rotten++;
                    q.add(new int[]{i, j});
                }
            }
        }
        if(fresh==0 ){
            return 0;
        }
        if(rotten==0){
            return -1;
        }
        int max_x=grid[0].length;
        int max_y=grid.length; 
        while (!q.isEmpty()) {
            int prevFresh=fresh;
            int size=q.size();
            for(int i=0; i<size; i++){
                int[] rott=q.poll();
                int curr_x=rott[1]; 
                int curr_y=rott[0]; 
                int x=rott[1]+1;
                int x1=rott[1]-1; 
                int y=rott[0]+1;  
                int y1=rott[0]-1;  
                if(x<max_x && grid[curr_y][x]==1){
                    grid[curr_y][x]=2;
                    fresh--;
                    rotten++;
                    q.add(new int[]{curr_y, x});
                }
                if(x1>=0 && grid[curr_y][x1]==1){
                    grid[curr_y][x1]=2;
                    fresh--;
                    rotten++;
                    q.add(new int[]{curr_y, x1});
                }
                if(y<max_y && grid[y][curr_x]==1){
                    grid[y][curr_x]=2;
                    fresh--;
                    rotten++;
                    q.add(new int[]{y, curr_x});
                }
                if(y1>=0 && grid[y1][curr_x]==1){
                    grid[y1][curr_x]=2;
                    fresh--;
                    rotten++;
                    q.add(new int[]{y1, curr_x});
                }
                
            }
            if(prevFresh>fresh){
                minutes++;
            }
        }
        if(fresh>0 ){
            return -1;
        }
        return minutes;

    }
    public static void createGrid(int[][] grid){
        grid[0][0]=2;
        grid[0][1]=1;
        grid[0][2]=1;

        grid[1][0]=1;
        grid[1][1]=1;
        grid[1][2]=0;

        grid[2][0]=0;
        grid[2][1]=1;
        grid[2][2]=1;
    }
    public static void main(String[] args){
        int[][] grid=new int[3][3];
        createGrid(grid);
        
    }
    // [2,1,1],
    // [1,1,1],
    // [0,1,2]]

    
}
