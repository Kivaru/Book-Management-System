package com.book.libary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;  
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String author;
    private Double price;

    public String getTitle(String title){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(String author){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public Double getPrice(Double price){
        return price;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }

}
