import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class AlphabetOrder {

	public static void main(String args[]){
		List<String> newList = Arrays.asList("AB", "CD", "CE", "DE", "AC", "BC");
		char[] chrs;
		Set<Character> charSet = new TreeSet<>();
/*			for (Iterator<String> iterator = newList.iterator(); iterator.hasNext();) 
			{
				String string = (String) iterator.next();
				chrs = string.toCharArray();
				for (int i = 0; i < chrs.length; i++) {
				char c = chrs[i];
				charSet.add(c);
			}
		}*/
		
			
			Iterator<String> iterator = newList.iterator();
				while(iterator.hasNext()){
					String string = (String) iterator.next();
					chrs = string.toCharArray();
					for (int i = 0; i < chrs.length; i++) {
					char c = chrs[i];
					charSet.add(c);
				}
			}	
			
		System.out.println(charSet);
		}
}

