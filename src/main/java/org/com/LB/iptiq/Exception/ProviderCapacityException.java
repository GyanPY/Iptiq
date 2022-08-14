package org.com.LB.iptiq.Exception;

import org.com.LB.iptiq.Main.Provider;

public class ProviderCapacityException extends RuntimeException {

    //private static final long serialVersionUID = -1041264753815342911L;

    public ProviderCapacityException(String provider) {
        super(String.format("Capacity of %s is reached, cannot add %s",
                Provider.getCapacity(), provider));
    }

}