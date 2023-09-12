import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Problema4 {
    public static void main(String[] args) {
        Set<Integer> A = generarConjuntoAleatorio(10);
        Set<Integer> B = generarConjuntoAleatorio(20);
        Set<Integer> C = generarConjuntoAleatorio(30);
        Set<Integer> D = generarConjuntoAleatorio(40);
 
        System.out.println("Conjunto A: " + A);
        System.out.println("Conjunto B: " + B);
        System.out.println("Conjunto C: " + C);
        System.out.println("Conjunto D: " + D);

        Set<Integer> interseccionABCD = new HashSet<>(A);
        interseccionABCD.retainAll(B);
        interseccionABCD.retainAll(C);
        interseccionABCD.retainAll(D);

        Set<Integer> interseccionAB = new HashSet<>(A);
        interseccionAB.retainAll(B);
        Set<Integer> interseccionCD = new HashSet<>(C);
        interseccionCD.retainAll(D);
        Set<Integer> unionABCD = new HashSet<>(interseccionAB);
        unionABCD.addAll(interseccionCD);

        Set<Integer> unionSinRepetir = new HashSet<>(A);
        unionSinRepetir.addAll(B);
        unionSinRepetir.addAll(C);
        unionSinRepetir.addAll(D);

        Set<Integer> complementoBU = new HashSet<>(unionSinRepetir);
        complementoBU.removeAll(B);
        
        System.out.println("\n\na. A interseccion B interseccion C interseccion D: " + interseccionABCD);
        System.out.println("\nb. (A interseccion B) union (C interseccion D): " + unionABCD);
        System.out.println("\nc. U = A union B union C union D sin repeticion de elementos: " + unionSinRepetir);
        System.out.println("\nd. Complemento de B con respecto a U: " + complementoBU);
    }
   
    public static Set<Integer> generarConjuntoAleatorio(int tamano) {
        Set<Integer> conjunto = new HashSet<>();
        Random random = new Random();
        while (conjunto.size() < tamano) {
            conjunto.add(random.nextInt(201)); 
        }
        return conjunto;
    }
}
