package org.com.LB.iptiq;

import org.com.LB.iptiq.Main.LoadBalancer;
import org.com.LB.iptiq.Main.RandomLoadBalancer;
import org.com.LB.iptiq.Main.RoundRobinLoadBalancer;

public class DriverLB {
    public static void main(String[] args) {
        typeLoadBalancer();
    }

    public static void typeLoadBalancer(){
          getLB(new RoundRobinLoadBalancer());
          getLB(new RandomLoadBalancer());
    }

    public static void getLB(LoadBalancer lb){
        mainProviderCall(lb, 50);
    }

    private static void mainProviderCall(LoadBalancer typeLoadBalancer, int query ){
        for(int i=0; i<query; i++){
            String server = typeLoadBalancer.get();
            System.out.println(String.format("[%s] index:%s,%s",
                    typeLoadBalancer.getClass().getSimpleName(), i, typeLoadBalancer)
            + " "+ "Server Name "+ server);

        }
    }
}
