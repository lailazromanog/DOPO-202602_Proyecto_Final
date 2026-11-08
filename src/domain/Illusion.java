package domain;

public class Illusion extends Power {
    public Illusion() {
        super("Illusion", 30, 2.5);
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

        opponent.applyEffect("confused", getEffectDuration());
    }
}
