/**
 * Created with IntelliJ IDEA.
 * User: lahmia
 * Date: 130305
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class LocationCard extends EncounterCard {
    protected int threatStrength;
    protected int questPoints;
    protected String traits;
    protected int victory;

    public LocationCard(String set, int idNumber, String cardTitle, int threatStrength, int questPoints, String traits, String gameText)
    {
        super(set, idNumber, cardTitle, gameText);
        this.threatStrength = threatStrength;
        this.questPoints = questPoints;
        this.traits = traits;
    }

    public LocationCard(String set, int idNumber, String cardTitle, int threatStrength, int questPoints, String traits, String gameText, int victory)
    {
        this(set, idNumber, cardTitle, threatStrength, questPoints, traits, gameText);
        this.victory = victory;
    }
}
