import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;

public class DrawingPanel implements ActionListener {
    public static void main(String[] args) {
        //make and set color for panel.
        DrawingPanel panel = new DrawingPanel(500, 500);// this is panel variable. It helps to make a panel to draw every objects inside.
        Graphics g = panel.getGraphics();
        panel.setBackground(Color.cyan);

        //draw a car
        g.setColor(Color.GRAY);//set color for a car body
        //make three part of a car body
        g.fillRect(30, 50, 60, 30);
        g.fillRect(170, 50, 60, 30);
        g.fillRect(90,30,80,50);
        g.setColor(Color.RED);//set color for car wheel
        //make two wheels for a car
        g.fillOval(50,70,20,20);
        g.fillOval(190,70,20,20);
        g.setColor(Color.BLUE);//set color for window
        //make three window for car( two in the middle and one in front)
        g.fillRect(110,35,15,15);
        g.fillRect(135,35,15,15);
        g.fillRect(160, 35,10,15);

        //draw a truck
        g.setColor(Color.GREEN);//set color and do the back of the truck.
        g.fillRect(30,150, 100,60);
        g.setColor(Color.GRAY);//set color and make the front of the truck.
        g.fillRect(130,170, 30, 40 );
        g.setColor(Color.BLUE);//set color of two window
        //make two windows
        g.fillRect(132,175, 15,15);
        g.fillRect(150, 175, 10,15);
        g.setColor(Color.RED);//set color for wheels
        //make three wheels(two in the back and one in the front)
        g.fillOval(40, 200, 20, 20);
        g.fillOval(60, 200, 20, 20);
        g.fillOval(140, 200, 20, 20);

    }



    private static final boolean PRETTY = true;  // true to anti-alias

    private int width, height;    // dimensions of window frame
    private JFrame frame;         // overall window frame
    private JPanel panel;         // overall drawing surface
    private BufferedImage image;  // remembers drawing commands
    private Graphics2D g2;        // graphics context for painting
    private JLabel statusBar;     // status bar showing mouse position

    public static final int DELAY = 250;  // delay between repaints in millis

    // construct a drawing panel of given width and height enclosed in a window
    public DrawingPanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        this.statusBar = new JLabel(" ");
        this.statusBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.panel.setBackground(Color.WHITE);
        this.panel.setPreferredSize(new Dimension(width, height));
        this.panel.add(new JLabel(new ImageIcon(image)));

        // listen to mouse movement
        MouseInputAdapter listener = new MouseInputAdapter() {
            public void mouseMoved(MouseEvent e) {
                DrawingPanel.this.statusBar.setText("(" + e.getX() + ", " + e.getY() + ")");
            }

            public void mouseExited(MouseEvent e) {
                DrawingPanel.this.statusBar.setText(" ");
            }
        };
        this.panel.addMouseListener(listener);
        this.panel.addMouseMotionListener(listener);

        this.g2 = (Graphics2D)image.getGraphics();
        this.g2.setColor(Color.BLACK);
        if (PRETTY) {
            this.g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            this.g2.setStroke(new BasicStroke(1.1f));
        }

        this.frame = new JFrame("Drawing Panel");
        this.frame.setResizable(false);
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                DrawingPanel.this.save("output.png");
                System.exit(0);
            }
        });
        this.frame.getContentPane().add(panel);
        this.frame.getContentPane().add(statusBar, "South");
        this.frame.pack();
        this.frame.setVisible(true);

        new Timer(DELAY, this).start();
    }

    // used for an internal timer that keeps repainting
    public void actionPerformed(ActionEvent e) {
        this.panel.repaint();
    }

    // obtain the Graphics object to draw on the panel
    public Graphics2D getGraphics() {
        return this.g2;
    }

    // set the background color of the drawing panel
    public void setBackground(Color c) {
        this.panel.setBackground(c);
    }

    // show or hide the drawing panel on the screen
    public void setVisible(boolean visible) {
        this.frame.setVisible(visible);
    }

    // makes the program pause for the given amount of time,
    // allowing for animation
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }

    // makes drawing panel become the frontmost window on the screen
    public void toFront() {
        this.frame.toFront();
    }

    // take the current contents of the panel and write them to a file
    public void save(String filename) {
        String extension = filename.substring(filename.lastIndexOf(".") + 1);

        // create second image so we get the background color
        BufferedImage image2 = new BufferedImage(this.width, this.height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = image2.getGraphics();
        g.setColor(panel.getBackground());
        g.fillRect(0, 0, this.width, this.height);
        g.drawImage(this.image, 0, 0, panel);

        // write file
        try {
            javax.imageio.ImageIO.write(image2, extension, new java.io.File(filename));
        } catch (java.io.IOException e) {
            System.err.println("Unable to save image:\n" + e);
        }
    }
}
