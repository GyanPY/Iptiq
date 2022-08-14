package org.com.LB.iptiq.Main;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider {

    private static Map<String, AtomicInteger> mapOfProviders;
    private static final int heartbeatChecker = 30;
    private static final int capacity =10;
    private static final int HBCount = 2;

    public static int getCapacity(){
        return capacity;
    }
    public static int getHeartbeatChecker(){
        return HBCount;
    }
    public static int getHBCount(){
        return heartbeatChecker;
    }

    /**
     * this is a map of providers as ip key and initial HB count as 2 , makes it alive
     * if less than 2, then assumes inactive
     */
    static{
        mapOfProviders = new ConcurrentHashMap<>(capacity);
        mapOfProviders.put("192.168.1.1", new AtomicInteger(2));
        mapOfProviders.put("192.168.1.2", new AtomicInteger(2));
        mapOfProviders.put("192.168.1.3", new AtomicInteger(2));
        mapOfProviders.put("192.168.1.4", new AtomicInteger(2));
        mapOfProviders.put("192.168.1.5", new AtomicInteger(2));
        mapOfProviders.put("192.168.1.6", new AtomicInteger(2));
        mapOfProviders.put("192.168.1.7", new AtomicInteger(2));
        mapOfProviders.put("192.168.1.8", new AtomicInteger(2));
        mapOfProviders.put("192.168.1.9", new AtomicInteger(2));
        mapOfProviders.put("192.168.2.1", new AtomicInteger(2));

        HealthChecker task = new HealthChecker(HBCount);
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(task, 0,  heartbeatChecker * 1000);
    }

    public static Map<String, AtomicInteger> getMapOfProviders(){
        return mapOfProviders;
    }
   /**
    * active provider logic
    */
    public static List<String> getActiveProviders(){
        List<String> activeProviders = new ArrayList<>();
        for(Map.Entry<String, AtomicInteger> map: mapOfProviders.entrySet()){
            if(map.getValue().get()==2){
                activeProviders.add(map.getKey());
            }
        }
        return activeProviders;
    }


}
