package es.urjccode.mastercloudapps.adcs.draughts.models;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    protected Game game;
    protected Game expectedGame;

    protected void setGame(Color color, String... strings) {
        this.game = new GameBuilder().color(color).rows(strings).build();
    }

    protected void setExpectedGame(Color color, String... strings) {
        this.expectedGame = new GameBuilder().color(color).rows(strings).build();
    }

    private void expectMove(Coordinate origin, Coordinate destiny){
        assertNull(this.game.move(origin, destiny));
        assertEquals(this.game, this.expectedGame);
    }

    @Test
    public void testRemovePieceAfterNotEatingWithWhitePieces(){
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "    n   ",
            "     b  ",
            "        ",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "    n   ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        this.expectMove(
            new Coordinate(4, 5),
            new Coordinate(5, 6)
        );
    }

    @Test
    public void testRemovePieceAfterNotEatingWithBlackPieces(){
        this.setGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "    n   ",
            "     b  ",
            "        ");
        this.setExpectedGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "     b  ",
            "        ");
        this.expectMove(
            new Coordinate(6, 5),
            new Coordinate(5, 6)
        );
    }

    @Test
    public void testEatingAndNotRemovingBlackPieceWithWhitePieces(){
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "   n    ",
            "    b   ",
            "        ",
            "        ",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "  b     ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        this.expectMove(
            new Coordinate(4, 5),
            new Coordinate(2, 3)
        );
    }

    @Test
    public void testEatingAndNotRemovingWhitePieceWithBlackPieces(){
        this.setGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "  n     ",
            "   b    ",
            "        ",
            "        ",
            "        ");
        this.setExpectedGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "    n   ",
            "        ",
            "        ");
        this.expectMove(
            new Coordinate(3, 2),
            new Coordinate(5, 4)
        );
    }


}
