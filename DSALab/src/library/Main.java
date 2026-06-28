package library;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Clean Code", "Robert Martin"),
            new Book(2, "Data Structures", "Mark Weiss"),
            new Book(3, "Design Patterns", "Gang of Four"),
            new Book(4, "Java Programming", "James Gosling"),
            new Book(5, "The Pragmatic Programmer", "Andrew Hunt")
        };

        System.out.println("--- Linear Search ---");
        int index = LibrarySearch.linearSearch(books, "Design Patterns");
        if (index != -1) {
            System.out.println("Book found at index " + index + ":");
            books[index].display();
        } else {
            System.out.println("Book not found.");
        }

        System.out.println();
        System.out.println("--- Binary Search (sorted by title) ---");
        int index2 = LibrarySearch.binarySearch(books, "Java Programming");
        if (index2 != -1) {
            System.out.println("Book found at index " + index2 + ":");
            books[index2].display();
        } else {
            System.out.println("Book not found.");
        }

        System.out.println();
        System.out.println("--- Searching for non-existing book ---");
        int index3 = LibrarySearch.linearSearch(books, "Harry Potter");
        if (index3 != -1) {
            books[index3].display();
        } else {
            System.out.println("Book 'Harry Potter' not found.");
        }
    }
}
