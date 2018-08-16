import java.util.GregorianCalendar;
import java.util.Scanner;
class Q4p6{
	public static void main(String [] args){
		GregorianCalendar gcl = new GregorianCalendar();
		int year = gcl.get(GregorianCalendar.YEAR);
		int birth_year,ganzi;
		String ganzi_name="";
		Scanner s = new Scanner(System.in);
		System.out.print("Ãâ»ı³âµµ¸¦ ÀÔ·ÂÇÏ¼¼¿ä:");
		birth_year = s.nextInt();
		ganzi = birth_year%12;
		
		switch(ganzi){
			case 0:
			ganzi_name = "ãé";
			break;
			case 1:
			ganzi_name = "ë·";
			break;
			case 2:
			ganzi_name = "âù";
			break;
			case 3:
			ganzi_name = "ú¤";
			break;
			case 4:
			ganzi_name = "í­";
			break;
			case 5:
			ganzi_name = "õä";
			break;
			case 6:
			ganzi_name = "ìÙ";
			break;
			case 7:
			ganzi_name = "ÙÖ";
			break;
			case 8:
			ganzi_name = "òã";
			break;
			case 9:
			ganzi_name = "ŞÓ";
			break;
			case 10:
			ganzi_name = "çí";
			break;
			case 11:
			ganzi_name = "Ú±";
			break;
		}
		System.out.println("´ç½ÅÀÇ ¶ì´Â " + ganzi_name + "ÀÔ´Ï´Ù.\n");
	}
}
			
			
			
			
			