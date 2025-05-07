package cine_alvarogonzalez;

public class Pelicula {
    private String id;
    private String titulo;
    private String director;
    private int año;
    private String genero;
    private String sala;

    public Pelicula(String id, String titulo, String director, int año, String genero, String sala) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.genero = genero;
        this.sala = sala;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDirector() { return director; }
    public int getAno() { return año; }
    public String getGenero() { return genero; }
    public String getSala() { return sala; }

    @Override
    // Devuelve una representación en cadena de la pelicula
    public String toString() {
        return String.format("%-10s %-35s %-25s %-6d %-15s %-15s",
                id, titulo, director, año, genero, sala);
    }
}
