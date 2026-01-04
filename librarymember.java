// LibraryMember class
public class LibraryMember {
    private String name;
    private String memberId;
    private String email;
    private int borrowedBooksCount;

    // Constructor
    public LibraryMember(String name, String memberId, String email) {
        this.name = name;
        this.memberId = memberId;
        this.email = email;
        this.borrowedBooksCount = 0;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }

    public void setBorrowedBooksCount(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }

    // Borrow book
    public void borrowBook() {
        borrowedBooksCount++;
        System.out.println(name + " borrowed a book. Total: " + borrowedBooksCount);
    }

    // Return book
    public void returnBook() {
        if (borrowedBooksCount > 0) {
            borrowedBooksCount--;
            System.out.println(name + " returned a book. Total: " + borrowedBooksCount);
        } else {
            System.out.println(name + " has no books to return.");
        }
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "name='" + name + '\'' +
                ", memberId='" + memberId + '\'' +
                ", email='" + email + '\'' +
                ", borrowedBooks=" + borrowedBooksCount +
                '}';
    }

    // Override equals - compare by memberId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LibraryMember member = (LibraryMember) obj;
        return memberId.equals(member.memberId);
    }

    // Override hashCode
    @Override
    public int hashCode() {
        return memberId.hashCode();
    }
}
