import java.util.ArrayList;
import java.util.Scanner;

// Main class with Scanner for user input
public class Main {
    private static Library library;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        // Create library
        library = new Library("City Central Library", "123 Main Street");
        
        // Add sample data
        initializeSampleData();
        
        // Main menu loop
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter choice: ");
            
            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    filterAvailableBooks();
                    break;
                case 5:
                    sortBooks();
                    break;
                case 6:
                    borrowBook();
                    break;
                case 7:
                    returnBook();
                    break;
                case 8:
                    displayMembers();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
    }

    // Initialize sample data
    private static void initializeSampleData() {
        // Add books - demonstrates polymorphism
        library.addBook(new PhysicalBook("1984", "George Orwell", "ISBN-001", 15));
        library.addBook(new EBook("The Great Gatsby", "F. Scott Fitzgerald", "ISBN-002", 2.5));
        library.addBook(new PhysicalBook("To Kill a Mockingbird", "Harper Lee", "ISBN-003", 23));
        library.addBook(new EBook("Pride and Prejudice", "Jane Austen", "ISBN-004", 1.8));
        
        // Add members
        library.registerMember(new LibraryMember("John Smith", "M001", "john@email.com"));
        library.registerMember(new LibraryMember("Sarah Johnson", "M002", "sarah@email.com"));
    }

    // Display main menu
    private static void displayMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add New Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Search Book by Title");
        System.out.println("4. Filter Available Books");
        System.out.println("5. Sort Books");
        System.out.println("6. Borrow Book");
        System.out.println("7. Return Book");
        System.out.println("8. Display Members");
        System.out.println("0. Exit");
    }

    // Add new book using Scanner
    private static void addNewBook() {
        System.out.println("\nBook Type: 1-Physical, 2-EBook");
        int type = getIntInput("Enter type: ");
        
        System.out.print("Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Author: ");
        String author = scanner.nextLine();
        
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        
        if (type == 1) {
            int shelf = getIntInput("Shelf number: ");
            library.addBook(new PhysicalBook(title, author, isbn, shelf));
        } else {
            System.out.print("File size (MB): ");
            double size = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            library.addBook(new EBook(title, author, isbn, size));
        }
    }

    // Display all books
    private static void displayAllBooks() {
        library.displayAllBooks();
    }

    // Search book by title
    private static void searchBook() {
        System.out.print("\nEnter title to search: ");
        String title = scanner.nextLine();
        
        Book book = library.searchBookByTitle(title);
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Filter available books
    private static void filterAvailableBooks() {
        ArrayList<Book> available = library.filterAvailableBooks();
        System.out.println("\n=== Available Books ===");
        for (Book book : available) {
            System.out.println(book);
        }
    }

    // Sort books
    private static void sortBooks() {
        System.out.println("\nSort by: 1-Title, 2-Author");
        int choice = getIntInput("Enter choice: ");
        
        if (choice == 1) {
            library.sortBooksByTitle();
        } else {
            library.sortBooksByAuthor();
        }
        library.displayAllBooks();
    }

    // Borrow book
    private static void borrowBook() {
        System.out.print("\nEnter book title: ");
        String title = scanner.nextLine();
        
        Book book = library.searchBookByTitle(title);
        if (book != null) {
            book.borrowBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    // Return book
    private static void returnBook() {
        System.out.print("\nEnter book title: ");
        String title = scanner.nextLine();
        
        Book book = library.searchBookByTitle(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    // Display members
    private static void displayMembers() {
        library.displayAllMembers();
    }

    // Helper to get integer input
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
}
