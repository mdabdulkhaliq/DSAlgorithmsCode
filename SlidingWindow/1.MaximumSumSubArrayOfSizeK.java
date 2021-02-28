//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int start = 0;
        int end = 0;
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        while(end < N){
            windowSum += Arr.get(end);
            if(end-start+1 < K){
                end++;
            } else {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= Arr.get(start);
                start++;
                end++;
            }
        }
        return maxSum;
    }
}
