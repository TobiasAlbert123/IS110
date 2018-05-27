import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BathRoomTest {
    private BathRoom b;

    @Before
    public void setUp() throws Exception {
        b = new BathRoom(10,1, 2, false);
    }

    @Test
    public void getExtraLineTest() {
        assertEquals(b.getExtraLine(), "ekstra bad");
    }

    @After
    public void tearDown() {
    }
}
