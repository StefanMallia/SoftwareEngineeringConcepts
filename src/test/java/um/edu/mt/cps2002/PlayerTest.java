package um.edu.mt.cps2002;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest
{
    Player playerTest;

    @Before
    public void setUp()
    {
        playerTest = new Player();
    }
    @Test
    public void testMove()
    {
        playerTest.position = new Position(0,0);
        playerTest.move(Direction.RIGHT);
        Assert.assertEquals(true, playerTest.position.equals(0,1));
        playerTest.move(Direction.DOWN);
        Assert.assertEquals(true, playerTest.position.equals(1,1));
        playerTest.move(Direction.UP);
        Assert.assertEquals(true, playerTest.position.equals(0,1));
        playerTest.move(Direction.LEFT);
        Assert.assertEquals(true, playerTest.position.equals(0,0));
    }

    @Test
    public void testSetPosition()
    {
        playerTest.position = new Position(0,0);
        playerTest.setPosition(new Position(5,5));
        Assert.assertEquals(true, playerTest.position.equals(5,5));
        playerTest.setPosition(new Position(2,5));
        Assert.assertEquals(true, playerTest.position.equals(2,5));
        playerTest.setPosition(new Position(5,3));
        Assert.assertEquals(true, playerTest.position.equals(5,3));
    }
}