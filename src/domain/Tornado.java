package domain;

public class Tornado extends Power {
    public Tornado() {
        super("Tornado", 40, 3);
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

        opponent.setPositionY(opponent.getPositionY() + 200);
        opponent.applyEffect("unconscious", getEffectDuration());
    }
}
