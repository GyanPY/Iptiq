package org.com.LB.iptiq.Main;

import java.util.Random;
import java.util.TimerTask;

public class HealthChecker extends TimerTask {

    private int heartbeat;

    public HealthChecker(int count){
        this.heartbeat = count;
    }
    @Override
    public void run() {
        Provider.getMapOfProviders().entrySet().stream().
                forEach(entry -> {
                    if(!check(entry.getKey())){
                        entry.getValue().set(0);
                    }
                    else if(entry.getValue().get() < this.heartbeat){
                        entry.getValue().incrementAndGet();
                    }
                });

    }

    private boolean check(String provider){
        return randomBoolean(provider.hashCode());
    }

    private boolean randomBoolean(int val) {
        Random random = new Random(val);
        return random.nextBoolean();
    }
}
