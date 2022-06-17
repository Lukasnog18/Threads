package CountDown;

import java.util.ArrayList;

public class CountdownApp {

    public static void main(String[] args) {
        CountdownClock cdc = new CountdownClock(20);
        Thread clock = new Thread(cdc);
        ArrayList<Runnable> events = new ArrayList<Runnable>();

        events.add(new LaunchEvent(16, "Flood the pad", cdc));
        events.add(new LaunchEvent(6, "Start engines", cdc));
        events.add(new LaunchEvent(0, "Liftoff!", cdc));

        clock.start();
        for (Runnable e : events) new Thread(e).start();
    }

}
