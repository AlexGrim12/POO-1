import java.util.Hashtable;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.ArrayList;
import java.time.LocalDate;

public class pract3 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = i * 2;
        }

        //foreeach
        for(int k: nums) {
            System.out.println(k);
        }

        int[][] m = new int[5][5];
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                if(i == j) {
                    m[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                    System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        String a = args[0];
        int n = Integer.parseInt(args[1]); // moldeaado o casting

        System.out.println("El GOAT es: " + a + " : " + n);

        String s = "Samuel el reprobado de POO GRUPO 3";

        s = s.toUpperCase();
        System.out.println(s);

        StringBuilder sb = new StringBuilder(s);
        sb.append(" por irle a MESSI");
        System.out.println(sb);

        Hashtable<String,String> atlas = new Hashtable<String,String>();

        atlas.put("Mexico", "CDMX");
        atlas.put("Rusia ", "Moscu");
        atlas.put("Etiopia", "Addis Abeba");
        atlas.put("Marruecos", "Rabat");
        atlas.put("Sudafrica", "Pretoria");

        String pais;
        String capital;

        Enumeration<String> claves = atlas.keys();

        while(claves.hasMoreElements()) {
            pais = claves.nextElement();
            capital = atlas.get(pais);

            System.out.println("Paìs:  " + pais + " su capital es " + capital);
        }

        ArrayList<String> programastv = new ArrayList<String>();

        programastv.add("Tortugas Ninja");
        programastv.add("Hey Arnold!");
        programastv.add("Los chicos del barrio");
        programastv.add("Los cuentos de la calle broca");
        programastv.add("Zobomafuu y los hermanos Krat");
        programastv.add("Power Rangers");

        programastv.remove(0);

        for(String pr: programastv) {
            System.out.println(pr);
        }

        LocalDate hoy = LocalDate.now();
        System.out.println(hoy);
    }
}