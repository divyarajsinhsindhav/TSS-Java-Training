package com.tss.model;

import com.tss.Exception.CapacityFullException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieManager implements Serializable {
    List<Movie> movies;
    final static int MAX_MOVIE_COUNT = 5;
    private static int currentMovieCount = 0;

    static final String filePath = "data.bin";

    public MovieManager() throws RuntimeException {
        movies = new ArrayList<>();
        loadMovies();
    }

    public void addMovie(Movie movie) throws CapacityFullException {
        if (currentMovieCount >= MAX_MOVIE_COUNT) {
            throw new CapacityFullException();
        }
        if (movie != null) {
            movies.add(movie);
            currentMovieCount++;
            saveMovies();
        } else {
            throw new NullPointerException();
        }
    }

    public void clearMovies() {
        movies.clear();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void loadMovies() throws RuntimeException {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File Created");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            movies = (List<Movie>) ois.readObject();
            currentMovieCount = movies.size();
            ois.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveMovies() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(movies);
            oos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAllMovies() {
        clearMovies();
        saveMovies();
        currentMovieCount = 0;
    }
}
