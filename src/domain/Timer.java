package domain;

public class Timer {
    private int totalTime;
    private int currentTime;
    private boolean running;

    public Timer() {
        this.totalTime = 60;
        this.currentTime = 60;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public void update(double deltaTime) {
        if (running) {
            currentTime -= deltaTime;
            if (currentTime < 0) {
                currentTime = 0;
            }
        }
    }

    public boolean isTimeUp() {
        return currentTime <= 0;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public boolean isRunning() {
        return running;
    }
}
