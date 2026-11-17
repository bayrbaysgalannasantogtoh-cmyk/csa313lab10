package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GcdTest {

    @Test
    @DisplayName("gcd(7, 0) - Covers y=0 directly, bypassing loop")
    public void testGcd_7_0() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("gcd(12, 8) - Covers loop iterations and updates")
    public void testGcd_12_8() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }
}
