package CountDown;

public class CountdownClock implements Runnable, TimeMonitor {

    private int t;

    public CountdownClock(int t) {
        this.t = t;
    }

    public void run() {
        for(; t >= 0; t--) {
            System.out.println("T menos " + t);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    public int getTime() {
        return t;
    }

}
