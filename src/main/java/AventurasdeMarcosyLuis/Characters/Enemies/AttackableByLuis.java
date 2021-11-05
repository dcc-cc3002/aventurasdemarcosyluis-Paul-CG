package AventurasdeMarcosyLuis.Characters.Enemies;

import AventurasdeMarcosyLuis.Characters.Playable;

public interface AttackableByLuis {
    default void defendFromLuisJump(Playable player){}

    default void defendFromLuisHammer(Playable player){}
}
