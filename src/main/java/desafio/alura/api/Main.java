package desafio.alura.api;

import desafio.alura.api.modelos.Currency;
import desafio.alura.api.servicios.Conversion;
import desafio.alura.api.servicios.CurrencyApi;

import java.util.*;

import static desafio.alura.api.servicios.ShowResult.showResultMenu;

public class Main {
    public static void main(String[] args) {
        CurrencyApi currencyApi = new CurrencyApi();
        Optional<Conversion> conversion;
        List<Optional<Conversion>> conversions = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        int menu = -1;

        System.out.println("*************************************");
        System.out.println("Bienvenido al conversor de monedas \n");

        // Mapa de opciones de conversión
        Map<Integer, Currency[]> conversionMap = new HashMap<>();
        conversionMap.put(1, new Currency[]{Currency.USD, Currency.COP});
        conversionMap.put(2, new Currency[]{Currency.COP, Currency.USD});
        conversionMap.put(3, new Currency[]{Currency.USD, Currency.BRL});
        conversionMap.put(4, new Currency[]{Currency.BRL, Currency.USD});
        conversionMap.put(5, new Currency[]{Currency.USD, Currency.ARS});
        conversionMap.put(6, new Currency[]{Currency.ARS, Currency.USD});
        conversionMap.put(7, new Currency[]{Currency.USD, Currency.EUR});
        conversionMap.put(8, new Currency[]{Currency.EUR, Currency.USD});

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
            } catch (InputMismatchException e) {
                System.out.println("Error, no estas ingresando un número válido \n");
                keyboard.next(); // Limpiar el buffer
                continue;
            }

            switch (menu) {
                case 1, 2, 3, 4, 5, 6, 7, 8 -> {
                    Currency[] currencies = conversionMap.get(menu);
                    conversion = showResultMenu(keyboard, currencyApi, currencies[0], currencies[1]);
                    System.out.println(conversion.get().getMessage());
                    conversions.add(conversion);
                }
                case 9 -> {
                    System.out.println("Historial de conversiones:\n");
                    if (conversions.isEmpty()) {
                        System.out.println("Lista vacía, no ha hecho ninguna conversión");
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