package domain;

public abstract class Power {
    private String name;
    private int damageTiro;
    private boolean active;
    private double effectDuration;

    public Power(String name, int damageTiro, double effectDuration) {
        this.name = name;
        this.damageTiro = damageTiro;
        this.active = false;
        this.effectDuration = effectDuration;
    }

    public String getName() {
        return name;
    }

    public int getDamageTiro() {
        return damageTiro;
    }

    public boolean isActive() {
        return active;
    }

    public double getEffectDuration() {
        return effectDuration;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void activate(Match match, Player attacker);
}
