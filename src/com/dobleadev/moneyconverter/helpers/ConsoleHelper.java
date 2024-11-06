package com.dobleadev.moneyconverter.helpers;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleHelper {
    public static Scanner getInput() {
        return new Scanner(System.in);
    }

    public static void waitForInput() {
        System.out.println("Presione Enter para continuar...");
        while (true) {
            try {
                System.in.read();
                break;
            } catch (Exception e) {
                // NO ERROR REALLY
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
