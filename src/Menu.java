import java.util.ArrayList;

public class Menu {

    private ArrayList<User> users;
    private ArrayList<Media> media;
    private TextUI ui;
    private User currentUser;
    private FileIO io;


    public Menu(TextUI ui, FileIO io) {
        this.users = new ArrayList<>(io.loadUsers(users));
        this.media = new ArrayList<>();
        this.ui = ui;
        this.io = io;

    }

    public ArrayList<Media> getMedia() {
        return media;
    }

    public User start() {


        this.ui.displayMessage("Velkommen");

        while (this.currentUser == null) {
        boolean loggedIn;
            this.ui.displayMessage("1. Opret bruger");
            this.ui.displayMessage("2. Login");
            switch (this.ui.getUserInput("Vælg 1. Opret bruger el. 2. Login")) {
                case "1":
                    this.register();
                    break;
                case "2":
                    this.login();
                    if (currentUser != null) {
                        loggedIn = true;
                    break;
            }
            }
        }
        return currentUser;
    }

    public void login () {
        String username = this.ui.promptForUsername();
        String password = this.ui.promptForPassword();

        for (User user : this.users) {
            io.loadUsers(users);
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                this.ui.displayMessage("Velkommen tilbage " + user);
                return;
            }
        }
        this.ui.displayMessage("Prøv igen forkert brugernavn eller kode");

    }

    public void register () {
        String username = this.ui.getUserInput("Indtast brugernavn");
        String password = this.ui.getUserInput("Indtast adgangskode");

        User newUser = new User(username, password);
        users.add(newUser);
        io.saveUsers(users);
        this.ui.displayMessage("Velkommen du er nu oprettet");

    }

    @Override
    public String toString() {
        return "Menu{" +
                "users=" + users +
                ", media=" + media +
                ", ui=" + ui +
                ", currentUser=" + currentUser +
                ", menuActs="  +
                '}';
    }
}