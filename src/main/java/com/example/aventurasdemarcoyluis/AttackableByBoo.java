package com.example.aventurasdemarcoyluis;

public interface AttackableByBoo {

    default void defendFromBoo(Playable enemy){}
}
