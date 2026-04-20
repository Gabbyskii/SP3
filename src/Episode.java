import java.util.List;

public class Episode extends Media {

    private String episodeTitle;
    private int duration;
    private int episodeNumber;


    public Episode(int releaseYear, String title, int rating, List<Category> categories,
                   String episodeTitle, int duration, int episodeNumber) {
        super(releaseYear, title, rating, categories);
        this.title = episodeTitle;
        this.duration = duration;
        this.episodeNumber = episodeNumber;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public int getDuration() {
        return duration;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }


    @Override
    public void play() {
        ui.displayMessage("Starter episode: "+ title);
    }

    @Override
    public void pause() {
        ui.displayMessage("Pauser episode: "+ title);
    }


}
