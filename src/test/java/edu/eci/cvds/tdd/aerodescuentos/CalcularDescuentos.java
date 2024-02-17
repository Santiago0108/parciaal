package edu.eci.cvds.tdd.aerodescuentos;

import edu.eci.cvds.tdd.aerodescuentos.ExcepcionParametrosInvalidos;

/**
 * Calcula la tarifa de cada billete según el trayecto, la antelación
 * en la que se obtiene el billete y la edad del pasajero, de acuerdo
 * con la normativa 005.
 *
 * @param tarifaBase     valor base del vuelo
 * @param diasAntelacion días de antelación del vuelo
 * @param edad           - edad del pasajero
 * @throws ExcepcionParametrosInvalidos si los parámetros son inválidos
 */

public class CalcularDescuentos {
    private double totalDescuento;

    public void CalculoTarifa() {
        totalDescuento = 0;
    }

    public int calcularDescuento(int edad, int diasAntelacion) throws ExcepcionParametrosInvalidos {
        if (edad < 0 || edad > 135 || diasAntelacion < 0 || diasAntelacion > 365) {
            throw new ExcepcionParametrosInvalidos("Edad o días de antelación inválidos");
        }

        totalDescuento = 0;
        if (edad >= 0 && edad <= 17) {
            totalDescuento += 0.5;
        }
        if (edad >= 65 && edad <= 135) {
            totalDescuento += 0.8;
        }
        if (diasAntelacion > 20) {
            totalDescuento += 0.15;
        }
        return (int) (totalDescuento * 100);
    }

    public double calcularPrecioFinal(long tarifaBase) throws ExcepcionParametrosInvalidos {
        if (tarifaBase <= 0) {
            throw new ExcepcionParametrosInvalidos("Tarifa base inválida.");
        }

        return tarifaBase * (1.0 - totalDescuento);
    }
}
