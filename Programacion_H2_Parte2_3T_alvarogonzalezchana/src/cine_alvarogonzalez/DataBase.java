package cine_alvarogonzalez;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String url = "jdbc:mysql://localhost:3307/cine_alvarogonzalez";
    private static final String usuario = "root";
    private static final String contraseña = "";
    // obtiene la lista de todas las peliculas de la base de datos
    public List<Pelicula> obtenerPeliculas() {
    //  creamos una lista para guardar las peliculas
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT p.id_pelicula, p.titulo, p.director, p.año, g.nombre_genero, s.nombre_sala " +
                "FROM peliculas p " +
                "JOIN generos g ON p.id_genero = g.id_genero " +
                "JOIN salas s ON p.id_sala = s.id_sala";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                peliculas.add(new Pelicula(
                        rs.getString("id_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("año"),
                        rs.getString("nombre_genero"),
                        rs.getString("nombre_sala")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error cargando películas: " + e.getMessage());
        }
        return peliculas;
    }
    // busca una pelicula en la base de datos por su ID
    public Pelicula buscarPeliculaPorId(String id) {
        String sql = "SELECT p.id_pelicula, p.titulo, p.director, p.año, g.nombre_genero, s.nombre_sala " +
                "FROM peliculas p " +
                "JOIN generos g ON p.id_genero = g.id_genero " +
                "JOIN salas s ON p.id_sala = s.id_sala WHERE p.id_pelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Pelicula(
                        id,
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("año"),
                        rs.getString("nombre_genero"),
                        rs.getString("nombre_sala")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error, buscando película: " + e.getMessage());
        }
        return null;
    }

    public boolean añadirPelicula(Pelicula pelicula, String idGenero, String idSala) {
        if (buscarPeliculaPorId(pelicula.getId()) != null) {
            System.out.println("La pelicula ya existe");
            return false;
        }
    //  La consulta SQL para añadir una nueva pelicula
        String sql = "INSERT INTO peliculas (id_pelicula, titulo, director, año, id_genero, id_sala) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement ps = conn.prepareStatement(sql)) {
        //  asignamos los valores de los datos de la pelicula a los parametros de la consulta.
            ps.setString(1, pelicula.getId());
            ps.setString(2, pelicula.getTitulo());
            ps.setString(3, pelicula.getDirector());
            ps.setInt(4, pelicula.getAno());
            ps.setString(5, idGenero);
            ps.setString(6, idSala);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error añadiendo película: " + e.getMessage());
            return false;
        }
    }
    // elimina una pelicula de la base de datos por su ID
    public boolean eliminarPelicula(String id) {
        if (buscarPeliculaPorId(id) == null) {
            System.out.println("La pelicula no existe.");
            return false;
        }

        String sql = "DELETE FROM peliculas WHERE id_pelicula = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando pelicula: " + e.getMessage());
            return false;
        }
    }
    //  modifica el titulo y el director de una película en la base de datos
    public boolean modificarPelicula(String id, String nuevoTitulo, String nuevoDirector) {
        if (buscarPeliculaPorId(id) == null) {
            System.out.println("La película no existe.");
            return false;
        }
    //  la consulta SQL para actualizar el título y el director de la pelicula
        String sql = "UPDATE peliculas SET titulo = ?, director = ? WHERE id_pelicula = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoTitulo);
            ps.setString(2, nuevoDirector);
            ps.setString(3, id);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error modificando película: " + e.getMessage());
            return false;
        }
    }
}
