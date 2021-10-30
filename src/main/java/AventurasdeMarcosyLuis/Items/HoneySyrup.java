package AventurasdeMarcosyLuis.Items;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * Creates a RedMushroom Item, it adds 3 FP to the character.
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public class HoneySyrup extends AbstractItems implements Consumable{

    public HoneySyrup(){
        super();
    }

    /**
     * The HoneySyrup activation adds 3 FP to the character.
     *
     * @param character it receives the character that uses the item
     */
    public void activate(Playable character){
        character.addFP(3);
    }
}
