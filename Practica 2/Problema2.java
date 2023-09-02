public class Problema2 {
    final static String[] Numeros = new String[] {
        "Uno", "Dos", "Tres", "Cuatro", 
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

    static void Numero(int i) {
        System.out.print(Numeros[i] + " ");        
    }

    static void Regalo(int i) {
        System.out.println(Regalos[i]);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 12; i ++) {
            for(int j = 0; j < i; j ++) {
                Numero(j);
                Regalo(j);          
            }
            System.out.println();
        }
    }

}
