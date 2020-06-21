//find-the-access-codes
public class Solution {
    public static int solution(int[] l) {
        // Your code here
        int count=0;
        int array [] = new int[l.length];
        for(int i =0;i<array.length;i++)
        {
            array[i]=0;
        }
        for(int i =0;i<l.length;i++)
        {
            for(int j =0;j<i;j++)
            {
                if(l[i]%l[j]==0)
                {
                    array[i]=array[i]+1;
                    count = count +array[j];
                }
            }
        } 
        return count;
    }
}
