package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.Playable;

public interface AttackableByBoo {

    default void defendFromBoo(Playable enemy){}
}
