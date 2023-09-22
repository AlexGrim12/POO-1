import java.util.ArrayList;
import java.util.Random;

public class Palabra {
    private ArrayList<String> words = new ArrayList<String>();
    private StringBuilder word = new StringBuilder();
    private StringBuilder hiddenWord = new StringBuilder();
    private Random rand = new Random();

    public Palabra() {
        setWords();
        
        int r = rand.nextInt(words.size());
        this.word = new StringBuilder(words.get(r).toUpperCase());
        
        for(int i = 0; i < word.length(); i++)
            this.hiddenWord.append('_');
    }

    private void setWords() {
        words.add("personas");
        words.add("computadora");
        words.add("ciudad");
        words.add("sistema");
        words.add("historia");
        words.add("internet");
        words.add("perro");
        words.add("gato");
        words.add("casa");
        words.add("dia");
        words.add("noche");
        words.add("importante");
        words.add("pelicula");
        words.add("musica");
        words.add("libro");
        words.add("desarrollo");
        words.add("tiempo");
        words.add("programacion");
        words.add("cuerpo");
        words.add("problema");
        words.add("solucion");
        words.add("informacion");
        words.add("movimiento");
        words.add("lenguaje");
        words.add("actividad");
        words.add("luz");
        words.add("fuerza");  
        words.add("nuevo");
        words.add("espacio");
        words.add("naturaleza");
    }

    public StringBuilder getWord() {
        return this.word;
    }

    public StringBuilder getHiddenWord() {
        return this.hiddenWord;
    }

    public boolean guessLetter(char l) {
        boolean inWord = false;
        
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == l) {
                this.hiddenWord.setCharAt(i, l);
                inWord = true;
            }
        }
        
        return inWord;
    }
}
