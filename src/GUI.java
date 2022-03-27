import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame
{
    public JButton buttonForStart = new JButton("Mixing");
    public JButton buttonForFinish = new JButton("Finish");

    public JButton buttonForUp = new JButton("UP");
    public JButton buttonForDown = new JButton("DOWN");
    public JButton buttonForLeft = new JButton("LEFT");
    public JButton buttonForRight = new JButton("RIGHT");

    public JLabel space = new JLabel("");
    public JLabel space2 = new JLabel("");

    public JLabel input01 = new JLabel();
    public JLabel input02 = new JLabel();
    public JLabel input03 = new JLabel();
    public JLabel input04 = new JLabel();
    public JLabel input05 = new JLabel();
    public JLabel input06 = new JLabel();
    public JLabel input07 = new JLabel();
    public JLabel input08 = new JLabel();
    public JLabel input09 = new JLabel();
    public JLabel input10 = new JLabel();
    public JLabel input11 = new JLabel();
    public JLabel input12 = new JLabel();
    public JLabel input13 = new JLabel();
    public JLabel input14 = new JLabel();
    public JLabel input15 = new JLabel();
    public JLabel input16 = new JLabel();

    public GUI()
    {
        super("Tag Game");
        this.setBounds(100, 100 , 310,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6,4,2,2));

        container.add(input01);
        container.add(input02);
        container.add(input03);
        container.add(input04);
        container.add(input05);
        container.add(input06);
        container.add(input07);
        container.add(input08);
        container.add(input09);
        container.add(input10);
        container.add(input11);
        container.add(input12);
        container.add(input13);
        container.add(input14);
        container.add(input15);
        container.add(input16);

        container.add(space);
        container.add(buttonForUp);
        container.add(space2);
        container.add(buttonForStart);
        container.add(buttonForLeft);
        container.add(buttonForDown);
        container.add(buttonForRight);
        container.add(buttonForFinish);
    }

}
