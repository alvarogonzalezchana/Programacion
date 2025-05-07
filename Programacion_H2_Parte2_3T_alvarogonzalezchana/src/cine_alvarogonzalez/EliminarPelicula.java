package cine_alvarogonzalez;

import java.util.Scanner;
// esta clase se encarga de eliminar una pelicula de la base de datos
public class EliminarPelicula {
    private DataBase database;
    private Scanner scanner;

    public EliminarPelicula(DataBase database, Scanner scanner) {
        this.database = database;
        this.scanner = scanner;
    }

    public void ejecutar() {
        System.out.print("Introduce ID de la pelicula a eliminar: ");
        String id = scanner.nextLine();

        if (database.eliminarPelicula(id)) {
            System.out.println("Pelicula eliminada");
        } else {
            System.out.println("No se pudo eliminar la pelicula o no existe");
        }
    }
}
