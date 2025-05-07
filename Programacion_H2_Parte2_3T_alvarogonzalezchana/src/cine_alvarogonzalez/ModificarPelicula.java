package cine_alvarogonzalez;

import java.util.Scanner;

public class ModificarPelicula {
    private DataBase database;
    private Scanner scanner;

    public ModificarPelicula(DataBase database, Scanner scanner) {
        this.database = database;
        this.scanner = scanner;
    }
    // metodo principal para ejecutar la modificación de la pelicula
    public void ejecutar() {
        System.out.print("Introduce ID de la pelicula a modificar: ");
        String id = scanner.nextLine();

        Pelicula p = database.buscarPeliculaPorId(id);
        if (p == null) {
            System.out.println("Pelicula no encontrada");
            return;
        }

        System.out.print("Nuevo titulo: ");
        String nuevoTitulo = scanner.nextLine();
        System.out.print("Nuevo director: ");
        String nuevoDirector = scanner.nextLine();

        if (database.modificarPelicula(id, nuevoTitulo, nuevoDirector)) {
            System.out.println("Película modificada");
        } else {
            System.out.println("No se pudo modificar la película");
        }
    }
}

