package org.com.LB.iptiq.Main;

import java.util.List;
import java.util.Random;

public class RandomLoadBalancer extends LoadBalancer{
    @Override
    public String get() {
        List<String> providers = Provider.getActiveProviders();
        int random = new Random().nextInt(providers.size());
        return providers.get(random);
    }
}
