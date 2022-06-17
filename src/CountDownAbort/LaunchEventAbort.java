package CountDownAbort;

public class LaunchEventAbort implements Runnable {
    private int start;
    private String message;
    TimeMonitorAbort tm;
    public LaunchEventAbort(int start, String message, TimeMonitorAbort tm){
        this.start = start;
        this.message = message;
        this.tm = tm;
    }

    public void run(){
        boolean eventDone = false;
        boolean aborted = false;
        while(!eventDone){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                aborted = true;
            }
            if(tm.getTime() <= start){
                System.out.println(this.message);
                eventDone = true;
                System.out.println("ABORT!!!");
                tm.abortCountDown();
            }
            if(Thread.interrupted()) aborted = true;

            if(aborted){
                System.out.println("Aborting " + message);
                break;
            }
        }
    }

}
