package desafio.alura.api.servicios;

import desafio.alura.api.modelos.Moneda;

import java.time.LocalDateTime;

public class Conversion {
    private Moneda monedaInicial;
    private Moneda monedaFinal;
    private double cantidad;
    private double resultado;
    private LocalDateTime fechaConversion;

    public Conversion(Moneda monedaInicial, Moneda monedaFinal, double cantidad, double resultado, LocalDateTime fechaConversion) {
        this.monedaInicial = monedaInicial;
        this.monedaFinal = monedaFinal;
        this.cantidad = cantidad;
        this.resultado = resultado;
        this.fechaConversion = fechaConversion;
    }

    public Moneda getMonedaInicial() {
        return monedaInicial;
    }

    public void setMonedaInicial(Moneda monedaInicial) {
        this.monedaInicial = monedaInicial;
    }

    public Moneda getMonedaFinal() {
        return monedaFinal;
    }

    public void setMonedaFinal(Moneda monedaFinal) {
        this.monedaFinal = monedaFinal;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public LocalDateTime getFechaConversion() {
        return fechaConversion;
    }

    public void setFechaConversion(LocalDateTime fechaConversion) {
        this.fechaConversion = fechaConversion;
    }

    public String getMessage(){
        return "El valor " + cantidad + " [" + monedaInicial + "] corresponde al valor final de => " + resultado + " [" + monedaFinal + "]\n";
    }

    @Override
    public String toString() {
        return "{" +
                "Moneda inicial = " + monedaInicial +
                ", Moneda final = " + monedaFinal +
                ", Valor inicial = " + cantidad +
                ", Resultado = " + resultado +
                ", Fecha = " + fechaConversion +
                '}'+ "\n";
    }

}

