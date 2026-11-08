package domain;

public class Stupid extends Bot {
    
    public Stupid() {
        super();
    }

    @Override
    public void decideAction(Match match) {
        int random = (int) (Math.random() * 5); // Genera un numero random entre 0 y 4
        Ball ball = match.getBall();

        if (random == 0) {
            moveLeft();
        } else if (random == 1) {
            moveRight();
        } else if (random == 2) {
            jump();
        } else if (random == 3) {
            kick(ball);
        } else if (random == 4) {
            usePower();
        }
    }
}
