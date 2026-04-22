import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    private String filmFile = "csv/film.txt";
    private String seriesFile = "csv/series.txt";
    private String userFile = "csv/userData.txt";

    private Scanner scan;

    public List<Film> loadFilms() {
        List<Film> filmList = new ArrayList<>();
        try {
            File films = new File("csv/film.txt");
            scan = new Scanner(films);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] values = line.split(";");

                String title = values[0].trim();
                int releaseYears = Integer.parseInt(values[1].trim().split("-")[0]);
                String[] categories = values[2].trim().split(",");
                int rating = (int) Double.parseDouble(values[3].trim().replace(",", "."));
                System.out.println("Movies: " + title + ", (" + releaseYears + ") " +
                        ", Genres: " + Arrays.toString(categories) + ", rating: " + rating);
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("Filen ikke fundet!!!");
        }

        return filmList;
    }

    public List<Series> loadSeries() {
        List<Series> seriesList = new ArrayList<>();
        try {
            File series = new File("csv/series.txt");
            scan = new Scanner(series);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] values = line.split(";");

                String title = values[0].trim();
                int releaseYears = Integer.parseInt(values[1].trim().split("-")[0]);
                String[] categories = values[2].trim().split(",");
                double rating = Double.parseDouble(values[3].trim().replace(",", "."));
                int seasons = Integer.parseInt(values[4].trim().split("-")[0].split(",")[0].trim());
                int episodes = Integer.parseInt(values[5].trim().split("-")[0].split(",")[0].trim());
                System.out.println("Series: " + title + releaseYears +
                        Arrays.toString(categories) + rating + seasons + episodes);
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("Filen ikke fundet!!!");
        }
        return seriesList;
    }

    public List<User> loadUsers(ArrayList<User> users) {
        List<User> userList = new ArrayList<>();

        try {
            BufferedReader breader = new BufferedReader(new FileReader(userFile));
            String line = breader.readLine();

            while (line != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    User newUser = new User(values[0], values[1]);
                    userList.add(newUser);
                }
                line = breader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fejl ved indlæsning af brugere: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fejl ved indlæsning af bruger. " + e.getMessage());
        }

        return userList;
    }

    public void saveUsers(List<User> userList) {
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(userFile));

            for (User user : userList) {
                bWriter.write(user.getUsername() + ", " + user.getPassword());
                bWriter.newLine();
            }
            bWriter.close();

        } catch (Exception e) {
            System.out.println("Fejl ved gemning af bruger: " + e.getMessage());
        }
    }
}
