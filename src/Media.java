import java.util.List;

public abstract class Media {

  protected String title;
  private int releaseYear;
  private int rating;
  private List<Category> categories;


    public Media(int releaseYear, String title, int rating, List<Category> categories) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.rating = rating;
        this.categories = categories;
    }


    public void play(){

    }

    public void pause(){

    }



}
