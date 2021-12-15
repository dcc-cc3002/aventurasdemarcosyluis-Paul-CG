package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;
import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidChoiceException;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * In this phase the player chooses an enemy and attacks him with the attack method picked on the previous phase
 */
public class AttackPhase extends Phase{
    int attackType;

    /**
     * The constructor uses a Scanner to take the users input, and the attack type from the previous phase. It also
     * allows transitions to WaitAttack and EndTurn phases.
     */
    public AttackPhase(int attackType){
        this.toLoad = false;
        this.toBattleStart = false;
        this.toWaitChoice = false;
        this.toWaitAttack = true;
        this.toWaitItem = false;
        this.toAttack = false;
        this.toItem = false;
        this.toEnemyAttack = false;
        this.toEndTurn = true;
        this.toEndBattle = false;
        this.toEndGame = false;

        reader = new Scanner(System.in);
        this.attackType = attackType;
    }

    @Override
    public String toString(){
        return "Attack Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException, InvalidChoiceException {
        String choice;
        Playable target = null;
        LinkedList<Playable> enemies = controller.getEnemies();
        int hpEnemy;
        int hpHero;

        // We check for the conditions to complete the transition
        if(toEndTurn && toWaitAttack &&
                !(toLoad && toBattleStart && toWaitChoice && toWaitItem && toAttack && toItem && toEnemyAttack && toEndBattle && toEndGame)){
            // We show all enemies and pick one to attack (or go back to the Attack Phase)
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
                    throw new InvalidChoiceException("Please choose a valid option");
                }

                // If the target is a valid enemy we resolve the attack
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
                    throw new InvalidChoiceException("Please choose a valid option");
                }
            }
        }else{
            throw new InvalidTransitionException("This transition is not allowed.");
        }

    }
}
