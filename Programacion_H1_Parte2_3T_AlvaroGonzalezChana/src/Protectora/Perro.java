package Protectora;

class Perro extends Animal {
    private String tamaño; //tamaño del perro

    public Perro(String numeroChip, String nombre, int edad, String raza, String tamaño) {
        super(numeroChip, nombre, edad, raza); 
        this.tamaño = tamaño;
    }

    @Override
    public void mostrar() {   // metodo para mostrar la informacion del perro
        System.out.println("perro: " + nombre + ", chip: " + numeroChip + ", edad: " + edad + ", raza: " + raza + ", tamaño: " + tamaño + ", adoptado: " + adoptado);
    }
}