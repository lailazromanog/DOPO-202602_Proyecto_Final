package domain;

public class Ball  {
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double gravity;

    public Ball(){
        this.positionX = 0;
        this.positionY = 0;
        this.velocityX = 0;
        this.velocityY = 0;
        this.gravity = 9.8;
    }

    public void move(){
        positionX += velocityX;
        positionY += velocityY;
        applyGravity();
    }
    
    private void applyGravity(){
        velocityY += gravity;
    }

    public void applyForce(double force, double angle){
        velocityX += force * Math.cos(angle);
        velocityY += force * Math.sin(angle);
    }

    public void bounce(){
        velocityY = -velocityY;
    }

    public void reset(){
        this.positionX = 0;
        this.positionY = 0;
        this.velocityX = 0;
        this.velocityY = 0;
        this.gravity = 9.8;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public double getGravity() {
        return gravity;
    }
}
