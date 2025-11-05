// Definición de la clase Sueldo, que representa el sueldo de un colaborador en la empresa
package com.mycompany.empresaoptimagenes;

// Clase que representa el sueldo de un colaborador
class Sueldo {
    // Atributos principales del sueldo
    private final int base; // Sueldo base del colaborador
    private static final int GRATIFICACION = 75000; // Monto fijo correspondiente a la gratificación
    private static final int COLACION = 20000; // Monto fijo correspondiente a la colación
    private static final int LOCOMOCION = 35000; // Monto fijo correspondiente a la locomoción
    private static final double DESCUENTO_SALUD = 0.07; // Porcentaje del sueldo base destinado a salud
    private static final double DESCUENTO_AFP = 0.10; // Porcentaje del sueldo base destinado a AFP (previsión)

    // Constructor que inicializa el sueldo base
    public Sueldo(int base) {
        this.base = base;
    }

    // Método para calcular el sueldo líquido del colaborador
    public double calcularLiquido() {
        // Base imponible: sueldo base + gratificación
        double imponible = base + GRATIFICACION;
        // Suma de los descuentos por salud y AFP sobre la base imponible
        double descuentos = imponible * (DESCUENTO_SALUD + DESCUENTO_AFP);
        // Cálculo del sueldo líquido: base + beneficios - descuentos
        return base + GRATIFICACION + COLACION + LOCOMOCION - descuentos;
    }

    // Sobrescritura del método `toString` para proporcionar una representación textual del sueldo
    @Override
    public String toString() {
        double imponible = base + GRATIFICACION;
        double descuentoSalud = imponible * DESCUENTO_SALUD;
        double descuentoAFP = imponible * DESCUENTO_AFP;
        double liquido = calcularLiquido();
        // Devuelve el sueldo base y el sueldo líquido con todos sus componentes desglosados
        return "Base: $" + base +
               ", Gratificacion: $" + GRATIFICACION +
               ", Colacion: $" + COLACION +
               ", Locomocion: $" + LOCOMOCION +
               ", Salud (7% sobre imponible): -$" + String.format("%.2f", descuentoSalud) +
               ", AFP (10% sobre imponible): -$" + String.format("%.2f", descuentoAFP) +
               ", Liquido: $" + String.format("%.2f", liquido);
    }
}
