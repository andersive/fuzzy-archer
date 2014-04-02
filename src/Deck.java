import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lahmia
 * Date: 130304
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deck
{
    protected Set<Card> cards = new LinkedHashSet<Card>();
    private int cardNumber = 1;
    Random random = new Random();
    public Deck()
    {
    }

    public Deck add(Deck d)
    {
        cards.addAll(d.getCards());
        return this;
    }

    public Deck add(Card c)
    {
        cards.add(c);
        return this;
    }
    public Deck addCloneOf(Card c)
    {
        Card clone = null;
        try {
            clone = (Card) c.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        clone.setSetNumber(cardNumber++);
        cards.add(clone);
        return this;
    }

    private Collection<? extends Card> getCards()
    {
        return cards;
    }

    public Deck shuffle() {
        if (!isEmpty())
        {
            Card[] cardArray = cards.toArray(new Card[0]);
            Set<Card> tempCards = new LinkedHashSet<Card>();
            for (int i = cards.size()-1; i > 0; i--)
            {
                int swapPosition = random.nextInt(i);
                tempCards.add(cardArray[swapPosition]);
                cardArray[swapPosition] = cardArray[i];
            }
            tempCards.add(cardArray[0]);
            cards = tempCards;
        }
        return this;
    }

    public Deck hide()
    {
        for (Card c : cards)
        {
            c.hide();
        }
        return this;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for (Card c : cards)
        {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }

    public Image getTopImage() {
        return getTopImageIcon().getImage();
    }

    public ImageIcon getTopImageIcon() {
        ImageIcon topImageIcon = Card.EmptyImageIcon;
        Card topCard = getTopCard();
        if (topCard.isRevealed())
        {
            topImageIcon = topCard.getImageIcon();
        }
        else
        {
            topImageIcon = topCard.getBackImageIcon();
        }
        return topImageIcon;
    }

    public Card getTopCard() {
        Card topCard = Card.NoCard;
        for (Card c : cards)
        {
            topCard = c;
            break;
        }
        return topCard;
    }

    public void remove(Card card)
    {
        cards.remove(card);
    }

    public void addFirst(Card topCard)
    {
        Set<Card> newCards = new LinkedHashSet<Card>();
        newCards.add(topCard);
        newCards.addAll(cards);
        cards = newCards;
    }

    public boolean isEmpty() {
        return cards.size() == 0;
    }

    public Deck move(Deck encounterDiscardPile)
    {
        while (encounterDiscardPile.cards.size() > 0)
        {
            Card card = encounterDiscardPile.getTopCard();
            encounterDiscardPile.remove(card);
            cards.add(card);
        }
        return this;
    }
}
