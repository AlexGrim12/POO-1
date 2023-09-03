import java.util.Random;

public class Problema2VersionB {
    final static String[] Numeros = new String[] {
        "Una", "Dos", "Tres", "Cuatro", 
        "Cinco", "Seis", "Siete", "Ocho",
        "Nueve", "Diez", "Once", "Doce"
    };

    final static String[] Regalos = new String[] {
        "perdiz en un peral", "t\u00F3rtolas", "gallinas francesas",
        "p\u00E1jaros piando", "anillos de oro", "ocas empollando",
        "cisnes nadando", "sirvientas orde\u00F1ando", "damas danzando",
        "se\u00F1ores saltando", "gaiteros tocando la gaita", 
        "tamborileros tocando el tambor"
    };

    static Integer[] Arr = new Integer[12]; 

    static void GenerarOrdenAleatorio() {
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

    static void Estrofas(int i, int j) {
        if (j < i) {
            System.out.println(Numeros[Arr[j]] + " " + Regalos[Arr[j]]);    
            Estrofas(i, j + 1);
        } else
        System.out.println();
    }

    public static void main(String[] args) {
        GenerarOrdenAleatorio();

        for(int i = 1; i <= 12; i ++)
            Estrofas(i, 0);
    }   
}
