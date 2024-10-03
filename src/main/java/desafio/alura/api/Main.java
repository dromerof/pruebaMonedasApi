package desafio.alura.api;

import desafio.alura.api.modelos.Currency;
import desafio.alura.api.servicios.Conversion;
import desafio.alura.api.servicios.CurrencyApi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static desafio.alura.api.servicios.ShowResult.showResultMenu;

public class Main {
    public static void main(String[] args) {

        CurrencyApi currencyApi = new CurrencyApi();
        Conversion conversion;
        List<Conversion> conversions = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        int menu = -1;

        System.out.println("*************************************");
        System.out.println("Bienvenido al conversor de monedas \n");

        while (menu != 0) {
            System.out.println("Selecciona una opción del siguiente menú: \n");
            System.out.println("1. Dólar => Peso colombiano");
            System.out.println("2. Peso colombiano => Dolar");
            System.out.println("3. Dólar => Real Brasileño");
            System.out.println("4. Real Brasileño => Dólar");
            System.out.println("5. Dólar => Peso argentino");
            System.out.println("6. Peso argentino => Dólar");
            System.out.println("7. Dólar => Euro");
            System.out.println("8. Euro => Dólar");
            System.out.println("9. Historial");
            System.out.println("0. Salir");
            try {
                menu = keyboard.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Error, no estas ingresando un número valido \n");
                keyboard.next();
                continue;
            }
            switch (menu) {
                case 1 -> {
                    conversion = showResultMenu(keyboard, currencyApi, Currency.USD, Currency.COP);
                    System.out.println(conversion.getMessage());
                    conversions.add(conversion);
                }
                case 2 -> {
                    conversion = showResultMenu(keyboard, currencyApi, Currency.COP, Currency.USD);
                    System.out.println(conversion.getMessage());
                    conversions.add(conversion);
                }
                case 3 -> {
                    conversion = showResultMenu(keyboard, currencyApi, Currency.USD, Currency.BRL);
                    System.out.println(conversion.getMessage());
                    conversions.add(conversion);
                }
                case 4 -> {
                    conversion = showResultMenu(keyboard, currencyApi, Currency.BRL, Currency.USD);
                    System.out.println(conversion.getMessage());
                    conversions.add(conversion);
                }
                case 5 -> {
                    conversion = showResultMenu(keyboard, currencyApi, Currency.USD, Currency.ARS);
                    System.out.println(conversion.getMessage());
                    conversions.add(conversion);
                }
                case 6 -> {
                    conversion = showResultMenu(keyboard, currencyApi, Currency.ARS, Currency.USD);
                    System.out.println(conversion.getMessage());
                    conversions.add(conversion);
                }
                case 7 -> {
                    conversion = showResultMenu(keyboard, currencyApi, Currency.USD, Currency.EUR);
                    System.out.println(conversion.getMessage());
                    conversions.add(conversion);
                }
                case 8 -> {
                    conversion = showResultMenu(keyboard, currencyApi, Currency.EUR, Currency.USD);
                    System.out.println(conversion.getMessage());
                    conversions.add(conversion);
                }
                case 9 -> {
                    System.out.println("Historial de conversiones:\n");
                    if (conversions.isEmpty()) {
                        System.out.println("Lista vacía, no ha hecho niguna conversión");
                    } else {
                        System.out.println(conversions);
                    }
                }
                case 0 -> System.out.println("Saliendo del sistema \n");
                default -> System.out.println("Opción incorrecta \n");
            }
        }


    }
}