package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

@Service
public class StoredIntService {
    private static final String FILE_PATH = "/tmp/stored-int.txt";

    public int getOrCreateStoredInt() throws IOException {
        Path path = Path.of(FILE_PATH);

        if (Files.exists(path)) {
            String content = Files.readString(path);
            return Integer.parseInt(content.trim());
        } else {
            int randomInt = new Random().nextInt(1000);
            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(String.valueOf(randomInt));
            }
            return randomInt;
        }
    }
}
