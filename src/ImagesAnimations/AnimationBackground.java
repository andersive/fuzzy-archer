package ImagesAnimations;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class AnimationBackground extends JLabel implements ActionListener
{
    public static void walkin(File dir) {

        File listFile[] = dir.listFiles();
        if (listFile != null) {
            for (int i=0; i<listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    System.out.println("|\t\t");
                    walkin(listFile[i]);
                } else {
                    System.out.println("+---"+listFile[i].getName().toString());
                }
            }
        }
    }

    int deltaX = 2;
    int deltaY = 3;
    int directionX = 1;
    int directionY = 1;

    public AnimationBackground(
            int startX, int startY,
            int deltaX, int deltaY,
            int directionX, int directionY,
            int delay)
    {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.directionX = directionX;
        this.directionY = directionY;

        setIcon( new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingdLCG/out/production/LordOfTheRingdLCG/images/dukeWaveRed.gif") );
        setSize( getPreferredSize() );
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
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
            Image image = new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingdLCG/out/production/LordOfTheRingdLCG/images/mong.jpg").getImage();

            protected void paintComponent(Graphics g)
            {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                super.paintComponent(g);
            }
        };
        JPanel panel2 = new JPanel(null)
        {
            Image image = new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingdLCG/out/production/LordOfTheRingdLCG/images/dukeWaveRed.gif").getImage();

            protected void paintComponent(Graphics g)
            {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                super.paintComponent(g);
            }
        };

        panel.setOpaque(false);
//      panel.add( new ImagesAnimations.AnimationBackground(10, 10, 2, 3, 1, 1, 10) );
        panel.add( new AnimationBackground(300, 100, 3, 2, -1, 1, 20) );
        panel.add( new AnimationBackground(200, 200, 2, 3, 1, -1, 20) );
        panel.add( new AnimationBackground(50, 50, 5, 5, -1, -1, 20) );
//      panel.add( new ImagesAnimations.AnimationBackground(0, 000, 5, 0, 1, 1, 20) );
        panel.add( new AnimationBackground(0, 200, 5, 0, 1, 1, 80) );

        JFrame frame = new JFrame();
//        panel.setSize(100,200);
        frame.add(panel);
//        frame.add(panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
//        frame.setIconImage(new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingdLCG/out/production/LordOfTheRingdLCG/images/mong.jpg").getImage());
        frame.setBackground(Color.WHITE);
/*
        frame.add(
            new JPanel()
            {
                Image image = new ImageIcon("/Users/lahmia/Documents/Programmering/LordOfTheRingdLCG/out/production/LordOfTheRingdLCG/images/mong.jpg").getImage();
                protected void paintComponent(Graphics g)
                {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                    g.setColor(Color.GREEN);
                    g.drawLine(0, 0, 100, 200);
                    setBackground(Color.BLUE);
                    setSize(100,200);
                    super.paintComponent(g);
                }
            }
        );
*/

/*
        frame.add(new ImagesAnimations.ImagePanel2());
        try {
            frame.add(new JLabel(new java.io.File( "." ).getCanonicalPath()));
            //frame.add(new JLabel(String.valueOf(new java.io.File( "images/mong.jpg" ).exists())));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
*/
        walkin(new File("/Users/lahmia/Documents/Programmering/LordOfTheRingdLCG/out/production/LordOfTheRingdLCG/images/"));
        frame.setVisible(true);
    }
}