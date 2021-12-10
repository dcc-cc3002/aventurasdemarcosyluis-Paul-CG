package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;
import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Controllers.GameController;
import AventurasdeMarcosyLuis.Items.Consumable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TurnTest {

    private GameController controller;

    @BeforeEach
    public void setUp(){
        controller = new GameController();
        controller.createChest();
        controller.createRedMushroom();
        controller.createHoneySyrup();
        controller.initializeLists();
        controller.stockChest(3);

        controller.initializePlayers();
        controller.initializeEnemies(4);
        controller.formCurrentCharactersList();
    }

    /**
     * This is an important test that simulates a couple of turns using only the controller (and a sudden nuclear bomb
     * to finish it faster). All basic steps are tested, showing that, once we have the View implemented, the game
     * will run smoothly.
     */
    @Test
    public void turnTest() {
        /**
         * ... and Items...
         */
        LinkedList<Consumable> listOfItems = controller.getListItems();

        Playable character = controller.getCurrentCharacter(1);
        /**
        * Marcos decides to attack the first enemy
         */
        controller.playerJumpAttacks((Heroic) character, (Wicked) controller.getCurrentCharacters().get(2));
        /**
         * We change to the next character
         */
        character = controller.getCurrentCharacter(2);
        /**
         * Luis decides to gang upon the same dude
         */
        controller.playerJumpAttacks((Heroic) character, (Wicked) controller.getCurrentCharacters().get(2));
        /**
         * Enemies attack Marcos and Luis (2 and 2)
         */
        character = controller.getCurrentCharacter(3);
        controller.enemyAttack((Wicked) character, (Heroic) controller.getCurrentCharacters().get(0));
        character = controller.getCurrentCharacter(4);
        controller.enemyAttack((Wicked) character, (Heroic) controller.getCurrentCharacters().get(0));
        character = controller.getCurrentCharacter(5);
        controller.enemyAttack((Wicked) character, (Heroic) controller.getCurrentCharacters().get(1));
        character = controller.getCurrentCharacter(6);
        controller.enemyAttack((Wicked) character, (Heroic) controller.getCurrentCharacters().get(1));
        /**
         * Marcos uses an Item
         */
        character = controller.getCurrentCharacter(1);
        controller.useItem(character, listOfItems.get(1));
        /**
         * Luis Passes
         */
        character = controller.getCurrentCharacter(2);
        /**
         * Suddenly, an atomic bomb kills all enemies and finishes them off...
         */
        character = controller.getCurrentCharacter(3);
        character.setHP(0);
        character = controller.getCurrentCharacter(4);
        character.setHP(0);
        character = controller.getCurrentCharacter(5);
        character.setHP(0);
        character = controller.getCurrentCharacter(6);
        character.setHP(0);

        /**
         * We remove the dead from the turn
         */
        controller.removeDead();

        /**
         * We check if we won...
         */
        assertTrue(controller.didIWin());

        /**
         * We restock the chest and heal all players
         */
        controller.endBattle();
    }

}
