/**
 * Created with IntelliJ IDEA.
 * User: lahmia
 * Date: 130304
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class LordOfTheRingsLCG {

    public static void main(String[] s)
    {
//        Deck EncounterDeck = new Deck().add(PassageThroughMirkwood).add(SpidersOfMirkwood).add(DolGuldurOrcs)
        Deck encounterDeck = new Deck().
                add(EncounterSet.JourneyDownTheAnduin).
//                add(EncounterSet.SauronsReach).
//                add(EncounterSet.DolGuldurOrcs).
//                add(EncounterSet.Wilderlands).
                shuffle();
        Deck encounterDiscardPile = new Deck();
        Deck victoryPile = new Deck();
        Deck stagingArea = new Deck();
        Deck questDeck = new Deck();
        Deck activeLocation = new Deck();
        Player[] player = new Player[4];
        for (int i = 0; i < player.length; i++)
        {
            player[i] = new Player();
        }

        System.out.println(encounterDeck.toString());

        PlayArea playArea = new PlayArea(encounterDeck, encounterDiscardPile);
        playArea.showDecks();
    }
}

