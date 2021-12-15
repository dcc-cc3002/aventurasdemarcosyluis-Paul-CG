package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Controllers.GameController;
import AventurasdeMarcosyLuis.Phases.Phase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhasesTest {
    private GameController controller;
    private Phase phase;

    @BeforeEach
    public void setUp(){
        controller = new GameController();
        phase = new Phase();
    }

    @Test
    public void phaseTest() {

    }


    public void transitionsTest(){

    }
}
