package com.dobleadev.moneyconverter.main;

import com.dobleadev.moneyconverter.helpers.ConsoleHelper;
import com.dobleadev.moneyconverter.services.ConversionLoadService;
import com.dobleadev.moneyconverter.services.CurrencyExchangeService;

public class Program {
    public static void main(String[] args) {
        CurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();
        ConversionLoadService conversionLoadService = new ConversionLoadService();

        while (true) {
            System.out.print("""
___________________________________________________
                Exchange App
1- Realizar conversion de [""" + currencyExchangeService.getFromCurrency() + "] a [" + currencyExchangeService.getToCurrency() + "]" + """
        
2- Cambiar peso de entrada [""" + currencyExchangeService.getFromCurrency() + "]" + """
        
3- Cambiar peso de salida  [""" + currencyExchangeService.getToCurrency() + "]" + """
        
4- Ver registros guardados
0- Salir
___________________________________________________
Digite su eleccion:\s""");
            int opcion = ConsoleHelper.getInput().nextInt();
            ConsoleHelper.clearScreen();
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
                case 4: { //  Change bill to type
                    conversionLoadService.askToLoad();
                } break;
                default: { // Invalid choice
                    System.out.println("ERROR - Opcion invalida");
                    ConsoleHelper.waitForInput();
                } break;
            }
            ConsoleHelper.clearScreen();
        }
        System.out.println("Gracias por usar nuestro programa");
    }
}
