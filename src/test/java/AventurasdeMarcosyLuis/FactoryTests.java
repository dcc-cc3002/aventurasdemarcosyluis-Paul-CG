package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Factories.WickedFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTests {

    WickedFactory factory;
    Playable enemy;

    @BeforeEach
    public void setUp(){
        factory = new WickedFactory(2, 10, 8, 50);
    }

    @Test
    public void createEnemiesTest() {
        enemy = factory.create();
        assertTrue(enemy instanceof Wicked); // me dieron permiso de usar instanceof en los test! :D
        assertEquals(10, enemy.getATK());
        assertEquals(8, enemy.getDEF());
        assertEquals(50, enemy.getHPMax());
        assertEquals(2, enemy.getLVL());
    }

    @Test
    public void changeStatsTest() {
        factory.setATK(100);
        factory.setDEF(100);
        factory.setHPMax(100);
        factory.setLVL(10);
        enemy = factory.create();

        assertEquals(100, enemy.getATK());
        assertEquals(100, enemy.getDEF());
        assertEquals(100, enemy.getHPMax());
        assertEquals(10, enemy.getLVL());
    }
}
