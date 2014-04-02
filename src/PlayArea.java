import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class PlayArea extends JLabel implements ActionListener, MouseListener, MouseMotionListener
{
    int startX;
    int startY;
    int deltaX = 2;
    int deltaY = 3;
    int directionX = 1;
    int directionY = 1;
    private JFrame frame;
    private Deck encounterDeck;
    private Deck encounterDiscardPile;

    protected Deck deck;

    PlayArea playArea;

    public PlayArea(
            Deck deck,
            int startX, int startY,
            int deltaX, int deltaY,
            int directionX, int directionY,
            int delay, PlayArea playArea)
    {
        this(deck, startX, startY, deltaX, deltaY, directionX, directionY, delay);
        this.playArea = playArea;
    }

    public PlayArea(
            Deck deck,
            int startX, int startY,
            int deltaX, int deltaY,
            int directionX, int directionY,
            int delay)
    {
        this.deck = deck;
        this.startX = startX;
        this.startY = startY;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.directionX = directionX;
        this.directionY = directionY;

        setIcon(deck.getTopImageIcon());
        setSize( getPreferredSize() );
        setLocation(startX, startY);
        //new Timer(delay, this).start();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        Container parent = getParent();

        //  Determine next X position

        int nextX = getLocation().x + (deltaX * directionX);

        if (nextX < 0)
        {
            nextX = 0;
            directionX *= -1;
        }

        if ( nextX + getSize().width > parent.getSize().width)
        {
            nextX = parent.getSize().width - getSize().width;
            directionX *= -1;
        }

        //  Determine next Y position

        int nextY = getLocation().y + (deltaY * directionY);

        if (nextY < 0)
        {
            nextY = 0;
            directionY *= -1;
        }

        if ( nextY + getSize().height > parent.getSize().height)
        {
            nextY = parent.getSize().height - getSize().height;
            directionY *= -1;
        }

        //  Move the label

        setLocation(nextX, nextY);
    }

    public static void main(String[] args)
    {
        JPanel panel = new JPanel(null)
        {
            Image image = new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingsCardSelector-exploded/tmp/Background Gandalf Aragorn.png").getImage();

            protected void paintComponent(Graphics g)
            {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                super.paintComponent(g);
            }
        };
        panel.setOpaque(false);
//      panel.add( new ImagesAnimations.AnimationBackground(10, 10, 2, 3, 1, 1, 10) );
        //panel.add( new PlayArea(300, 100, 3, 2, -1, 1, 20) );
        //panel.add( new PlayArea(200, 200, 2, 3, 1, -1, 20) );
        //panel.add( new PlayArea(50, 50, 5, 5, -1, -1, 20) );
//      panel.add( new ImagesAnimations.AnimationBackground(0, 000, 5, 0, 1, 1, 20) );
        //panel.add( new PlayArea(0, 200, 5, 0, 1, 1, 80) );

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
    }

    public PlayArea(Deck encounterDeck, Deck encounterDiscardPile)
    {
        this.encounterDeck = encounterDeck;
        this.encounterDiscardPile = encounterDiscardPile;

    }

    private static Image backgroundImage = new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingsCardSelector-exploded/tmp/Background Gandalf Aragorn.png").getImage();

    public void showDecks() {

        JPanel background = new JPanel(null)
        {
            protected void paintComponent(Graphics g)
            {
                g.drawImage(PlayArea.backgroundImage, 0, 0, PlayArea.backgroundImage.getWidth(null), PlayArea.backgroundImage.getHeight(null), null);
                super.paintComponent(g);
            }
        };

        JPanel encounterDecks = new JPanel(null)
        {
            protected void paintComponent(Graphics g)
            {
                Image topEncounterDiscardPile = encounterDiscardPile.getTopImage();
                Image topEncounterDeck = encounterDeck.getTopImage();
                g.drawImage(topEncounterDiscardPile, 0, 0, topEncounterDiscardPile.getWidth(null), topEncounterDiscardPile.getHeight(null), null);
                int encounterStartX = topEncounterDiscardPile.getWidth(null)+10;
                g.drawImage(topEncounterDeck, encounterStartX, 0, topEncounterDeck.getWidth(null), topEncounterDeck.getHeight(null), null);
                super.paintComponent(g);
            }
        };
        background.setOpaque(false);
        PlayArea eDP = new PlayArea(encounterDiscardPile, 0, 0, 0, 0, 0, 0, 0);
        background.add(eDP);
        int encounterStartX = encounterDiscardPile.getTopImage().getWidth(null) + 10;
        PlayArea eD = new PlayArea(encounterDeck, encounterStartX, 0, 0, 0, 0, 0, 0, eDP)
        {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                Image topImage = deck.getTopImage();
                startX = mouseEvent.getX();
                startY = mouseEvent.getY();
                System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
            }

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                setLocation(getLocation().x + mouseEvent.getX() - startX, getLocation().y + mouseEvent.getY() - startY);
                //System.out.println("drag:"+mouseEvent.getX() + " " + mouseEvent.getY());
            }

            @Override
            public void mouseClicked(MouseEvent mouseEvent)
            {
                if (deck.isEmpty())
                {
                    encounterDeck.move(encounterDiscardPile).shuffle().hide();
                    playArea.setIcon(playArea.deck.getTopImageIcon());
                }
                else
                {
                    Card topCard = this.deck.getTopCard();
                    if (topCard.isRevealed())
                    {
                        deck.remove(topCard);
                        encounterDiscardPile.addFirst(topCard);
                        playArea.setIcon(playArea.deck.getTopImageIcon());
                        System.out.println("To staging (discard)" + playArea.deck.getTopImageIcon());
                    }
                    else
                    {
                        System.out.println("Reveal " + topCard);
                        topCard.reveal();
                    }
                    System.out.println("Discard size:"+encounterDiscardPile.cards.size()+ " Draw size:"+encounterDeck.cards.size());
                }
                setIcon(deck.getTopImageIcon());
            }
        };
        background.add(eD);
        //encounterDecks.setOpaque(false);

        frame = new JFrame();
        frame.add(background);
        //frame.add(encounterDecks);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
        frame.setLocationRelativeTo(null);
        //frame.setBackground(Color.WHITE);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        //System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        //System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
    }
}