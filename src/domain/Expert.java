package domain;

public class Expert extends Bot {
    
    public Expert() {
        super();
    }

    @Override
    public void decideAction(Match match) {
        Ball ball = match.getBall();
        Score score = match.getScore();
        int myGoals = score.getGoalsPlayerTwo();
        int opponentGoals = score.getGoalsPlayerOne();
        double distanceToBall = Math.abs(ball.getPositionX() - getPositionX());

        if(myGoals <= opponentGoals){
            if(ball.getPositionX() > getPositionX()){
                moveRight();
            } else {
                moveLeft();
            }
        } else {
            Goal myGoal = match.getRightGoal();
            if(getPositionX() > myGoal.getPositionX() + 100){
                moveLeft();
            } else if (getPositionX() < myGoal.getPositionX()){
                moveRight();
            }
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
