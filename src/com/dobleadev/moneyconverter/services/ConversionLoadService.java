package com.dobleadev.moneyconverter.services;

import com.dobleadev.moneyconverter.helpers.ConsoleHelper;
import com.dobleadev.moneyconverter.helpers.FileHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConversionLoadService {
    public void askToLoad() {
        try {
            File folder = new File("LocalSave");
            if (!folder.exists() || !folder.isDirectory()) {
                System.out.println("No hay datos guardados.");
                ConsoleHelper.waitForInput();
                return;
            }

            File[] files = folder.listFiles();
            System.out.println("\n________________________________________________________");
            System.out.println("Archivos encontrados en la carpeta de guardado:");
            for (int i = 0; i < files.length; i++) {
                System.out.println((i + 1) + ". " + files[i].getName());
            }
            System.out.println("\n________________________________________________________");
            System.out.print("Selecciona el número del archivo que deseas leer: ");
            int option = ConsoleHelper.getInput().nextInt();
            if (option > 0 && option <= files.length) {
                File archivoSeleccionado = files[option - 1];
                System.out.println("Contenido del archivo " + archivoSeleccionado.getName() + ":");
                BufferedReader reader = new BufferedReader(new FileReader(archivoSeleccionado));
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
                reader.close();
                ConsoleHelper.waitForInput();
            } else {
                System.out.println("Opción inválida.");
                ConsoleHelper.waitForInput();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            ConsoleHelper.waitForInput();
        }
    }
}
