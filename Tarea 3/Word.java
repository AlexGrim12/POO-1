import java.util.Random;
import java.util.ArrayList;

public class Word {
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
        Random rand = new Random();
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
        for(int i = 0; i < this.solutions.size(); i++) {
            if(this.solutions.get(i).equals(s)) {
                this.solutions.remove(i);
                return true;
            }
        }
        return false;
    }
}
