public class Ahorcado {
    private StringBuilder solution = new StringBuilder();
    private StringBuilder guess = new StringBuilder();
    private int lives = 7;

    public Ahorcado() {
        Palabra p = new Palabra();
        this.solution.append(p.getWord().toUpperCase());
        setGuess();
    }

    public void paintAhorcado() {
        for(int i = 0; i < lives; i++) {
            switch(i) {
                case 0: System.out.print("  O"); break;
                case 1: System.out.print("\n/"); break;
                case 2: System.out.print(" | "); break;
                case 3: System.out.print((char)92); break;
                case 4: System.out.print("\n  |"); break;
                case 5: System.out.print("\n/   "); break;
                case 6: System.out.print((char)92); break;
            }
        }
    }

    private void setGuess() {
        for(int i = 0; i < solution.length(); i++)
            this.guess.append('_');
    }
    
    public StringBuilder getGuess() {
        return this.guess;
    }

    private void loseLife() {
        this.lives--;
    }

    public int getLives() {
        return this.lives;
    }

    public StringBuilder getSolution() {
        return this.solution;
    }

    private void setLetter(char l, int i) {
        this.guess.replace(i, i + 1, Character.toString(l));
    }

    public void checkLetter(char l) {
        boolean found = false;

        for(int i = 0; i < solution.length(); i++) {
            if(solution.charAt(i) == l) { 
                this.setLetter(l, i);
                found = true;
            }
        }   

        if(!found)
            this.loseLife();
    }
}
