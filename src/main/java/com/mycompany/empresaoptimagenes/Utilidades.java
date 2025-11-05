// Definición de la clase Utilidades, que contiene métodos auxiliares utilizados en la aplicación
package com.mycompany.empresaoptimagenes;

import java.text.ParseException;         // Necesario para manejar errores al parsear fechas (ej. si el formato es incorrecto).
import java.text.SimpleDateFormat;       // Clase para formatear y parsear fechas en un formato específico (ej. "dd-MM-yyyy").
import java.time.LocalDate;              // Importa la clase LocalDate de la nueva API de fecha/hora de Java 8+.
import java.time.Period;                 // Importa la clase Period de la nueva API de fecha/hora.
import java.time.ZoneId;                 // Importa ZoneId para convertir entre java.util.Date y java.time.LocalDate.
import java.util.Date;                   // Importa la clase Date de la API antigua de fecha/hora.
import java.util.Scanner;                // Importa la clase Scanner para leer la entrada del usuario desde la consola.

// Clase de utilidades que proporciona métodos auxiliares para diferentes funcionalidades
class Utilidades {

    // Método para formatear un RUT eliminando puntos y guion
    public static String formatearRut(String rut) {
        // Verifica si el RUT es nulo o está vacío
        if (rut == null || rut.isEmpty()) return null;

        // Elimina puntos y guion del RUT
        rut = rut.replaceAll("\\.", "").replaceAll("-", "");

        // Valida que el RUT cumpla con el formato esperado (7-8 dígitos seguidos de un dígito o 'k')
        if (!rut.matches("\\d{7,8}[0-9kK]")) {
            System.out.println("RUT no valido. Intente nuevamente.");
            return null;
        }

        // Retorna el RUT formateado
        return rut;
    }

    // Método para agregar puntos y guion a un RUT
    public static String formatearRutConPuntos(String rut) {
        // Verifica si el RUT es nulo, vacío o no cumple con el formato esperado
        if (rut == null || rut.isEmpty() || !rut.matches("\\d{7,8}[0-9kK]")) return rut;

        // Divide el RUT en el cuerpo numérico y el dígito verificador (DV)
        String cuerpo = rut.substring(0, rut.length() - 1);
        String dv = rut.substring(rut.length() - 1);

        // Agrega puntos al cuerpo del RUT y un guion antes del DV
        return cuerpo.replaceAll("(\\d)(?=(\\d{3})+$)", "$1.") + "-" + dv;
    }

    // Método para leer y validar el género del usuario
    public static String leerGenero(Scanner scanner) {
        while (true) {
            System.out.print("Genero (Masculino/Femenino/Otro): ");
            String genero = scanner.nextLine().trim();

            // Valida que el género sea uno de los valores aceptados
            if (genero.equalsIgnoreCase("Masculino") || 
                genero.equalsIgnoreCase("Femenino") || 
                genero.equalsIgnoreCase("Otro")) {
                return genero; // Retorna el género válido
            }

            // Mensaje de error si el género no es válido
            System.out.println("Entrada no valida. Intente nuevamente.");
        }
    }

    // Método para leer y validar una fecha ingresada por el usuario
    public static Date leerFecha(Scanner scanner, String mensaje) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); // Define el formato de fecha esperado
        formato.setLenient(false); // Desactiva la leniencia para validar estrictamente las fechas

        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            try {
                return formato.parse(entrada); // Intenta parsear la fecha
            } catch (ParseException e) {
                System.out.println("Fecha no valida. Intente nuevamente. Formato: dd-MM-yyyy"); // Muestra un error si el formato no es válido
            }
        }
    }

    // Método para calcular la edad a partir de una fecha de nacimiento usando LocalDate
    public static int calcularEdad(Date fechaNacimiento) {
        LocalDate fechaNacimientoLocal = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual = LocalDate.now(); // Obtiene la fecha actual

        Period periodo = Period.between(fechaNacimientoLocal, fechaActual);
        return periodo.getYears(); // Retorna la edad en años
    }

    // Método para calcular el número de días desde una fecha específica hasta hoy
    public static int calcularDias(Date fechaInicio) {
        LocalDate fechaInicioLocal = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy = LocalDate.now(); // Obtiene la fecha actual

        long diferenciaDias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicioLocal, hoy);
        return (int) diferenciaDias; // Retorna la diferencia en días
    }
}
