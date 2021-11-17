package AventurasdeMarcosyLuis.Controllers;

import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;
import AventurasdeMarcosyLuis.Characters.Heroes.Luis;
import AventurasdeMarcosyLuis.Characters.Heroes.Marcos;
import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Factories.WickedFactory;
import AventurasdeMarcosyLuis.Items.Chest;
import AventurasdeMarcosyLuis.Items.Consumable;
import AventurasdeMarcosyLuis.Items.HoneySyrup;
import AventurasdeMarcosyLuis.Items.RedMushroom;
import Visitor.JumpAttackVisitor;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * GameController is the Controller of the game. Its function is to separate the View from the Model, using a
 * Mediators like Pattern.
 *
 *  @author Paul Chauveau Gerber
 *  @version 1.0
 *  @since 2021-11-05
 */
public class GameController {

    private final LinkedList<Playable> players = new LinkedList<>();
    private final LinkedList<Playable> enemies = new LinkedList<>();
    private LinkedList<Playable> currentCharacters = new LinkedList<>();
    private Marcos marcos;
    private Luis luis;
    private final Chest chest = new Chest();
    private final RedMushroom redMushroom = new RedMushroom();
    private final HoneySyrup honeySyrup = new HoneySyrup();
    WickedFactory wickedFactory = new WickedFactory(1, 30, 8, 50);

    /**
     * It creates the mains characters of the game, Marcos and Luis
     * @return a linked list with marcos and luis
     */
    public LinkedList<Playable> initializePlayers() {
        marcos = new Marcos(1, 10, 8, 50, 20);
        luis = new Luis(1, 10, 8, 50, 20);
        players.add(marcos);
        players.add(luis);
        return players;
    }

    /**
     * InitializeEnemies creates the opponents for Marcos and Luis at each stage.
     * @param numberOfEnemies number of enemies to be created
     * @return all enemies in a linked list
     */
    public LinkedList<Playable> initializeEnemies(int numberOfEnemies) {
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(wickedFactory.create());
        }
        return enemies;
    }

    /**
     * Takes players and enemies and creates a single list with all of them. It is used to keep track of the characters
     * during a stage.
     * @param players list of main characters
     * @param enemies list of enemies
     * @return list with all characters
     */
    public LinkedList<Playable> formCurrentCharactersList(LinkedList<Playable> players, LinkedList<Playable> enemies){
        players.addAll(enemies);
        currentCharacters = players;
        return currentCharacters;
    }

    /**
     * Returns the list of current characters active in the stage.
     * @return currentCharacters
     */
    public LinkedList<Playable> getCurrentCharacters(){
        return currentCharacters;
    }

    /**
     * Removes the dead characters from the currentCharacters list
     * @param currentCharacters list of active characters
     */
    public void removeDead(LinkedList<Playable> currentCharacters) {
        int list_length = currentCharacters.size();
        int i = 0;
        while (i < list_length){
            Playable character = currentCharacters.get(i);
            if (character.isKO()){
                currentCharacters.remove(character);
                i--;
                list_length--;
            }
            i++;
        }
    }

    /**
     * Gets the current character that is active this step.
     * @param currentCharacters list of current characters
     * @param turn indicates the number of actions since the beginning of a turn
     * @return current character
     */
    public Playable getCurrentCharacter(LinkedList<Playable> currentCharacters, int turn) {
        int index = (turn - 1) % currentCharacters.size();
        return currentCharacters.get(index);
    }

    /**
     * Gets the next character that will be active next step.
     * @param currentCharacters list of current characters
     * @param turn indicates the number of actions since the beginning of a turn
     * @return next current character
     */
    public Playable getNextCharacter(LinkedList<Playable> currentCharacters, int turn){
        return getCurrentCharacter(currentCharacters, turn+1);
    }

    /**
     * Checks if the conditions for winning have been fulfilled.
     * @param currentCharacters list of current characters
     * @return true if the players won, false otherwise
     */
    public boolean didIWin(LinkedList<Playable> currentCharacters){
        if (currentCharacters.size() == 2 && (currentCharacters.contains(marcos) && currentCharacters.contains(luis))){
            return true;
        } else return currentCharacters.size() == 1 && (currentCharacters.contains(marcos) || currentCharacters.contains(luis));
    }

    /**
     * Checks if the conditions for losing have been fulfilled.
     * @param currentCharacters list of current characters
     * @return true if the players lose, false otherwise
     */
    public boolean didILose(LinkedList<Playable> currentCharacters){
        return !currentCharacters.contains(marcos) && !currentCharacters.contains(luis);
    }

    /**
     * Applies the modifications (lvl up, healing and more items) at the end of each turn.
     * @param players list of active players
     */
    public void endBattle(LinkedList<Playable> players) {
        for (Playable player : players) {
            player.lvlUp();
            player.setHP(player.getHPMax());
            player.setFP(player.getFPMax());
        }
        stockChest(1);
    }

    /**
     * Adds the same amount of RedMushroom and HoneySyrup to the chest.
     * @param amount of items to be restocked
     */
    public void stockChest(int amount) {
        for (int i = 0; i < amount; i++){
            chest.addItem(redMushroom);
            chest.addItem(honeySyrup);
        }
    }

    /**
     * Allows to use an item, if possible, from the chest.
     * @param player that would use the item
     * @param item to be used
     */
    public void useItem(Playable player, Consumable item) {
        chest.useItem(player, item);
    }

    /**
     * Gets all the items that are stored in the chest (names and amount).
     * @return hashmap of the full chest
     */
    public HashMap<Consumable, Integer> getMapItems(){
        return chest.getItems();
    }

    /**
     * Gets the names of all items in the chest.
     * @return list of items in the chest
     */
    public LinkedList<Consumable> getListItems(){
        HashMap<Consumable, Integer> map = getMapItems();
        return new LinkedList<>(map.keySet());
    }

    /**
     * Gets the amount left of an item on the chest.
     * @param item item to check how many are left
     * @return amount of items left
     */
    public int getHowManyItems(Consumable item) {
        return chest.howManyItems(item);
    }

    /**
     * This method represents the jump attack that Heroes have.
     * @param attacker Hero attacking
     * @param defender Enemy defending
     */
    public void playerJumpAttacks(Heroic attacker, Wicked defender) {
        attacker.jump(defender);
        //JumpAttackVisitor jumpAttackVisitor = new JumpAttackVisitor(defender);
        //attacker.accept(jumpAttackVisitor);
        //defender.accept(jumpAttackVisitor);
    }


    /**
     * This method represents the hammer attack that Heroes have.
     * @param attacker Hero attacking
     * @param defender Enemy defending
     */
    public void playerHammerAttacks(Heroic attacker, Wicked defender) {
        attacker.hammer(defender);
    }

    /**
     * This method represents the standard attack that Enemies have.
     * @param attacker Enemy attacking
     * @param defender Hero defending
     */
    public void enemyAttack(Wicked attacker, Heroic defender) {
        attacker.attack(defender);
    }

}
