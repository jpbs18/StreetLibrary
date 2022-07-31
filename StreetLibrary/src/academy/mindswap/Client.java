package academy.mindswap;


import academy.mindswap.Libraries.Library;
import academy.mindswap.Libraries.SimpleLibrary;

import static academy.mindswap.Messages.Messages.*;

public class Client {

    private final String name;
    private boolean borrowedBook;
    private Library library;


    public Client(String name){
        this.name = name;
        library = null;
        borrowedBook = false;
    }

    public void donation(){
        library.receivedDonation();
    }

    public void askByAuthor(String author){
        if(!checkPresence()){
            System.out.println(ENTER_LIBRARY);
            return;
        }

        if(borrowedBook){
            System.out.println(BOOK_BORROWED);
            return;
        }

        library.borrowByAuthor(author, library);
        borrowedBook = true;
    }



    public void askByTitle(String title){
        if(!checkPresence()){
            System.out.println(ENTER_LIBRARY);
            return;
        }

        if(borrowedBook){
            System.out.println(BOOK_BORROWED);
            return;
        }

        library.borrowByTitle(title, library);
        borrowedBook = true;
    }

    public void returnBook(){
        if(!checkPresence()){
            System.out.println(ENTER_LIBRARY);
            return;
        }

        if(!borrowedBook){
            System.out.println(CANT_RETURN);
            return;
        }

        library.receiveBook();
        borrowedBook = false;
    }

    public void setLibrary(Library library){
        if(checkPresence()){
            System.out.println(ALREADY_ENTERED);
            return;
        }

        String type = library instanceof SimpleLibrary ? "SimpleLibrary" : "DonationLibrary";
        System.out.printf("Welcome to the %s!%n", type);
        this.library = library;
    }

    private boolean checkPresence(){
        if(library == null){
            return false;
        }
        return true;
    }


}
