package domain;

public class Goals extends Match {
    private int goalLimit;

    public Goals(Player playerOne, Player playerTwo, Ball ball, Goal leftGoal, Goal rightGoal, Timer timer, Score score, int goalLimit) {
        super(playerOne, playerTwo, ball, leftGoal, rightGoal, timer, score);
        this.goalLimit = goalLimit;
    }

    @Override 
    public boolean checkWinCondition(){
        return score.getGoalsPlayerOne() >= goalLimit || score.getGoalsPlayerTwo() >= goalLimit;
    }

    public int getGoalLimit(){
        return goalLimit;
    }
}
