import java.util.ArrayList;
import java.util.Comparator;

// Library class with filtering, searching, sorting
public class Library {
    private String libraryName;
    private String address;
    private ArrayList<Book> books;
    private ArrayList<LibraryMember> members;

    // Constructor
    public Library(String libraryName, String address) {
        this.libraryName = libraryName;
        this.address = address;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // Getters
    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<LibraryMember> getMembers() {
        return members;
    }

    // Add book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' added.");
    }

    // Register member
    public void registerMember(LibraryMember member) {
        members.add(member);
        System.out.println("Member '" + member.getName() + "' registered.");
    }

    // SEARCH - find book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // FILTER - get only available books
    public ArrayList<Book> filterAvailableBooks() {
        ArrayList<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                available.add(book);
            }
        }
        return available;
    }

    // FILTER - get books by author
    public ArrayList<Book> filterBooksByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // SORT - sort books by title (alphabetically)
    public void sortBooksByTitle() {
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });
        System.out.println("Books sorted by title.");
    }

    // SORT - sort books by author
    public void sortBooksByAuthor() {
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
            }
        });
        System.out.println("Books sorted by author.");
    }

    // Display all books
    public void displayAllBooks() {
        System.out.println("\n=== Books in " + libraryName + " ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Display all members
    public void displayAllMembers() {
        System.out.println("\n=== Members of " + libraryName + " ===");
        for (LibraryMember member : members) {
            System.out.println(member);
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + libraryName + '\'' +
                ", address='" + address + '\'' +
                ", totalBooks=" + books.size() +
                ", totalMembers=" + members.size() +
                '}';
    }
}
