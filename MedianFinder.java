import java.util.ArrayList;

public class MedianFinder {
        ArrayList<Integer> arr;
    
        public MedianFinder() {
            arr=new ArrayList<>();
        }
        
        public void addNum(int num) {
            if(arr.size()>0 && num<arr.get(arr.size()-1)){
                for(int i=0; i<arr.size(); i++){
                    if(arr.get(i)>num){
                        arr.add(i, num);
                        return;
                    }
                }
            }
            arr.add(num);
        }
        
        public double findMedian() {
            double med=0.00;
            int mid=(0+arr.size()-1)/2;
            if(arr.size()%2==0){
                med=(double)((arr.get(mid)+arr.get(mid+1))/2.00);
            }else{
                med=(double)arr.get(mid);
            }
            return med;
        }
        public ArrayList<Integer> getArr(){
            return arr;
        }

        public static void main(String[] args){
            MedianFinder med=new MedianFinder();
            med.addNum(1);
            med.addNum(2);
            med.addNum(7);
            med.addNum(4);
            // med.addNum(2);
            // med.addNum(2);
            med.findMedian();
            ArrayList<Integer> arr=med.getArr();
            for(int i=0; i<arr.size(); i++){
                System.out.print(arr.get(i)+", ");
            }
        }
}
