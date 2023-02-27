package main.java.com.example.springdemo.services;

import com.example.springdemo.models.Author;
import main.java.com.example.springdemo.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of("Spring Data/Exam/src/main/resources/files/authors.txt"))
                .stream().forEach(e -> {
                    String[] split = e.split(" ");
                    authorRepository.save(new Author(split[0], split[1]));
                });
    }

    @Override
    public Author getRandomAuthor() {
        long size = this.authorRepository.count();

        int authorId = new Random().nextInt((int) size) + 1;

        return this.authorRepository.findById(authorId).get();
    }
}
