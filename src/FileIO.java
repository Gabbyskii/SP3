import java.io.*;
import java.util.ArrayList;
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
            File films = new File(filmFile);
            scan = new Scanner(films);

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] values = line.split(";");
                if (values.length < 4) continue;

                String title = values[0].trim();
                int releaseYear = Integer.parseInt(values[1].trim().split("-")[0]);
                String[] catStrings = values[2].trim().split(",");
                int rating = (int) Double.parseDouble(values[3].trim().replace(",", "."));

                List<Category> categories = parseCategories(catStrings);

                filmList.add(new Film(releaseYear, title, rating, categories, null));
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
            File series = new File(seriesFile);
            scan = new Scanner(series);

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] values = line.split(";");
                if (values.length < 4) continue;

                String title = values[0].trim();
                int releaseYear = Integer.parseInt(values[1].trim().split("-")[0]);
                String[] catStrings = values[2].trim().split(",");
                int rating = (int) Double.parseDouble(values[3].trim().replace(",", "."));

                List<Category> categories = parseCategories(catStrings);

                seriesList.add(new Series(releaseYear, title, rating, categories));
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("Filen ikke fundet!!!");
        }
        return seriesList;
    }

    private List<Category> parseCategories(String[] catStrings) {
        List<Category> categories = new ArrayList<>();
        for (String cat : catStrings) {
            try {
                categories.add(Category.valueOf(cat.trim().toUpperCase().replace("-", "_").replace(" ", "_")));
            } catch (IllegalArgumentException e) {
                // skip unknown categories
            }
        }
        return categories;
    }

    public List<User> loadUsers(ArrayList<User> users) {
        List<User> userList = new ArrayList<>();

        try {
            BufferedReader breader = new BufferedReader(new FileReader(userFile));
            String line = breader.readLine();

            while (line != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    User newUser = new User(values[0].trim(), values[1].trim());
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