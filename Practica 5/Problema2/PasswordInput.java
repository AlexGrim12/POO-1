import java.io.Console;

class PasswordInput {
    public static String main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No se puede obtener la consola");
            System.exit(0);
        }

        String password = new String(console.readPassword("Ingresa la password: "));

        return password;
    }
}