import java.util.List;

public class Series extends Media {

    private List<Season>season;

    public Series(int releaseYear, String title, int rating, List<Category> categories) {
        super(releaseYear, title, rating, categories);
    }

    public List<Season> getSeason() {
        return season;
    }


    @Override
    public void play() {
      ui.displayMessage("Starter serie: "+ title);
    }

    @Override
    public void pause() {
        ui.displayMessage("Pauser serie: "+ title);
    }


}
