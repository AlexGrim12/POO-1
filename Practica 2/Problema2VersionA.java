public class Problema2VersionA {
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

    static void Estrofas(int i, int j) {
        if (j < i) {
            System.out.println(Numeros[j] + " " + Regalos[j]);    
            Estrofas(i, j + 1);
        } else
        System.out.println();
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 12; i ++)
            Estrofas(i, 0);
    }
}
