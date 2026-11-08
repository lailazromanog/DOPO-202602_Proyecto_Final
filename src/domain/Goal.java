package domain;

public class Goal {
    private double positionX;
    private double positionY;
    private int width;
    private int height;

    public Goal(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = 10; 
        this.height = 100; 
    }

    public boolean isGoal(Ball ball) {

        return ball.getPositionX() >= positionX && ball.getPositionX() <= positionX + width &&
               ball.getPositionY() >= positionY && ball.getPositionY() <= positionY + height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }
}
