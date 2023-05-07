package com.larrex.TextToImageConverterNsibidi.controller;

import com.larrex.TextToImageConverterNsibidi.TextToImageConverterNsibidiApplication;
import com.larrex.TextToImageConverterNsibidi.model.Status;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/text_to_image/")
public class GenerateImageController {

    @GetMapping("word")
    public ResponseEntity<byte[]> generateImage(@RequestParam(name = "word") String word) throws IOException, FontFormatException {

        int width = 500;
        int height = 300;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics graphics = bufferedImage.getGraphics();
        Font fontFile = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\user\\Downloads\\Akagu20203.ttf"));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontFile);

        graphics.setFont(new Font("Akagu", Font.PLAIN, 40));
        FontMetrics fontMetrics = graphics.getFontMetrics();

        int x = (width - fontMetrics.stringWidth(word)) / 2;
        int y = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();

        graphics.drawString(word, x, y);

        File file = new File("C:\\Users\\user\\Downloads\\" + System.currentTimeMillis() + ".png");

        ImageIO.write(bufferedImage, "png", file);

        byte[] bytes = Files.readAllBytes(file.toPath());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("sentence")
    public ResponseEntity<byte[]> generate(@RequestParam(name = "sentence") String sentence) throws IOException, FontFormatException {

        int width = sentence.length() * 22;
        int height = 50;
        System.out.println(width);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics graphics = bufferedImage.getGraphics();
        Font fontFile = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\user\\Downloads\\Akagu20203.ttf"));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fontFile);

        graphics.setFont(new Font("Akagu", Font.BOLD, 22));
        FontMetrics fontMetrics = graphics.getFontMetrics();

        int x = (width - fontMetrics.stringWidth(sentence)) / 2;
        int y = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();

        graphics.drawString(sentence, x, y);

        File file = new File("C:\\Users\\user\\Downloads\\" + System.currentTimeMillis() + ".png");

        ImageIO.write(bufferedImage, "png", file);

        byte[] bytes = Files.readAllBytes(file.toPath());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.OK);
    }

}