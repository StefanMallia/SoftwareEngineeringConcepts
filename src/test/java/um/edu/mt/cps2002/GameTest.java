package um.edu.mt.cps2002;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;



public class GameTest
{


    @Before
    public void setUp()
    {
        Game.map = new Map();

        Game.setNumPlayers(2);
        Game.map.setMapSize(6,2);
        Game.map.generate();
        Game.players = new Player[2];
        Game.players[0] = new Player(Game.map.tileColours);
        Game.players[1] = new Player(Game.map.tileColours);

    }
    @Test
    public void testSetNumPlayers()
    {
        Assert.assertEquals(false, Game.setNumPlayers(1));
        Assert.assertEquals(true, Game.setNumPlayers(2));
        Assert.assertEquals(true, Game.setNumPlayers(5));
        Assert.assertEquals(true, Game.setNumPlayers(8));
        Assert.assertEquals(8, Game.players.length);
        Assert.assertEquals(false, Game.setNumPlayers(9));

    }
    @Test
    public void testWinner()
    {
        Game.map.tileColours[Game.players[0].initialPosition.row][Game.players[0].initialPosition.column] = Colour.YELLOW;
        Assert.assertEquals(1, Game.Winner());

        Game.map.tileColours[Game.players[0].initialPosition.row][Game.players[0].initialPosition.column] = Colour.GREEN;
        Game.map.tileColours[Game.players[1].initialPosition.row][Game.players[1].initialPosition.column] = Colour.YELLOW;
        Assert.assertEquals(2, Game.Winner());
    }

    @Test
    public void testGenerateHTMLFiles()
    {

        Game.players[0] = new Player(Game.map.tileColours);
        Game.players[0].setPosition(new Position(0,0), Game.map);
        Game.players[1] = new Player(Game.map.tileColours);
        Game.players[1].setPosition(new Position(5,5), Game.map);





        Game.players[0].mapKnowledge = new Colour[][]{
                {Colour.GREEN, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
        };
        Game.players[1].mapKnowledge = new Colour[][]{
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREEN},
        };
        Game.generateHTMLFiles(Game.players[0], 0, "./src/test/resources/um/edu/mt/cps2002/");
        Game.generateHTMLFiles(Game.players[1], 1, "./src/test/resources/um/edu/mt/cps2002/");

        try {
            //https://stackoverflow.com/questions/3891375/how-to-read-a-text-file-resource-into-java-unit-test
            String player0Map = IOUtils.toString(this.getClass().getResourceAsStream("player0Map.html"), "UTF-8");
            //player0Map = player0Map.substring(0, player0Map.length()-1); //for some reason newline is appended by IOUtils
            Assert.assertTrue(player0Map.equals("<table>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"green\" align=\"center\"><font size=\"5\">('_')</font></td>\n" +
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
                    "  </tr>\n" +
                    "</table>"));

            String player1Map = IOUtils.toString(this.getClass().getResourceAsStream("player1Map.html"), "UTF-8");
            //player1Map = player1Map.substring(0, player1Map.length()-1);
            Assert.assertTrue(player1Map.equals("<table>\n" +
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
                    "  </tr>\n" +
                    "</table>"));
        }
        catch(IOException e) { e.printStackTrace();}


    }
}
