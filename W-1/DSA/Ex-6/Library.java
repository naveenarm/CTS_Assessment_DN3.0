import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchByTitleLinear(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByTitleBinary(String title) {
    int low = 0;
    int high = books.size() - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        Book midBook = books.get(mid);

        if (midBook.getTitle().equals(title)) {
            return midBook;
        } else if (midBook.getTitle().compareTo(title) < 0) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return null;
}
}