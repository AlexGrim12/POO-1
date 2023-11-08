abstract class Persona {
	String nombre;
	int edad;
	Sx sexo;
	String nacionalidad;

	public String getNombre() {
		return this.nombre;
	}

	public int getEdad() {
		return this.edad;
	}

	public Sx getSexo() {
		return this.sexo;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	abstract boolean votar();

	abstract boolean servicioMilitar();

	abstract boolean serPresidente();

	public void verificarNacionalidad() throws NacionalidadInvalidaException {
		if (this.nacionalidad.equals("Mexicano") && this instanceof Extranjero) {
			throw new NacionalidadInvalidaException("Un extranjero no puede ser mexicano.");
		}
	}

	public void verificarEdad() throws EdadInvalidaException {
		if (this.edad <= 0) {
			throw new EdadInvalidaException("La edad no puede ser menor o igual a 0.");
		}
	}

	abstract boolean jubilar() throws JubilacionException;

	public void verificarJubilacion() throws JubilacionException {
		if (this.edad < 64) {
			throw new JubilacionException("La persona no cumple con la edad mínima para jubilarse.");
		}
	}
}

class Mexicano extends Persona {
	String curp; // Variable polimorfica

	Mexicano(String nombre, int edad, Sx sexo, String curp) {
		this.nombre = nombre;
		this.sexo = sexo;
		if (edad <= 0) {
			throw new EdadInvalidaException("La edad no puede ser menor o igual a 0.");
		}
		this.edad = edad;
		this.curp = curp;
		this.nacionalidad = "Mexicano";
	}

	@Override
	boolean votar() {
		return (this.edad >= 18) ? true : false;
	}

	@Override
	boolean servicioMilitar() {
		/*
		 * boolean bandera = false;
		 * if(this.edad >= 17 && this.sexo == Sx.MASCULINO) {
		 * bandera= true;
		 * }
		 * return bandera;
		 */
		// el siguiente codigo es equivalente al comentado de arriba

		return (this.edad >= 17 && this.sexo == Sx.MASCULINO) ? true : false;
	}

	@Override
	boolean serPresidente() {
		return (this.edad >= 35) ? true : false;
	}

	@Override
	boolean jubilar() throws JubilacionException {
		verificarJubilacion();
		return true;
	}
}

class Extranjero extends Persona {
	Extranjero(String nombre, int edad, Sx sexo) {
		this.nombre = nombre;
		this.sexo = sexo;
		if (edad <= 0) {
			throw new EdadInvalidaException("La edad no puede ser menor o igual a 0.");
		}
		this.edad = edad;
		this.nacionalidad = "Extranjero";
	}

	@Override
	boolean votar() {
		return false;
	}

	@Override
	boolean servicioMilitar() {
		return false;
	}

	@Override
	boolean serPresidente() {
		return false;
	}

	@Override
	boolean jubilar() throws JubilacionException {
		verificarJubilacion();
		return true;
	}
}
