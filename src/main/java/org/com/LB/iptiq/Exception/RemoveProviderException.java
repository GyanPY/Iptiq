package org.com.LB.iptiq.Exception;

public class RemoveProviderException extends  RuntimeException {

    //private static final long serialVersionUID = 7657127025152001791L;

    public RemoveProviderException(String provider) {
        super(" Provider Can Not Be Removed : " + provider);
    }
}
