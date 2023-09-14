import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class TextTwist {
    static Random rand = new Random();
    
    static public class Word {
        public String word;
        public String scrambled;
        public ArrayList<String> solutions = new ArrayList<String>();

        public  Word(String word, String s1, String s2, String s3, String s4, String s5) {
            this.word = word;
            this.scrambled = scrambled(word);
            this.solutions.add(s1);
            this.solutions.add(s2);
            this.solutions.add(s3);
            this.solutions.add(s4);
            this.solutions.add(s5);
            this.solutions.add(word);
        }

        public String scrambled(String w) {
            StringBuilder s = new StringBuilder(w);
            int n = s.length();

            for(int i = 0; i < n; i++) {
                int r = rand.nextInt(n);
                char c = s.charAt(i);
                s.setCharAt(i, s.charAt(r));
                s.setCharAt(r, c);
            }
            
            if (s.toString().equals(w))
                return scrambled(w);
            else
                return s.toString();
        }

        public int points(String s) {
            String sb = s.toUpperCase();

            if(this.isSolution(sb)) {
                switch(sb.length()) {
                    case 3: return 1;
                    case 4: return 2;
                    case 5: return 3;
                    case 6: 
                        if(this.word.equals(sb)) 
                            return 54;
                        else 
                            return 4;
                    default: return 0;
                }
            } else
                return 0;
        }        

        public boolean isSolution(String s) {
            s = s.toUpperCase();
            for(int i = 0; i < solutions.size(); i++) {
                if(this.solutions.get(i).equals(s)) {
                    this.solutions.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = rand.nextInt(5);  
        int tries = 10;  
        int score = 0;
        
        Word w;
        switch(r) {
            case 0: w = new Word("SELECT", "CEL","SET", "ELSE", "ELECT", "STEEL"); break;
            case 1: w = new Word("DATING", "AND", "ANTI", "DING", "GAIN", "GIANT"); break;
            case 2: w = new Word("VALUES", "SEA", "USE", "SAVE", "SALE", "SLAVES"); break;
            case 3: w = new Word("MANGOS", "MAN",  "GAS", "SON", "SONG", "AMONG"); break;
            default: w = new Word("UNMADE", "END", "AMEN", "MEAN", "MENU", "NAMED"); break;
        }

        System.out.println("*** Bienvenido a TextTwist ***");
        System.out.println("Tienes 10 intentos para adivinar las 5 palabras (en ingles)");
        System.out.println("La palabra revuelta es: " + w.scrambled);
        
        while(tries > 0 && w.solutions.size() > 0) {
            System.out.println("\nTe quedan " + tries + " intentos");

            System.out.print("Ingresa tu respuesta: ");
            String s = sc.nextLine();

            int p = w.points(s);
            score += p;

            System.out.println("Ganaste " + p + " puntos\n");
            tries--;
        }

        if(tries == 0)
            System.out.println("Se te acabaron los intentos");
        else 
            System.out.println("Felicidades, adivinaste todas las palabras");

        System.out.println("\nTu puntaje final es: " + score);
        sc.close();
    }
}
