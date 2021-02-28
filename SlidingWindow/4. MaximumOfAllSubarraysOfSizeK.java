// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        
        if(pat.length() == 0 || txt.length() == 0)
            return 0;
        
        //Maintain a count to check if there is atleast one character with value > 0
        int count = 0, answer=0;
        //Add all the characters to hashmap with the count
        Map<Character, Integer> hm = new HashMap<Character, Integer>(); 
        
        for(int i=0;i<pat.length();i++)
        {
            if(hm.containsKey(pat.charAt(i))){
                hm.put(pat.charAt(i), hm.get(pat.charAt(i)) + 1);
            }else{
                hm.put(pat.charAt(i), 1);
                count++;
            }
        }
        
        int start = 0, end = 0, n = txt.length(), k = pat.length(), value = 0;
        
        while(end<n){
            if(hm.containsKey(txt.charAt(end))){
                value = hm.get(txt.charAt(end));
                if(value == 1){
                    count--;
                }
                hm.put(txt.charAt(end), value - 1);
            }
            
            
            if(end-start+1 < k){
                end++;
            }
            else {
                if(count == 0){
                    answer++;
                }
                if(hm.containsKey(txt.charAt(start))){
                    value = hm.get(txt.charAt(start));
                    if(value == 0){
                        count++;
                    }
                    hm.put(txt.charAt(start), value + 1);
                }
                start++;
                end++;
            }
        }
    
        return answer;
    }
    
}
