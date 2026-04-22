import import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getWatchedMedia() {
        User u = new User("rebecca", "1234");
        assertTrue(u.getWatchedMedia().isEmpty());
    }

    @Test
    void addSavedMedia() {
        User u = new User("rebecca", "1234");

        Media m = new Film(
                180,                     // duration
                1997,                    // releaseYear
                "Titanic",               // title
                8,                       // rating (int!)
                List.of(Category.DRAMA), // categories
                List.of()                // tom liste af Media
        );

        u.addSavedMedia(m);

        assertEquals(1, u.getSavedMedia().size());
        assertEquals("Titanic", u.getSavedMedia().get(0).getTitle());
    }

    @Test
    void removeSavedMedia() {
        User u = new User("rebecca", "1234");

        Media m = new Film(
                160,
                2009,
                "Avatar",
                8,
                List.of(Category.SCIFI),
                List.of()
        );

        u.addSavedMedia(m);
        u.removeSavedMedia(m);

        assertTrue(u.getSavedMedia().isEmpty());
    }

    @Test
    void getSavedMedia() {
        User u = new User("rebecca", "1234");

        Media m1 = new Film(
                180,
                1997,
                "Titanic",
                8,
                List.of(Category.DRAMA),
                List.of()
        );

        Media m2 = new Film(
                160,
                2009,
                "Avatar",
                8,
                List.of(Category.SCIFI),
                List.of()
        );

        u.addSavedMedia(m1);
        u.addSavedMedia(m2);

        List<Media> saved = u.getSavedMedia();

        assertEquals(2, saved.size());
        assertTrue(saved.contains(m1));
        assertTrue(saved.contains(m2));
    }
}