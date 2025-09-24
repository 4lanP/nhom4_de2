class Movie {
    private String title;
    private int duration;
    private double rating;
    public Movie(String title, int duration, double rating) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }
    public int getDuration() {
        return duration;
    }
    public double getRating() {
        return rating;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    @Override
    //hiển thị thông tin phim
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", duration=" + duration + " minutes" +
                ", rating=" + rating +
                '}';
    }
}

class Cinema {
    private Movie[] movies;
    private int movieCount;
    private static int totalMovies = 0;

    public Cinema(int capacity) {
        this.movies = new Movie[capacity];
        this.movieCount = 0;
    }

    public void addMovie(Movie movie) {
        if (movieCount < movies.length) {
            movies[movieCount] = movie;
            movieCount++;
            totalMovies++;
            System.out.println("Added movie: " + movie.getTitle());
        } else {
            System.out.println("Cinema is full, cannot add new movie!");
        }
    }

    public void showMovies() {
        System.out.println("\n=== MOVIE LIST IN CINEMA ===");
        if (movieCount == 0) {
            System.out.println("No movies in cinema.");
            return;
        }

        for (int i = 0; i < movieCount; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }
        System.out.println("Total movies: " + movieCount);
    }

    public void showLongMovies() {//phim có thời lượng > 120 phút
        System.out.println("\n=== MOVIES WITH DURATION > 120 MINUTES ===");
        boolean foundLongMovie = false;

        //kiểm tra nếu không có phim nào
        for (int i = 0; i < movieCount; i++) {
            if (movies[i].getDuration() > 120) {
                System.out.println("- " + movies[i]);
                foundLongMovie = true;
            }
        }

        //nếu không có phim nào có thời lượng > 120 phút
        if (!foundLongMovie) {
            System.out.println("No movies with duration > 120 minutes.");
        }
    }

    public static int getTotalMovies() {
        return totalMovies;
    }

    public int getMovieCount() {
        return movieCount;
    }
}

public class CinemaManagement { 
    public static void main(String[] args) {//main
        Cinema cinema = new Cinema(10);//tạo class cinema với sức chứa 10 phim

        //tạo 5 phim
        Movie movie1 = new Movie("Avengers: Endgame", 181, 8.4);
        Movie movie2 = new Movie("Spider-Man: No Way Home", 148, 8.2);
        Movie movie3 = new Movie("The Batman", 176, 7.8);
        Movie movie4 = new Movie("Top Gun: Maverick", 130, 8.3);
        Movie movie5 = new Movie("Minions: The Rise of Gru", 87, 6.5);

        //thêm phim vào rạp
        cinema.addMovie(movie1);
        cinema.addMovie(movie2);
        cinema.addMovie(movie3);
        cinema.addMovie(movie4);
        cinema.addMovie(movie5);

        //hiển thị danh sách phim
        cinema.showMovies();

        //hiển thị phim có thời lượng > 120 phút
        cinema.showLongMovies();

        //hiển thị tổng số phim đã tạo và số phim hiện có trong rạp
        System.out.println("\nTotal movies created: " + Cinema.getTotalMovies());
        System.out.println("Current movies in cinema: " + cinema.getMovieCount());
    }
}