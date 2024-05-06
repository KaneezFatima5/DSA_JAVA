package BinarySearchAlgorithm;

public class IsBadVersion {
    public static Boolean isBadVersion(int n){
        return true;
    }
    public int firstBadVersion(int n) {
        int mid;
        int lo=1;
        int hi=n;
        while(lo<hi){
            mid=(lo+hi)/2;
            if(isBadVersion(mid)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return hi;
    }
}
