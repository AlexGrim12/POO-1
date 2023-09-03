import java.util.Random;

public class Problema2VersionB {
    static int n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11 = -1;

    static void estrofas(int i) {
        String estrofa = "";

        switch(i) {
            case 0: estrofa = "Una perdiz en un peral"; break;
            case 1: estrofa = "Dos t\u00F3rtolas"; break;
            case 2: estrofa = "Tres gallinas francesas"; break;
            case 3: estrofa = "Cuatro p\u00E1jaros piando"; break;
            case 4: estrofa = "Cinco anillos de oro"; break;
            case 5: estrofa = "Seis ocas empollando"; break;
            case 6: estrofa = "Siete cisnes nadando"; break;
            case 7: estrofa = "Ocho sirvientas orde\u00F1ando"; break;
            case 8: estrofa = "Nueve damas danzando"; break;
            case 9: estrofa = "Diez se\u00F1ores saltando"; break;
            case 10: estrofa = "Once gaiteros tocando la gaita"; break;
            case 11: estrofa = "Doce tamborileros tocando el tambor"; break;
        }

        System.out.println(estrofa); 
    }

    static void generarOrdenAleatorio() {
        Random rand = new Random();
        int i = 0;

        while (i < 12) {
            int n = rand.nextInt(12);
            boolean flag = true;

            if (n0 == n) flag = false;
            else if (n1 == n) flag = false;
            else if (n2 == n) flag = false;
            else if (n3 == n) flag = false;
            else if (n4 == n) flag = false;
            else if (n5 == n) flag = false;
            else if (n6 == n) flag = false;
            else if (n7 == n) flag = false;
            else if (n8 == n) flag = false;
            else if (n9 == n) flag = false;
            else if (n10 == n) flag = false;
            else if (n11 == n) flag = false;
            
            if (flag) {
                switch(i) {
                    case 0: n0 = n; break;
                    case 1: n1 = n; break;
                    case 2: n2 = n; break;
                    case 3: n3 = n; break;
                    case 4: n4 = n; break;
                    case 5: n5 = n; break;
                    case 6: n6 = n; break;
                    case 7: n7 = n; break;
                    case 8: n8 = n; break;
                    case 9: n9 = n; break;
                    case 10: n10 = n; break;
                    case 11: n11 = n; break;    
                }
                i ++;
            }
        }
    }
    
    public static void main(String[] args) {
        generarOrdenAleatorio();

        for(int i = 1; i <= 12; i ++) {
            for(int j = 0; j < i; j ++) {
                switch(j) {
                    case 0: estrofas(n0); break;
                    case 1: estrofas(n1); break;
                    case 2: estrofas(n2); break;
                    case 3: estrofas(n3); break;
                    case 4: estrofas(n4); break;
                    case 5: estrofas(n5); break;
                    case 6: estrofas(n6); break;
                    case 7: estrofas(n7); break;
                    case 8: estrofas(n8); break;
                    case 9: estrofas(n9); break;
                    case 10: estrofas(n10); break;
                    case 11: estrofas(n11); break;
                }
            }
            System.out.println();
        }
    }
}
