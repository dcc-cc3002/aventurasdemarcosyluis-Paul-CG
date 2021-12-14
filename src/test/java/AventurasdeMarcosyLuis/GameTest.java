package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Controllers.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private GameController controller;

    @BeforeEach
    public void setUp(){
        controller = new GameController();
    }

    /**
     * This test replaces the old turnTest with a more thorough game like experience. The user need to use inputs to
     * play each step.
     */
    @Test
    public void gameTest() {
        controller.tryNextPhase();
        controller.tryNextPhase();
        controller.tryNextPhase();



    }

}
