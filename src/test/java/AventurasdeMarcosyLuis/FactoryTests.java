package AventurasdeMarcosyLuis;


import AventurasdeMarcosyLuis.Factories.WickedFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FactoryTests {

    @BeforeEach
    public void setUp(){
        WickedFactory factory = new WickedFactory(2, 10, 8, 50);
    }

    @Test
    public void Test() {

    }
}
