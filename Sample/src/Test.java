import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;


class Cape{
	static int cape = -0;
	
	public static void displayCapeGemini(){
		System.out.println("Cape"+" "+cape);
	}
}
class Gemini extends Cape{
	static int gemini = 9999;
	
	public static void displayCapeGemini(){
		System.out.println("Gemini"+" "+gemini);
	}
}
public class Test{

	public static void main(String[] args) {
/*		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(6);
		l.add(5);
		Collections.sort(l);
		l.add(2);
		Collections.reverse(l);
		System.out.println(l);*/
		Cape cape = new Gemini();
		cape.displayCapeGemini();

}

		
		
	}

