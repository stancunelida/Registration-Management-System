import java.util.ArrayList;
import java.util.Scanner;

public class GuestsList {
	
	private ArrayList <Guest> theList;
	private ArrayList <Guest> waitingList;
	private int limitOfList;
	
	//constructor
	public GuestsList(int limit) {
		this.limitOfList = limit;
		this.theList = new ArrayList<>();
		this.waitingList = new ArrayList<>();
	}
	
	// getting data from user with a Scanner
	Scanner sc = new Scanner(System.in);
	
	
	//adding Guests to GuestList
	public int add () {
		
		// get data from User
		System.out.println("Se adauga o noua persoana…");
		System.out.println("Introduceti numele de familie: ");
		String numeFamilie = sc.next();
		System.out.println("Introduceti prenumele: ");
		String prenume =  sc.next();
		System.out.println("Introduceti email: ");
		String email = sc.next();
		System.out.println("Introduceti numar de telefon: ");
		String numarTelefon = sc.next();

		
		//Creating object Guest
		Guest g = new Guest(prenume,numeFamilie,email,numarTelefon);
		
		//verify Guest fields in GuestList to avoid duplicates.
		for (Guest guest: theList) {
			if (g.equalsToFirstNameAndLastName(guest)) {
				System.out.println("Eroare! Participant cu acelasi nume si prenume inscris deja in lista!");
				return -1;
				
			} else if (g.equalsToEmail(guest)) {
				System.out.println("Eroare! Participant cu acelasi email inscris deja in lista!");
				return -1;
				
			} else if (g.equalsToPhoneNumber(guest)) {
				System.out.println("Eroare! Participant cu acleasi numar de telefon inscris deja in lista!");
				return -1;
			}
		}
		
		//verify if adding a Guest to theList can be possibile if adding is less then the limitOfList
		if (theList.size() < limitOfList) {
			theList.add(g);
			System.out.println("Felicitari " + g.getFirstName() + " " + g.getLastName() + "! Locul tau la eveniment este confirmat. Te asteptam!.");
			return 0;
		}
		
		waitingList.add(g);
		System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine <" + waitingList.size() + ">. "
				+ "Te vom notifica daca un loc devine disponibil.");
		return waitingList.size();
	}
	
	// overloading function add for easier testing results
	public int add (Guest g) {
		//verify Guest fields in GuestList to avoid duplicates.
		for (Guest guest: theList) {
			if (g.equalsToFirstNameAndLastName(guest)) {
				System.out.println("Eroare! Participant cu acelasi nume si prenume inscris deja in lista!");
				return -1;
						
			} else if (g.equalsToEmail(guest)) {
				System.out.println("Eroare! Participant cu acelasi email inscris deja in lista!");
				return -1;
						
			} else if (g.equalsToPhoneNumber(guest)) {
				System.out.println("Eroare! Participant cu acleasi numar de telefon inscris deja in lista!");
				return -1;
			}
		}
				
			//verify if adding a Guest to theList can be possibile if adding is less then the limitOfList
			if (theList.size() < limitOfList) {
				theList.add(g);
				System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!.");
				return 0;
			}
				
			waitingList.add(g);
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine <" + waitingList.size() + ">. "
						+ "Te vom notifica daca un loc devine disponibil.");
			return waitingList.size();
	}
	
	
	//check in theList & waitingList
	public boolean check() {
		
		//get data from criteria for check in list or waiting list
		System.out.println("Dupa ce criteriu doriti sa cautati?\n\t"
				+ "1. Nume si Prenume\n\t"
				+ "2. Email \n\t"
				+ "3. Numar de telefon \n"
				+ "Va rugam sa introduceti doar cifrele 1, 2 sau 3");
		
		int n = sc.nextInt();
		
		// Error: not choosing one of 3 methods of search
		if (n > 3 && n < 1) {
			System.out.println("Nu ati introdus una din cifrele 1, 2 sau 3");
			return false;
		}
		
		//case 1: first name & last name
		if (n == 1) {
			
			//get user data for case 1
			System.out.println("Introduceti numele de familie: ");
			String secondName = sc.next();
			System.out.println("Introduceti prenumele: ");
			String firstName = sc.next();
			
			//searching Guest by name in theList
			for (Guest i : theList) {
				if ((i.getFirstName().toLowerCase().compareTo(firstName.toLowerCase()) == 0) && (i.getLastName().toLowerCase().compareTo(secondName.toLowerCase()) == 0)) {
					System.out.println("Persoana " + firstName + " " + secondName + " se afla pe lista de invitati");
					return true;
				}
			}
			
			//searching Guest by name in waitingList
			for (Guest i : waitingList) {
				if ((i.getFirstName().toLowerCase().compareTo(firstName.toLowerCase()) == 0) && (i.getLastName().toLowerCase().compareTo(secondName.toLowerCase()) == 0)) {
					System.out.println("Persoana " + firstName + " " + secondName + " este pe lista de asteptare!");
					return true;
				}
			}
		}
		
		//case 2: email
		if (n == 2) {
			
			//get user data for case 2
			System.out.println("Introduceti numele de email-ul: ");
			String mail = sc.next();
			System.out.println();
			
			//finding out if the email it's on the main list
			for (Guest i : theList) {
				if (i.getEmail().toLowerCase().compareTo(mail.toLowerCase()) == 0) {
					System.out.println("Persoana cu email-ul: " + mail + " se afla pe lista de invitati");
					return true;
				}
			}
			
			//finding out if the email it's on the waiting list
			for (Guest i : waitingList) {
				if (i.getEmail().toLowerCase().compareTo(mail.toLowerCase()) == 0) {
					System.out.println("Persoana cu email-ul: " + mail + " este pe lista de asteptare");
					return true;
				}
			}
		}
		
		//case 3: Phone Number
		if (n == 3) {
			//get data user
			System.out.println("Introduceti numarul de telefon: ");
			String num = sc.next();
			sc.close();
			
			//search in main list with phone number
			for (Guest i : theList) {
				if (i.getPhoneNumber().toLowerCase().compareTo(num.toLowerCase()) == 0) {
					System.out.println("Persoana cu numarul de telefon: " + num + " se afla pe lista de invitati");
					return true;
				}
			}
			
			//search in waiting list with phone number
			for(Guest i : waitingList) {
				if(i.getPhoneNumber().toLowerCase().compareTo(num.toLowerCase()) == 0) {
					System.out.println("Persoana cu numarul de telefon: " + num + " se afla pe lista de asteptare");
					return true;
				}
			}
		}
		
		System.out.println("Persoana cautata, nu se afla in lista de invitati si nici in cea de asteptare.");
		return false;
	}
	
	
	//remove a Guest from theList or from the waitingList
	public boolean remove() {
		//get data for remove
		System.out.println("Dupa ce criteriu doriti sa cautati si sa stergeti persoana?\n\t"
				+ "1. Nume si Prenume\n\t"
				+ "2. Email \n\t"
				+ "3. Numar de telefon \n"
				+ "Va rugam sa introduceti doar cifrele 1, 2 sau 3");
		
		int n = sc.nextInt();
		
		// Error: not choosing one of 3 methods for remove
		if (n > 3 && n < 1) {
			System.out.println("Nu ati introdus una din cifrele 1, 2 sau 3");
			return false;
		}
		
		//case 1
		if (n == 1) {
			
			//get user data for case 1
			System.out.println("Introduceti numele de familie: ");
			String secondName = sc.next();
			System.out.println("Introduceti prenumele: ");
			String firstName = sc.next();
			
			//remove Guest by name in theList
			boolean guestOnMainList = false;
			for (Guest i : theList) {
				if ((i.getFirstName().toLowerCase().compareTo(firstName.toLowerCase()) == 0) && (i.getLastName().toLowerCase().compareTo(secondName.toLowerCase()) == 0)) {
					theList.remove(i);
					System.out.println("Stergerea persoanei s-a realizat cu succes.");
					boolean result =  waitingList.isEmpty();
					guestOnMainList = true;
					if (result == false) {
						theList.add(waitingList.get(0));
						System.out.println("Felicitari " + waitingList.get(0).getFirstName() + " " + waitingList.get(0).getLastName() + "! S-a eliberat un loc pe lista invitatilor."
								+ "Te asteptam la eveniment!");
						waitingList.remove(0);
					}
					return true;
				}
			}
			//remove Guest by name in waitingList
			if (guestOnMainList == false) {
				for (Guest i : waitingList) {
					if ((i.getFirstName().toLowerCase().compareTo(firstName.toLowerCase()) == 0) && (i.getLastName().toLowerCase().compareTo(secondName.toLowerCase()) == 0)) {
						waitingList.remove(i);
						System.out.println("Stergerea persoanei s-a realizat cu succes.");
						return true;
					}
				}
			}
		}
		
		//case 2: email
		if(n == 2){
			
			//get user data for case 2
			System.out.println("Introduceti numele de email-ul: ");
			String mail = sc.next();
			System.out.println();
			
			//remove Guest by email in theList & add person from waitingList to theList
			boolean guestOnMainList = false;
			for (Guest i : theList) {
				if (i.getEmail().toLowerCase().compareTo(mail.toLowerCase()) == 0) {
					theList.remove(i);
					System.out.println("Stergerea persoanei s-a realizat cu succes.");
					boolean result =  waitingList.isEmpty();
					guestOnMainList = true;
					
					if (result == false) {
						theList.add(waitingList.get(0));
						System.out.println("Felicitari " + waitingList.get(0).getFirstName() + " " + waitingList.get(0).getLastName() + "! S-a eliberat un loc pe lista invitatilor."
								+ "Te asteptam la eveniment!");
						waitingList.remove(0);
					}
					return true;
				}
			}
			
			//remove Guest by email in waitingList
			if (guestOnMainList == false) {
				for (Guest i : waitingList) {
					if (i.getEmail().toLowerCase().compareTo(mail.toLowerCase()) == 0) {
						waitingList.remove(i);
						System.out.println("Stergerea persoanei s-a realizat cu succes.");
						return true;
					}
				}
			}
		}
		
		//case 3: phoneNumber
		if (n == 3) {
			
			//get user data for case 3
			System.out.println("Introduceti numele de numarul de telefon: ");
			String num = sc.next();
			System.out.println();
			
			//remove Guest by phoneNumber in theList & add person from waitingList to theList
			boolean guestOnMainList = false;
			for (Guest i : theList) {
				if (i.getPhoneNumber().toLowerCase().compareTo(num.toLowerCase()) == 0) {
					theList.remove(i);
					System.out.println("Stergerea persoanei s-a realizat cu succes.");
					boolean result =  waitingList.isEmpty();
					guestOnMainList = true;
					
					if (result == false) {
						theList.add(waitingList.get(0));
						System.out.println("Felicitari " + waitingList.get(0).getFirstName() + " " + waitingList.get(0).getLastName() + "! S-a eliberat un loc pe lista invitatilor."
								+ "Te asteptam la eveniment!");
						waitingList.remove(0);
					}
					return true;
				}
			}
			
			//remove Guest by phoneNumber in waitingList
			if (guestOnMainList == false) {
				for (Guest i : waitingList) {
					if (i.getPhoneNumber().toLowerCase().compareTo(num.toLowerCase()) == 0) {
						waitingList.remove(i);
						System.out.println("Stergerea persoanei s-a realizat cu succes.");
						return true;
					}
				}
			}
			
		}
		
		System.out.println("Persoana in cauza, nu a fost gasitia in nici o lista!");
		return false;
	}
	
	//rewrite check for internal use (for firstName and secondName)
	private int checkTheList (int n, String firstName, String secondName) {
		// Error: not choosing one of 3 methods of search
		if (n != 1) {
			return -1;
		}
		for (Guest i : theList) {
			if ((i.getFirstName().toLowerCase().compareTo(firstName.toLowerCase()) == 0) && (i.getLastName().toLowerCase().compareTo(secondName.toLowerCase()) == 0)) {
				return theList.indexOf(i);
			}
		}
		return -1;
	}
	
	//rewrite check for internal use of email or phoneNumber
	private int checkTheListEmailOrNumber(int n, String emailPhoneNumber) {

		if (n == 2) {
			for (Guest i : theList) {
				if ((i.getEmail().toLowerCase().compareTo(emailPhoneNumber.toLowerCase())) == 0) {
					return theList.indexOf(i);
				}
			}
		} else {
			for (Guest i : theList) {
				if ((i.getPhoneNumber().toLowerCase().compareTo(emailPhoneNumber.toLowerCase())) == 0) {
					return theList.indexOf(i);
				}
			}
		}
		return -1;
	}

	
	//update method for Guests in theList
	public boolean update() {
		
		//get data from user
		System.out.println("Se actualizeaza detaliile unei persoane…");
		System.out.println("Alege modul de autentificare, tastand:\r\n"
				+ "\"1\" - Nume si prenume\r\n"
				+ "\"2\" - Email\r\n"
				+ "\"3\" - Numar de telefon");
		int dataUser = sc.nextInt();
		
		// Error: not choosing one of 3 methods for remove
		if (dataUser > 3 || dataUser < 1) {
			System.out.println("Nu ati introdus una din cifrele 1, 2 sau 3");
			return false;
		}
		
		String lastName, firstName, email, phoneNumber;
		
		//case 1: for firstName and lastName
		if (dataUser == 1) {
			System.out.println("Introduceti numele: ");
			lastName = sc.next();
			System.out.println("Introduceti prenumele: ");
			firstName = sc.next();
			int i = checkTheList(dataUser,firstName,lastName);
			if (i != -1) {
				System.out.println("Alege campul de actualizat, tastand:\r\n"
						+ "\"1\" - Nume\r\n"
						+ "\"2\" - Prenume\r\n"
						+ "\"3\" - Email\r\n"
						+ "\"4\" - Numar de telefon");
				int modify = sc.nextInt();
				
				if (modify == 1) {
					System.out.println("Scrieti numele: \n");
					lastName = sc.next();
					theList.get(i).setLastName(lastName);
					System.out.println("Nume schimbat cu succes!");
				
				} else if (modify == 2) {
					System.out.println("Scrieti prenumele: \n");
					firstName = sc.next();
					theList.get(i).setFirstName(firstName);
					System.out.println("Prenume schimbat cu succes!");
					
				} else if (modify == 3) {
					System.out.println("Scrieti email-ul: \n");
					email = sc.next();
					theList.get(i).setEmail(email);
					System.out.println("Email schimbat cu succes! ");
					
				} else if (modify == 4) {
					System.out.println("Scrieti numarul de telefon: \n");
					phoneNumber = sc.next();
					theList.get(i).setPhoneNumber(phoneNumber);
					System.out.println("Numarul de telefon schimbat cu succes! ");
				} else {
					System.out.println("Nu ati introdus un numar valid");
				}
			} else {
				System.out.println("Persoana nu se afla in sistem.");
			}
			
		//case 2 for email
		} else if (dataUser == 2) {
			System.out.println("Introduceti email-ul: ");
			email = sc.next();
			int i = checkTheListEmailOrNumber(dataUser, email);

			if (i != -1) {
				System.out.println("Alege campul de actualizat, tastand:\r\n"
						+ "\"1\" - Nume\r\n"
						+ "\"2\" - Prenume\r\n"
						+ "\"3\" - Email\r\n"
						+ "\"4\" - Numar de telefon");
				int modify = sc.nextInt();
				
				if (modify == 1) {
					System.out.println("Scrieti numele: \n");
					lastName = sc.next();
					theList.get(i).setLastName(lastName);
					System.out.println("Numele schimbat cu succes!");

					
				} else if (modify == 2) {
					System.out.println("Scrieti prenumele: \n");
					firstName = sc.next();
					theList.get(i).setFirstName(firstName);
					System.out.println("Prenumele schimbat cu succes!");
					
				} else if (modify == 3) {
					System.out.println("Scrieti email-ul: \n");
					email = sc.next();
					theList.get(i).setEmail(email);
					System.out.println("Email schimbat cu succes! ");
					
				} else if (modify == 4) {
					System.out.println("Scrieti numarul de telefon: \n");
					phoneNumber = sc.next();
					theList.get(i).setPhoneNumber(phoneNumber);
					System.out.println("Numarul de telefon schimbat cu succes!");
				} else {
					System.out.println("Nu ati introdus un numar valid");
				}
			} else {
				System.out.println("Persoana nu se afla in sistem.");
			}
		
		//case 3 for phone Number
		} else if(dataUser == 3) {
			System.out.println("Introduceti numarul de telefon: ");
			phoneNumber = sc.next();
			int i = checkTheListEmailOrNumber (dataUser, phoneNumber);
			if (i != -1) {
				System.out.println("Alege campul de actualizat, tastand:\r\n"
						+ "\"1\" - Nume\r\n"
						+ "\"2\" - Prenume\r\n"
						+ "\"3\" - Email\r\n"
						+ "\"4\" - Numar de telefon");
				int modify = sc.nextInt();
				
				if (modify == 1) {
					System.out.println("Scrieti numele: \n");
					lastName = sc.next();
					theList.get(i).setLastName(lastName);
					System.out.println("Numele schimbat cu succes!");
					
				} else if (modify == 2) {
					System.out.println("Scrieti prenumele: \n");
					firstName = sc.next();
					theList.get(i).setFirstName(firstName);
					System.out.println("Prenumele schimbat cu succes!");
					
				} else if (modify == 3) {
					System.out.println("Scrieti email-ul: \n");
					email = sc.next();
					theList.get(i).setEmail(email);
					System.out.println("Email schimbat cu succes!");
					
				} else if (modify == 4) {
					System.out.println("Scrieti numarul de telefon: \n");
					phoneNumber = sc.next();
					theList.get(i).setPhoneNumber(phoneNumber);
					System.out.println("Numarul de telefon schimbat cu succes! ");
				} else {
					System.out.println("Nu ati introdus un numar valid");
				}
			} else {
				System.out.println("Persoana nu se afla in sistem.");
			}
		}
		return false;
	}
	
	//print all Guests in theList
	public void guests() {
		int guestNo = 1;
		for(Guest i : theList) {
			System.out.println(guestNo + ". Nume: " + i.getFirstName() + " " + i.getLastName() + " ,Email: " + i.getEmail() + " ,numar de telefon: " + i.getPhoneNumber());
			++guestNo;
		}
		if (theList.isEmpty()) {
			System.out.println("Lista de invitati este goala!");
		}
	}
	
	//print all Guests in waitingList
	public void waitlist() {
		int guestNo = 1;
		for(Guest i : waitingList) {
			System.out.println(guestNo + ". Nume: " + i.getFirstName() + " " + i.getLastName() + " ,Email: " + i.getEmail() + " ,numar de telefon: " + i.getPhoneNumber());
			++guestNo;
		}
		if (waitingList.isEmpty()) {
			System.out.println("Lista de asteptare este goala!");
		}
	}
	
	//see how many seats are available on theList
	public void available() {
		int availableGuests = this.limitOfList - theList.size();
		System.out.println("Numarul de locuri ramase: " + availableGuests);
	}
	
	//print how many participants are to the event
	public void guest_no() {
		System.out.println("Numarul de participanti: " + theList.size());
	}
	
	//print how many participants are on waiting list
	public void waitlist_no() {
		System.out.println("Numarul de persoane aflate pe lista de asteptare: " + waitingList.size());
	}
	
	//print all Guests from main list and wait list
	public void subscribe_no() {
		int total = theList.size() + waitingList.size();
		System.out.println("Numarul total de persoane: " + total);
	}
	
	//partial and case insensitive search
	public void search() {
		System.out.println("Introduceti sirul de caractere pentru cautarea partiala: ");
		String partialWord = sc.next();
		ArrayList <Guest> fieldsContainsPartialWord = new ArrayList<>();
		int guestNo = 1;
		
		for (Guest i : theList) {
			if (i.getFirstName().toLowerCase().contains(partialWord.toLowerCase())) {
				fieldsContainsPartialWord.add(i);
			} else if (i.getLastName().toLowerCase().contains(partialWord.toLowerCase())) {
				fieldsContainsPartialWord.add(i);
			} else if (i.getEmail().toLowerCase().contains(partialWord.toLowerCase())) {
				fieldsContainsPartialWord.add(i);
			} else if (i.getPhoneNumber().toLowerCase().contains(partialWord.toLowerCase())) {
				fieldsContainsPartialWord.add(i);
			}
		}
		
		if (fieldsContainsPartialWord.isEmpty()) {
			System.out.println("Nu s-a gasit niciun rezultat!");
		}
		
		for (Guest i : fieldsContainsPartialWord) {
			System.out.println(guestNo + ". Nume: " + i.getFirstName() + " " + i.getLastName() + " ,Email: " + i.getEmail() + " ,numar de telefon: " + i.getPhoneNumber());
			++guestNo;
		}
		
	}
	
	//show all commands for using
	public void help() {
		System.out.println("\n\n1. help         - Afiseaza aceasta lista de comenzi\r\n"
				+ "2. add          - Adauga o noua persoana (inscriere)\r\n"
				+ "3. check        - Verifica daca o persoana este inscrisa la eveniment\r\n"
				+ "4. remove       - Sterge o persoana existenta din lista\r\n"
				+ "5. update       - Actualizeaza detaliile unei persoane\r\n"
				+ "6. guests       - Lista de persoane care participa la eveniment\r\n"
				+ "7. waitlist     - Persoanele din lista de asteptare\r\n"
				+ "8. available    - Numarul de locuri libere\r\n"
				+ "9. guests_no    - Numarul de persoane care participa la eveniment\r\n"
				+ "10. waitlist_no  - Numarul de persoane din lista de asteptare\r\n"
				+ "11. subscribe_no - Numarul total de persoane inscrise\r\n"
				+ "12. search       - Cauta toti invitatii conform sirului de caractere introdus\r\n"
				+ "13. quit         - Inchide aplicatia\n\n");
	}
}
