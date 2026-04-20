import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class FileIO {

    private List<String> filmFile = "csv/film.txt";
    private String seriesFile = "csv/series.txt";
    private String userFile = "csv/userData.txt";


    private Scanner scan;


    public List<String> loadFilms() {

        try {
            File films = new File("csv/film.txt");
            scan = new Scanner(films);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] values = line.split(";");

                String title = values[0].trim();
                int releaseYear = Integer.parseInt(values[1].trim());
                String[] categories = values[2].trim().split(",");
                int rating = Integer.parseInt(values[3]);
                System.out.println("Movies: "+ title + releaseYear +
                        Arrays.toString(categories) + rating);

                /*Film movies = new Film(title, releaseYear, categories, rating);
                System.out.println(movies);*/
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("Filen ikke fundet!!!");
        }

        return filmFile;
    }


    public List<String> loadSeries() {
        //List<Series> seriesList = new ArrayList<>();
        try {
            File series = new File("csv/series.txt");
            scan = new Scanner(series);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] values = line.split(";");

                String title = values[0].trim();
                int releaseYears = Integer.parseInt(values[1].trim());
                String[] categories = values[2].trim().split(",");
                double rating = Double.parseDouble(values[3].trim());
                int seasons = Integer.parseInt(values[4].trim());
                int episodes = Integer.parseInt(values[5].trim());
                System.out.println("Series: " + title + releaseYears +
                        Arrays.toString(categories) + rating + seasons + episodes);

                //oprette et series objekt?
                /*Series series = new Series(title, releaseYears, categories, rating, seasons, episodes);
                seriesList.add(series);
                System.out.println(series);*/
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("Filen ikke fundet!!!");
        }
        return List.of(seriesFile);
    }




    public List<User>loadUsers(){
        List<User> userList = new ArrayList<>();

        try {

            BufferedReader breader = new BufferedReader(new FileReader(userFile));
            String line = breader.readLine();

            while(line != null){


              String[] values = line.split(",");
              if (values.length >= 2){
                  User newUser = new User(values[0], values[1]);
                  userList.add(newUser);

              }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Fejl ved indlæsning af brugere: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fejl ved indlæsning af bruger. " + e.getMessage());
        }

        return userList;
    }


    public void saveUsers (List<User> userList){
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




