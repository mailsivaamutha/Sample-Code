import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.*;



class Result1 {

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

    public static int getExpenditure(int userId, int locationId, int netStart, int netEnd) {
        float transactions = 0;
        int page = 1;
        int total_pages = 1;
    	try{
	        URL urlForGetRequest = new URL("https://jsonmock.hackerrank.com/api/transactions/search?userId="+userId+"&page="+page);
	        String readLine = null;
	        Map<String, String> keyValueMap = new HashMap<String, String>();
	        List<Map<String, String>> listKeyValueMap = new ArrayList<Map<String, String>>();
	        List<String> jsonList = new ArrayList<String>();
	        List<String> keyValueList = new ArrayList<String>();
	        String dataString = new String();
	        while(page<=total_pages){
		        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		        conection.setRequestMethod("GET");
		        int responseCode = conection.getResponseCode();
		        if (responseCode == HttpURLConnection.HTTP_OK) {
		            BufferedReader in = new BufferedReader(
		                new InputStreamReader(conection.getInputStream()));
		            StringBuffer response = new StringBuffer();
		            while ((readLine = in .readLine()) != null) {
		                response.append(readLine);
		            } in .close();
		            //System.out.println("JSON String Result " + response.toString());
		            String[] pairs = response.toString().split("\\[");
		            String data = pairs[pairs.length-1];
		            total_pages = Integer.parseInt(keyValue(pairs[0], "\"total_pages\":", ","));
		            System.out.println("total_pages:"+total_pages+"data:"+dataString);
		            data = data.substring(0, data.length()-2); 
		            dataString = dataString+data;
		            page++;
			        } else {
			            System.out.println("GET NOT WORKED");
			        }
	        	}
	        
	            jsonList = patternMatch(dataString,jsonList,true);
	            
				for(String singleRecord : jsonList){
					singleRecord = singleRecord.substring(1, singleRecord.length()-1);
					System.out.println("singleRecord:"+singleRecord);
					keyValueList.add(singleRecord);
				}
	            
	            //Param paramArr[] = Param.values();
				String value = null;
				String[] paramArr = {"id","userId","userName","timestamp","txnType","amount","location","ip"};
				for(String pair : keyValueList){
					//System.out.println("pair:"+pair);
		            for(int i=0; i<paramArr.length; i++){

		            	if(i == paramArr.length-1)
		            	{
		            		String ip = paramArr[i]+"\":";
		            		//System.out.println(i+"last:"+pair.substring(pair.lastIndexOf(",") + 1));
		            		value = pair.substring(pair.lastIndexOf(ip) + ip.length());
		            		keyValueMap.put(paramArr[i], value);
		            		//System.out.println(value);
		            	}
		            	else{
		            		//System.out.println(keyValue(pair, "\""+paramArr[i]+"\":", ",\""+paramArr[i+1]+"\":"));
		            		value = keyValue(pair, "\""+paramArr[i]+"\":", ",\""+paramArr[i+1]+"\":");
		            		keyValueMap.put(paramArr[i], value);
		            	}
		            }
		            
		            listKeyValueMap.add(new HashMap<String, String>(keyValueMap));
				}
				
				for(int i=0; i<listKeyValueMap.size();i++){

					int uId = Integer.parseInt(listKeyValueMap.get(i).get("userId"));
					//System.out.println(listKeyValueMap.get(i).get("location").toString());
					String[] locationDetails = listKeyValueMap.get(i).get("location").split(",");
					int locId = Integer.parseInt(LocationParam(locationDetails,"id"));
					float amnt = Float.parseFloat(listKeyValueMap.get(i).get("amount").replaceAll("[$]|,|\"",""));
					String ip = listKeyValueMap.get(i).get("ip");
					String[] ipArray = ip.replaceAll("\"","").split("\\.");
					int ipStart = Integer.parseInt(ipArray[0]);
					System.out.println("amnt:"+amnt+"|ip:"+ipStart+"|uId:"+uId+"|userId:"+userId+"|locId:"+locId+"|locationId:"+locationId+"|netStart:"+netStart+"|netEnd:"+netEnd);
					if(uId==userId && locId==locationId && ipStart>netStart && ipStart<netEnd){
						transactions = transactions + amnt;
						System.out.println("transactions"+transactions);
					}
				}
				
/*	            String[] keyValuePairs = dataString.split(",");              
	            Map<String,String> map = new HashMap<>();               

	            for(String keyValuePair : keyValuePairs)                        
	            {
	            	System.out.println("keyValuePair:"+keyValuePair);
	                String[] entry = keyValuePair.split(":");                    
	                map.put(entry[0].trim(), entry[1].trim());          
	            }*/
	            
/*	            StringTokenizer st = new StringTokenizer(dataString);  
	            while (st.hasMoreTokens()) {  
	                String token = st.nextToken();
	            	System.out.println("token:"+token);
	                if(token.equals("userId"))
	                {
	                	int userIdValue = new Integer(st.nextToken());
	                	if(userIdValue == userId){
	                		System.out.println("userIdValue:"+userIdValue);
	                	}
	                	else
	                		break;
	                }

	            }  */
/*	            for (int i=0;i<pairs.length;i++) {
	                String pair = pairs[i];
	                //String[] keyValue = pair.split(":");
	                //json.put(keyValue[i], keyValue[i+1]);
		            
	            }*/

	            
	            
	            
	            
/*	        } else {
	            System.out.println("GET NOT WORKED");
	        }*/
    	}catch(NullPointerException ne){
    		System.err.println(ne);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
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
            //System.out.println("keyValue:"+keyValue);
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
    
/*    enum Param 
    { 
    	id,userId,userName,timestamp,txnType,amount,location,ip; 
    }*/

}
public class Result {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Ammu\\output.txt"));

        int userId = Integer.parseInt(bufferedReader.readLine().trim());

        int locationId = Integer.parseInt(bufferedReader.readLine().trim());

        int netStart = Integer.parseInt(bufferedReader.readLine().trim());

        int netEnd = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result1.getExpenditure(userId, locationId, netStart, netEnd);
        System.out.println("result:"+result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
