package BinarySearchAlgorithm;

public class MinInRotatedSortedArr {
    public static void main(String args[]){
        int[] arr={3,4,5,1,2};
        int min=MinInSortedArr(arr);
        System.out.print(min);
    }
    public static int MinInSortedArr(int[] arr){
        int lo=0;
        int hi=arr.length-1;
        int mid;
        while (lo<hi) {
            mid=(lo+hi)/2;
            if(arr[lo]<arr[hi]){
                return arr[lo];
            }
            if(arr[mid]<arr[hi]){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return arr[lo];
    }
}
