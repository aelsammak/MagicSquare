import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MagicSquareModelTest {

    private MagicSquareModel magicSquareModel;

    @Before
    public void setUp() {
        magicSquareModel = new MagicSquareModel(3);
    }

    @After
    public void tearDown() {
        magicSquareModel = null;
    }

    @Test
    public void testInitialStatus() {
        assertEquals(MagicSquareModel.Status.UNDECIDED, magicSquareModel.getStatus());
    }

    @Test
    public void testMagicSquareWin() {
       magicSquareModel.play(0,0, 2);
       magicSquareModel.play(0,1, 7);
       magicSquareModel.play(0,2, 6);
       magicSquareModel.play(1,0, 9);
       magicSquareModel.play(1,1, 5);
       magicSquareModel.play(1,2, 1);
       magicSquareModel.play(2,0, 4);
       magicSquareModel.play(2,1, 3);
       magicSquareModel.play(2,2, 8);
       assertEquals(MagicSquareModel.Status.MAGIC_SQUARE, magicSquareModel.getStatus());
    }

    @Test
    public void testMagicSquareLose() {
        magicSquareModel.play(0,0, 3);
        magicSquareModel.play(0,1, 8);
        magicSquareModel.play(0,2, 6);
        magicSquareModel.play(1,0, 5);
        magicSquareModel.play(1,1, 9);
        magicSquareModel.play(1,2, 1);
        magicSquareModel.play(2,0, 4);
        magicSquareModel.play(2,1, 2);
        magicSquareModel.play(2,2, 7);
        assertEquals(MagicSquareModel.Status.NONMAGIC_SQUARE, magicSquareModel.getStatus());
    }

}