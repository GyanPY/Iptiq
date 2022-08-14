package org.com.LB.iptiq.Main;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinLoadBalancer extends LoadBalancer{

    private static Integer currentIndexPosition = 0;
    private static ReentrantLock lock;
    @Override
    public String get() {
        lock = new ReentrantLock();
        String currentProvider;
        List<String> providers = Provider.getActiveProviders();
        lock.lock();
        try{
            int idx = currentIndexPosition % (providers.size());
            currentProvider = providers.get(idx);
            ++idx;
        }finally {
            lock.unlock();
        }
        return currentProvider;
    }
}
