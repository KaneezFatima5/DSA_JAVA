public class MergeSort {
    public static void main(String args[]){

    }
    public static int[] divide(int[] arr1, int[] arr2){
        int i=0;
        int j=0;
        int idx=0;
        int[] arr3={};
        while (i<arr1.length || j<arr2.length) {
            if(arr1[i]<arr2[j]){
                arr3[idx]=arr1[i];
                i++;
            }else{
                arr3[idx]=arr2[j];
                j++;
            }
            idx++;
        }
        while (i<arr1.length) {
            arr3[idx]=arr1[i];
            idx++;i++;
        }
        while (j<arr1.length) {
            arr3[idx]=arr1[j];
            idx++;j++;
        }
        return arr3;
    }
    public static int[] mergeSort(int[] arr, int hi, int lo){
        if(hi==lo){
            return ;
        }
        int mid=(hi+lo)/2;
        int[] arr1=mergeSort(arr, lo, mid);
        int[] arr2=mergeSort(arr, mid+1, hi);
        int[] arr3=divide(arr1, arr2);
        return arr3;
    }
    
}
