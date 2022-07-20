package com.minhcv.java11;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadAndWringStringInFileApp {
    public static void main(String[] args) throws Exception {
        Path dir = Files.createTempDirectory("temp");
        Path filePath = Files.writeString(Files.createTempFile(dir, "demo", ".txt"), "MinhCV test");
        String fileContent = Files.readString(filePath);
        System.out.println("File content: " + fileContent);
    }
}
