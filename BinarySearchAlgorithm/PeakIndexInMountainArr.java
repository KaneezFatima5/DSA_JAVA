package BinarySearchAlgorithm;

public class PeakIndexInMountainArr {
    public static void main(String args[]){
        // int[] arr ={3,4,5,1};
        int[] arr ={0,10, 11,10, 8, 7, 5,2};
        System.out.print(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int lo=0;
        int hi=arr.length-1;
        int mid;
        while (lo<hi) {
            mid=(lo+hi)/2;
            // System.out.print( mid);
            // if(arr[lo]<arr[mid]){
            //     return lo;
            // }
            if(arr[mid]<arr[mid+1]){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return lo;

    }
}
