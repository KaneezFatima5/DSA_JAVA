package TwoPointerAlgorithm;
public class ContainerWithMostWater{
    public static void main(String args[]){
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.print(maxArea(arr));
    }
    public static int maxArea(int[] height) {
        int p1=0;
        int length=height.length-1;
        int p2=length;
        int maxA=0;
        while (p1<p2) {
            int area=Math.min(height[p1], height[p2])*length;
            if(height[p1]<height[p2]){
                p1++;
            }else{
                p2--;
            }
            length--;
            if(maxA<area){
                maxA=area;
            }
            
        }
        return maxA;
    }
}