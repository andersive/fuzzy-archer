import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: lahmia
 * Date: 130304
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Card implements Cloneable
{
    public String set;
    public int idNumber;
    protected int setNumber;

    protected String cardTitle;
    protected String gameText;
    protected String shadowEffectText;

    public static Card Core111 = new EnemyCard("Core", 111, "Misty Mountain Goblins", 15, 2, 2, 1, 3,  "Goblin. Orc.",
            "Forced: After Mist Mountain Goblins attacks, remove one progress token from the current quest.",
            "Shadow: Remove 1 progress token from the current quest. (3 progress tokens instead of this attack is undefended.)");
    public static Card Core112 = new TreacheryCard("Core", 112, "Massing at the Night",
            "When Revealed: Reveal X additional cards from the encounter deck. X is the setNumber of players in the game.",
            "Shadow: Deal X shadow cards to this attacker. X is the setNumber of players in the game.");
    public static Card Core113 = new LocationCard("Core", 113, "Banks of the Anduin", 3, 1, "Riverland.",
                    "Forced: If Banks of the Anduin leaves play, return it to the top of the encounter deck instead of placing it in the discard pile.");
    public static Card Core114 = new LocationCard("Core", 114, "Gladden Fields", 3, 3, "Marshland.",
            "Forced: While Gladden Fields is the active location, each player must raise his threat by an additional point during the refresh phase.",
            3);
    public static Card Core115 = new EnemyCard("Core", 115, "Eastern Crows", 30, 1, 1, 0, 1,
            "Creature.",
                    "Surge.",
                    "Forced: After Eastern Crows is defeated, shuffle it at back into the encounter deck.",
    "Shadow: Attacking enemy gets +1. (+2 instead if defending player's threat is 35 or higher.)");
    public static Card Core116 = new TreacheryCard("Core", 116, "Evil Storm",
            "When Revealed: Deal 1 damage to each character controlled by each player with a threat of 35 or higher.");
    public static Card Core117 = new TreacheryCard("Core", 117, "Pursued by Shadow",
            "When Revealed: Each player raises his threat by 1 for each character he controls that is not currently committed to a quest.",
            "Shadow: Defending player chooses and returns 1 exhausted ally he controls to its owner's hand. if he controls no exhausted allies, raise his threat by 3.");
    public static Card Core118 = new TreacheryCard("Core", 118, "Treacherous Fog",
            "When Revealed: Each location in the staging area gets +1 until the end of the phase. Then, each player with a threat of 35 or higher chooses and discards 1 cards from his hand.");
    public static Card Core89 = new EnemyCard("Core", 89, "Dol Guldur Orcs",   10,  2,   2,   0,   3,
            "Dol Guldur. Orc.",
            "When Revealed: The first player chooses 1 character currently committed to a quest. Deal 2 damage to that character.",
    "Shadow: Attacking enemy gets +1. (+3instead if this attack is undefended.)");
    public static Card Core90 = new EnemyCard("Core", 90, "Chieftan Ufthak",   35,  2,   3,   3,   6,
            "Dol Guldur. Orc.",
            "Victory: 4",
            "Cheiftan Ufthak gets +2 for each resource token on him.",
        "Forced: After Cheiftan Ufthak attacks, place 1 resource token on him.");
    public static Card Core91 = new EnemyCard("Core", 91, "Dol Guldur Beastmaster",   35,  2,   3,   1,   5,
            "Dol Guldur. Orc.",
            "Forced: After Dol Guldor Beastmaster attacks, deal it 1 additional shadow card.");
    public static Card Core92 = new TreacheryCard("Core", 92, "Driven by Shadow",
            "Each enemy and each location in the staging area gets +1 until the of the phase. If there are no cards in the staging area, Driven by Shadow gains surge.",
            "Shadow: Choose and discard 1 attachment from the defending character. (If this attack is undefended, discard all the attachment you control.)");
    public static Card Core93 = new TreacheryCard("Core", 93, "The Necromancer's Reach",
    "When Revealed: Deal 1 damage to each exhausted character.");
    public static Card Core94 = new LocationCard("Core", 94, "Necromancer's Pass",   2,  3,
    "Stronghold. Dol Guldur.",
    "Travel: The first player must discard 2 cards from his hand at random to travel here.");
    public static Card Core95 = new LocationCard("Core", 95, "Enchanted Stream",   2,  2,
            "Forest.",
                    "While Enchanted Stream is the active location, players cannot draw cards.");
    public static Card Core81 = new EnemyCard("Core", 81, "Wolf Rider",   10,  1,   2,   0,   2,
    "Goblin. Orc.",
            "Surge.",
            "Shadow: Wolf Rider attacks the defending player. That player may declare 1 character as a defender. Deal Wolf Rider its own Shadow cards. After combat, return Wolf Rider to the top of the encounter deck.", "");
    public static Card Core82 = new EnemyCard("Core", 82, "Hill Troll",   30,  1,   6,   3,   9,
            "Troll.",
            "Victory: 4",
                    "Excess combat damage dealt by the Hill Troll (damage that is dealt beyond the remaining hit points of the character damaged in the attack) must be assigned as an increase to you threat.","");
    public static Card Core83 = new EnemyCard("Core", 83, "Goblin Sniper",   48,  2,   2,   0,   2,
            "Goblin. Orc.",
                    "During the encounter phase, players cannot optionally engage Goblin Sniper if there are other enemies in the staging area.",
    "Forced: If Goblin Sniper is in the staging area at the end of the combat phase, each player deals 1 point of damage to 1 character he controls.");
    public static Card Core84 = new EnemyCard("Core", 84, "Marsh Adder",   40,  3,   4,   1,   7,
            "Creature.",
                    "Victory: 3",
                    "Forced: Each time Marsh Adder attacks you, raise your threat by 1.");
    public static Card Core85 = new EnemyCard("Core", 85, "Wargs",   20,  2,   3,   1,   3,
            "Creature.",
                    "Forced: If Wargs is dealt a shadow card with no effect, return Wargs to the staging area after it attacks.",
    "Shadow: Attacking enemy gets +1. (+2 if this attack is undefended.)");
    public static Card Core86 = new TreacheryCard("Core", 86, "Despair",
            "When Revealed: Remove 4 progress tokens from the current quest card. (If there are fewer then 4 progress tokens on the quest, remove all progress tokens from that quest.)",
    "Shadow: Defending character does not count its .");
    public static Card Core87 = new LocationCard("Core", 87, "The Brown Lands",   1,  5,
            "Wasteland.",
                    "Forced: After the players travel to The Brown Lands, place one progress token on it.");
    public static Card Core88 = new LocationCard("Core", 88, "The East Blight",   6,  1,
            "Wasteland.",
                    "When faced with the option to travel, the players must travel to The East Blight if there is no active location.");
    private ImageIcon imageIcon = Card.EmptyImageIcon;
    public static ImageIcon EmptyImageIcon = new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingsCardSelector-exploded/tmp/EmptyImage.jpg");
    public static ImageIcon BackHeroDeckImageIcon = new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingsCardSelector-exploded/tmp/MBack Hero Deck.jpg");
    public static ImageIcon BackEncounterDeckImageIcon = new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingsCardSelector-exploded/tmp/MBack Encounter Deck.jpg");
    private boolean revealed = false;
    protected static Card NoCard = new Card() {
        @Override
        public ImageIcon getBackImageIcon() {
            return EmptyImageIcon;
        }
    };

    public Card(String set, int idNumber, String cardTitle, String gameText, String shadowEffectText)
    {
        this(set, idNumber, cardTitle, gameText);
        this.shadowEffectText = shadowEffectText;
    }

    public Card(String set, int idNumber, String cardTitle, String gameText)
    {
        this.set = set;
        this.idNumber = idNumber;
        this.cardTitle = cardTitle;
        this.gameText = gameText;
        this.imageIcon = new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingsCardSelector-exploded/tmp/"+String.format("S1%03d",idNumber)+".jpg");
    }

    public Card() {
    }

    public Card setSetNumber(int setNumber)
     {
         this.setNumber = setNumber;
         return this;
     }

    public String toString()
    {
        return set + "-" + idNumber + ": " + cardTitle + " " + setNumber;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public Image getBackImage()
    {
        return getBackImageIcon().getImage();
    }

    public abstract ImageIcon getBackImageIcon();

    public boolean isRevealed() {
        return revealed;
    }


    public void reveal()
    {
        revealed = true;
    }

    public void hide()
    {
        revealed = false;
    }
}
