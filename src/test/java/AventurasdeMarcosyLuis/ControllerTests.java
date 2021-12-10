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
        listOfItems = new LinkedList<>();
        listAux = new LinkedList();
        map = new HashMap();

        controller.createChest();
        controller.createRedMushroom();
        controller.createHoneySyrup();
        controller.initializeLists();
        controller.stockChest(3);

        controller.initializePlayers();
        controller.initializeEnemies(4);
        controller.formCurrentCharactersList();
    }

    @Test
    public void mainCharactersCreationTest() {
        assertEquals(2, controller.getPlayers().size());
    }

    @Test
    public void enemiesCreationTest() {
        assertEquals(4, controller.getEnemies().size());
    }

    @Test
    public void createCharactersListTest(){
        assertEquals(6, controller.getCurrentCharacters().size());
    }

    @Test
    public void removeDeadCharacterTest() {
        character = controller.getCurrentCharacters().get(0);
        character.setHP(0);
        assertTrue(character.isKO());

        int size = controller.getCurrentCharacters().size();
        controller.removeDead();

        assertFalse(controller.getCurrentCharacters().contains(character));
        assertEquals(size-1, controller.getCurrentCharacters().size());
    }

    @Test
    public void playerJumpAttackTest() {
        character = controller.getPlayers().get(0);
        enemy = new Goomba(2, 10, 8, 50, 10);

        controller.playerJumpAttacks((Heroic) character, (Wicked) enemy);

        assertNotEquals(enemy.getHPMax(),enemy.getHP());
    }

    @Test
    public void playerHammerAttackTest() {
        controller.initializePlayers();

        character = controller.getPlayers().get(0);
        enemy = new Goomba(2, 10, 8, 50, 10);

        controller.playerHammerAttacks((Heroic) character, (Wicked) enemy);
        controller.playerHammerAttacks((Heroic) character, (Wicked) enemy);
        controller.playerHammerAttacks((Heroic) character, (Wicked) enemy);
        controller.playerHammerAttacks((Heroic) character, (Wicked) enemy);

        assertNotEquals(enemy.getHPMax(),enemy.getHP());
    }

    @Test
    public void enemyAttackTest() {
        character = controller.getPlayers().get(1);
        enemy = new Goomba(2, 10, 8, 50, 10);

        controller.enemyAttack((Wicked) enemy, (Heroic) character);

        assertNotEquals(character.getHPMax(),character.getHP());
    }

    @Test
    public void didIWinTest() {
        assertFalse(controller.didIWin());

        character = controller.getPlayers().get(0);
        character.setHP(0);
        assertTrue(character.isKO());
        controller.removeDead();
        assertFalse(controller.didIWin());

        enemy = controller.getEnemies().get(0);
        enemy.setHP(0);
        enemy = controller.getEnemies().get(1);
        enemy.setHP(0);
        enemy = controller.getEnemies().get(2);
        enemy.setHP(0);
        enemy = controller.getEnemies().get(3);
        enemy.setHP(0);

        controller.removeDead();

        assertTrue(controller.didIWin());
    }

    @Test
    public void didILoseTest() {
        assertFalse(controller.didILose());

        character = controller.getPlayers().get(0);
        character.setHP(0);
        assertTrue(character.isKO());

        character = controller.getPlayers().get(1);
        character.setHP(0);
        assertTrue(character.isKO());
        controller.removeDead();

        assertTrue(controller.didILose());
    }

    @Test
    public void getCurrentCharacterTest() {
        character = controller.getCurrentCharacter(2);
        assertEquals(controller.getCurrentCharacters().get(1), character);

        character = controller.getCurrentCharacter(9);
        assertEquals(controller.getCurrentCharacters().get(2), character);
    }

    @Test
    public void getNextCharacterTest() {
        character = controller.getNextCharacter(2);
        assertEquals(controller.getCurrentCharacters().get(2), character);

        character = controller.getNextCharacter(9);
        assertEquals(controller.getCurrentCharacters().get(3), character);
    }

    @Test
    public void chestCreationTest() {
        listOfItems = controller.getListItems();
        assertEquals(3, controller.getHowManyItems(listOfItems.get(0)));
        assertEquals(3, controller.getHowManyItems(listOfItems.get(1)));
    }

    @Test
    public void chestUsageTest() {
        character = controller.getPlayers().get(0);
        character.setHP(45);
        listOfItems = controller.getListItems();
        System.out.println(listOfItems.get(1));
        controller.useItem(character, listOfItems.get(1));
        assertEquals(50,character.getHP());
        assertEquals(2, controller.getHowManyItems(listOfItems.get(1)));
    }

    @Test
    public void endBattleTest() {
        listOfItems = controller.getListItems();

        controller.getCurrentCharacters().get(0).setHP(1);
        controller.getCurrentCharacters().get(1).setHP(1);
        assertEquals(1,controller.getCurrentCharacters().get(0).getHP());
        assertEquals(1,controller.getCurrentCharacters().get(1).getHP());
        assertEquals(1,controller.getCurrentCharacters().get(0).getLVL());
        assertEquals(1,controller.getCurrentCharacters().get(1).getLVL());

        controller.endBattle();

        assertEquals(controller.getCurrentCharacters().get(0).getHPMax(),controller.getCurrentCharacters().get(0).getHP());
        assertEquals(controller.getCurrentCharacters().get(1).getHPMax(),controller.getCurrentCharacters().get(1).getHP());
        assertEquals(2,controller.getCurrentCharacters().get(0).getLVL());
        assertEquals(2,controller.getCurrentCharacters().get(1).getLVL());
        assertEquals(4,controller.getHowManyItems(listOfItems.get(0)));
    }


}
