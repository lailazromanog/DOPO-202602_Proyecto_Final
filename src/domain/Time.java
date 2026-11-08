package domain;

public class Time extends Match {
    private boolean goldenGoal;

    public Time(Player playerOne, Player playerTwo, Ball ball, Goal leftGoal, Goal rightGoal, Timer timer, Score score) {
        super(playerOne, playerTwo, ball, leftGoal, rightGoal, timer, score);
        this.goldenGoal = false;
    }

    @Override 
    public boolean checkWinCondition(){
        if (timer.isTimeUp()){
            int goalsOne = score.getGoalsPlayerOne();
            int goalsTwo = score.getGoalsPlayerTwo();

            if (goalsOne != goalsTwo){
                return true;
            } else {
                goldenGoal = true;
                return false;
            }
        }

        if(goldenGoal){
            int goalsOne = score.getGoalsPlayerOne();
            int goalsTwo = score.getGoalsPlayerTwo();

            return goalsOne != goalsTwo;
            
        }

        return false;
    }

    public boolean isGoldenGoal(){
        return goldenGoal;
    }
}
