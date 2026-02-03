package com.tss.model;

import com.tss.Exception.CapacityFullException;
import com.tss.Exception.NoSuchMovieFoundException;

import java.util.Scanner;

public class MovieController {
    private MovieManager manager;
    Scanner scanner = new Scanner(System.in);
    public MovieController() {
        this.manager = new MovieManager();
    }

    public void start() {
        while(true) {
            System.out.println("""
                1. Display Movies
                2. Add Movies
                3. Delete All Movies
                4. Update movie
                5. Exit
                """);
            System.out.println("Enter Your choice: ");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    displayMovies();
                    break;
                case 2:
                    try {
                        addMovies();
                    } catch (CapacityFullException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    manager.deleteAllMovies();
                    break;
                case 4:
                    try {
                        setMovieDetails();
                    } catch (NoSuchMovieFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Please enter valid choice");
            }
        }
    }

    private void addMovies() {
        try {
            System.out.println("Enter id");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter release year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter genre: ");
            String genre = scanner.nextLine();
            Movie movie = new Movie(id, name, year, genre);
            manager.addMovie(movie);
        } catch (CapacityFullException e) {
            System.out.println(e.getMessage());
        }
    }

    private Movie getMovieById(int id) {
        for (Movie item : manager.getMovies()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private Movie getMovieByName() {
        return null;
    }

    private void displayMovies() {
        for (Movie item : manager.getMovies()) {
            System.out.println(item.toString());
        }
    }

    private void setMovieDetails() {
        System.out.println("Enter movie Id: ");
        int id = scanner.nextInt();

        Movie movie = getMovieById(id);

        if (movie == null) {
            throw new NoSuchMovieFoundException();
        }

        System.out.println(movie);

        scanner.nextLine();
        System.out.println("\nUpdate Name: ");
        String name = scanner.nextLine();

        System.out.println("Update Year: ");
        int year = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Update genre: ");
        String genre = scanner.nextLine();

        movie.setName(name);
        movie.setYear(year);
        movie.setGenre(genre);

        manager.saveMovies();
    }

    public void deleteSingleMovie() {
        System.out.println("Enter movie Id: ");
        int id = scanner.nextInt();

        Movie movie = getMovieById(id);

        if (movie != null) {
            //TODO
        }
    }
}
