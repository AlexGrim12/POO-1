import java.util.Scanner;

public class Anagrama {
    public static Boolean esAnagrama(String p1, String p2) {
        if (p1.length() != p2.length()) {
            return false;
        }

        p1 = p1.toLowerCase();
        p2 = p2.toLowerCase();

        StringBuilder pc1 = new StringBuilder(p1);
        StringBuilder pc2 = new StringBuilder(p2);

        for (int i = 0; i < pc1.length(); i++) {
            for (int j = 0; j < pc2.length(); j++) {
                if (pc1.charAt(i) == pc2.charAt(j)) {
                    pc1.deleteCharAt(i);
                    pc2.deleteCharAt(j);
                    i--;
                    break;
                }
            }
        }

        return pc1.length() == 0 && pc2.length() == 0;
    }

    public static void main(String[] args) {
        String palabra1, palabra2;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa la primera palabra: ");
        palabra1 = sc.nextLine();
        System.out.print("Ingresa la segunda palabra: ");
        palabra2 = sc.nextLine();

        System.out.println(esAnagrama(palabra1, palabra2));

        sc.close();
    }
}
