//hey-i-already-did-that
public class Solution {
    public static int solution(String n, int b) {
        //Your code here 
        //b between 2 and 10
        
        
        int x =0;//digits of n in decending order
        int y =0;//digits of n in acending order
        
        int arrayZ []= new int [100];
        int count=0;
        while(true)
        {
            int u =Integer.parseInt(n);
            if(u==0)
            {
                return 1;
            }
            for(int i=0;i<=count;i++)
            {
                if(arrayZ[i]==u)
                {
                    return count-i;
                }
            }
            
             arrayZ[count]=u;
             count++;
            //System.out.println(arrayZ[count]);
            int k =n.length();//between 2 and 9
            int arrayN [] = new int [k];
            for(int i=0;i<k;i++)
            {
                arrayN[i]=Integer.parseInt(n.substring(i,i+1));
            }
            for(int i=0;i<k;i++)
            {
                for(int j=0;j<k;j++)
                {
                    if(arrayN[i] > arrayN[j]) {    
                       int temp = arrayN[i];    
                       arrayN[i] = arrayN[j];    
                       arrayN[j] = temp;    
                   }    
                }
            }
            
            String X="";
            String Y="";
            for(int i=0;i<k;i++)
            {
                Y=arrayN[i]+Y;
                X=X+arrayN[i];
            }
            x=Integer.parseInt(X,b);
            y=Integer.parseInt(Y,b);
            String z = Integer.toString(x-y,b);
            int h =n.length()-z.length();
            if(h>0)
            {
                for(int i=0;i<h;i++)
                {
                    z="0"+z;
                }
            }
            n=z;
        }
    }
}
