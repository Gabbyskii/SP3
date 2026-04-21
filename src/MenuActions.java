import java.util.List;

public class MenuActions {

    private TextUI ui;
    private List<Media> media;
    private User currentUser;
    private FileIO fileio;

    public MenuActions(TextUI ui, List<Media> media, User currentUser, FileIO fileio) {
        this.ui = ui;
        this.media = media;
        this.currentUser = currentUser;
        this.fileio = fileio;
    }

    //SØGEFUNKTION

    public void searchMedia() {
        String query = ui.promptString("Søg efter titel eller kategori:")
                .toLowerCase();

        boolean found = false;

        for (Media m : media) {
            boolean matchTitle = m.getTitle().toLowerCase().contains(query);
            boolean matchCategory = m.getCategories()
                    .toString()
                    .toLowerCase()
                    .contains(query);

            if (matchTitle || matchCategory) {
                ui.displayMessage(m.getTitle() + " (" + m.getReleaseYear() + ")");
                found = true;
            }
        }

        if (!found) {
            ui.displayMessage("Ingen resultater fundet.");
        }
    }





    public void showSavedMedia(){
        ui.displayMessage("Dine gemte medier: ");

        for (Media m: media){
           ui.displayMessage("-" + m.getTitle());
        }

    }


    public void showMenu(){
        boolean mediaRuns = true;

        while (mediaRuns){
            ui.displayMessage("1. Søg film.");
            ui.displayMessage("2. Søg medie kategori.");
            ui.displayMessage("3. Mine sete medier.");
            ui.displayMessage("4. Mine gemte medier.");
            ui.displayMessage("5. Log ud af bruger.");

            String choice = ui.promptString("Vælg en af mulighederne (1-5) ");

            switch (choice){
                case "1" -> searchMedia();
                case "2" -> searchMediaCategory();
                case "3" -> showWatchedMedia();
                case "4" -> showSavedMedia();
                case "5" -> mediaRuns = false;
            }

        }

    }








}