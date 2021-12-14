package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;
import AventurasdeMarcosyLuis.Characters.Playable;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * In this phase the player chooses an enemy and attacks him with the attack method picked on the previous phase
 */
public class AttackPhase extends Phase{
    int attackType;

    /**
     * The constructor uses a Scanner to take the users input, and the attack type from the previous phase
     */
    public AttackPhase(int attackType){
        reader = new Scanner(System.in);
        this.attackType = attackType;
    }

    @Override
    public String toString(){
        return "Attack Phase";
    }

    @Override
    public void toNextPhase(){
        String choice;
        Playable target = null;
        LinkedList<Playable> enemies = controller.getEnemies();
        int hpEnemy;
        int hpHero;

        while(!controller.choiceIsEnemy(target)){
            int enemyIndex = 1;
            for(Playable enemy : enemies) {
                System.out.println(enemyIndex + "- " + enemy.toString());
                enemyIndex += 1;
            }
            System.out.println(enemyIndex + "- Back");
            System.out.println("(Pick a number)");
            choice = reader.nextLine();


            try {
                if(Integer.parseInt(choice) == enemyIndex) {
                    changePhase(new WaitAttackPhase());
                    break;
                }
                target = enemies.get(Integer.parseInt(choice)-1);
            } catch (NumberFormatException e){
                System.out.println("Please choose a valid option.");
                continue;
            }

            if (controller.choiceIsEnemy(target)){
                hpEnemy = target.getHP();
                hpHero = controller.getCurrentCharacter().getHP();

                if (attackType == 1){
                    controller.playerJumpAttacks((Heroic) controller.getCurrentCharacter(), (Wicked) target);
                    hpEnemy -= target.getHP();
                    hpHero -= controller.getCurrentCharacter().getHP();
                    if (hpHero != 0) {
                        System.out.println("You hurt yourself with " + hpHero + " points of damage!!");
                    } else {
                        System.out.println("You did " + hpEnemy + " points of damage to " + target.toString());
                    }
                } else if (attackType == 2) {
                    controller.playerHammerAttacks((Heroic) controller.getCurrentCharacter(), (Wicked) target);
                    hpEnemy -= target.getHP();
                    if (hpEnemy == 0) {
                        System.out.println("MISS!");
                    } else {
                        System.out.println("You did " + hpEnemy + " points of damage to " + target.toString());
                    }
                }
                changePhase(new EndTurnPhase());
            } else {
                System.out.println("Please choose a valid option.");
            }
        }
    }
}
