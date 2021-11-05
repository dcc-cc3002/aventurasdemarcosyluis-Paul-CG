package AventurasdeMarcosyLuis.Controllers;

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
 *  @version 1.0
 *  @since 2021-11-05
 */
public class GameController {

    private final LinkedList<Playable> players = new LinkedList<Playable>();
    private final LinkedList<Playable> enemies = new LinkedList<Playable>();
    private LinkedList<Playable> currentCharacters = new LinkedList<Playable>();
    private Playable character;
    private Marcos marcos;
    private Luis luis;
    private final Chest chest = new Chest();
    private final RedMushroom redMushroom = new RedMushroom();
    private final HoneySyrup honeySyrup = new HoneySyrup();
    WickedFactory wickedFactory = new WickedFactory(1, 10, 8, 50);

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
     * @param players
     * @param enemies
     * @return list with all characters
     */
    public LinkedList<Playable> formCurrentCharactersList(LinkedList<Playable> players, LinkedList<Playable> enemies){
        players.addAll(enemies);
        currentCharacters = players;
        return currentCharacters;
    }

    /**
     * Returns the list of current characters active in the stage.
     * @return
     */
    public LinkedList getCurrentCharacters(){
        return currentCharacters;
    }

    /**
     * Removes the dead characters from the currentCharacters list
     * @param currentCharacters
     */
    public void removeDead(LinkedList<Playable> currentCharacters) {
        for (int i = 0; i < currentCharacters.size(); i++){
            character = currentCharacters.get(i);
            if (character.isKO()) currentCharacters.remove(character);
        }
    }

    /**
     * Gets the current character that is active this step.
     * @param currentCharacters
     * @param turn
     * @return
     */
    public Playable getCurrentCharacter(LinkedList<Playable> currentCharacters, int turn) {
        int index = (turn - 1) % currentCharacters.size();
        return currentCharacters.get(index);
    }

    /**
     * Gets the next character that will be active next step.
     * @param currentCharacters
     * @param turn
     * @return
     */
    public Playable getNextCharacter(LinkedList<Playable> currentCharacters, int turn){
        return getCurrentCharacter(currentCharacters, turn+1);
    }

    /**
     * Checks if the conditions for winning have been fulfilled.
     * @param currentCharacters
     * @return
     */
    public boolean didIWin(LinkedList<Playable> currentCharacters){
        if (currentCharacters.size() == 2 && (currentCharacters.contains(marcos) && currentCharacters.contains(luis))){
            return true;
        } else if (currentCharacters.size() == 1 && (currentCharacters.contains(marcos) || currentCharacters.contains(luis))){
            return true;
        }
        return false;
    }

    /**
     * Checks if the conditions for losing have been fulfilled.
     * @param currentCharacters
     * @return
     */
    public boolean didILose(LinkedList<Playable> currentCharacters){
        if (!currentCharacters.contains(marcos) && !currentCharacters.contains(luis)){
            return true;
        }
        return false;
    }

    /**
     * Applies the modifications (lvl up, healing and more items) at the end of each turn.
     * @param players
     */
    public void endTurn(LinkedList<Playable> players) {
        for (int i = 0; i < players.size(); i++){
            players.get(i).lvlUp();
            players.get(i).setHP(players.get(i).getHPMax());
            players.get(i).setFP(players.get(i).getFPMax());
        }
        stockChest(1);
    }

    /**
     * Adds the same amount of RedMushroom and HoneySyrup to the chest.
     * @param amount
     */
    public void stockChest(int amount) {
        for (int i = 0; i < amount; i++){
            chest.addItem(redMushroom);
            chest.addItem(honeySyrup);
        }
    }

    /**
     * Allows to use an item, if possible, from the chest.
     * @param player
     * @param item
     */
    public void useItem(Playable player, Consumable item) {
        chest.useItem(player, item);
    }

    /**
     * Gets all the items that are stored in the chest (names and amount).
     * @return
     */
    public HashMap getMapItems(){
        return chest.getItems();
    }

    /**
     * Gets the names of all items in the chest.
     * @return
     */
    public LinkedList getListItems(){
        HashMap map = getMapItems();
        return new LinkedList<String>(map.keySet());
    }

    /**
     * Gets the amount left of an item on the chest.
     * @param item
     * @return
     */
    public int getHowManyItems(Consumable item) {
        return chest.howManyItems(item);
    }

}
