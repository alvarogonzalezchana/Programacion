package Protectora;

import java.util.HashMap;
import java.util.Scanner;

public class ProtectoraAnimales {
    private HashMap<String, Animal> animales; // Estructura para almacenar animales

    public ProtectoraAnimales() {
        animales = new HashMap<>(); // Inicia el HashMap
    }

    // Metodo para agregar un animal
    public void agregarAnimal(Animal animal) {
        if (animales.containsKey(animal.getNumeroChip())) {
            System.out.println("Error: Ya existe un animal con el numero de chip " + animal.getNumeroChip());
        } else {
            animales.put(animal.getNumeroChip(), animal);
            System.out.println("Animal agregado exitosamente");
        }
    }

    // Metodo para buscar un animal por numero de chip
    public void buscarAnimal(String numeroChip) {
        Animal animal = animales.get(numeroChip);
        if (animal != null) {
            animal.mostrar(); // Muestra la información del animal
        } else {
            System.out.println("No se encontro un animal con el numero de chip " + numeroChip);
        }
    }

    // Metodo principal para ejecutar el programa
    public static void main(String[] args) {
        ProtectoraAnimales protectora = new ProtectoraAnimales();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            System.out.println("\n Menu de la Protectora de Animales");
            System.out.println("1. Dar de alta un animal");
            System.out.println("2. Buscar un animal por número de chip");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine()); // lee la opción seleccionada

            switch (opcion) {
                case 1: // Opcion para dar de alta un animal
                    System.out.println("Dar de alta un animal:");
                    System.out.print("Ingrese el tipo de animal (perro/gato): ");
                    String tipo = scanner.nextLine().toLowerCase(); // lee el tipo de animal

                    System.out.print("Ingrese el numero de chip: ");
                    String numeroChip = scanner.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad: ");
                    int edad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese la raza: ");
                    String raza = scanner.nextLine();

                    if (tipo.equals("perro")) {
                        System.out.print("Ingrese el tamaño (pequeño/mediano/grande): ");
                        String tamaño = scanner.nextLine();
                        Perro perro = new Perro(numeroChip, nombre, edad, raza, tamaño);
                        protectora.agregarAnimal(perro);
                    } else if (tipo.equals("gato")) {
                        System.out.print("¿El gato tiene test de leucemia? (si/no): ");
                        boolean testLeucemia = scanner.nextLine().equalsIgnoreCase("si"); // lee el estado del test de leucemia
                        Gato gato = new Gato(numeroChip, nombre, edad, raza, testLeucemia);
                        protectora.agregarAnimal(gato);
                    } else {
                        System.out.println("Tipo de animal no reconocido");
                    }
                    break;

                case 2: // Opcion para buscar un animal
                    System.out.print("Ingrese el numero de chip para buscar: ");
                    numeroChip = scanner.nextLine();
                    protectora.buscarAnimal(numeroChip);
                    break;

                case 3: // Opcion para salir
                    System.out.println("Saliendo del programa...");
                    break;

                default: // Opcion no valida
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida");
            }
        } while (opcion != 3); // Contina hasta que el usuario elija salir

        scanner.close(); // Cierra el scanner
    }
}