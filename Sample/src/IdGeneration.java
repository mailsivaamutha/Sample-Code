import java.util.Scanner;


public class IdGeneration {

	char[] idchars = {'0','1','2','3','4','5','6','7','8','9'};
	
	String generateId(int m){
		String id = null;
		
		if(m>9 || m==0)
		{
			System.out.println("Invalid input");
			return null;
		}
		System.out.println(m+":"+m+",char:"+idchars[m]);
		int idStart = Character.getNumericValue(idchars[m])-2;
		System.out.println("idStart:"+idStart);
		int idConse = idStart-1;
		String cont = String.format ("%d", idConse);
		System.out.println(idConse+":"+cont);
		if(m>0){
			id = String.format ("%d", idStart)+cont+cont+cont;
		}
		
		return id;
	}
	
	public static void main(String args[]){
		
		int a;
		System.out.println("Enter the m:");
		Scanner sc  = new Scanner(System.in);
		a = sc.nextInt();
		IdGeneration id1 = new IdGeneration();
		System.out.println("Id:"+id1.generateId(a));
	}
	
}
