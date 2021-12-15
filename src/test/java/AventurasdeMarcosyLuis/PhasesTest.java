package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Controllers.GameController;
import AventurasdeMarcosyLuis.Phases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class PhasesTest {
    private GameController controller;
    private Phase phase;

    @BeforeEach
    public void setUp(){
        controller = new GameController();
        phase = new Phase();
        phase.setController(controller);

    }

    @Test
    public void phaseTest() {

    }

    @Test
    public void transitionsTest(){
        assertEquals("Load Phase", controller.getPhaseName());
        controller.tryNextPhase();

        assertEquals("Battle Start Phase", controller.getPhaseName());
        controller.tryNextPhase();

        assertEquals("Wait Choice Phase", controller.getPhaseName());

        phase.changePhase(new WaitAttackPhase());
        assertEquals("Wait Attack Phase", controller.getPhaseName());

        phase.changePhase(new AttackPhase(1));
        assertEquals("Attack Phase", controller.getPhaseName());

        phase.changePhase(new WaitItemPhase());
        assertEquals("Wait Item Phase", controller.getPhaseName());

        phase.changePhase(new ItemPhase(0));
        assertEquals("Item Phase", controller.getPhaseName());

        phase.changePhase(new EnemyAttackPhase());
        assertEquals("Enemy Attack Phase", controller.getPhaseName());

        phase.changePhase(new EndTurnPhase());
        assertEquals("End Turn Phase", controller.getPhaseName());

        phase.changePhase(new EndBattlePhase());
        assertEquals("End Battle Phase", controller.getPhaseName());

        phase.changePhase(new EndGamePhase(true));
        assertEquals("End Game Phase", controller.getPhaseName());
    }
}
