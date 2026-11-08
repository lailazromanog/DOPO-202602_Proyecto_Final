package domain;

public class Score {
    private int goalsPlayerOne;
    private int goalsPlayerTwo;
    private Player playerOne;
    private Player playerTwo;

    public Score(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.goalsPlayerOne = 0;
        this.goalsPlayerTwo = 0;
    }

    public void addGoal(Player player) {
        if (player == playerOne) {
            goalsPlayerOne++;
        } else {
            goalsPlayerTwo++;
        }
    }

    public Player getWinner() {
        if (goalsPlayerOne > goalsPlayerTwo) {
            return playerOne;
        } else if (goalsPlayerTwo > goalsPlayerOne) {
            return playerTwo;
        }
        return null;
    }

    public int getGoalsPlayerOne() {
        return goalsPlayerOne;
    }

    public int getGoalsPlayerTwo() {
        return goalsPlayerTwo;
    }
}
