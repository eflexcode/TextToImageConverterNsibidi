package com.larrex.TextToImageConverterNsibidi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String word;
    private String imageUrl;

}
