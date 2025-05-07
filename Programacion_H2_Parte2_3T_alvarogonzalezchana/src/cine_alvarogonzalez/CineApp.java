package cine_alvarogonzalez;

import java.util.List;
import java.util.Scanner;

// clase principal que contiene el menu
public class CineApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase database = new DataBase();
        int opcion;

        do {
            System.out.println("Menu Principal:");
            System.out.println("1 - Ver películas");
            System.out.println("2 - Añadir película");
            System.out.println("3 - Eliminar película");
            System.out.println("4 - Modificar película");
            System.out.println("5 - Salir");
            System.out.print("Elige una opción: ");
            
            // Lee la opcion del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        List<Pelicula> peliculas = database.obtenerPeliculas();
                        System.out.printf("%-10s %-35s %-25s %-6s %-15s %-15s%n",
                                "ID", "Titulo", "Director", "Año", "Genero", "Sala");
                        System.out.println("---------------------------------------------------------------------------------------------------------");
                        for (Pelicula p : peliculas) {
                            System.out.println(p);
                        }
                        break;
                    case 2:
                        new AñadirPelicula(database, scanner).ejecutar();
                        break;
                    case 3:
                        new EliminarPelicula(database, scanner).ejecutar();
                        break;
                    case 4:
                        new ModificarPelicula(database, scanner).ejecutar();
                        break;
                    case 5:
                        System.out.println("Saliendo... Vuelva pronto");
                        break;
                    default:
                        System.out.println("Opcion erronea cambie de numero");
                }
            } else {
                System.out.println("Por favor elige el numero valido");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 5);

        scanner.close();
    }
}
