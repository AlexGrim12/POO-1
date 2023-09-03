public class Problema2VersionA {
    static void estrofas(int i, int j) {
        String estrofa = "";
        
        if(j >= i) {
            System.out.println();
            return;
        }

        switch(j) {
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
            case 11: estrofa = "Doce tamborileros tocando el tambor";break;
        }
    
        System.out.println(estrofa);
        estrofas(i, j + 1);    
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 12; i ++)
            estrofas(i, 0);
    }
}
