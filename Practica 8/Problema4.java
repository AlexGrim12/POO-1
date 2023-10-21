public class Problema4{
    public class Sort{
        public static String sortByLength(String s, String a){
            String[] words = s.split(" ");

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length - 1; j++) {
                    if (words[j].length() > words[j + 1].length())
                        swap(words, j, j + 1);
                }
            }

            return append(words);
        }

        public static String sortByLength(String s, char a){
            String[] words = s.split(" ");

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length - 1; j++) {
                    if (words[j].length() < words[j + 1].length())
                        swap(words, j, j + 1);
                }
            }

            return append(words);
        }

        public static String sortByAlphabet(String s, String a){
            String[] words = s.split(" ");

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length - 1; j++) {
                    if (words[j].toLowerCase().charAt(0) 
                        > words[j + 1].toLowerCase().charAt(0))
                        swap(words, j, j + 1);
                }
            }

            return append(words);
        }

        public static String sortByAlphabet(String s, char a){
            String[] words = s.split(" ");

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length - 1; j++) {
                    if (words[j].toLowerCase().charAt(0) 
                        < words[j + 1].toLowerCase().charAt(0))
                        swap(words, j, j + 1);
                }
            }

            return append(words);
        }

        private static void swap(String[] words, int i, int j){
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
        }

        private static String append(String[] words){
            String result = "";
            for (int i = 0; i < words.length; i++)
                result += words[i] + " ";

            return result;
        }
    }

    public static void main(String[] args) {
        String s = "Hello World in Java";

        System.out.println("String: " + s);
        
        System.out.println("\n- Ordenacion por longitud -");
        System.out.println("Ascendente: " + Sort.sortByLength(s, "s"));
        System.out.println("Descendente: " + Sort.sortByLength(s, 's'));
        
        System.out.println("\n- Ordenacion alfabetica -");
        System.out.println("a-z: " + Sort.sortByAlphabet(s, "s"));
        System.out.println("z-a: " + Sort.sortByAlphabet(s, 's'));
    }
}
