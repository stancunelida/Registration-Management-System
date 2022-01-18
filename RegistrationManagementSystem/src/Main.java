import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
		int value = sc.nextInt();
		GuestsList list = new GuestsList(value);
		
		while (true) {
			System.out.println("\nAsteapta comanda sau apasa 1 pentru a se afisa lista de comenzi (help)");
			 value = sc.nextInt();
			switch (value) {
			case 1:
				list.help();
				break;
			case 2:
				list.add();
				break;
			case 3:
				list.check();
				break;
			case 4:
				list.remove();
				break;
			case 5:
				list.update();
				break;
			case 6: 
				list.guests();
				break;
			case 7: 
				list.waitlist();
				break;
			case 8: 
				list.available();
				break;
			case 9:
				list.guest_no();
				break;
			case 10:
				list.waitlist_no();
				break;
			case 11:
				list.subscribe_no();
				break;
			case 12:
				list.search();
				break;
			}
			if (value == 13) {
				System.out.println("La revedere!");
				break;
			}
			if (value > 13 || value < 1) {
				System.out.println("Nu ati introdus o comanda valida!");
			}
		}
		sc.close();
	}

}
