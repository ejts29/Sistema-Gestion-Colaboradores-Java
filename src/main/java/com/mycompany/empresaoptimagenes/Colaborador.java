// Definición de la clase Colaborador, que representa a un empleado de la empresa
package com.mycompany.empresaoptimagenes;

// Importación de clases necesarias para el manejo de fechas
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

// Clase que representa a un colaborador dentro de la empresa
class Colaborador {
    // Atributos principales del colaborador
    private final String rut; // Identificación única del colaborador
    private final String nombre; // Nombre completo del colaborador
    private final String genero; // Género del colaborador (e.g., Masculino, Femenino)
    private final Date fechaNacimiento; // Fecha de nacimiento del colaborador
    private final Date fechaIngreso; // Fecha de ingreso del colaborador a la empresa
    private final Cargo cargo; // Cargo o posición del colaborador dentro de la empresa
    private final Sueldo sueldo; // Información del sueldo del colaborador
    private boolean activo; // Estado del colaborador: activo o inactivo

    // Constructor que inicializa todos los atributos del colaborador
    public Colaborador(String rut, String nombre, String genero, Date fechaNacimiento, Date fechaIngreso, Cargo cargo, Sueldo sueldo) {
        this.rut = rut;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.activo = true; // Por defecto, un nuevo colaborador se considera activo
    }

    // Método para obtener el RUT del colaborador
    public String getRut() {
        return rut;
    }

    // Método para verificar si el colaborador está activo
    public boolean isActivo() {
        return activo;
    }

    // Método para cambiar el estado de actividad del colaborador
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Método que genera un resumen del colaborador (nombre, edad, y nombre del cargo)
    public String resumen() {
        return formatearNombre() + ", " + calcularEdad() + " anios" +
               ", Dias en el cargo: " + calcularDiasEnCargo() + ", " + calcularTiempoServicio() +
               ", " + cargo.getNombre();
    }

    // Método que genera un detalle completo del colaborador, incluyendo toda la información relevante
    public String detalle() {
        // Formateador para convertir fechas en cadenas con formato "dd-MM-yyyy"
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

        // Construcción de la cadena de detalles del colaborador
        return "RUT: " + Utilidades.formatearRutConPuntos(rut) +
                ", Nombre: " + formatearNombre() +
                ", Genero: " + genero +
                ", Edad: " + calcularEdad() + " anios" +
                ", Dias en el cargo: " + calcularDiasEnCargo() + ", " + calcularTiempoServicio() +
                ", Fecha de Ingreso: " + formatoFecha.format(fechaIngreso) +
                ", Cargo: " + cargo +
                ", Sueldo: " + sueldo +
                ", Activo: " + activo;
    }

    // Método privado para calcular la edad del colaborador en años
    private int calcularEdad() {
        return Utilidades.calcularEdad(fechaNacimiento); // Uso de la utilidad para calcular la edad
    }

    // Método privado para calcular los días que el colaborador lleva en el cargo
    private int calcularDiasEnCargo() {
        return Utilidades.calcularDias(fechaIngreso); // Uso de la utilidad para calcular los días
    }

    // Método privado para formatear el nombre como "Nombre, Apellido_M, Apellido_P"
    private String formatearNombre() {
        String[] partes = nombre.trim().split(" ");
        return partes.length >= 3 ? partes[0] + ", " + partes[1] + ", " + partes[2] : nombre;
    }

    // Método privado para calcular el tiempo de servicio en meses y años
    private String calcularTiempoServicio() {
        LocalDate ingreso = fechaIngreso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(ingreso, hoy);
        return periodo.getYears() + " anios, " + periodo.getMonths() + " meses";
    }
}
