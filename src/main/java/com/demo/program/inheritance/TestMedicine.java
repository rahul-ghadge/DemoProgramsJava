package Assignment;
import java.util.Random;

public class TestMedicine 
{
    public static void main(String[] args) 
    {	
		Random random = new Random();
		Medicine[] medicines = new Medicine[10];
		int choice = random.nextInt(3);
		
		
		for(int i=0;i<medicines.length;i++) {
			
			if(choice == 0) {
				medicines[i] = new Tablet("Medicine - Tablet","Nagpur, Maharashtra");
				medicines[i].displayLabel();
			}
			else if(choice == 1) {
				medicines[i] = new Syrup("Medicine - Syrup","Pune, Maharashtra");
				medicines[i].displayLabel();
			}
			else if(choice == 2) {
				medicines[i] = new Ointment("Medicine - Ointment", "Noida, Delhi");
				medicines[i].displayLabel();
			}
	
			System.out.println();
		}
		
		
	
		
		
	}
}