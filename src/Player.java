/**
 * Created with IntelliJ IDEA.
 * User: lahmia
 * Date: 130311
 * Time: 9:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player
{
    public Deck getHeroes() {
        return heroes;
    }

    public void addHero(HeroCard hero) {
        heroes.add(hero);
        addThreat(hero.getThreatCost());
    }

    Deck heroes = new Deck();
    Deck deck = new Deck();
    Deck discardPile = new Deck();
    Deck playArea = new Deck();
    Deck hand = new Deck();
    Deck engagementArea = new Deck();

    public boolean isFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(boolean firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    boolean firstPlayer = false;

    public int getThreat() {
        return threat;
    }

    public void setThreat(int threat) {
        this.threat = threat;
    }

    public void addThreat(int threat) {
        this.threat += threat;
    }

    int threat = 0;
}
