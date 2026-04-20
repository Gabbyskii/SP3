import java.util.List;

public class MenuActions {

    private TextUI ui;

    //SØGEFUNKTION

    public void searchMedia(TextUI ui, User user, List<Media> mediaList) {
        String query = ui.promptString("Søg efter titel eller kategori:")
                .toLowerCase();

        boolean found = false;

        for (Media m : mediaList) {
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





}