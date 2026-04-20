import java.util.Scanner;

public class TextUI {

    private Scanner scan = new Scanner(System.in);


    public void displayMessage(String message){
        System.out.println(message);
    }

    public String getUserInput(String prompt){
        System.out.println(prompt);
        return scan.nextLine();
    }

    public String promptForUsername(){
        System.out.println("Indtast brugernavn: ");
        return scan.nextLine();

    }
    public String promptForPassword(){
        System.out.println("Indtast password: ");
        return scan.nextLine();

    }


    public String promptString(String msg){
        displayMessage(msg);
        return scan.nextLine().trim();
    }

    public boolean promptBinary(String msg){
        displayMessage(msg);
        String input = scan.nextLine();
        if(input.equalsIgnoreCase("Y")){
            return true;
        }
        else if(input.equalsIgnoreCase("N")){
            return false;
        }
        else{
            return promptBinary(msg);
        }
    }



}
