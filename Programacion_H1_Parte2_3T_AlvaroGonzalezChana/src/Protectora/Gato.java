package Protectora;

class Gato extends Animal {
    boolean testLeucemia; // Indica si el gato ha pasado el test de leucemia

    public Gato(String numeroChip, String nombre, int edad, String raza, boolean testLeucemia) {
        super(numeroChip, nombre, edad, raza);
        this.testLeucemia = testLeucemia;
    }

    @Override
    public void mostrar() { // metodo para mostrar la informacion del gato
        System.out.println("gato: " + nombre + ", chip: " + numeroChip + ", edad: " + edad + ", raza: " + raza + ", test leucemia: " + (testLeucemia ? "si" : "no") + ", adoptado: " + adoptado);
    }
}