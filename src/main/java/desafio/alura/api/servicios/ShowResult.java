package desafio.alura.api.servicios;

import desafio.alura.api.modelos.Currency;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class ShowResult {

    public static Optional<Conversion> showResultMenu(Scanner keyboard, CurrencyApi currencyApi, Currency from, Currency to) {
        double amount = Double.NaN;

        while (Double.isNaN(amount)) {
            System.out.println("Diga el valor que desea convertir de " + from + " a " + to);
            String input = keyboard.next().replace(",", ".");

            amount = parseNumber(input, Locale.US);

            if (Double.isNaN(amount)) {
                System.out.println("Por favor coloca un valor válido\n");
            }
        }

        return Optional.of(currencyApi.convertCurrency(from, to, amount));
    }

    private static double parseNumber(String input, Locale locale) {
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        try {
            return numberFormat.parse(input).doubleValue();
        } catch (ParseException e) {
            return Double.NaN;
        }
    }
}
