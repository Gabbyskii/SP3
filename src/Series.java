import java.util.List;

public class Series extends Media {

    private List<Seasons>season;

    public Series(int releaseYear, String title, int rating, List<Category> categories) {
        super(releaseYear, title, rating, categories);
    }

    public List<Seasons> getSeason() {
        return season;
    }

    @Override
    public void play() {
        super.play();
    }

    @Override
    public void pause() {
        super.pause();
    }
}
