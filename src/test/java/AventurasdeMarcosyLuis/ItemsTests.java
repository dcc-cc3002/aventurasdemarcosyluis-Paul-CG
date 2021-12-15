package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Items.Chest;
import AventurasdeMarcosyLuis.Items.RedMushroom;
import AventurasdeMarcosyLuis.Items.HoneySyrup;
import AventurasdeMarcosyLuis.Characters.Heroes.Marcos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public class ItemsTests {

    private Marcos testMarcos;
    private Chest testChest;
    private RedMushroom testRedMushroom;
    private HoneySyrup testHoneySyrup;
    private HashMap chest;

    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(2, 10, 8, 50, 10);
        testChest = new Chest();
        testRedMushroom = new RedMushroom();
        testHoneySyrup = new HoneySyrup();
    }

    @Test
    public void hasItemTest(){
        assertFalse(testChest.hasItem(testRedMushroom));
        assertFalse(testChest.hasItem(testHoneySyrup));
    }

    @Test
    public void addItemTest(){
        testChest.addItem(testRedMushroom);
        testChest.addItem(testHoneySyrup);
        assertTrue(testChest.hasItem(testRedMushroom));
        assertTrue(testChest.hasItem(testHoneySyrup));
    }

    @Test
    public void getItemsTest(){
        testChest.addItem(testRedMushroom);
        testChest.addItem(testHoneySyrup);
        chest = testChest.getItems();
        assertEquals(1,chest.get(testRedMushroom));
        assertEquals(1,chest.get(testHoneySyrup));
    }

    @Test
    public void addManyItemsTest(){
        testChest.addItem(testRedMushroom);
        testChest.addItem(testRedMushroom);
        testChest.useItem(testMarcos, testRedMushroom);
        assertTrue(testChest.hasItem(testRedMushroom));
        testChest.useItem(testMarcos, testRedMushroom);
        assertFalse(testChest.hasItem(testRedMushroom));
    }


    @Test
    public void removeItemTest(){
        testChest.addItem(testRedMushroom);
        assertTrue(testChest.hasItem(testRedMushroom));
        testChest.removeItem(testRedMushroom);
        assertFalse(testChest.hasItem(testRedMushroom));
    }

    @Test
    public void useItemTest(){
        testChest.addItem(testRedMushroom);
        testChest.addItem(testHoneySyrup);
        testChest.useItem(testMarcos, testRedMushroom);
        testChest.useItem(testMarcos, testHoneySyrup);
        assertFalse(testChest.hasItem(testRedMushroom));
        assertFalse(testChest.hasItem(testHoneySyrup));
    }

    @Test
    public void howManyItemsTest(){
        testChest.addItem(testRedMushroom);
        testChest.addItem(testRedMushroom);
        assertEquals(2,testChest.howManyItems(testRedMushroom));
    }

    @Test
    public void effectRedMushRoomTest(){
        testMarcos.setHP((int) (testMarcos.getHPMax()*0.9));
        testChest.addItem(testRedMushroom);
        testChest.useItem(testMarcos, testRedMushroom);
        assertEquals(testMarcos.getHPMax(),testMarcos.getHP());
    }

    @Test
    public void effectHoneySyrupTest(){
        testMarcos.setFP(0);
        testChest.addItem(testHoneySyrup);
        testChest.useItem(testMarcos, testHoneySyrup);
        assertEquals(3,testMarcos.getFP());
    }

    @Test
    public void toStringTest(){
        assertEquals("Honey Syrup", testHoneySyrup.toString());
        assertEquals("Red Mushroom", testRedMushroom.toString());
    }

}
