import java.util.List;

public class Film extends Media {

    public Film(int releaseYear, String title, int rating, List<Category> categories, List<Media> media) {
        super(releaseYear, title, rating, categories);

    }


    @Override
    public void play() {
        System.out.println("Starter " + getTitle());
    }

    @Override
    public void pause() {
        ui.displayMessage(getTitle() + " Sat på pause");
    }



}