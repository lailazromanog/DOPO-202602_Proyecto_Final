package domain;

public class Lightning extends Power {
    
    public Lightning() {
        super("Lightning", 60, 3.0);
    }

    @Override
    public void activate(Match match, Player attacker) {
        Player opponent;
        if(attacker == match.getPlayerOne()){
            opponent = match.getPlayerTwo();
        } else {
            opponent = match.getPlayerOne();
        }

        double damage = getDamageTiro() * attacker.getMultiplicadorKick();
        opponent.takeDamage(damage);

        opponent.applyEffect("electrocuted", getEffectDuration());
    }
}
