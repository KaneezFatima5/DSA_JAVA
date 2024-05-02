public class MergeSort {
    public static void main(String args[]){
        int[] arr ={18, 16, 882, 63, 87, 0, 4, 23, 23};
        int[] arr3=mergeSort(arr, 0, arr.length-1);
        for(int i=0; i<arr3.length; i++){
            System.out.print(arr3[i] + ", ");
        }
    }
    public static int[] divide(int[] arr1, int[] arr2){
        int i=0;
        int j=0;
        int idx=0;
        int[] arr3=new int[arr1.length+arr2.length];
        while (i<arr1.length && j<arr2.length) {
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
        while (j<arr2.length) {
            arr3[idx]=arr2[j];
            idx++;j++;
        }
        return arr3;
    }
    public static int[] mergeSort(int[] arr, int lo, int hi){
        if(hi==lo){
            int[] temp= {arr[lo]};
            return temp;
        }
        int mid=(hi+lo)/2;
        int[] arr1=mergeSort(arr, lo, mid);
        int[] arr2=mergeSort(arr, mid+1, hi);
        int[] arr3=divide(arr1, arr2);
        return arr3;
    }
    
}
