/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int noOfTestCases = scan.nextInt();
		
		while(noOfTestCases-- > 0){
		    String input = scan.next();
		    int noOfUniqueChars = scan.nextInt();
		    
		    int result = getLongestUniqueCharactersSubstring(input, noOfUniqueChars);
		    System.out.println(result);
		    
		}
		
	}
	
	private static int getLongestUniqueCharactersSubstring(String input, int noOfUniqueChars){
	    
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    
	    int windowStart = 0, windowEnd = 0, maxLength = 0;
	    
	    while(windowEnd < input.length()){
	        
	        if(map.containsKey(input.charAt(windowEnd))){
	            map.put(input.charAt(windowEnd), map.get(input.charAt(windowEnd)) + 1);    
	        } else {
	            map.put(input.charAt(windowEnd), 1);    
	        }
	        
	        if(map.size() < noOfUniqueChars){
	            windowEnd++;
	        }
	        else if(map.size() == noOfUniqueChars){
	            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
	            windowEnd++;
	        }
	        else if(map.size() > noOfUniqueChars){
	            while(map.size() > noOfUniqueChars){
	                if(map.containsKey(input.charAt(windowStart))){
	                    int value = map.get(input.charAt(windowStart));
	                    if(value == 1){
	                        map.remove(input.charAt(windowStart));
	                    } else {
	                        map.put(input.charAt(windowStart), value-1 );
	                    }
	                }
	                windowStart++;
	            }
	            
	            windowEnd++;
	        }
	    }
	        return maxLength > 0 ? maxLength: -1;
	}

    
}
