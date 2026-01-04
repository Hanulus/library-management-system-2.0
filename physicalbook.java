// PhysicalBook - inherits from Book
public class PhysicalBook extends Book {
    private int shelfNumber;

    // Constructor
    public PhysicalBook(String title, String author, String isbn, int shelfNumber) {
        super(title, author, isbn); // call parent constructor
        this.shelfNumber = shelfNumber;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    // Polymorphism - override abstract method
    @Override
    public String getBookType() {
        return "PhysicalBook";
    }

    @Override
    public String toString() {
        return super.toString() + ", shelf=" + shelfNumber;
    }
}
