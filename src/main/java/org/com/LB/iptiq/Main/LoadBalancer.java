package org.com.LB.iptiq.Main;

import org.com.LB.iptiq.Exception.ProviderCapacityException;
import org.com.LB.iptiq.Exception.RemoveProviderException;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class LoadBalancer {
    /**
     *
     * @return this function will return the provider instance IP
     */
    public abstract String get();

    /**
     * remove Provider from providerlist
      */
    public void removeProvider(String provider){
        AtomicInteger val = Provider.getMapOfProviders().remove(provider);
        if( val == null){
            throw new RemoveProviderException(provider);
        }
    }

    /**
     * Add Provider
     */

    public void addProvider(String provider){
        if(Provider.getMapOfProviders().size()<Provider.getCapacity()){
            Provider.getMapOfProviders().putIfAbsent(provider, new AtomicInteger(Provider.getHBCount()));
        }
        else{
            throw new ProviderCapacityException(provider);
        }
    }
}
