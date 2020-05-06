/*import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
	  public class Solution {
		  
		  
		  	public static String election(String[] votes){


		        Map<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
		        for (String vote : votes) {
		            if (map.containsKey(vote)) {
		                map.put(vote, map.get(vote) + 1);
		            } else {
		                map.put(vote, 1);
		            }
		        }
		        //System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue())
		          //      .getKey());
				return Collections.max(map.entrySet(), Map.Entry.comparingByValue())
		                .getKey();
		    
		  	}
		    public static void main(String[] args) {
		        String[] votes1 = { "victor", "veronica", "ryan", "dave", "maria", "farah", "farah", "ryan", "veronica" };
		        System.out.println(election(votes1));
		    }
	  
		
		  public static void maximumCupcakes(List<String> trips){

	               int N = Integer.parseInt(temp[0]); 
	               int C = Integer.parseInt(temp[1]); 
	               int M = Integer.parseInt(temp[2]); 
	               int total = N/C; 
	               int wrappers = total; 
	               while (wrappers >= M){ 
	                   int free = wrappers/M; 
	                   total += free; 
	                   wrappers = free + wrappers%M; 
	               } 

			  StringBuffer sb = new StringBuffer();
              sb.append(total + "\n"); 
		                   for(String trip: trips){ 
		                      String[] temp = trip.split(" "); 
		                      int N = Integer.parseInt(temp[0]); 
		                      int C = Integer.parseInt(temp[1]); 
		                      int M = Integer.parseInt(temp[2]); 
		                      int total = N/C; 
		                      int wrappers = total; 
		                      while (wrappers >= M){ 
		                          int free = wrappers/M; 
		                          total += free; 
		                          wrappers = free + wrappers%M; 
		                      } 
		                      sb.append(total + "\n"); 
		                  } 
		                  System.out.print(sb); 


		  }

		    
		    public static void main(String[] args) { 
		         Scanner input = new Scanner(System.in); 
		                   int t = input.nextInt(); 
		                    
		                   for(int i = 0; i < t; i++) 
		                   { 
		                       int n = input.nextInt(); 
		                       int c = input.nextInt(); 
		                       int m = input.nextInt(); 
		                        
		                       int ate = 0; 
		                        
		                       int chocolates = n / c; 
		                        
		                      ate += chocolates; 
		           
		          
		                       while(chocolates >= m) 
		                       { 
		                           ate += chocolates / m; 
		                           chocolates = (chocolates / m) + (chocolates % m); 
		                       } 
		                       System.out.println(ate); 
		                   } 
		               } 


		  
	  
		
		    public static void main(String[] args) 
		    { 
		        String s1 = "geeks"; 
		        String s2 = "forgeeks"; 
		        System.out.println(merge(s1, s2)); 
		    } 
		  
		    // function for merging two strings 
		    public static String merge(String s1, String s2) 
		    { 
		        StringBuilder finalString = new StringBuilder(); 
		  
  
		        int i = 0, j = 0; 
		        while (i < s1.length() && j < s2.length()) { 

		            finalString.append(s1.charAt(i++)); 
		            finalString.append(s2.charAt(j++)); 
		        } 
		  
		        if (i != s1.length()) { 
		            finalString.append(s1.substring(i)); 
		        } 
		        if (j != s2.length()) { 
		            finalString.append(s2.substring(j)); 
		        } 
		        return finalString.toString(); 
		    } 

	  
	  
		public static void main(String args[]){
			String string = "a:e,b,cdde:ceewed,loc:{e:a,f:b},a,f";
			Pattern p = Pattern.compile("\\{.*?\\}|[^,]+");
			Matcher m = p.matcher(string);
			while (m.find())
			    System.out.println(m.group());
			System.out.println(string.replace(",a", ""));
			
			String prev = "for";
			String next = "Oscar";
			
            String str = "Nom:ee,for 3 Oscar: dom for 234235 Oscars";
            Pattern pattern = Pattern.compile(prev+"(.*?)"+next);
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
            System.out.println(str.substring(str.lastIndexOf(",for") + 1));
            
            keyValue(str, (prev), (next));
			String amt = "\"$3,611.80\"";
			System.out.println(amt.replaceAll("[$]|,|\"",""));
			String ip = "134.23.232.21";
			String[] ipArray = ip.split("\\.");
			System.out.println(ipArray.length);
		}
		
	    public static String keyValue(String singleRecord, String prev, String next){
	    	prev= ","+prev;
	    	next=next+":";
	        Pattern pattern = Pattern.compile(prev+"(.*?)"+next);
	        Matcher matcher = pattern.matcher(singleRecord);
	        String keyValue = null;
	        while (matcher.find()) {
	            keyValue = matcher.group(1);
	            System.out.println("keyValue:"+keyValue);
	        }
	        return keyValue;
	    }
	  } 
*/

import java.io.*;
/*import java.math.*;
import java.security.*;
import java.text.*;*/
import java.util.*;
/*import java.util.concurrent.*;
import java.util.function.*;*/
import java.util.regex.*;
/*import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;*/


import java.net.*;

class FindResult {

    /*
     * Complete the 'getExpenditure' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER userId
     *  2. INTEGER locationId
     *  3. INTEGER netStart
     *  4. INTEGER netEnd
     *
     *  https://jsonmock.hackerrank.com/api/transactions/search?userId=
     */

    public static int getExpenditure(int userId, int locationId, int netStart, int netEnd)     {
        float transactions = 0;
        int total_pages = 1;
        int page =1;
        
        do{
        	 System.out.println("Do");
	        try{
	        	 System.out.println("Try");
	            URL urlForGetRequest = new URL("https://jsonmock.hackerrank.com/api/transactions/search?userId="+userId+"&page="+page);
	            String readLine = null;
	            Map<String, String> keyValueMap = new HashMap<String, String>();
	            List<Map<String, String>> listKeyValueMap = new ArrayList<Map<String, String>>();
	            List<String> jsonList = new ArrayList<String>();
	            List<String> keyValueList = new ArrayList<String>();
	            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	            System.out.println("After connection");
	            conection.setRequestMethod("GET");
	            int responseCode = conection.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                BufferedReader in = new BufferedReader(
	                    new InputStreamReader(conection.getInputStream()));
	                StringBuffer response = new StringBuffer();
	                while ((readLine = in .readLine()) != null) {
	                    response.append(readLine);
	                } in .close();
	                String[] pairs = response.toString().split("\\[");
	                String dataString = pairs[pairs.length-1];
	                
	                /* Modifided Code*/
	                total_pages = Integer.parseInt(keyValue(pairs[0], "\"total_pages\":", ","));
	                System.out.println("total_pages:"+total_pages);
	                
	                dataString = dataString.substring(0, dataString.length()-2); 
	                jsonList = patternMatch(dataString,jsonList,true);
	                
	                System.out.println("dataString:"+dataString);
	                
	                for(String singleRecord : jsonList){
	                    singleRecord = singleRecord.substring(1, singleRecord.length()-1);
	                    keyValueList.add(singleRecord);
	                }
	                
	                String value = null;
	                String[] paramArr = {"id","userId","userName","timestamp","txnType","amount","location","ip"};
	                for(String pair : keyValueList){
	                    for(int i=0; i<paramArr.length; i++){
	                        if(i == paramArr.length-1)
	                        {
	                            String ip = paramArr[i]+"\":";
	                            value = pair.substring(pair.lastIndexOf(ip) + ip.length());
	                            keyValueMap.put(paramArr[i], value);
	                        }
	                        else{
	                            value = keyValue(pair, "\""+paramArr[i]+"\":", ",\""+paramArr[i+1]+"\":");
	                            keyValueMap.put(paramArr[i], value);
	                        }
	                    }
	                    
	                    listKeyValueMap.add(new HashMap<String, String>(keyValueMap));
	                }
	                
	                System.out.println("listKeyValueMap:"+listKeyValueMap.toString());
	                
	                for(int i=0; i<listKeyValueMap.size();i++){
	
	                    int uId = Integer.parseInt(listKeyValueMap.get(i).get("userId"));
	                    System.out.println("uId:"+uId);
	                    String[] locationDetails = listKeyValueMap.get(i).get("location").split(",");
	                    int locId = Integer.parseInt(LocationParam(locationDetails,"id"));
	                    System.out.println("locId:"+locId);
	                    float amnt = Float.parseFloat(listKeyValueMap.get(i).get("amount").replaceAll("[$]|,|\"",""));
	                    System.out.println("amnt:"+amnt);
	                    String ip = listKeyValueMap.get(i).get("ip");
	                    String[] ipArray = ip.replaceAll("\"","").split("\\.");
	                    int ipStart = Integer.parseInt(ipArray[0]);
	                    System.out.println("ipStart:"+ipStart);
	                    if(uId==userId && locId==locationId && ipStart>=netStart && ipStart<=netEnd){
	                        transactions = transactions + amnt;
	                        System.out.println("transactions"+transactions);
	                    }
	                }
	                
	                
	            } else {
	                System.out.println("GET NOT WORKED");
	            }
	        }catch(NullPointerException ne){
	            System.err.println(ne);
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	        ++page;
    	}while(page<=total_pages);
        return Math.round(transactions);
    
    }

        public static List<String> patternMatch(String string, List<String> list, boolean isConcat){
        Pattern p = Pattern.compile("\\{.*?\\}|[^,]+");
        Matcher m = p.matcher(string);
        int i=0;
        String record = "";
        while (m.find())
        {
            if(i==2)
            {
                i=0;
                record = "";
            }
            if(isConcat){
                if(record.isEmpty())
                    record = record.concat(m.group()+",");
                else
                    record = record.concat(m.group());
                if(i==1)
                    list.add(record);
            }
            else
                list.add(m.group());
            i++;
        }
        return list;
    }
    
    public static String keyValue(String singleRecord, String prev, String next){
        Pattern pattern = Pattern.compile(prev+"(.*?)"+next);
        Matcher matcher = pattern.matcher(singleRecord);
        String keyValue = null;
        while (matcher.find()) {
            keyValue = matcher.group(1);
        }
        return keyValue;
    }
    
    public static String LocationParam(String[] locationDetails, String param){
        Map<String,String> locationMap = new HashMap<String,String>();
        for (String location : locationDetails) {
            String keyValue = location.replaceAll("\\{|\\}|\"","");
            String[] keyValuePair = keyValue.split(":");
            if(keyValuePair.length==2)
                locationMap.put(keyValuePair[0], keyValuePair[1]);
            else
                locationMap.put(keyValuePair[0],keyValuePair[0]);
        }
        return locationMap.get(param);
    }


}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\ammu\\output.txt"));

        int userId = Integer.parseInt(bufferedReader.readLine().trim());

        int locationId = Integer.parseInt(bufferedReader.readLine().trim());

        int netStart = Integer.parseInt(bufferedReader.readLine().trim());

        int netEnd = Integer.parseInt(bufferedReader.readLine().trim());

        int result = FindResult.getExpenditure(userId, locationId, netStart, netEnd);
        System.out.println("result:"+result);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
