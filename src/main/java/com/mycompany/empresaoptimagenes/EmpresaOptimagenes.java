package com.mycompany.empresaoptimagenes;

// Importación de la clase Scanner y otras utilidades necesarias
import java.util.*;

public class EmpresaOptimagenes {
    // Definición de la lista estática de colaboradores y el objeto scanner para leer entradas
    private static final List<Colaborador> colaboradores = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Bucle infinito para mostrar continuamente el menú hasta que el usuario decida salir
        while (true) {
            mostrarMenu(); // Muestra el menú principal
            int opcion = leerEntero("Seleccione una opcion: "); // Lee la opción seleccionada por el usuario

            switch (opcion) {
                // En el caso de que el usuario elija la opción 1 (ingresar colaborador)
                case 1 -> ingresarColaborador();
                // En el caso de que el usuario elija la opción 2 (ver colaborador)
                case 2 -> verColaborador();
                // En el caso de que el usuario elija la opción 3 (eliminar colaborador)
                case 3 -> eliminarColaborador();
                // En el caso de que el usuario elija la opción 4 (ver estado de la empresa)
                case 4 -> estadoEmpresa();
                // En el caso de que el usuario elija la opción 5 (salir del sistema)
                case 5 -> {
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    return; // Termina la ejecución del programa
                }
                // En caso de que el usuario ingrese una opción no válida
                default -> System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }
    }

    // Método para mostrar el menú principal de opciones
    private static void mostrarMenu() {
        System.out.println("\nMenu Principal");
        System.out.println("1. Ingresar Colaborador");
        System.out.println("2. Ver Colaboradores");
        System.out.println("3. Eliminar Colaborador");
        System.out.println("4. Estado de la Empresa");
        System.out.println("5. Salir");
    }

    // Método para ingresar los datos de un nuevo colaborador
    private static void ingresarColaborador() {
        System.out.println("\nIngrese los datos del colaborador:");

        // Solicitar el RUT, asegurándose de que esté bien formateado
        String rut;
        while (true) {
            rut = Utilidades.formatearRut(leerCadena("RUT (sin puntos ni guion, debe tener minimo 8 numeros y maximo 9 con digito verificador): "));
            if (rut != null) break;
        }

        // Solicitar el nombre completo del colaborador, asegurándose de que solo contenga letras
        String nombre;
        while (true) {
            nombre = leerCadena("Nombre completo (Nombre Apellido_Materno Apellido_Paterno ): ");
            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) break;
            System.out.println("El nombre solo debe contener letras. Intente nuevamente.");
        }

        // Leer el género usando el método de utilidad
        String genero = Utilidades.leerGenero(scanner);

        // Leer las fechas de nacimiento e ingreso
        Date fechaNacimiento = Utilidades.leerFecha(scanner, "Ingrese la Fecha de nacimiento con este formato (DD-MM-YYYY): ");
        Date fechaIngreso = Utilidades.leerFecha(scanner, "Fecha de ingreso o contratacion  del empleado con este formato (DD-MM-YYYY): ");

        // Solicitar el cargo del colaborador, asegurándose de que solo contenga letras
        String cargo;
        while (true) {
            cargo = leerCadena("Cargo: ");
            if (cargo.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) break;
            System.out.println("El cargo solo debe contener letras. Intente nuevamente.");
        }

        // Leer el departamento
        String departamento = leerCadena("Departamento: ");

        // Solicitar el sueldo base, asegurándose de que sea un número positivo
        int sueldoBase;
        while (true) {
            sueldoBase = leerEntero("Sueldo base: ");
            if (sueldoBase > 0) break;
            System.out.println("El sueldo base debe ser un numero positivo. Intente nuevamente.");
        }

        // Crear los objetos de cargo y sueldo
        Cargo cargoObj = new Cargo(cargo, departamento);
        Sueldo sueldo = new Sueldo(sueldoBase);

        // Crear un nuevo colaborador y agregarlo a la lista
        colaboradores.add(new Colaborador(rut, nombre, genero, fechaNacimiento, fechaIngreso, cargoObj, sueldo));
        System.out.println("Colaborador ingresado exitosamente.");
    }

    // Método para mostrar la lista de colaboradores y sus detalles
    private static void verColaborador() {
        System.out.println("\nLista de colaboradores:");
        if (colaboradores.isEmpty()) {
            System.out.println("No hay colaboradores registrados.");
        } else {
            for (Colaborador c : colaboradores) {
                System.out.println(c.detalle()); // Mostrar detalles de cada colaborador
            }
        }
    }

    // Método para desactivar un colaborador a partir de su RUT
    private static void eliminarColaborador() {
        String rut = leerCadena("Ingrese el RUT del colaborador a desactivar (sin puntos ni guion): ");
        boolean encontrado = false;
        for (Colaborador c : colaboradores) {
            if (c.getRut().equals(rut)) {
                c.setActivo(false); // Marcar al colaborador como inactivo
                System.out.println("Colaborador desactivado exitosamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro un colaborador con ese RUT.");
        }
    }

    // Método para mostrar el estado de la empresa, clasificando colaboradores activos e inactivos
    private static void estadoEmpresa() {
        System.out.println("\n[Colaboradores Activos]");
        boolean hayActivos = false;
        for (Colaborador c : colaboradores) {
            if (c.isActivo()) {
                System.out.println(c.resumen()); // Mostrar resumen de colaboradores activos
                hayActivos = true;
            }
        }
        if (!hayActivos) {
            System.out.println("No hay colaboradores activos.");
        }

        System.out.println("\n[Colaboradores Inactivos]");
        boolean hayInactivos = false;
        for (Colaborador c : colaboradores) {
            if (!c.isActivo()) {
                System.out.println(c.resumen()); // Mostrar resumen de colaboradores inactivos
                hayInactivos = true;
            }
        }
        if (!hayInactivos) {
            System.out.println("No hay colaboradores inactivos.");
        }
    }

    // Método para leer una cadena de texto con un mensaje personalizado
    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    // Método para leer un número entero con validación de entrada
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no valida. Intente nuevamente.");
            }
        }
    }
}
