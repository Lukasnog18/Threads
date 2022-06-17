package CountDown;

public class LaunchEvent implements Runnable {

    private int start;
    private String message;
    TimeMonitor tm;

    public LaunchEvent(int start, String message, TimeMonitor tm) {
        this.start = start;
        this.message = message;
        this.tm = tm;
    }

    public void run() {
        boolean eventDone = false;
        while(!eventDone) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}

            if(tm.getTime() <= start) {
                System.out.println(this.message);
                eventDone = true;
            }
        }
    }

}
