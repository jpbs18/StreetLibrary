package academy.mindswap;

import academy.mindswap.Libraries.DonationLibrary;
import academy.mindswap.Libraries.Library;
import academy.mindswap.Libraries.SimpleLibrary;


public class Main {

    public static void main(String[] args) {

        Library library = new SimpleLibrary();
        Library library2 = new DonationLibrary();


        Client client2 = new Client("Henrique");

        client2.setLibrary(library2);

        client2.donation();
        client2.askByTitle("The Cosmos");





    }
}
