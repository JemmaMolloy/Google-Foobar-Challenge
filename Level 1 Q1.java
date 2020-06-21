//i-love-lance-janice
public class Solution {
    public static int solution(int[] l) {
        // Your code here
        String out ="abcdefghijklmnopqrstuvwxyz;
        String in = "zyxwvutsrqponmlkjihgfedcba";
        String ans = "";
        for(int i =0;i<x.length();i++)
        {
            char y = x.charAt(i);
            int pos=in.indexOf(y);
            if(pos!=-1)
            {
                char z = out.charAt(pos);
                ans = ans + z;
            }
            else{
            ans = ans + y;
        } 
        return ans;
    }
}
