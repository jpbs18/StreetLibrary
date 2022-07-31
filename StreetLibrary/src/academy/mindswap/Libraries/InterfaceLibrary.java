package academy.mindswap.Libraries;

public interface InterfaceLibrary {

    void borrowByAuthor(String author, Library library);
    void borrowByTitle(String title, Library library);
    void receiveBook();
}
