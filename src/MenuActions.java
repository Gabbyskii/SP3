import util.TextUI;
import java.util.List;
import Category;

public class MenuActions {

    //SØGEFUNKTION

    public static void searchMedia(TextUI ui, User user, List<Media> mediaList) {
        String query = ui.promptString("Søg efter titel eller kategori:")
                .toLowerCase();

        boolean found = false;

        for (Media m : mediaList) {
            boolean matchTitle = m.getTitle().toLowerCase().contains(query);
            boolean matchCategory = false;
            for (Category c : m.getCategories()) {
                if (c.name().toLowerCase().contains(query)) {
                    matchCategory = true;
                    break;
                }
                if (matchTitle || matchCategory) {
                    String categoryList = m.getCategories().toString();
                    ui.displayMessage(m.getTitle() + " (" + m.getReleaseYear() + ") — " + categoryList);
                    found = true;
                }
            }

        if (!found) {
            ui.displayMsg("Ingen resultater fundet.");
        }
    }

}


