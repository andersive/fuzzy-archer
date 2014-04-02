import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: lahmia
 * Date: 130310
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class EncounterCard extends Card {

    public EncounterCard(String set, int idNumber, String cardTitle, String gameText, String shadowEffectText)
    {
        super(set, idNumber, cardTitle, gameText, shadowEffectText);
    }

    public EncounterCard(String set, int idNumber, String cardTitle, String gameText)
    {
        super(set, idNumber, cardTitle, gameText);
    }

    @Override
    public ImageIcon getBackImageIcon() {
        return Card.BackEncounterDeckImageIcon;
    }
}
