import java.util.ArrayList;
import java.util.Random;

public class Palabra {
    private ArrayList<String> words = new ArrayList<String>();
    private String word;
    Random rand = new Random();

    public Palabra() {
        setWords();
        int i = rand.nextInt(words.size());
        setWord(i);
    }

    public void setWords() {
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

    private void setWord(int i) {
        this.word = words.get(i);
    }

    public String getWord() {
        return this.word;
    }
}
