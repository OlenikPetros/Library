import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
                System.out.println("\n--- Library --- \n");
                System.out.println("1. All Free Books");
                System.out.println("2. Add New Book");
                System.out.println("3. Delete  Book"); 
                System.out.println("4. All Persons");
                System.out.println("5. Add Person");
                System.out.println("6. Delete Person"); 
                System.out.println("7. RentBook"); 
                System.out.println("8. RentedBooks");
                System.out.println("10. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
        switch (choice) {

                case 1:
                        ShowAllBooks.showBooks();
                                break;  
                case 2:
                        System.out.print("Name of the book: ");
                        String name = scanner.nextLine();
                        AddNewBook.add(name);
                                break;

                 case 3:
                        ShowAllBooks.showBooks();
                        System.out.print("BooksID From List: ");
                        String bookIdStri = scanner.nextLine();
                        DeleteBook.delbook(bookIdStri);
                                break;

                case 4:
                        ShowAllPersons.showPersons();
                                break;

                case 5:
                        System.out.print("Name of person: ");
                        String nameperson = scanner.nextLine();
                        AddNewPerson.AddPerson(nameperson);
                                break;
                case 6:
                        ShowAllPersons.showPersons();
                        System.out.print("PersonsID From List: ");
                        String personIdStri = scanner.nextLine();
                        DeletePerson.delperson(personIdStri);
                                break;
                case 7:
                        HowToRent.allPersonsAndBooks();
                        System.out.print("BooksID From List: ");
                        String bookIdStr = scanner.nextLine();
                        int bookid = Integer.parseInt(bookIdStr);
                        System.out.print("PersonID From List: ");
                        String personIdStr = scanner.nextLine();
                        int personid = Integer.parseInt(personIdStr);
                        RentBook.addrentbook(bookid,personid);
                                break;

                case 8:
                        RentedBooks.showRentedBooks();
                                break;

                case 9:
                        System.out.println("👋 Exiting program...");
                                return;   
                default:
                        System.out.println("❌ Invalid option. Try again.");                                  
            }
        }

        scanner.close();
    }
}
