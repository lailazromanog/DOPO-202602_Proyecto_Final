package domain;

public class PowerBar {
    private double currentCharge;
    private double maxCharge;

    public PowerBar() {
        this.maxCharge = 100;
        this.currentCharge = 0;
    }

    public void update(double deltaTime) {
        currentCharge += (maxCharge / 10) * deltaTime;
        if (currentCharge > maxCharge) {
            currentCharge = maxCharge;
        }
    }

    public void chargeOnGoal(){
        currentCharge += maxCharge / 4;
        if (currentCharge > maxCharge) {
            currentCharge = maxCharge;
        }
    }

    public void reset() {
        currentCharge = 0;
    }

    public boolean isFull() {
        return currentCharge >= maxCharge;
    }

    public double getCurrentCharge() {
        return currentCharge;
    }

    public double getMaxCharge() {
        return maxCharge;
    }
}
