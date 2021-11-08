package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Characters.Enemies.Goomba;
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

public class ControllerTests {

    private GameController controller;
    private LinkedList<Playable> listOfCharacters;
    private LinkedList<Consumable> listOfItems;
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

    @Test
    public void mainCharactersCreationTest() {
        listOfCharacters = controller.initializePlayers();
        assertEquals(2, listOfCharacters.size());
    }

    @Test
    public void enemiesCreationTest() {
        listOfCharacters = controller.initializeEnemies(4);
        assertEquals(4, listOfCharacters.size());
    }

    @Test
    public void createCharactersListTest(){
        listOfCharacters = controller.initializePlayers();
        listAux = controller.initializeEnemies(4);
        listOfCharacters = controller.formCurrentCharactersList(listOfCharacters, listAux);
        assertEquals(6, listOfCharacters.size());
    }

    @Test
    public void getAliveCharactersTest() {
        listOfCharacters = controller.initializePlayers();
        listOfCharacters = controller.formCurrentCharactersList(listOfCharacters,listAux);
        listAux = controller.getCurrentCharacters();
        assertEquals(listOfCharacters, listAux);
    }

    @Test
    public void removeDeadCharacterTest() {
        listOfCharacters = controller.initializePlayers();
        listAux = controller.initializeEnemies(4);
        listOfCharacters = controller.formCurrentCharactersList(listOfCharacters, listAux);
        character = listOfCharacters.get(0);
        character.setHP(0);
        assertTrue(character.isKO());

        int size = listOfCharacters.size();
        controller.removeDead(listOfCharacters);
        listOfCharacters = controller.getCurrentCharacters();

        assertFalse(listOfCharacters.contains(character));
        assertEquals(size-1, listOfCharacters.size());
    }

    @Test
    public void playerJumpAttackTest() {
        listOfCharacters = controller.initializePlayers();

        character = listOfCharacters.get(0);
        enemy = new Goomba(2, 10, 8, 50, 10);

        controller.playerJumpAttacks((Heroic) character, (Wicked) enemy);

        assertNotEquals(enemy.getHPMax(),enemy.getHP());
    }

    @Test
    public void playerHammerAttackTest() {
        listOfCharacters = controller.initializePlayers();

        character = listOfCharacters.get(0);
        enemy = new Goomba(2, 10, 8, 50, 10);

        controller.playerHammerAttacks((Heroic) character, (Wicked) enemy);
        controller.playerHammerAttacks((Heroic) character, (Wicked) enemy);
        controller.playerHammerAttacks((Heroic) character, (Wicked) enemy);
        controller.playerHammerAttacks((Heroic) character, (Wicked) enemy);

        assertNotEquals(enemy.getHPMax(),enemy.getHP());
    }

    @Test
    public void enemyAttackTest() {
        listOfCharacters = controller.initializePlayers();

        character = listOfCharacters.get(1);
        enemy = new Goomba(2, 10, 8, 50, 10);

        controller.enemyAttack((Wicked) enemy, (Heroic) character);

        assertNotEquals(character.getHPMax(),character.getHP());
    }

    @Test
    public void didIWinTest() {
        listOfCharacters = controller.initializePlayers();
        assertTrue(controller.didIWin(listOfCharacters));

        character = listOfCharacters.get(0);
        character.setHP(0);
        assertTrue(character.isKO());
        controller.removeDead(listOfCharacters);
        assertTrue(controller.didIWin(listOfCharacters));

        listAux = controller.initializeEnemies(4);
        listOfCharacters = controller.formCurrentCharactersList(listOfCharacters, listAux);
        assertFalse(controller.didIWin(listOfCharacters));
    }

    @Test
    public void didILoseTest() {
        listOfCharacters = controller.initializePlayers();
        assertFalse(controller.didILose(listOfCharacters));
        listAux = controller.initializeEnemies(3);
        listOfCharacters = controller.formCurrentCharactersList(listOfCharacters, listAux);
        assertFalse(controller.didILose(listOfCharacters));

        character = listOfCharacters.get(0);
        character.setHP(0);
        assertTrue(character.isKO());
        controller.removeDead(listOfCharacters);

        character = listOfCharacters.get(0);
        character.setHP(0);
        assertTrue(character.isKO());
        controller.removeDead(listOfCharacters);

        assertTrue(controller.didILose(listOfCharacters));
    }

    @Test
    public void getCurrentCharacterTest() {
        listOfCharacters = controller.initializePlayers();
        listAux = controller.initializeEnemies(2);
        listOfCharacters = controller.formCurrentCharactersList(listOfCharacters, listAux);

        character = controller.getCurrentCharacter(listOfCharacters,2);
        assertEquals(listOfCharacters.get(1), character);

        character = controller.getCurrentCharacter(listOfCharacters,7);
        assertEquals(listOfCharacters.get(2), character);
    }

    @Test
    public void getNextCharacterTest() {
        listOfCharacters = controller.initializePlayers();
        listAux = controller.initializeEnemies(2);
        listOfCharacters = controller.formCurrentCharactersList(listOfCharacters, listAux);

        character = controller.getNextCharacter(listOfCharacters,2);
        assertEquals(listOfCharacters.get(2), character);

        character = controller.getNextCharacter(listOfCharacters,7);
        assertEquals(listOfCharacters.get(3), character);
    }

    @Test
    public void chestCreationTest() {
        controller.stockChest(3);
        listOfItems = controller.getListItems();
        System.out.println(listOfItems);
        assertEquals(3, controller.getHowManyItems(listOfItems.get(0)));
        assertEquals(3, controller.getHowManyItems(listOfItems.get(1)));
    }

    @Test
    public void chestUsageTest() {
        controller.stockChest(3);
        listOfCharacters = controller.initializePlayers();
        character = listOfCharacters.get(0);
        character.setHP(45);
        listOfItems = controller.getListItems();
        controller.useItem(character, listOfItems.get(1));
        assertEquals(50,character.getHP());
        assertEquals(2, controller.getHowManyItems(listOfItems.get(1)));
    }

    @Test
    public void endBattleTest() {
        listOfCharacters = controller.initializePlayers();
        controller.stockChest(3);
        listOfItems = controller.getListItems();

        listOfCharacters.get(0).setHP(1);
        listOfCharacters.get(1).setHP(1);
        assertEquals(1,listOfCharacters.get(0).getHP());
        assertEquals(1,listOfCharacters.get(1).getHP());
        assertEquals(1,listOfCharacters.get(0).getLVL());
        assertEquals(1,listOfCharacters.get(1).getLVL());

        controller.endBattle(listOfCharacters);

        assertEquals(listOfCharacters.get(0).getHPMax(),listOfCharacters.get(0).getHP());
        assertEquals(listOfCharacters.get(1).getHPMax(),listOfCharacters.get(1).getHP());
        assertEquals(2,listOfCharacters.get(0).getLVL());
        assertEquals(2,listOfCharacters.get(1).getLVL());
        assertEquals(4,controller.getHowManyItems(listOfItems.get(0)));
    }


}
