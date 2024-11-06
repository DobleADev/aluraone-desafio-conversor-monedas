package com.dobleadev.moneyconverter.helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {
    public static void CheckOrAddDirectory(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Carpeta creada correctamente: " + path);
            } else {
                System.out.println("No se pudo crear la folder: " + path);
            }
        } else {
//            System.out.println("La folder ya existe: " + path);
        }
    }

    public static void WriteLineOnFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
