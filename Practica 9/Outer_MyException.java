class Outer_MyException extends Exception {
    Outer_MyException() {
        super();
    }

    public String getMessage() {
        return "No puede votar";
    }
}