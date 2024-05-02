public class QuickSort {
    public static void main(String args[]){
        int[] arr ={18, 16, 882, 63, 87, 0, 4, 23, 23};
        quickSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }

    }
    public static int divide(int pivot, int[] arr, int start){
        int j=start;
        for(int i=start; i<=pivot; i++){
            if(arr[i]<=arr[pivot]){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                j++;
            }
        }
        // System.out.print(j);
        return j-1;
    }
    public static void quickSort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int pivot=divide(end, arr, start);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);

    }
    
}
