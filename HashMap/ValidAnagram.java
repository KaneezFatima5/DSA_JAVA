package HashMap;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args){
        String s="ab";
        String t="ba";
        System.out.print(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        if(t.length()!=s.length()){
            return false;
        }
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            System.out.print(s.charAt(i)+" "+map.get(s.charAt(i)));
        }
        for(int i=0; i<t.length(); i++){
            if(!map.containsKey(t.charAt(i)) || map.get(t.charAt(i))<=0){
                return false;
            }else{
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
                System.out.print(s.charAt(i)+" "+map.get(s.charAt(i)));
            }
        }
        return true;
    }
}
