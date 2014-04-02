/**
 * Created with IntelliJ IDEA.
 * User: lahmia
 * Date: 130304
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnemyCard extends EncounterCard
{
    protected int engagementCost;
    protected int threatStrength;
    protected int attackStrength;
    protected int defenseStrength;
    protected int hitPoints;
    protected String traits;
    protected String keywords;

    public EnemyCard(String set, int idNumber, String cardTitle, int engagementCost, int threatStrength, int attackStrength, int defenseStrength,
                     int hitPoints, String traits, String gameText)
    {
        super(set, idNumber, cardTitle, gameText);
        this.engagementCost = engagementCost;
        this.threatStrength = threatStrength;
        this.attackStrength = attackStrength;
        this.defenseStrength = defenseStrength;
        this.hitPoints = hitPoints;
        this.traits = traits;
    }

    public EnemyCard(String set, int idNumber, String cardTitle, int engagementCost, int threatStrength, int attackStrength, int defenseStrength,
                     int hitPoints, String traits, String gameText, String shadowEffectText)
    {
        super(set, idNumber, cardTitle, gameText, shadowEffectText);
        this.engagementCost = engagementCost;
        this.threatStrength = threatStrength;
        this.attackStrength = attackStrength;
        this.defenseStrength = defenseStrength;
        this.hitPoints = hitPoints;
        this.traits = traits;
    }

    public EnemyCard(String set, int idNumber, String cardTitle, int engagementCost, int threatStrength, int attackStrength, int defenseStrength,
                     int hitPoints, String traits, String keywords, String gameText, String shadowEffectText)
    {
        this(set, idNumber, cardTitle, engagementCost, threatStrength, attackStrength, defenseStrength, hitPoints, traits, gameText, shadowEffectText);
        this.keywords = keywords;
    }

}
