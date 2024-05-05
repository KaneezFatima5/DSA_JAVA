package BinarySearchAlgorithm;

public class BinarySearch{
    public static void main(String[] args){
        int[] arr= {1, 3, 5, 6, 27, 99};
        int find=5;
        int index=binarySearch(arr, find);
        System.out.print(index);

    }
    public static int binarySearch(int[] arr, int find){
        int start=0;
        int end= arr.length-1;
        while(start<end){
            int mid=(start+end)/2;
            if(find==arr[mid]){
                return mid;
            }else if(find > arr[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}