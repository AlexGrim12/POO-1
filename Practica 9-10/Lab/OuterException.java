// OuterException verifica que una persona puede votar
// InnerException verifica que ademas pueda ser presidente 
class OuterException extends Exception {
	OuterException(String s) {
		super(s);
	}
	
	// para mandar a llamar la inner clase local no estatica
	OuterException(String s, boolean sth) {
		InnerException2 local = new InnerException2(s);
	}

	//Inner class
	//se puede nombrar una clase interna  de esta manera
	//es necesario utilizar static porque de otra manera se necesitara
	//crear un objeto de esta clase
	static class InnerException extends Exception {
		InnerException(String s) {
			super(s);
		}
	}
	
	//usamos una inner class generica 
	class InnerException2 extends Exception {
		
		InnerException2(String s) {
			System.out.println(s);
		}
	}
}
