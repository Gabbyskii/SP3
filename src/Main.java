
public class Main {
    public void main(String[] args) {
        TextUI ui = new TextUI();
        FileIO fileio = new FileIO();
        Menu startMenu = new Menu(ui, fileio);
        User currentUser = startMenu.start();

        MenuActions menuActions = new MenuActions(ui, startMenu.getMedia(), currentUser, fileio);
        menuActions.showMenu();
    }
}