import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main {
    /*
     * Complete the function below.
    */
	
	public static int fnumber(long input1,int[] input2){ 
		int max=0; 
		int result=-1; 
		int[] cities=Arrays.copyOf(input2, input2.length); 
		Arrays.sort(cities); 
		for(int F:cities){ 
			System.out.println("F:"+F);
		max=getMaxCount(input2, F); 
		System.out.println("Max in saveking:"+max);
		if(max>input1){ 
		result=F; 
		break;	
		} 
		} 
		return result; 
		} 
	public static int getMaxCount(int[] array,int number){ 
		int count=0; 
		int max=0; 
		int tempMax=0; 
		int j=0; 
		for(int i=0;i<array.length;i++){ 
		j=i; 
		count=0; 
		tempMax=0; 
		//tempMax=number;
		while(count<number && j<array.length){ 
		tempMax=tempMax+array[j]; 
		System.out.println("j:"+j+"|array:"+array[j]+"|Max:"+max+"|tempMax:"+tempMax);
		if(tempMax>max) 
		max=tempMax; 
		count++; 
		j++; 
		} 
		//checks it reached to last city, no further iterations are required. 
		if(j==array.length) 
		break; 
		} 
		return max; 
		}
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        long ip1 = Long.parseLong(in.nextLine().trim());
        int ip2_size = 0;
        ip2_size = Integer.parseInt(in.nextLine().trim());
        int[] ip2 = new int[ip2_size];
        int ip2_item;
        for(int ip2_i = 0; ip2_i < ip2_size; ip2_i++) {
            ip2_item = Integer.parseInt(in.nextLine().trim());
            ip2[ip2_i] = ip2_item;
        }
        output = fnumber(ip1,ip2);
        System.out.println(String.valueOf(output));
    }
}	