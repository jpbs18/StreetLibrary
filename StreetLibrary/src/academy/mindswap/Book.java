package academy.mindswap;


public class Book {

    private final String author;
    private final String title;
    private int serialNumber;

    public Book(String author, String title){
        this.author = author;
        this.title = title;
        serialNumber = 0;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    public void setSerialNumber(int serialNumber){
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber(){
        return this.serialNumber;
    }

}
