package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Characters.Enemies.Boo;
import AventurasdeMarcosyLuis.Characters.Enemies.Goomba;
import AventurasdeMarcosyLuis.Characters.Enemies.Spiny;
import AventurasdeMarcosyLuis.Characters.Heroes.Luis;
import AventurasdeMarcosyLuis.Characters.Heroes.Marcos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BattleTests {

    private Marcos testMarcos;
    private Luis testLuis;
    private Spiny testSpiny;
    private Goomba testGoomba;
    private Boo testBoo;

    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(2, 10, 8, 50, 10);
        testLuis = new Luis(2, 10, 8, 50, 10);
        testSpiny = new Spiny(2, 10, 8, 50, 10);
        testGoomba= new Goomba(2, 10, 8, 50, 10);
        testBoo = new Boo(2, 10, 8, 50, 10);
    }

    @Test
    public void Test(){

    }

}
