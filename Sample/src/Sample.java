
  
 
/*  import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.math.BigInteger; 
import java.util.Scanner;

  
 
  
 
 
  public class Solution {
	  
	 	private BigInteger[] solutions = new BigInteger[100]; 
	 	private int maxSolution=1; 

	 	public static void main(String[] args) { 
	 		 Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.  
	 		Solution sol = new Solution(); 
	 		Read input 
	 		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 		Scanner scan = new Scanner(System.in);
	 		         
	 		          String number=null; 
	 		          int numberInt=0; 
	 		          sol.solutions[0]=BigInteger.ZERO; 
	 		          sol.solutions[1]=BigInteger.ONE; 
	 		  	        while((number = scan.next()) != null){	    	        
	 		  		    	try{ 
	 		  		    		numberInt = Integer.parseInt(number); 
	 		  		    		if(numberInt>100){ 
	 		  		    			System.out.println("Error: Input number > 100"); 
	 		  			        	return; 
	 		  		    		} 
	 		  		    	}catch(NumberFormatException e){ 
	 		  		    		System.out.println("Error parsing line"+e); 
	 		  		        	return; 
	 		  		    	}    	 
	 		  		    	System.out.println(sol.fibbonacciSeries(numberInt)); 
	 		  	        } 
 		  		    	scan.close();
	 		      }	 

	 	
	 	public BigInteger fibbonacciSeries(int number){ 
	 		  		if(solutions[number]!=null) 
	 		  			return solutions[number]; 
	 		  		 
	 		  		for(int i=maxSolution+1;i<=number; i++){			 
	 		  			solutions[i]=solutions[i-1].add(solutions[i-2]); 
	 		  		} 
	 		  		maxSolution=number; 
	 		  		return solutions[number]; 
	 		  	} 

	  
	  
  */

	  import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


	  public class Sample {
		  
		    static String findNumber(List<Integer> arr, int k) {
		    	List<Integer> list = arr;
		    	int item = 0;
		    	for(int i: list){
		    		if(k==i){
				    	return "YES";
		    		}
		    	}
		    	return "NO";
		    }
		    
	     static List<Integer> oddNumbers(int l, int r) { 
	           if (r < l) { 
	        	   List<Integer> list = new ArrayList<Integer>();
	               return list; 
	           } 
	           Integer[] res = new Integer[(r - l) / 2 + 1]; 
	           int count = 0; 
	           for (int i = l; i <= r; i++) { 
	               if (i % 2 == 1) { 
	                   res[count++] = i; 
	              } 
	           } 
	           List<Integer> list22 = Collections.unmodifiableList(Arrays.asList(res));
	           //return Arrays.copyOf(res, count); 
			return list22;
	      } 

		    
		    public static void main(String[] args)  {
		        List<Integer> res1 = oddNumbers(3, 9); 
		                 for (Integer res : res1) { 
		                     System.out.println(res); 
		                  } 
		          
		         
		                 List<Integer> res2 = oddNumbers(2, 5); 
		                 for (Integer res : res2) { 
		                      System.out.println(res); 
		                  } 

		    }
	  } 
