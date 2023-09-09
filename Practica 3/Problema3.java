import java.util.Random;

public class Problema3 {
    static StringBuilder[][] p = new StringBuilder[10][10];

    static void inicio() {
        int k = 2;

        p[0][0] = new StringBuilder("S");
        p[9][9] = new StringBuilder("E");

        for(int i = 0; i < p.length; i ++) {
            for(int j = 0; j < p[0].length; j ++){
                if((i == 0 && j == 0) || (i == 9 && j == 9))
                    continue;
                else {
                    p[i][j] = new StringBuilder(Integer.toString(k));
                    k ++;
                }
            }
        }

        p[0][0].append("HT");
    }

    static void pista() {
        for(int i = 0; i < p.length; i ++) {
            for(int j = 0; j < p[0].length; j ++)
                System.out.print(p[i][j] + "\t");
            System.out.println();
        }
    }

    static int jugada(int nPos) {
        Random rand = new Random();
        int d, n = nPos;

        d = rand.nextInt(6) + 1;
        n += d;

        if (n > 100)
            n = 100;

        System.out.println("Dado: " + d);
        System.out.println("Avanza de " + nPos +" a " + n);
        
        if(n == 7 || n == 14 || n == 33 || n == 77 || n == 89) {
            System.out.println("Casilla Especial!\tTira de nuevo");
            n = jugada(n);
        } else if(n == 6 || n == 23 || n == 42 || n == 56 || n == 82 || n == 90) {
            System.out.println("Trampa\tRetrocede de " + n + " a " + (n - 5));
            n -= 5;
        } else if(n == 36) {
            System.out.println("Casilla Especial!\tAvanza de " + n + " a 71");
            n = 71;
        } else if(n == 65) {
            System.out.println("Casilla Especial!\ttAvanza de " + n + " a 84");
            n = 84;
        } else if(n == 10) {
            System.out.println("Trampa\tRegresa al inicio");
            n = 1;
        } else if(n == 66) {
            System.out.println("Trampa\tRegresa de " + n + " a 40");
            n = 40;
        }

        return n;
    }

    public static void main(String[] args) {
        int posIH = 0, posJH = 0, posIT = 0, posJT = 0, nH = 1, nT = 1, turno = 0;

        inicio();        

        System.out.println("Pista inicial");
        pista();

        while(true) {
            turno ++;

            System.out.print("\nTurno " + turno);	
            if(turno % 2 != 0){
                System.out.println(". Tira la Tortuga\n");
                
                nT = jugada(nT);

                if(p[posIT][posJT].charAt(p[posIT][posJT].length() - 1) == 'T')
                    p[posIT][posJT].deleteCharAt(p[posIT][posJT].length() - 1);
                else
                    p[posIT][posJT].deleteCharAt(p[posIT][posJT].length() - 2);
                
                if(nT == 0) {
                    posIT = 0;
                    posJT = 0;
                } else {
                    posIT = (nT - 1) / 10;
                    posJT = (nT - 1) % 10;
                }

                p[posIT][posJT].append("T");
            } else {
                System.out.println(". Tira la Liebre\n");
                
                nH = jugada(nH);

                if(p[posIH][posJH].charAt(p[posIH][posJH].length() - 1) == 'H')
                    p[posIH][posJH].deleteCharAt(p[posIH][posJH].length() - 1);
                else
                    p[posIH][posJH].deleteCharAt(p[posIH][posJH].length() - 2);

                if(nH == 0) {
                    posIH = 0;
                    posJH = 0;
                } else {
                    posIH = (nH - 1) / 10;
                    posJH = (nH - 1) % 10;
                }

                p[posIH][posJH].append("H");
            }
            
            pista();
            
            if(nH == 100 || nT == 100)
                break;

            System.out.println("Fin del turno\n");
        }

        System.out.println("\nGanador: " + (turno % 2 != 0 ? "Tortuga!" : "Liebre!"));
        System.out.println("Fin del juego");
    }
}
