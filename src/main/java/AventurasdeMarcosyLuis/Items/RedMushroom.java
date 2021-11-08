package AventurasdeMarcosyLuis.Items;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * Creates a RedMushroom Item, it adds 10% of HPMax to the character's HP.
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public class RedMushroom extends AbstractItems implements Consumable {

    /**
     * Constructor of the class RedMushroom
     */
    public RedMushroom(){
        super();
    }

    /**
     * The effect of RedMushRoom is to increase the HP of the character
     * by 10% of his HPMax. The result is cast to an int.
     *
     * @param character it receives the character that uses the item
     */
    public void activate(Playable character){
        character.addHP((int) (character.getHPMax()*0.1));
    }
}
