import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Problema4 {
    static ArrayList<Integer> ulam(int u, int v) {
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        ArrayList<Integer> sums = new ArrayList<Integer>();

        sequence.add(u);
        sequence.add(v);

        for(int i = 0; i < 8; i ++) {
            sums.clear();

            for(int j = 0; j < sequence.size(); j ++) {
                for(int k = j + 1; k < sequence.size(); k ++)
                    sums.add(sequence.get(j) + sequence.get(k));
            }

            sums.sort(Comparator.naturalOrder());

            for(int j = 0; j < sums.size(); j ++) {
                if(sequence.contains(sums.get(j))) {
                    sums.remove(j);
                    j --;
                }
            }

            while(true) {
                if(sums.size() == 1) {
                    sequence.add(sums.get(0));
                    break;
                } else if(sums.get(0) == sums.get(1)) {
                    int temp = sums.get(0);
                    while(sums.get(0) == temp)
                        sums.remove(0);
                } else {
                    sequence.add(sums.get(0));
                    break;
                }
            }
        }

        return sequence;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero 1: ");
        int u = sc.nextInt();
        System.out.print("Numero 2: ");
        int v = sc.nextInt();


        System.out.println("\nPrimeros 10 numeros de la secuencia: ");
        System.out.println(ulam(u, v));

        sc.close();
    }
}
