package domain;

public abstract class Bot extends Player {
    public Bot() {
        super();
    }

    public abstract void decideAction(Match match);
    
}
