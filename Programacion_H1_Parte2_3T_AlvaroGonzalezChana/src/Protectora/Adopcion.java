package Protectora;

class Adopcion {
	private Animal animal;
	private String NombreAdoptante;
	private String DniAdoptante;
	
	public Adopcion(Animal animal, String NombreAdoptante, String DniAdoptante) {
		this.animal = animal;
		this.NombreAdoptante = NombreAdoptante;
		this.DniAdoptante = DniAdoptante;
	}
	
	public Animal getAnimal() {
		return animal;
	}
}
