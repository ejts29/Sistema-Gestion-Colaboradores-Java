// Definición de la clase Cargo, que representa el cargo de un colaborador en la empresa
package com.mycompany.empresaoptimagenes;

// Clase que representa el cargo o posición de un colaborador dentro de la empresa
class Cargo {
    // Atributos principales del cargo
    private final String nombre; // Nombre del cargo (e.g., Gerente, Analista)
    private final String departamento; // Departamento al que pertenece el cargo (e.g., Recursos Humanos, TI)

    // Constructor que inicializa el nombre del cargo y el departamento
    public Cargo(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    // Método para obtener el nombre del cargo
    public String getNombre() {
        return nombre;
    }

    // Sobrescritura del método `toString` para proporcionar una representación textual del cargo
    @Override
    public String toString() {
        // Devuelve una descripción del cargo con su nombre y departamento en formato "Nombre (Departamento)"
        return nombre + " (" + departamento + ")";
    }
}
