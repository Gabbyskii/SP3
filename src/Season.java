import java.util.List;

public class Season extends Series {

    private int seasonNumber;
    private List<Episode>episodes;

    public Season(int releaseYear, String title, int rating, List<Category> categories, int seasonNumber) {
        super(releaseYear, title, rating, categories);
        this.seasonNumber = seasonNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }





}
