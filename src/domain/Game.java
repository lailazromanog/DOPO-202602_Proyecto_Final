package domain;

public class Game{
    private String mode;
    private String matchType;
    private String botProfile;
    private Match match;

    public Game(String mode, String matchType, String botProfile) {
        this.mode = mode;
        this.matchType = matchType;
        this.botProfile = botProfile;
    }

    public void createMatch(){
        Player playerOne = new Player();
        Player playerTwo;

        if (mode.equals("PvP")){
            playerTwo = new Player();
        } else {
            if(botProfile.equals("stupid")){
                playerTwo = new Stupid();
            } else if(botProfile.equals("expert")){
                playerTwo = new Expert();
            } else if(botProfile.equals("defensive")){
                playerTwo = new Defensive();
            } else {
                playerTwo = new Offensive();
            }
        }
        playerOne.setInitialPosition(0, 0);
        playerTwo.setInitialPosition(0, 0);
        
        Ball ball = new Ball();
        Goal leftGoal = new Goal(0, 0);
        Goal rightGoal = new Goal(0, 0);
        Timer timer = new Timer();
        Score score = new Score(playerOne, playerTwo);

        if(matchType.equals("time")){
            match = new Time(playerOne, playerTwo, ball, leftGoal, rightGoal, timer, score);
        } else {
            match = new Goals(playerOne, playerTwo, ball, leftGoal, rightGoal, timer, score, 5);
        }
    }

    public Match getMatch(){
        return match;
    }

    public String getMode(){
        return mode;
    }

    public String getMatchType(){
        return matchType;
    }

    public String getBotProfile(){
        return botProfile;
    }
}