package Arrays;

public class EscapeTheMatrix {
    public int[] array(int[][] arr){
        int[] spiral = new int[arr.length*arr[0].length];
        int z=0;
        int m=0;
        int j=0;
        int l=0;
        int n=0;
        for(m=0; m<arr.length; m++){
            for(j=m; j<arr[m].length-m; j++){
                spiral[z]=arr[m][j];
                z++;
            }
            for(l=m+1; l<arr.length-m; l++){
                spiral[z]=arr[j][l];
                z++;
            }
            for(n=j-1; n>arr[i].length+m; n--){
                spiral[z]=arr[l][n];
                z++;
            }
            m++;
            for(int o=n-1; o>arr.length+m; o--){
                spiral[z]=arr[o][n];
                z++;
            }
        }
        return spiral;
    }
}
