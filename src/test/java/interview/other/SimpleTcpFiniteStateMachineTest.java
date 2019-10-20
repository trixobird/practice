package interview.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SimpleTcpFiniteStateMachineTest {

    @Test
    public void testCases() {
        // Is stateless, so fine to reuse for tests
        SimpleTcpFiniteStateMachine cut = new SimpleTcpFiniteStateMachine();
        assertEquals(cut.traverseTcpStates(Arrays.asList("APP_PASSIVE_OPEN", "APP_SEND", "RCV_SYN_ACK")), "ESTABLISHED");
        assertEquals(cut.traverseTcpStates(Collections.singletonList("APP_ACTIVE_OPEN")), "SYN_SENT");
        assertEquals(cut.traverseTcpStates(Arrays.asList("APP_ACTIVE_OPEN", "RCV_SYN_ACK", "APP_CLOSE", "RCV_FIN_ACK", "RCV_ACK")), "ERROR");
    }
}