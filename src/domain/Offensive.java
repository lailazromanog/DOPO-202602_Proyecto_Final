package domain;

public class Offensive extends Bot {
    
    public Offensive() {
        super();
    }

    @Override
    public void decideAction(Match match) {
        Ball ball = match.getBall();
        double distanceToBall = Math.abs(ball.getPositionX() - getPositionX());

        if(ball.getPositionX() > getPositionX()){
            moveRight();
        } else if (ball.getPositionX() < getPositionX()){
            moveLeft();
       }

        if (ball.getPositionY() > getPositionY()) {
            jump();
        }

        if (distanceToBall < 50) {
            if(getPowerBar().isFull() && !isAuraActive()){
                usePower();
            }
            kick(ball);
        }
    }
}
