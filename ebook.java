// EBook - inherits from Book
public class EBook extends Book {
    private double fileSizeMB;

    // Constructor
    public EBook(String title, String author, String isbn, double fileSizeMB) {
        super(title, author, isbn); // call parent constructor
        this.fileSizeMB = fileSizeMB;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    // Polymorphism - override abstract method
    @Override
    public String getBookType() {
        return "EBook";
    }

    @Override
    public String toString() {
        return super.toString() + ", size=" + fileSizeMB + "MB";
    }
}
