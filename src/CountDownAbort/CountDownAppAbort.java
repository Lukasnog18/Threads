package CountDownAbort;

import java.util.ArrayList;

public class CountDownAppAbort {
    public static void main(String[] args){
        CountDownClockAbort clock = new CountDownClockAbort(20);
        Thread tclock = new Thread(clock);
        ArrayList<Runnable> events = new ArrayList<Runnable>();

        events.add(new LaunchEventAbort(16, "Flood the pad!", clock));
        events.add(new LaunchEventAbort(6, "Start engines!", clock));
        events.add(new LaunchEventAbort(0,"Liftoff!", clock));

        tclock.start();

        for(Runnable e : events) new Thread(e).start();
    }
}
