import java.util.ArrayList;

abstract class Menu {

    private ArrayList<User> users;
    private ArrayList<Media> media;
    private TextUI ui;
    private User currentUser;

    public Menu(TextUI ui, User currentUser) {
        this.users = new ArrayList<>();
        this.media = new ArrayList<>();
        this.ui = ui;
        this.currentUser = currentUser;

    }

    public void start() {
        this.ui.displayMessage("Velkommen");

        while (this.currentUser == null) {
            this.ui.displayMessage("1. Opret bruger");
            this.ui.displayMessage("2. Login");
            switch (this.ui.getUserInput("Vælg 1. Opret bruger el. 2. Login")) {
                case "1":
                    this.login();
                    break;
                case "2":
                    this.register();
                    break;
            }
        }
    }

    public void login () {
        String username = this.ui.promptForUsername();
        String password = this.ui.promptForPassword();

        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                this.currentUser = user;
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
        this.ui.displayMessage("Velkommen du er nu oprettet");

    }
}