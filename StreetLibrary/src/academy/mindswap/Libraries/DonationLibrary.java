package academy.mindswap.Libraries;

import static academy.mindswap.Messages.Messages.DONATE;

public class DonationLibrary extends Library {

    @Override
    public void borrowByAuthor(String author, Library library){
        if(getDonation()){
            super.borrowByAuthor(author, library);
            return;
        }
        System.out.println(DONATE);
    }

    public void borrowByTitle(String title, Library library){
        if(getDonation()){
            super.borrowByTitle(title, library);
            return;
        }
        System.out.println(DONATE);
    }


}
