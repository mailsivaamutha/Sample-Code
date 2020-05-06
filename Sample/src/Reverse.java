
public class Reverse {

	public static void main(String args[]){
		String a = "Hello and Welcome";
/*		String b = new StringBuilder(a).reverse().toString();
		System.out.println("a:"+a+"|b:"+b);*/
		
		System.out.println(reverse(a));
	}
	
	public static String reverse(String a){
		char[] c = a.toCharArray();
		char[] d = new char[c.length];
		int i = 0;
		int j = c.length-1;
		//System.out.println("c:"+new String(c)+"| Length D:"+d.length);
/*		if(reversed == null){
			d[i] = c[j];
			System.out.println(c[j]+"|"+reversed);
			i++;
			j--;
		}*/
		//System.out.println(a.length()+"|"+a+"|"+ reversed.length()+"|"+reversed);
		while(j>=0){
			d[i] = c[j];
			//System.out.println(c[j]+"| while"+d[i]);
			i++;
			j--;
		}
		return new String(d);
	}
	
}
