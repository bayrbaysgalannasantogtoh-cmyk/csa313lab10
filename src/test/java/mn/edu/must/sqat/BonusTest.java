package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BonusTest {





    @Test
    @DisplayName("Exceptions: Null array or negative threshold")
    public void testExceptions() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, 1));
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[]{}, -1));
    }

    @Test
    @DisplayName("Empty attendance - Covers default score=0")
    public void testEmptyArray() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{}, 1));
    }

    @Test
    @DisplayName("Meets threshold only - Covers score=5")
    public void testThresholdMet() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{1}, 1));
    }

    @Test
    @DisplayName("Meets threshold and streak - Covers score=5+3=8")
    public void testFullBonus() {
        assertEquals(8, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 5));
    }





    @Test
    @DisplayName("Streak breaks (kill) - present counts but streak resets")
    public void testStreakBreak() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{1, 0, 1}, 2));
    }

    @Test
    @DisplayName("Streak >=5 but present < threshold")
    public void testStreakWithoutThreshold() {
        // present=5 боловч threshold=10 тул score = 0 + 3 = 3
        assertEquals(3, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 10));
    }

    @Test
    @DisplayName("Multiple streaks but not beating best")
    public void testStreakNotBeatingBest() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{1, 1, 0, 1}, 2));
    }

    
}
