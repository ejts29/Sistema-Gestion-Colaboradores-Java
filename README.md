#  Sistema de Gestión de Colaboradores (POO en Java)

> Proyecto de aplicación de **consola** desarrollado en **Java (Maven)** para la gestión básica de empleados (colaboradores) de una empresa ficticia.
>
> Desarrollado como **Examen Final de Programación Orientada a Objetos (POO)**, este sistema demuestra la aplicación rigurosa de principios POO, lógica de negocio compleja y manejo de excepciones en un entorno *backend* puro.

---

##  Principios de Programación Orientada a Objetos (POO)

El diseño del sistema se basó en la **Abstracción** y el **Encapsulamiento** para modelar las entidades de negocio y su comportamiento.

* **Abstracción y Estructura Modular:** El sistema está organizado con clases bien definidas que representan entidades del mundo real:
* `Colaborador`: Representa al empleado con sus atributos personales, cargo y sueldo.
* `Cargo`: Define el nombre del cargo y el departamento asociado.
* `Sueldo`: Encapsula la lógica para el cálculo detallado del sueldo líquido.
* `Utilidades`: Contiene métodos auxiliares **estáticos** para validaciones de formato (RUT, fechas) y cálculos de tiempo.
* **Encapsulamiento y Seguridad:** Todos los atributos principales son **privados** (`private` o `private final`) y su acceso se controla estrictamente mediante métodos *getters* y *setters* (como `setActivo`), asegurando la **integridad de los datos**.

---

##  Características Clave del Back-End

* **Persistencia en Memoria:** Utilización de `ArrayList` para gestionar la colección dinámica de colaboradores en tiempo de ejecución.
* **Lógica de Negocio y Cálculos Financieros:**
* Implementación del cálculo detallado del **Sueldo Líquido**, que incluye el Sueldo Base, Gratificaciones, Bonos (Colación, Locomoción), y los **descuentos legales chilenos** (7% para Salud y 10% para AFP).
* Cálculo preciso de la **Edad** y **Tiempo de Servicio** (en años y meses) del colaborador utilizando la moderna **Java Date/Time API** (`LocalDate`, `Period`).
* **Control de Flujo y Manejo de Errores:**
* Manejo riguroso de **Excepciones** y validación estricta de formatos de entrada (RUT, fechas en formato DD-MM-YYYY, números enteros) para garantizar la robustez de la aplicación.
* Validación de patrones de cadena (ej. nombres y cargos solo deben contener caracteres alfabéticos).
* **Gestión de Estados:** Implementación de la **eliminación lógica**, donde la opción de 'Eliminar Colaborador' cambia el estado interno del registro a `inactivo` en lugar de borrar la información permanentemente.
* **Formato de Datos:** Métodos utilitarios para formatear datos críticos, como el **RUT** (ej. `XX.XXX.XXX-X`) y estandarizando el formato del nombre.

---

##  Ejecución

### Ejecución Rápida en Línea (Replit)

Este proyecto puede ejecutarse instantáneamente en tu navegador gracias a **Replit**, que prepara el entorno de desarrollo con Java y Maven automáticamente, sin necesidad de instalaciones locales.
## Pasos para la Ejecución

1.  **Pincha el enlace:** El enlace te redireccionará a **Replit**.
2.  **Inicia sesión o regístrate:** Inicia sesión en Replit o regístrate si no tienes una cuenta.
3.  **Remix this app:** Una vez que ya tengas tu cuenta, dale al botón **"Remix this app"**. Esto replicará el código en tu cuenta (no te preocupes, luego lo puedes borrar). Sigue las instrucciones.
4.  **Ejecutar:** Te aparecerá un botón **"Project"** en verde. Pínchalo.
5.  **¡Bienvenido!** Ya estás ejecutando el programa y lo puedes usar.

[![Run on Replit](https://replit.com/badge/github/ejts29/Sistema-Gestion-Colaboradores-Java)](https://replit.com/@ejts29/Sistema-Gestion-Colaboradores-Java)

---
### Ejecución Local

Para ejecutarlo localmente, asegúrate de tener **Java 21** (o compatible) y **Maven** instalados. Puedes utilizar un IDE como **Apache NetBeans** o seguir los pasos de la terminal:

1. Clonar el repositorio.
2. Navegar a la carpeta raíz del proyecto (`Sistema-Gestion-Colaboradores-Java`).
3. Ejecutar el siguiente comando en la terminal:
    ```bash
    mvn clean install exec:java
    ```

---

## Estructura del Proyecto

El proyecto sigue la estructura estándar de **Maven**:
