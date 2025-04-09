package Protectora;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class ProtectoraAnimales {
    private HashMap<String, Animal> animales; // Estructura para almacenar animales
    private ArrayList<Adopcion> adopciones;
    
    public ProtectoraAnimales() {
        animales = new HashMap<>(); // Inicia el HashMap
        adopciones = new ArrayList<>(); // inicia la lista de adopciones
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
       
    public void listarAnimales() {
    	if (animales.isEmpty()) {
    		System.out.println("No hay animales registrados.");
    	} else {
    		for (Animal animal : animales.values()) {
    			animal.mostrar();
    		}
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
    
    public void realizarAdopcion(String numeroChip, String NombreAdoptante, String DniAdoptante) {
    	Animal animal = animales.get(numeroChip);
    	if (animal == null) {
    		System.out.println("No se encontro un animal con el numero de chip " + numeroChip);
    	} else if (animal.adoptado) {
    		System.out.println("El animal ya ha sido adoptado");
    	} else {
    		animal.adoptado = true;
    		Adopcion adopcion = new Adopcion(animal, NombreAdoptante, DniAdoptante);
    		adopciones.add(adopcion);
    		System.out.println("Adopcion realizada con Exito");
    	}
    }
    
    public void darDeBaja(String numeroChip) {
    	Animal animal = animales.remove(numeroChip);
    	if (animal != null) {
    		adopciones.removeIf(adopcion -> adopcion.getAnimal().getNumeroChip().equals(numeroChip));
    		System.out.println("Animal dado de baja con exito.");
    	} else {
    		System.out.println("No se encontro un animal con el numero de Chip " + numeroChip);
    	}
    }
    // Metodo para mostrar las estadisticas de los gatos
    public void mostrarEstadisticasGatos() {
    	int totalGatos = 0;
    	int gatosConLeucemia = 0;
    	
    	for (Animal animal : animales.values()) {
    		if (animal instanceof Gato) {
    			totalGatos++;
    			if (((Gato) animal).testLeucemia) {
    				gatosConLeucemia++;
    			}
    		}
    	}
    	
    	System.out.println("Total de gatos: " + totalGatos);
    	System.out.println("Gatos con test de Leucemia: " + gatosConLeucemia );
    }
    // Metodo principal para ejecutar el programa
    public static void main(String[] args) {
        ProtectoraAnimales protectora = new ProtectoraAnimales();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menu de opciones
            System.out.println("\n Menu de la Protectora de Animales");
            System.out.println("1. Dar de alta un animal");
            System.out.println("2. Registrar animales");
            System.out.println("3. Buscar  animal");
            System.out.println("4. Realizar adopcion");
            System.out.println("5. Dar de baja");
            System.out.println("6. Mostrar estadisticas de gatos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine()); // lee la opción seleccionada

            switch (opcion) {
                case 1: // Opcion para dar de alta un animal
                    System.out.println("Dar de alta un animal:");
                    System.out.print("Ingresa el tipo de animal (perro/gato): ");
                    String tipo = scanner.nextLine().toLowerCase(); // lee el tipo de animal

                    System.out.print("Ingresa el numero de chip: ");
                    String numeroChip = scanner.nextLine();
                    System.out.print("Ingresa el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa la edad: ");
                    int edad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingresa la raza: ");
                    String raza = scanner.nextLine();

                    if (tipo.equals("perro")) {
                        System.out.print("Ingresa el tamaño (pequeño/mediano/grande): ");
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

                case 2: // Opcion para registrar animales
                	protectora.listarAnimales();
                    break;

                case 3: // Opcion para buscar un animal
                	System.out.print("Ingresa el numero de Chip para buscar: ");
                	numeroChip = scanner.nextLine();
                	protectora.buscarAnimal(numeroChip);
                  	break;
                  
                case 4: // Opcion para realizar una adopcion
                	System.out.print("Ingresa el numero de Chip del aniamal a adoptar: ");
                	numeroChip = scanner.nextLine();
                	System.out.print("Ingresa el nombre del adoptante: ");
                	String NombreAdoptante = scanner.nextLine();
                	System.out.print("Ingresa el DNI del adoptante: ");
                	String DniAdoptante = scanner.nextLine();
                	protectora.realizarAdopcion(numeroChip, NombreAdoptante, DniAdoptante);
                	break;
                
                case 5: // Opcion para dar de baja al animal
                	System.out.print("Ingresa el numero de Chip del animal a dar de baja: ");
                	numeroChip = scanner.nextLine();
                	protectora.darDeBaja(numeroChip);
                	break;
                
                case 6: // Opcion para mostrar estadisticas de los gatos
                	protectora.mostrarEstadisticasGatos();
                	break;
                
                case 7: // Opcion para salir
                	System.out.println("Saliendo del programa..");
                	break;
                	          	
                default: // Opcion no valida
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida");
            }
        } while (opcion != 7); // Contina hasta que el usuario elija salir

        scanner.close(); // Cierra el scanner
    }
}