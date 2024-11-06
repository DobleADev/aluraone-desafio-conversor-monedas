package com.dobleadev.moneyconverter.services;

import com.dobleadev.moneyconverter.helpers.ConsoleHelper;
import com.dobleadev.moneyconverter.helpers.FileHelper;

public class ConversionSaveService {
    public void askToSave(String contentToSave) {
        try {
            while (true)
            {
                System.out.print("Deseas guardar la ultima conversion hecha? y/n: ");
                String answer = ConsoleHelper.getInput().nextLine();
                switch (answer.toLowerCase()) {
                    case "y": {
                        System.out.print("\nComo quieres que se llame el archivo? ");
                        String fileName = ConsoleHelper.getInput().nextLine();
                        String folderName = "LocalSave";
                        FileHelper.CheckOrAddDirectory(folderName);
                        FileHelper.WriteLineOnFile(folderName + "/" + fileName + ".log", contentToSave);
                        System.out.println("Guardado exitoso! Revisa la carpeta local: \"" + folderName + "\"");
                        ConsoleHelper.waitForInput();
                        return;
                    }
                    case "n": {
                        return;
                    }
                    default: {
                        System.out.println("ERROR: Repita su respuesta porfavor.");
                    } break;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            ConsoleHelper.waitForInput();
        }

    }
}
