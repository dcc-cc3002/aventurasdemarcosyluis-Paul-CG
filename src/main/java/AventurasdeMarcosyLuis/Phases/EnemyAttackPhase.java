package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

import java.util.Random;

/**
 * This Phase handles the attacks made by enemies.
 */
public class EnemyAttackPhase extends Phase{
    /**
     * It allows transitions only to EndTurn phase.
     */
    public EnemyAttackPhase(){
        this.toLoad = false;
        this.toBattleStart = false;
        this.toWaitChoice = false;
        this.toWaitAttack = false;
        this.toWaitItem = false;
        this.toAttack = false;
        this.toItem = false;
        this.toEnemyAttack = false;
        this.toEndTurn = true;
        this.toEndBattle = false;
        this.toEndGame = false;
    }

    @Override
    public String toString(){
        return "Enemy Attack Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException {
        Random rand = new Random();
        boolean hit = false;
        int hpHero;

        // We check for the conditions to complete the transition
        if(toEndTurn &&
                !(toLoad && toBattleStart && toWaitAttack && toWaitItem && toAttack && toItem && toEnemyAttack && toWaitChoice && toEndBattle && toEndGame)){

            System.out.println(controller.getCurrentCharacter() + " is attacking!");

            // The enemy attacks a player randomly (we consider only the heroes that are still alive)
            while(!hit){
                int target = rand.nextInt(controller.getAlivePlayers().size());
                hpHero = controller.getAlivePlayers().get(target).getHP();
                try {
                    controller.enemyAttack((Wicked) controller.getCurrentCharacter(), (Heroic) controller.getAlivePlayers().get(target));
                    hpHero -= controller.getAlivePlayers().get(target).getHP();
                    hit = true;
                    System.out.println(controller.getAlivePlayers().get(target) + " got " + hpHero + " points of damage!");
                    changePhase(new EndTurnPhase());
                } catch (NumberFormatException e) {
                    continue; // Ignore this warning, this piece of code is importante
                }
            }
        }else{
            throw new InvalidTransitionException("This transition is not allowed.");
        }

    }
}
