import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private String nombre;
    private double precio;
    private int cantidadInicial;
    private int cantidadActual;
    private int unidadesVendidas;

    public Producto(String nombre, double precio, int cantidadInicial) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadInicial = cantidadInicial;
        this.cantidadActual = cantidadInicial;
        this.unidadesVendidas = 0;
    }

    public boolean venderProducto(int cantidad) {
        if (cantidadActual >= cantidad) {
            cantidadActual -= cantidad;
            unidadesVendidas += cantidad;
            return true;
        } else {
            System.out.println("No hay suficiente stock de " + nombre + ". Solo quedan " + cantidadActual + " unidades.");
            return false;
        }
    }

    public void duplicarInventario() {
        cantidadActual = cantidadInicial * 2;
        System.out.println("Stock de " + nombre + " duplicado a " + cantidadActual + " unidades.");
    }

    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad Inicial: " + cantidadInicial);
        System.out.println("Cantidad Disponible: " + cantidadActual);
        System.out.println("Unidades Vendidas: " + unidadesVendidas);
        System.out.println("----------------------------------------");
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }
}

class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarInventario() {
        System.out.println("\nInventario Actualizado:");
        for (Producto producto : productos) {
            producto.mostrarInformacion();
        }
    }

    public void procesarVenta(String nombreProducto, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                if (producto.venderProducto(cantidad)) {
                    if (producto.getCantidadActual() == 0) {
                        producto.duplicarInventario();
                    }
                }
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        System.out.println("Sistema de Gestión de Inventario - Tienda de Zapatos");

        while (true) {
            System.out.print("\nIngrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();

            System.out.print("Ingrese la cantidad inicial: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            Producto nuevoProducto = new Producto(nombre, precio, cantidad);
            inventario.agregarProducto(nuevoProducto);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Realizar una venta");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    inventario.mostrarInventario();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto a vender: ");
                    String nombreVenta = scanner.nextLine();

                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantidadVenta = scanner.nextInt();
                    scanner.nextLine();

                    inventario.procesarVenta(nombreVenta, cantidadVenta);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}