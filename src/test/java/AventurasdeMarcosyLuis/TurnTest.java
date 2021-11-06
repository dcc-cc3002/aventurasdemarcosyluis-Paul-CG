package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;
import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Controllers.GameController;
import AventurasdeMarcosyLuis.Items.Consumable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TurnTest {

    private GameController controller;
    private LinkedList<Playable> listOfCharacters;
    private LinkedList<Consumable> listOfItems;
    private LinkedList instructions;
    private LinkedList listAux;
    private HashMap<Consumable, Integer> map;
    private Playable character;
    private Playable enemy;

    @BeforeEach
    public void setUp(){
        controller = new GameController();
        listOfCharacters = new LinkedList();
        listOfItems = new LinkedList<>();
        listAux = new LinkedList();
        map = new HashMap();
    }

    /**
     * This is an important test that simulates a couple of turns using only the controller (and a sudden nuclear bomb
     * to finish it faster). All basic steps are tested, showing that, once we have the View implemented, the game
     * will run smoothly.
     */
    @Test
    public void TurnTest() {
        /**
         * We initialize all characters...
         */
        listOfCharacters = controller.initializePlayers();
        listAux = controller.initializeEnemies(4);
        listOfCharacters = controller.formCurrentCharactersList(listOfCharacters, listAux);
        /**
         * ... and Items...
         */
        controller.stockChest(3);
        listOfItems = controller.getListItems();

        character = controller.getCurrentCharacter(listOfCharacters,1);
        /**
        * Marcos decides to attack the first enemy
         */
        controller.playerJumpAttacks((Heroic) character, (Wicked) listOfCharacters.get(2));
        /**
         * We change to the next character
         */
        character = controller.getCurrentCharacter(listOfCharacters,2);
        /**
         * Luis decides to gang upon the same dude
         */
        controller.playerJumpAttacks((Heroic) character, (Wicked) listOfCharacters.get(2));
        /**
         * Enemies attack Marcos and Luis (2 and 2)
         */
        character = controller.getCurrentCharacter(listOfCharacters,3);
        controller.enemyAttack((Wicked) character, (Heroic) listOfCharacters.get(0));
        character = controller.getCurrentCharacter(listOfCharacters,4);
        controller.enemyAttack((Wicked) character, (Heroic) listOfCharacters.get(0));
        character = controller.getCurrentCharacter(listOfCharacters,5);
        controller.enemyAttack((Wicked) character, (Heroic) listOfCharacters.get(1));
        character = controller.getCurrentCharacter(listOfCharacters,6);
        controller.enemyAttack((Wicked) character, (Heroic) listOfCharacters.get(1));
        /**
         * Marcos uses an Item
         */
        character = controller.getCurrentCharacter(listOfCharacters,1);
        controller.useItem(character,listOfItems.get(1));
        /**
         * Luis Passes
         */
        character = controller.getCurrentCharacter(listOfCharacters,2);
        /**
         * Suddenly, an atomic bomb kills all enemies and finishes them off...
         */
        character = controller.getCurrentCharacter(listOfCharacters,3);
        character.setHP(0);
        character = controller.getCurrentCharacter(listOfCharacters,4);
        character.setHP(0);
        character = controller.getCurrentCharacter(listOfCharacters,5);
        character.setHP(0);
        character = controller.getCurrentCharacter(listOfCharacters,6);
        character.setHP(0);

        /**
         * We remove the dead from the turn
         */
        controller.removeDead(listOfCharacters);

        assertTrue(controller.didIWin(listOfCharacters));
    }

}
