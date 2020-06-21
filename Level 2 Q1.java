//please-pass-the-coded-messages
public class Solution {
    public static long c=0;
    public static int solution(int[] l) {
        // Your code here
        String str = ""; 
        for(int i=0;i<l.length;i++)
        {
            str=str+l[i];
        }
        
        permutation("", str);
        if(c>0)
        {
            return (int)c;
        }
        else{
            return 0;
        }
        
    } 
      private static void permutation(String prefix, String str)
    {
        long n = str.length();
        if (n == 0)
        {
            if(prefix!="")
            {
                long q =Long.parseLong(prefix);
               
                if(q%3==0&&q>c&&q!=0)
                {
                    c=q;
                }
                
            }
        
        }
