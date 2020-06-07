package CalculadoraFinal;

public class Calculator {
    private int resultado;

    public int sumar(int n1, int n2) {
        resultado = n1 + n2;
        return resultado;
    }

    public int restar(int n1, int n2) {
        resultado = n1 - n2;
        return resultado;
    }

    public int dividir(int n1, int n2) {
        resultado = n1 / n2;
        return resultado;
    }

    public int dividirPorCero(int n1, int n2) {
        if (n2 == 0) {
            throw new ArithmeticException ("No se puede dividir por 0");
        }
        resultado = n1 / n2;
        return resultado;
    }

    public void longTaskOperation() {
        try {
            Thread.sleep (1000);
        } catch (Exception e) {}
    }
}


