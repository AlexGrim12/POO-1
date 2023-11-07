public class Extranjero extends Persona{
	Extranjero(String nombre, int edad, Sx sexo){
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.nacionalidad = "Extranjero";
	}

	@Override
	boolean votar(){
		return false;
	}

	@Override
	boolean servicioMilitar(){
		return false;
	}

	@Override
	boolean presidente(){
		return false;
	}
}