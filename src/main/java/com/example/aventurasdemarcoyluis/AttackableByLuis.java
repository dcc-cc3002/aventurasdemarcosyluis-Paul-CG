package com.example.aventurasdemarcoyluis;

public interface AttackableByLuis {
    default void defendFromLuisJump(Playable player){}

    default void defendFromLuisHammer(Playable player){}
}
