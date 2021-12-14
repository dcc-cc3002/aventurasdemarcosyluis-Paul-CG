package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;

import java.util.Random;

public class EnemyAttackPhase extends Phase{

    @Override
    public String toString(){
        return "Enemy Attack Phase";
    }

    @Override
    public void toNextPhase() {
        Random rand = new Random();
        boolean hit = false;
        int hpHero;

        System.out.println(controller.getCurrentCharacter() + " is attacking!");

        while(!hit){
            int target = rand.nextInt(controller.getAlivePlayers().size());
            hpHero = controller.getAlivePlayers().get(target).getHP();
            try {
                controller.enemyAttack((Wicked) controller.getCurrentCharacter(), (Heroic) controller.getAlivePlayers().get(target));
                hpHero -= controller.getAlivePlayers().get(target).getHP();
                hit = true;
                if (hpHero == 0) {
                    System.out.println("Boo can't attack!!");
                }
                System.out.println(controller.getAlivePlayers().get(target) + " got " + hpHero + " points of damage!");
                changePhase(new EndTurnPhase());
            } catch (NumberFormatException e) {
                continue;
            }
        }
    }
}
