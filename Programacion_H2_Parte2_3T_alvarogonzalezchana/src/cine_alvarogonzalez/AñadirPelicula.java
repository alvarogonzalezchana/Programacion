package cine_alvarogonzalez;

import java.util.Scanner;
// Clase con la que añades una nueva película a la base de datos
public class AñadirPelicula {
    private DataBase database;
    private Scanner scanner;

    // constructor para Añadir Peliculas
    public AñadirPelicula(DataBase database, Scanner scanner) {
        this.database = database;
        this.scanner = scanner;
    }
    // Metodo para ejecutar añadir una pelicula
    public void ejecutar() {
        System.out.println("Introduce nuevos datos de película.");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.print("Año: ");
        int ano = Integer.parseInt(scanner.nextLine());
        System.out.print("ID Genero (ej. G01): ");
        String idGenero = scanner.nextLine();
        System.out.print("ID Sala (ej. S01): ");
        String idSala = scanner.nextLine();

        Pelicula p = new Pelicula(id, titulo, director, ano, "", "");

        if (database.añadirPelicula(p, idGenero, idSala)) {
            System.out.println("Pelicula añadida correctamente.");
        } else {
            System.out.println("No se pudo añadir la película.");
        }
    }
}
