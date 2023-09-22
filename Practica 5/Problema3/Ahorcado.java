public class Ahorcado {
    private int lives = 7;

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

    public int getLives() {
        return this.lives;
    }

    public void loseLife() {
        this.lives--;
    }
}
