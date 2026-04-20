import java.util.ArrayList;

public class Menu {

    private ArrayList<User>users;
   private ArrayList<Media>media;
   private TextUI ui;
    private User currentUser;


   public void register(){
       ui.promptForUsername();
       ui.promptForPassword();

       ui.displayMessage("Bruger oprettet!");

      /* if (User user: users){
           if (user.get..)
       }*/

   }


}
