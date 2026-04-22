import java.util.List;

public class Film extends Media {
private int duration;

    public Film(int duration, int releaseYear, String title, int rating, List<Category> categories, List<Media> media) {
        super(releaseYear, title, rating, categories);
        this.duration = duration;

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void play() {
        ui.displayMessage("Starter " + getTitle());
    }

    @Override
    public void pause() {
        ui.displayMessage(getTitle() + " Sat på pause");
    }

}