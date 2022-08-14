import org.com.LB.iptiq.Main.LoadBalancer;
import org.com.LB.iptiq.Main.Provider;
import org.com.LB.iptiq.Main.RandomLoadBalancer;
import org.com.LB.iptiq.Main.RoundRobinLoadBalancer;
import org.com.LB.iptiq.Exception.ProviderCapacityException;
import org.com.LB.iptiq.Exception.RemoveProviderException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLoadBalancerTestTest {

    @Test
    public void get() {
        testLoadBalancer(new RoundRobinLoadBalancer());
        testLoadBalancer(new RandomLoadBalancer());
    }

    private void testLoadBalancer(LoadBalancer loadBalance) {
        assertNotNull(loadBalance.get());
    }

    @Test
    public void addRemoveTest() {
        LoadBalancer lb = new RoundRobinLoadBalancer();
        lb.removeProvider("192.168.2.1");
        assertEquals(9, Provider.getMapOfProviders().size());
        lb.addProvider("192.168.2.2");
        assertEquals(10, Provider.getMapOfProviders().size());
    }

    @Test(expected = ProviderCapacityException.class)
    public void add() {
        LoadBalancer lb = new RoundRobinLoadBalancer();
        lb.addProvider("192.168.2.1");
    }

    @Test(expected = RemoveProviderException.class)
    public void remove() {
        LoadBalancer lb = new RoundRobinLoadBalancer();
        lb.removeProvider("192.168.2.3");
    }
}