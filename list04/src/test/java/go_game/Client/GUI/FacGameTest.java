package go_game.Client.GUI;

import go_game.Client.Factory.GameFactory;
import go_game.Client.Factory.GameI;
import go_game.Client.Game;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

public class FacGameTest {
    PrintWriter ou;
    @Test
    void createGame9() {
        GameBoardI gameI = GameBoardFactory.getGamefactory(9,ou);
        Assert.assertTrue(gameI instanceof GameBoard);
    }

    @Test
    void createGame19() {
        GameBoardI gameI = GameBoardFactory.getGamefactory(13,ou);
        Assert.assertTrue(gameI instanceof GameBoard13);
    }

    @Test
    void createGame13() {
        GameBoardI gameI = GameBoardFactory.getGamefactory(19,ou);
        Assert.assertTrue(gameI instanceof GameBoard19);
    }
}
