package domain;

public class Defensive extends Bot {
    
    public Defensive() {
        super();
    }

    @Override
    public void decideAction(Match match) {
        Ball ball = match.getBall();
        Goal myGoal = match.getRightGoal();
        double distanceToBall = Math.abs(ball.getPositionX() - getPositionX());


        if(getPositionX() > myGoal.getPositionX() + 100){
            moveLeft();
        } else if (getPositionX() < myGoal.getPositionX()){
            moveRight();
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
