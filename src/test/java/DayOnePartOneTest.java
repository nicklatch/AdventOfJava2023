import org.godDamnElves.dayOne.PartOne;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOnePartOneTest {

    @Test
    public void dayOnePartOneReturns142WithTestData() throws IOException {
        assertEquals(new PartOne().calibrationSum("src/main/resources/d1p1test.txt"), 142);
    }

    @Test
    public void dayOnePartOneReturnsCorrectWithAOCData() throws IOException {
        assertEquals(new PartOne().calibrationSum("src/main/resources/dayOnePartOneData.txt"), 52974);
    }


}
