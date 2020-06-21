//queue-to-do
public class Solution {
    public static int solution(int start, int length) {
        //Your code goes here.
        int count =0;
        int checksum=0;
        
        while(count<length)
        {
            for(int i=0;i<length-count;i++){
                checksum^=start;
                start++;
                
                
            } 
            start+=count;
            count++;
            
        }
        return checksum;
    }
}
