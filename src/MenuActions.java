import util.TextUI;
import java.util.List;

public class MenuActions {

    //SØGEFUNKTION

    public static void searchMedia(TextUI ui, User user, List<Media> mediaList) {
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
                ui.displayMsg(m.getTitle() + " (" + m.getReleaseYear() + ")");
                found = true;
            }
        }

        if (!found) {
            ui.displayMsg("Ingen resultater fundet.");
        }
    }

}


