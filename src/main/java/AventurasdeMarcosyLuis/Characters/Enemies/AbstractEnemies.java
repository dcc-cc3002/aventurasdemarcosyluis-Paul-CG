package AventurasdeMarcosyLuis.Characters.Enemies;

import AventurasdeMarcosyLuis.Characters.AbstractCharacter;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;

/**
 * Creates an abstract Enemy, it fixes the K value for all enemies
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public abstract class AbstractEnemies extends AbstractCharacter implements Wicked {

    /**
     * Creates a new Enemy
     */
    public AbstractEnemies(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    @Override
    public void attack(Heroic o) {    }
}
