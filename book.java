// Abstract class - data abstraction principle
public abstract class Book {
    // Encapsulation - private fields
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Abstract method - must be implemented by subclasses (polymorphism)
    public abstract String getBookType();

    // Method to borrow book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + title + "' borrowed.");
        } else {
            System.out.println("Book '" + title + "' not available.");
        }
    }

    // Method to return book
    public void returnBook() {
        isAvailable = true;
        System.out.println("Book '" + title + "' returned.");
    }

    // Override toString
    @Override
    public String toString() {
        return getBookType() + "{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + isAvailable +
                '}';
    }

    // Override equals - compare by ISBN
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    // Override hashCode - required when equals is overridden
    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
