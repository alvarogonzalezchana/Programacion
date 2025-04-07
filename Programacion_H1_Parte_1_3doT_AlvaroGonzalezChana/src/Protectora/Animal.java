package Protectora;

abstract class Animal {
    protected String numeroChip;
    protected String nombre;
    protected int edad;
    protected String raza;
    protected boolean adoptado;	

    public Animal(String numeroChip, String nombre, int edad, String raza) {
        this.numeroChip = numeroChip;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.adoptado = false; // esta puesto como no adoptado
    }

    public abstract void mostrar(); // metodo que se aplicara en las subclases

    public String getNumeroChip() {	// metodo para obtener el numero del chip
        return numeroChip;
    }
}