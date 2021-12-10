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

import java.util.HashMap;
import java.util.LinkedList;

/**
 * GameController is the Controller of the game. Its function is to separate the View from the Model, using a
 * Mediators like Pattern.
 *
 *  @author Paul Chauveau Gerber
 *  @version 2.0
 *  @since 2021-11-05
 */
public class GameController {

    private LinkedList<Playable> players;
    private LinkedList<Playable> enemies;
    private LinkedList<Playable> currentCharacters;
    private Marcos marcos;
    private Luis luis;
    private Chest chest;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;
    WickedFactory wickedFactory = new WickedFactory(1, 30, 8, 50);

    /**
     * It initializes the lists containing players and enemies.
     */
    public void initializeLists() {
        players = new LinkedList<>();
        enemies = new LinkedList<>();
        currentCharacters = new LinkedList<>();
    }

    /**
     * It creates the mains characters of the game, Marcos and Luis
     */
    public void initializePlayers() {
        marcos = new Marcos(1, 10, 8, 50, 20);
        luis = new Luis(1, 10, 8, 50, 20);
        players.add(marcos);
        players.add(luis);
    }

    /**
     * InitializeEnemies creates the opponents for Marcos and Luis at each stage.
     * @param numberOfEnemies number of enemies to be created
     */
    public void initializeEnemies(int numberOfEnemies) {
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(wickedFactory.create());
        }
    }

    /**
     * Takes players and enemies and creates a single list with all of them. It is used to keep track of the characters
     * during a stage.
     */

    public void formCurrentCharactersList(){
        currentCharacters.addAll(players);
        currentCharacters.addAll(enemies);
    }

    /**
     * Returns the list of current characters active in the stage.
     * @return currentCharacters
     */
    public LinkedList<Playable> getCurrentCharacters(){
        return currentCharacters;
    }


    /**
     * Returns the list of players, dead or alive.
     * @return players
     */
    public LinkedList<Playable> getPlayers(){
        return players;
    }

    /**
     * Returns the list of enemies, dead or alive.
     * @return enemies
     */
    public LinkedList<Playable> getEnemies(){
        return enemies;
    }


    /**
     * Removes the dead characters from the currentCharacters list
     */
    public void removeDead() {
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
     * @param turn indicates the number of actions since the beginning of a turn
     * @return current character
     */
    public Playable getCurrentCharacter(int turn) {
        int index = (turn - 1) % currentCharacters.size();
        return currentCharacters.get(index);
    }

    /**
     * Gets the next character that will be active next step.
     * @param turn indicates the number of actions since the beginning of a turn
     * @return next current character
     */
    public Playable getNextCharacter(int turn){
        return getCurrentCharacter( turn+1);
    }

    /**
     * Checks if the conditions for winning have been fulfilled.
     * @return true if the players won, false otherwise
     */
    public boolean didIWin(){
        if (currentCharacters.size() == 2 && (currentCharacters.contains(marcos) && currentCharacters.contains(luis))){
            return true;
        } else return currentCharacters.size() == 1 && (currentCharacters.contains(marcos) || currentCharacters.contains(luis));
    }

    /**
     * Checks if the conditions for losing have been fulfilled.
     * @return true if the players lose, false otherwise
     */
    public boolean didILose(){
        return !currentCharacters.contains(marcos) && !currentCharacters.contains(luis);
    }

    /**
     * Applies the modifications (lvl up, healing and more items) at the end of each turn.
     */
    public void endBattle() {
        for (Playable player : players) {
            player.lvlUp();
            player.setHP(player.getHPMax());
            player.setFP(player.getFPMax());
        }
        stockChest(1);
    }

    /**
     * Creates a new chest for the game
     */
    public void createChest() {
        chest = new Chest();
    }

    /**
     * Creates a RedMushroom item
     */
    public void createRedMushroom(){
        redMushroom = new RedMushroom();
    }

    /**
     * Creates a HoneySyrup item
     */
    public void createHoneySyrup(){
        honeySyrup = new HoneySyrup();
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
