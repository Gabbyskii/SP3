import java.util.List;

public class MenuActions {
    private TextUI ui;
    private List<Media> medialist;
    private User currentUser;
    private FileIO fileio;

    public MenuActions(TextUI ui, List<Media> media, User currentUser, FileIO fileio) {
        this.ui = ui;
        this.medialist = media;
        this.currentUser = currentUser;
        this.fileio = fileio;
    }

    //SØGEFUNKTION

    public void searchMedia() {
        String query = ui.promptString("Søg efter titel eller kategori:")
                .toLowerCase();

        boolean found = false;

        for (Media m : medialist) {
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

    //SE SETE MEDIER
    public void showWatchedMedia() {
        List<Media> watchedMedia = currentUser.getWatchedMedia();

        ui.displayMessage("Dine sete medier:");
        for (Media m : watchedMedia) {
            ui.displayMessage("-" + m.getTitle());
        }
    }

    //SE GEMTE MEDIER
    public void showSavedMedia() {
        List<Media> savedMedia = currentUser.getSavedMedia();

        ui.displayMessage("Dine gemte medier: ");
        for (Media m : savedMedia) {
            ui.displayMessage("- " + m.getTitle());
        }
    }

    public void showAllCategories() {
        int index = 1;
        for (Category c : Category.values()) {
            ui.displayMessage(index + "- " + c);
            index++;
        }
    }

    public void searchMediaCategory() {
        showAllCategories();

        String input = ui.promptString("Vælg en kategori: ");
        int choice = Integer.parseInt(input);

        Category chosen = Category.values()[choice - 1];

        System.out.println("Medier i kategorien " + chosen + ":");
        showMediaByCategory(chosen);
    }

    public void showMediaByCategory(Category category) {
        for (Media m : medialist) {
            if (m.getCategories().contains(category)) {
                ui.displayMessage(m.getTitle());
            }
        }
    }

    public void showMenu() {
        boolean mediaRuns = true;

        while (mediaRuns) {
            ui.displayMessage("1. Søg film.");
            ui.displayMessage("2. Søg medie kategori.");
            ui.displayMessage("3. Mine sete medier.");
            ui.displayMessage("4. Mine gemte medier.");
            ui.displayMessage("5. Log ud af bruger.");

            String choice = ui.promptString("Vælg en af mulighederne (1-5) ");

            switch (choice) {
                case "1" -> searchMedia();
                case "2" -> searchMediaCategory();
                case "3" -> showWatchedMedia();
                case "4" -> showSavedMedia();
                case "5" -> mediaRuns = false;
            }

        }

    }
}