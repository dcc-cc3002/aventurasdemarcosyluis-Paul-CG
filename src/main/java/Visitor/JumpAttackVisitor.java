package Visitor;

import AventurasdeMarcosyLuis.Characters.Enemies.Boo;
import AventurasdeMarcosyLuis.Characters.Enemies.Goomba;
import AventurasdeMarcosyLuis.Characters.Enemies.Spiny;
import AventurasdeMarcosyLuis.Characters.Heroes.Luis;
import AventurasdeMarcosyLuis.Characters.Heroes.Marcos;
import AventurasdeMarcosyLuis.Characters.Playable;

public class JumpAttackVisitor extends Visitor {

    Playable character;

    public JumpAttackVisitor(Playable character){
        this.character = character;
    }

    @Override
    public void visitMarcos(Marcos marcos){}

    @Override
    public void visitLuis(Luis luis){

    }

    @Override
    public void visitGoomba(Goomba goomba){}

    @Override
    public void visitSpiny(Spiny spiny){}

    @Override
    public void visitBoo(Boo boo){}
}
