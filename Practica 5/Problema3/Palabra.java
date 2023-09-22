import java.util.Random;

public class Palabra {
    private StringBuilder word = new StringBuilder();
    private StringBuilder hiddenWord = new StringBuilder();
    private Random rand = new Random();

    public Palabra() {
        int r = rand.nextInt(30);
        this.word = new StringBuilder(chooseWord(r).toUpperCase());
        
        for(int i = 0; i < word.length(); i++)
            this.hiddenWord.append('_');
    }

    private String chooseWord(int r) {
        switch(r) {
            case 1: return "personas";
            case 2: return "computadora";
            case 3: return "ciudad";
            case 4: return "sistema";
            case 5: return "historia";
            case 6: return "internet";
            case 7: return "perro";
            case 8: return "gato";
            case 9: return "casa";
            case 10: return "dia";
            case 11: return "noche";
            case 12: return "importante";
            case 13: return "pelicula";
            case 14: return "musica";
            case 15: return "libro";
            case 16: return "desarrollo";
            case 17: return "tiempo";
            case 18: return "programacion";
            case 19: return "cuerpo";
            case 20: return "problema";
            case 21: return "solucion";
            case 22: return "informacion";
            case 23: return "movimiento";
            case 24: return "lenguaje";
            case 25: return "actividad";
            case 26: return "luz";
            case 27: return "fuerza";
            case 28: return "nuevo";
            case 29: return "espacio";
            default: return "naturaleza";
        }
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
