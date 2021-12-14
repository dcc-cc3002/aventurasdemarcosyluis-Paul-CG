package AventurasdeMarcosyLuis.Phases;

/**
 * This Phase ends the game
 */
public class EndGamePhase extends Phase{
    boolean win;

    /**+
     * The constructor takes a boolean that indicates if the players won or lost the game
     * @param win true if players won
     */
    public EndGamePhase(boolean win){
        this.win = win;
    }

    @Override
    public String toString(){
        return "End Game Phase";
    }

    @Override
    public void toNextPhase() {
        controller.setEndOfGame(true);
        if(win){
            System.out.println("Congratulations! You fought hard and prevailed.");
            System.out.println("Countess Pitch is finally safe.");
        }else{
            System.out.println("You where outmatched by your enemies! D:");
            System.out.println("Hurry up and close the game, you don't want to be here and watch the foul destiny of the fallen heroes.");
        }
    }
}
