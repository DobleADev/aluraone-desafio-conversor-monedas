package com.dobleadev.moneyconverter.main;

import com.dobleadev.moneyconverter.helpers.HttpHelper;
import com.dobleadev.moneyconverter.services.CurrencyExchangeService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();

        while (true) {
            System.out.print("""
___________________________________________________
                Exchange App
1- Realizar conversion de [""" + currencyExchangeService.getFromCurrency() + "] a [" + currencyExchangeService.getToCurrency() + "]" + """
        
2- Cambiar peso de entrada [""" + currencyExchangeService.getFromCurrency() + "]" + """
        
3- Cambiar peso de salida  [""" + currencyExchangeService.getToCurrency() + "]" + """
        
        
        0- Salir
___________________________________________________
Digite su eleccion:\s""");
            int opcion = input.nextInt();
            if (opcion == 0) break; // Quit
            switch (opcion) {
                case 1: { // Do exchange
                    currencyExchangeService.doExchange();
                } break;
                case 2: { // Change bill from type
                    currencyExchangeService.setFromCurrency(currencyExchangeService.changeExchangeType(currencyExchangeService.getFromCurrency()));
                } break;
                case 3: { //  Change bill to type
                    currencyExchangeService.setToCurrency(currencyExchangeService.changeExchangeType(currencyExchangeService.getToCurrency()));
                } break;
                default: { // Invalid choice
                    System.out.println("ERROR - Opcion invalida");
                } break;
            }
        }
        System.out.println("Gracias por usar nuestro programa");
    }
}
