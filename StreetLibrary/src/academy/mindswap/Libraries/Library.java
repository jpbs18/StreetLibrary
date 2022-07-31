package academy.mindswap.Libraries;

import academy.mindswap.Book;

public abstract class Library implements InterfaceLibrary{

    private static int serialNumber = 10;
    private boolean donation = false;
    private int numberOfBooksBorrowed = 0;
    protected Book[] books = {new Book("John Spencer", "The Cosmos"),
                              new Book("Karen Phillips", "American Dream"),
                              new Book("Paul Rodriguez", "Mexican Food"),
                              new Book("Virgil Adams", "Ocean Creatures"),
                              new Book("George Machida", "Japanese Arts")};

    protected Book[] booksBorrowed = new Book[books.length];

    protected int[] serialNumbersSaved = new int[books.length];

    public int generateSerialNumber(Library library){
        if(library instanceof SimpleLibrary){
            serialNumber++;
            return serialNumber * 2;
        }
        serialNumber++;
        return serialNumber * 10;
    }

    @Override
    public void borrowByAuthor(String author, Library library){
        if(numberOfBooksBorrowed == books.length){
            System.out.println("You don't have books available at this moment, sorry!");
            return;
        }

       int number = generateSerialNumber(library);

        for(int i = 0; i < books.length; i++){
            if(books[i] == null){
                continue;
            }
            if(author.toLowerCase().equals(books[i].getAuthor().toLowerCase())){
                serialNumbersSaved[i] = number;
                books[i].setSerialNumber(number);
                booksBorrowed[i] = books[i];
                books[i] = null;
                numberOfBooksBorrowed++;
                System.out.printf("Here it is! Your book written by %s.%n", author);
                return;
            }
        }

        System.out.println("Sorry, we don't have a book by that author at this moment...");
    }

    @Override
    public void borrowByTitle(String title, Library library){
        if(numberOfBooksBorrowed == books.length){
            System.out.println("You don't have books available at this moment, sorry!");
            return;
        }

        int number = generateSerialNumber(library);

        for(int i = 0; i < books.length; i++){
            if(books[i] == null){
                continue;
            }
            if(title.toLowerCase().equals(books[i].getTitle().toLowerCase())){
                serialNumbersSaved[i] = number;
                books[i].setSerialNumber(number);
                booksBorrowed[i] = books[i];
                books[i] = null;
                numberOfBooksBorrowed++;
                System.out.printf("Here it is! Your book %s.%n", title);
                return;
            }
        }

        System.out.println("Sorry, we don't have a book with that title at this moment...");
    }

    @Override
    public void receiveBook(){
        if(numberOfBooksBorrowed == 0){
            System.out.println("Must be a mistake, we don't have books borrowed at this moment.");
            return;
        }

        for(int i = 0; i < booksBorrowed.length; i++){
            if(booksBorrowed[i] != null && serialNumbersSaved[i] == booksBorrowed[i].getSerialNumber()){
                numberOfBooksBorrowed--;
                books[i] = booksBorrowed[i];
                booksBorrowed[i] = null;
                serialNumbersSaved[i] = 0;
                System.out.println("Thank you for returning our book!");
                return;
            }
        }

        System.out.println("That book does not belong to our library!");
    }

    public void receivedDonation() {
        donation = true;
        System.out.println("Thank you!");
    }

    public boolean getDonation(){
        return donation;
    }
}
