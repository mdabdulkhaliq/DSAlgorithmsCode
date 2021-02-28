/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int testCases = scan.nextInt();
		
		for(int i=0;i<testCases;i++){
    		int n = scan.nextInt();
    		
    		int[] arr = new int[n];
            
            for(int j=0;j<n;j++){
                arr[j] =  scan.nextInt();
            }

            int k = scan.nextInt();
            
            printFirstNegative(arr, n, k);
		}
	}
	
	private static void printFirstNegative(int[] arr, int n, int k){
	    int start=0;
	    int end=0;
	    
	    Queue<Integer> queue = new LinkedList<Integer>();
	    
	    while(end<n){
	        if(arr[end] < 0){
	           queue.add(arr[end]);
	        }
	        
	        if(end-start+1 < k){
	            end++;
	        } else {
	            if(queue.size() == 0){
	                System.out.print("0 ");
	            }else {
	                if(arr[start] == queue.peek().intValue()){
	                    System.out.print(queue.remove().intValue() + " ");
	                }else {
	                    System.out.print(queue.peek().intValue() + " ");
	                }
	            }
	            start++;
	            end++;
	        }
	    }
	    System.out.println("");
	}
	
	
}
