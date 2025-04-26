# Gestión de Inventario - Tienda de Zapatos 👟

## Descripción

Esta es una aplicación de línea de comandos desarrollada en **Java** para la gestión de inventarios de una tienda de zapatos.  
Permite registrar productos, procesar ventas y mantener actualizado el inventario de manera automática.

## Funcionalidades principales

- 📦 Permitir el **ingreso de información** de los productos (nombre, precio, cantidad).
- 🧮 **Calcular la disponibilidad** en inventario restando las unidades vendidas de la cantidad inicial.
- ✅ **Determinar** si hay suficiente stock disponible para una venta.
- 🔄 **Duplicar el inventario inicial** de un producto que ya se haya vendido totalmente.
- 🖥️ **Mostrar** la información actualizada del inventario en pantalla.

## Estructura del proyecto

- `Main.java` → Contiene toda la lógica del programa (clases `Producto`, `Inventario` y `Main`).

## Requisitos

- Tener instalado **Java** (JDK 8 o superior).
- Un editor o IDE como **VSCode**, **IntelliJ IDEA** o simplemente usar la terminal.

## Instrucciones para ejecutar

1. Clonar el repositorio o descargar los archivos.
2. Compilar el archivo:

```bash
javac Main.java
```

3. Ejecutar el programa:

```bash
java Main
```

4. Seguir el menú interactivo para agregar productos, realizar ventas y ver el inventario.

## Ejemplo de uso

```plaintext
Ingrese el nombre del producto: Zapato Deportivo
Ingrese el precio del producto: 59.99
Ingrese la cantidad inicial: 10
¿Desea agregar otro producto? (s/n): n

Opciones:
1. Mostrar inventario
2. Realizar una venta
3. Salir

Seleccione una opción: 2
Ingrese el nombre del producto a vender: Zapato Deportivo
Ingrese la cantidad a vender: 10

Stock de Zapato Deportivo duplicado a 20 unidades.
```

## Autor

- [Romario Ramirez]
