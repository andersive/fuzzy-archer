/**
 * Created with IntelliJ IDEA.
 * User: lahmia
 * Date: 130304
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreacheryCard extends EncounterCard {

    public TreacheryCard(String set, int idNumber, String cardTitle, String gameText, String shadowEffectText)
    {
        super(set, idNumber, cardTitle, gameText, shadowEffectText);
    }

    public TreacheryCard(String set, int idNumber, String cardTitle, String gameText)
    {
        super(set, idNumber, cardTitle, gameText);
    }
}
