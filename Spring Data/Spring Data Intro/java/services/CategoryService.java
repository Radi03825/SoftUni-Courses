package main.java.com.example.springdemo.services;

import com.example.springdemo.models.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;
    Set<Category> getRandomCategories();
}
