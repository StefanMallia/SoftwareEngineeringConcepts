package um.edu.mt.cps2002;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;


public class GameTest
{
    Game gameTest;

    @Before
    public void setUp()
    {
        gameTest = new Game();
    }
    @Test
    public void testSetNumPlayers()
    {
        Assert.assertEquals(false, gameTest.setNumPlayers(1));
        Assert.assertEquals(true, gameTest.setNumPlayers(2));
        Assert.assertEquals(true, gameTest.setNumPlayers(5));
        Assert.assertEquals(true, gameTest.setNumPlayers(8));
        Assert.assertEquals(8, gameTest.players.length);
        Assert.assertEquals(false, gameTest.setNumPlayers(9));

    }


    @Test
    public void testGenerateHTMLFiles()
    {
        gameTest.setNumPlayers(2);
        gameTest.players = new Player[2];
        gameTest.players[0] = new Player();
        gameTest.players[0].setPosition(new Position(0,0));
        gameTest.players[1] = new Player();
        gameTest.players[1].setPosition(new Position(5,5));

        gameTest.map = new Map();
        gameTest.map.setMapSize(6, 2);


        gameTest.players[0].mapKnowledge = new Colour[][]{
                {Colour.GREEN, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
        };
        gameTest.players[1].mapKnowledge = new Colour[][]{
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREEN},
        };
        gameTest.generateHTMLFiles("./src/test/resources/um/edu/mt/cps2002/");

        try {
            //https://stackoverflow.com/questions/3891375/how-to-read-a-text-file-resource-into-java-unit-test
            String player1Map = IOUtils.toString(this.getClass().getResourceAsStream("player1Map.html"), "UTF-8");
            player1Map = player1Map.substring(0, player1Map.length()-1); //for some reason newline is appended by IOUtils
            Assert.assertTrue(player1Map.equals("<table>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"green\" align=\"center\"><font size=\"5\">('_')</font><\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>  \n" +
                    "</table>"));

            String player2Map = IOUtils.toString(this.getClass().getResourceAsStream("player2Map.html"), "UTF-8");
            player2Map = player2Map.substring(0, player2Map.length()-1);
            Assert.assertTrue(player2Map.equals("<table>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"green\" align=\"center\"><font size=\"5\">('_')</font></td>\n" +
                    "  </tr>  \n" +
                    "</table>"));
        }
        catch(IOException e) { e.printStackTrace();}


    }
}
