package cine_alvarogonzalez;

import java.sql.*;
import java.util.Scanner;


public class CineApp {
    // Conexión a sql
    private static final String url = "jdbc:mysql://localhost:3307/cine_alvarogonzalez";
    private static final String usuario = "root";
    private static final String contraseña = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // El menu se repite hasta que elija salir
        do {
            System.out.println(" Menu Principal ");
            System.out.println("1 - Ver películas");
            System.out.println("2 - Salir");
            System.out.print("Elige una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        mostrarPeliculas();
                        break;
                    case 2:
                        System.out.println("Vuelva pronto");
                        break;
                    default:
                        System.out.println("Opción erronea cambie de numero.");
                }
            } else {
                System.out.println("Por favor elige el número válido.");
                scanner.nextLine();  
                opcion = 0;
            }

        } while (opcion != 2);

        scanner.close();
    }

    // Método que mostra las películas con el genero y la sala
    public static void mostrarPeliculas() {
        String sql = "SELECT p.id_pelicula, p.titulo, p.director, p.año, g.nombre_genero, s.nombre_sala " +"FROM peliculas p " + "JOIN generos g ON p.id_genero = g.id_genero " +"JOIN salas s ON p.id_sala = s.id_sala";

        // Se cierra automaticamente
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Encabezados de la tabla
            System.out.printf("%-10s %-35s %-25s %-6s %-15s %-15s%n","ID", "Titulo", "Director", "Año", "Genero", "Sala");
            System.out.println("------------------------------------------------------------------------------------------------------");

            // Imprime cada registro 
            while (rs.next()) {
                String id = rs.getString("id_pelicula");
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                int año = rs.getInt("año");
                String genero = rs.getString("nombre_genero");
                String sala = rs.getString("nombre_sala");

                System.out.printf("%-10s %-35s %-25s %-6d %-15s %-15s%n", id, titulo, director, año, genero, sala);
            }

        } catch (SQLException e) {
            System.out.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }
}