import java.util.ArrayList;

public class Problema4{
    public class Sort{
        private static ArrayList<String> split(String s) {
            String[] words = s.split(" ");
            ArrayList<String> wordsAL = new ArrayList<>();
            for (int i = 0; i < words.length; i++)
                wordsAL.add(words[i]);
            return wordsAL;
        }

        private static String append(ArrayList<String> words){
            String result = "";
            for (int i = 0; i < words.size(); i++)
                result += words.get(i) + " ";
            return result;
        }

        public static String sortByLength(String s){
            ArrayList<String> words = new ArrayList<>();
            words = split(s);
            words.sort((word1, word2) -> word1.length() - word2.length());
            return append(words);
        }

        public static String sortByLength(String s, String a){
            ArrayList<String> words = new ArrayList<>();
            words = split(s);
            words.sort((word1, word2) -> word2.length() - word1.length());
            return append(words);
        }

        public static String sortByAlphabet(String s){
            ArrayList<String> words = new ArrayList<>();
            words = split(s);
            words.sort((word1, word2) -> word1.toLowerCase().charAt(0) 
                - word2.toLowerCase().charAt(0));
            return append(words);
        }

        public static String sortByAlphabet(String s, String a){
            ArrayList<String> words = new ArrayList<>();
            words = split(s);
            words.sort((word1, word2) -> word2.toLowerCase().charAt(0) 
                - word1.toLowerCase().charAt(0));
            return append(words);
        }
    }

    public static void main(String[] args) {
        String s = "Hello World in Java";

        System.out.println("String: " + s);
        
        System.out.println("\n- Ordenacion por longitud -");
        System.out.println("Ascendente: " + Sort.sortByLength(s));
        System.out.println("Descendente: " + Sort.sortByLength(s, "s"));
        
        System.out.println("\n- Ordenacion alfabetica -");
        System.out.println("a-z: " + Sort.sortByAlphabet(s));
        System.out.println("z-a: " + Sort.sortByAlphabet(s, "s"));
    }
}
