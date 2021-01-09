public class Timers {

    private Timers timer;
    private String methodName;
    private int milliseconds;
    private boolean isRepeated;
    private boolean shouldStop = false;

    public Timers setTimer(Timers timer, String methodName, int milliseconds, boolean isRepeated) {
        this.timer = timer;
        this.methodName = methodName;
        this.milliseconds = milliseconds;
        this.isRepeated = isRepeated;
        return this;
    }

    public void start() {
        if(!isRepeated) {
            System.out.println(0 + ":" + 0 + ":" + 0);
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(0 + ":" + 0 + ":" + milliseconds/1000);
        }else if(!shouldStop) {
            for (int i = 0; i < 60; i++) {
                for (int j = 0; j <= 59; j += milliseconds/1000) {
                    System.out.println(0 + ":" + i + ":" + j);
                    try {
                        Thread.sleep(milliseconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void stop() {
        this.shouldStop = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Timers timer = new Timers();
        timer.setTimer(timer, "methodName",2000, true).start();
    }
}
