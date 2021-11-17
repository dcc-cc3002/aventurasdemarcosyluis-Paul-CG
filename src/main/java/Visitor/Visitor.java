package Visitor;

import AventurasdeMarcosyLuis.Characters.Enemies.Boo;
import AventurasdeMarcosyLuis.Characters.Enemies.Goomba;
import AventurasdeMarcosyLuis.Characters.Enemies.Spiny;
import AventurasdeMarcosyLuis.Characters.Heroes.Luis;
import AventurasdeMarcosyLuis.Characters.Heroes.Marcos;

public class Visitor {

    public void visitMarcos(Marcos marcos){}

    public void visitLuis(Luis luis){}

    public void visitGoomba(Goomba goomba){}

    public void visitSpiny(Spiny spiny){}

    public void visitBoo(Boo boo){}
}
