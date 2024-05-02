public class SortingAlgorithms {
    public static void main(String args[]){
        int[] arr ={18, 16, 882, 63, 87, 0, 4, 23, 23};
        bubbleSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }

    }
    //sorting in Ascending Order
    // time complexity O(n^2)
    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    // time complexity O(n^2)
    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-1; j++){
                int temp=arr[j];
                if(temp>arr[j+1]){
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    
}

