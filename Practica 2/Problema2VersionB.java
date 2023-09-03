import java.util.Random;

public class Problema2VersionB {
    final static String[] ESTROFA = new String[] {
        "Una perdiz en un peral", "Dos t\u00F3rtolas", 
        "Tres gallinas francesas","Cuatro p\u00E1jaros piando", 
        "Cinco anillos de oro", "Seis ocas empollando",
        "Siete cisnes nadando", "Ocho sirvientas orde\u00F1ando", 
        "Nueve damas danzando", "Diez se\u00F1ores saltando", 
        "Once gaiteros tocando la gaita", "Doce tamborileros tocando el tambor"
    };

    static Integer[] Arr = new Integer[12]; 

    static void generarOrdenAleatorio() {
        Random rand = new Random();
        int i = 0;

        while (i < 12) {
            int n = rand.nextInt(12);
            boolean flag = false;
            
            for (int j = 0; j < i; j ++) {
                if (Arr[j] == n) {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                Arr[i] = n;
                i ++;
            }
        }
    }

    static void estrofas(int i, int j) {
        if (j < i) {
            System.out.println(ESTROFA[Arr[j]]);    
            estrofas(i, j + 1);
        } else
        System.out.println();
    }

    public static void main(String[] args) {
        generarOrdenAleatorio();

        for(int i = 1; i <= 12; i ++)
            estrofas(i, 0);
    }   
}
