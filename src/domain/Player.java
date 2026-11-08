package domain;

public class Player {
    private double positionX;
    private double positionY;
    private double initialX;
    private double initialY;
    private double health;
    private boolean stunned;
    private double stunTimer;
    private boolean auraActive;
    private String currentEffect;
    private double effectTimer;
    private int speed;
    private int jump;
    private int kick;
    private int survival;
    private int points;
    private Character character;
    private PowerBar powerBar;

    public Player() {
        this.health = getMaxHealth();
        this.stunned = false;
        this.stunTimer = 0;
        this.auraActive = false;
        this.speed = 1;
        this.jump = 1;
        this.kick = 1;
        this.survival = 1;
        this.points = 0;
        this.currentEffect = null;
        this.effectTimer = 0;
        this.powerBar = new PowerBar();
    }

    public void moveLeft() {
        if(!stunned && !"unconscious".equals(currentEffect)){
            if ("electrocuted".equals(currentEffect)) {
                positionX -= speed * 0.5;
            } else {
                positionX -= speed;
            }
        }
    }

    public void moveRight() {
        if(!stunned && !"unconscious".equals(currentEffect)){
            if ("electrocuted".equals(currentEffect)) {
                positionX += speed * 0.5;
            } else {
                positionX += speed;
            }
        }
    }

    public void jump() {
        if (!stunned && !"unconscious".equals(currentEffect) && !"electrocuted".equals(currentEffect)) {
            positionY += jump;
        }
    }

    public void kick(Ball ball) {
        if (!stunned && !"unconscious".equals(currentEffect)) {
            ball.applyForce(kick, 0);
        }
    }

    public void usePower(){
        if(!stunned && powerBar.isFull() && !auraActive){
            auraActive = true;
            powerBar.reset();
        }
    }

    public void stun(double duration) {
        this.stunned = true;
        this.stunTimer = duration;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void takeDamage(double damage){
        health -= damage;
        if (health <= 0) {
            health = 0;
            stun(3.0);
        }
    }

    public void resetHealth() {
        this.health = getMaxHealth();
        this.stunned = false;
        this.stunTimer = 0;
    }

    public void setInitialPosition(double x, double y) {
        this.initialX = x;
        this.initialY = y;
        this.positionX = x;
        this.positionY = y;
    }

    public void resetPosition() {
        this.positionX = initialX;
        this.positionY = initialY;
    }

    public double getMultiplicadorKick() {
        return 1 + 0.10 * (kick - 1);
    }

    public double getMaxHealth() {
        return 100 * (1 + 0.10 * (survival - 1));
    }

    public void applyEffect(String effect, double duration) {
        this.currentEffect = effect;
        this.effectTimer = duration;
    }

    public String getCurrentEffect() {
        return currentEffect;
    }

    public double getEffectTimer() {
        return effectTimer;
    }

    public void clearEffect() {
        this.currentEffect = null;
        this.effectTimer = 0;
    }

    public void upgradeStat(String stat){
        if(stat.equals("speed")){
            if (speed < 10) speed++;
        } else if(stat.equals("jump")){
            if (jump < 10) jump++;
        } else if(stat.equals("kick")){
            if (kick < 10) kick++;
        } else if(stat.equals("survival")){
            if (survival < 10) {
                survival++;
                health = getMaxHealth();
            }
        }
    }

    public void addPoints(int amount){
        this.points += amount;
    }

    public int getPoints(){
        return points;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getHealth() {
        return health;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public PowerBar getPowerBar() {
        return powerBar;
    }

    public boolean isAuraActive() {
        return auraActive;
    }

    public void setAuraActive(boolean auraActive){
        this.auraActive = auraActive;
    }

    public int getSpeed() {
        return speed;
    }

    public int getJump() {
        return jump;
    }

    public int getKick() {
        return kick;
    }

    public int getSurvival() {
        return survival;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }
}
