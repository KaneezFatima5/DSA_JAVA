import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeros=new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    int[] dim={i, j};
                    zeros.add(dim);
                }
            }
        }
        for(int i=0; i<zeros.size(); i++){
            setRowsNColumns(zeros.get(i)[0], zeros.get(i)[1], matrix);
        }
    }
    public static void setRowsNColumns(int x, int y, int[][] matrix){\
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][y]!=0){
                matrix[i][y]=0;
            }
        }
        for(int i=0; i<matrix[x].length; i++){
            if(matrix[x][i]!=0){
                matrix[x][i]=0;
            }
        }
    }
}
