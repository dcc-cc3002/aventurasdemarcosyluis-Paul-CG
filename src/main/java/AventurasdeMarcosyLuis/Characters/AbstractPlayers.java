package AventurasdeMarcosyLuis.Characters;

/**
 * Players Extends Character, it represents the main characters of the game.
 * This class implements all the methods to use AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.Items.Items.Characters.AventurasdeMarcosyLuis.Items.Items, which corresponds only
 * to the main characters.
 *
 * @author Paul Chauveau Gerber
 * @version 1.2
 * @since 2021-10-12
 */
public abstract class AbstractPlayers extends AbstractCharacter {
    private double KJump;
    private double KHammer;
    private double lvlUpFactor;

    /**
     * Constructor of the class, it defines two types of K (hammer and jump)
     * and a factor that determines the increase in power upon leveling up.
     *
     */
    public AbstractPlayers(int LVL, int ATK, int DEF, int HPMax, int FPMax) {
        super(LVL, ATK, DEF, HPMax, FPMax);
        KHammer = 1.5;
        KJump = 1;
        lvlUpFactor = 1.15;
    }

    /**
     * lvlUP increments the stats HPMax, FPMax, ATK and DEF by 15%, LVL by 1. HP and FP are incremented by the same
     * amount HPMax and FPMax respectively.
     */
    public void lvlUp(){
        int HP = (int) ((lvlUpFactor-1)*this.getHPMax());
        int FP = (int) ((lvlUpFactor-1)*this.getFPMax());

        this.setLVL(this.getLVL()+1);
        this.setHPMax(this.getHPMax() + HP);
        this.setFPMax(this.getFPMax() + FP);
        this.setHP(this.getHP() + HP);
        this.setFP(this.getFP() + FP);
        this.setATK((int) (lvlUpFactor*this.getATK()));
        this.setDEF((int) (lvlUpFactor*this.getDEF()));
    }

    @Override
    public double getKHammer(){
        return KHammer;
    }

    @Override
    public double getKJump(){
        return KJump;
    }
}








