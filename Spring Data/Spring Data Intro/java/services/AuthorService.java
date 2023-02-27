package main.java.com.example.springdemo.services;

import com.example.springdemo.models.Author;

import java.io.IOException;

public interface AuthorService {
    void seedAuthors() throws IOException;
    Author getRandomAuthor();
}
