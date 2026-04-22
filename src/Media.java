import java.util.List;

public abstract class Media {

  protected String title;
  private int releaseYear;
  private double rating;
  private List<Category> categories;
  TextUI ui;


    public Media(int releaseYear, String title, int rating, List<Category> categories) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.rating = rating;
        this.categories = categories;

    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public List<Category> getCategories() {
        return categories;
    }


    public abstract void play();
    public abstract void pause();



}
