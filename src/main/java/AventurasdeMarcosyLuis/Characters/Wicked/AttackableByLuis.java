package AventurasdeMarcosyLuis.Characters.Wicked;

import AventurasdeMarcosyLuis.Characters.Playable;

public interface AttackableByLuis {
    default void defendFromLuisJump(Playable player){}

    default void defendFromLuisHammer(Playable player){}
}
