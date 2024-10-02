package desafio.alura.api.servicios;

import desafio.alura.api.modelos.Moneda;
import java.time.LocalDateTime;

public class Conversion {
    private Moneda fromCurrency;
    private Moneda toCurrency;
    private  double amount;
    private double result;
    private LocalDateTime conversionDate;

    public Conversion(Moneda fromCurrency, Moneda toCurrency, double amount, double result) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.result = result;
        this.conversionDate = LocalDateTime.now();
    }

    public Moneda getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Moneda fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Moneda getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Moneda toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public LocalDateTime getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(LocalDateTime conversionDate) {
        this.conversionDate = conversionDate;
    }

    public String getMessage(){
        return "El valor " + amount + " [" + fromCurrency + "] corresponde al valor final de => " + result + " [" + toCurrency + "]\n";
    }

    @Override
    public String toString() {
        return "{" +
                "Moneda inicial = " + fromCurrency +
                ", Moneda final = " + toCurrency +
                ", Valor inicial = " + amount +
                ", Resultado = " + result +
                ", Fecha = " + conversionDate +
                '}'+ "\n";
    }
}