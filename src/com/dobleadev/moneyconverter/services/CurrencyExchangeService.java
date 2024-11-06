package com.dobleadev.moneyconverter.services;

import com.dobleadev.moneyconverter.helpers.HttpHelper;
import com.dobleadev.moneyconverter.modules.Currency;
import com.dobleadev.moneyconverter.modules.CurrencyExchangeRateApiList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Scanner;

public class CurrencyExchangeService {
    Gson gson = new GsonBuilder()
            .create();
    Scanner input = new Scanner(System.in);
    String defaultCurrency = "USD";
    Currency fromCurrency = new Currency(defaultCurrency, "US");
    Currency toCurrency = new Currency(defaultCurrency, "US");

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void doExchange() {
        try {

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public Currency changeExchangeType(Currency currency) {
        try {
            while (true)
            {
                System.out.println("Elije el peso a cambiar: ");
                // Accessing supported_codes directly
                List<String[]> supportedCodes = gson.fromJson(HttpHelper.requestData("https://v6.exchangerate-api.com/v6/96ae7394859d92c682c56188/codes"), CurrencyExchangeRateApiList.class).supported_codes();
                for (String[] item: supportedCodes) {
                    System.out.print("[" + item[0] + "]");
                }
                System.out.print("\nDigite su eleccion: ");
                String currencyChoice = input.nextLine();
                String[] currencyFounded = null;

                for (String[] item: supportedCodes) {
                    if (item[0].equals(currencyChoice)) {
                        currencyFounded = item;
                        break;
                    }
                }

                if (currencyFounded != null) {
                    System.out.println("Se encontró a " + currencyChoice);
                    return new Currency(currencyFounded[0], "");
                } else {
                    System.out.println("ERROR - No se encontró el peso ingresado.");
                }
            }
        } catch (Exception e) {
//            throw new RuntimeException();
            System.out.println("Error inesperado:\n" + e.getMessage());
        }
        return currency;
    }
}
