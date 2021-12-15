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
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidChoiceException;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTargetException;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;
import AventurasdeMarcosyLuis.Phases.LoadPhase;
import AventurasdeMarcosyLuis.Phases.Phase;

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

    private final LinkedList<Playable> players;
    private LinkedList<Playable> alivePlayers;
    private final LinkedList<Playable> enemies;
    private final LinkedList<Playable> currentCharacters;
    private Marcos marcos;
    private Luis luis;
    private Chest chest;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;
    WickedFactory wickedFactory = new WickedFactory(1, 30, 8, 1);
    private Phase phase;
    private Playable currentCharacter;
    private int turn;
    private boolean endOfGame;
    private int numberOfBattles;
    private int activeCharacterIndex;

    /**
     * Constructor of a controller. It initializes all variables needed (lists, phases, etc.)
     */
    public GameController() {
        players = new LinkedList<>();
        enemies = new LinkedList<>();
        currentCharacters = new LinkedList<>();
        phase = new Phase();
        setPhase(new LoadPhase());
        turn = 0;
        endOfGame = false;
        numberOfBattles = 1;
        activeCharacterIndex = -1;
    }

    /**
     * It creates the mains characters of the game, Marcos and Luis
     */
    public void initializePlayers() {
        marcos = new Marcos(1, 30, 8, 100, 20);
        luis = new Luis(1, 30, 8, 1, 20);
        players.add(marcos);
        players.add(luis);
        alivePlayers =  new LinkedList<>(players);
    }

    /**
     * InitializeEnemies creates the opponents for Marcos and Luis at each stage.
     * @param numberOfEnemies number of enemies to be created
     */
    public void initializeEnemies(int numberOfEnemies) {
        enemies.clear();
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(wickedFactory.create());
        }
    }

    /**
     * Takes players and enemies and creates a single list with all of them. It is used to keep track of the characters
     * during a Battle.
     */
    public void formCurrentCharactersListBattle(){
        currentCharacters.clear();
        currentCharacters.addAll(players);
        currentCharacters.addAll(enemies);
    }

    /**
     * Takes players and enemies and creates a single list with all of them. It is used to keep track of the characters
     * during a Turn.
     */
    public void formCurrentCharactersListTurn(){
        currentCharacters.clear();
        currentCharacters.addAll(alivePlayers);
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
     * Returns the list of alive players.
     * @return alivePlayers
     */
    public LinkedList<Playable> getAlivePlayers(){
        return alivePlayers;
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
        int list_length = alivePlayers.size();
        int i = 0;
        while (i < list_length){
            Playable character = alivePlayers.get(i);
            if (character.isKO()){
                alivePlayers.remove(character);
                activeCharacterIndex--;
                i--;
                list_length--;
            }
            i++;
        }

        list_length = enemies.size();
        i = 0;
        while (i < list_length){
            Playable character = enemies.get(i);
            if (character.isKO()){
                enemies.remove(character);
                i--;
                list_length--;
            }
            i++;
        }

        list_length = currentCharacters.size();
        i = 0;
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
     * Gets the next character that will be active next step.
     * @return next current character
     */
    public Playable getNextCharacter() {
        activeCharacterIndex += 1;
        if (activeCharacterIndex >= currentCharacters.size()){
            activeCharacterIndex = 0;
        }
        currentCharacter = currentCharacters.get(activeCharacterIndex);
        return currentCharacter;
    }

    /**
     * Gets the active character
     * @return active character
     */
    public Playable getCurrentCharacter() {
        return currentCharacter;
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
        activeCharacterIndex = -1;
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
        try{
            attacker.jump(defender);
        } catch (InvalidTargetException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method represents the hammer attack that Heroes have.
     * @param attacker Hero attacking
     * @param defender Enemy defending
     */
    public void playerHammerAttacks(Heroic attacker, Wicked defender) {
        try {
            attacker.hammer(defender);
        } catch (InvalidTargetException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method represents the standard attack that Enemies have.
     * @param attacker Enemy attacking
     * @param defender Hero defending
     */
    public void enemyAttack(Wicked attacker, Heroic defender) {
        try {
            attacker.attack(defender);
        } catch (InvalidTargetException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Changes the phase in the controller.
     * @param phase new phase
     */
    public void setPhase(Phase phase){
        this.phase = phase;
        phase.setController(this);
    }

    /**
     * currentCharacterIsHero checks if the current active character is a Hero or not.
     * @return true if the character is a Hero (either Marco or Luis)
     */
    public boolean currentCharacterIsHero(){
        return players.contains(currentCharacter);
    }

    /**
     * Checks if the given playable is an active enemy
     * @param hero object to be checked
     * @return true if it is an active enemy
     */
    public boolean choiceIsHero(Playable hero){
        return players.contains(hero);
    }

    /**
     * Checks if the given playable is an active enemy
     * @param enemy object to be checked
     * @return true if it is an active enemy
     */
    public boolean choiceIsEnemy(Playable enemy){
        return enemies.contains(enemy);
    }

    /**
     * Checks if the given consumable is available on the chest
     * @param item to be checked
     * @return true if it is available
     */
    public boolean choiceIsItem(Consumable item) {
        return chest.getItems().containsKey(item);
    }

    /**
     * This method generates players, chest and items.
     */
    public void loadGame(){
        initializePlayers();
        createChest();
        createRedMushroom();
        createHoneySyrup();
        stockChest(3);
    }

    /**
     * This method tries go to the next phase of the game.
     */
    public void tryNextPhase(){
        try{
            phase.toNextPhase();
        } catch (InvalidTransitionException e){
            e.printStackTrace();
        } catch (InvalidChoiceException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method increases the turn by one
     */
    public void nextTurn(){
        turn++;
    }

    /**
     * Sets the turn to a specific number
     * @param number of turn to set
     */
    public void setTurn(int number){
        turn = number;
    }

    /**
     * Gets the current Turn of the Battle in course
     * @return turn
     */
    public int getTurn(){
        return turn;
    }

    /**
     * Sets if the game is ready or not
     * @param end true if is the end of the game
     */
    public void setEndOfGame(boolean end) {
        endOfGame = end;
    }

    /**
     * This method returns if the game ended or not
     * @return endOfGame
     */
    public boolean getEndOfGame(){
        return endOfGame;
    }

    /**
     * This method increases the number of Battles by one
     */
    public void nextBattle(){
        numberOfBattles++;
    }

    /**
     * Gets the total number of battles fought
     * @return number of battles
     */
    public int getNumberOfBattles(){
        return numberOfBattles;
    }

    /**
     * This method decreases the value of activeCharacterIndex
     */
    public void decreaseActiveCharacterIndex(){
        activeCharacterIndex--;
    }
}
