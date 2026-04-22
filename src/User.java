import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String password;
    private List<Media> watchedMedia;
    private List<Media> savedMedia;
    private List<Media> removeMedia;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.watchedMedia = new ArrayList<>();
        this.savedMedia = new ArrayList<>();
        this.removeMedia = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Media> getWatchedMedia() {
        return watchedMedia;
    }

    public void setWatchedMedia(List<Media> watchedMedia) {
        this.watchedMedia = watchedMedia;
    }

    public void addSavedMedia(Media m) {
        savedMedia.add(m);
    }

    public void removeSavedMedia(Media m) {
        savedMedia.remove(m);
    }

    public List<Media> getSavedMedia() {
        return savedMedia;
    }

    public void setSavedMedia(List<Media> savedMedia) {
        this.savedMedia = savedMedia;
    }


    public List<Media> getRemoveMedia() {
        return removeMedia;
    }

    public void setRemoveMedia(List<Media> removeMedia) {
        this.removeMedia = removeMedia;

    }


    @Override
    public String toString() {
        return username + " 🤍";
    }
}
