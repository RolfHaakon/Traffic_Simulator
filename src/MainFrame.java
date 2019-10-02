import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
    private JLabel label;
    private JButton start, stop;
    private JPanel main, zone1, zone2,zone3,zone4,zone5,zone6,zone7,zone8,zone9;

    public MainFrame() {
        super("Traffic Simulator");

        /** Main layout */
        main = new JPanel(new GridLayout(3,3,5,5));
        main.setPreferredSize(new Dimension(800,600));

        zone1 = new JPanel();
        zone1.setBackground(Color.BLUE);
        zone2 = new JPanel();
        zone2.setBackground(Color.RED);
        zone3 = new JPanel();
        zone3.setBackground(Color.GREEN);
        zone4 = new JPanel();
        zone4.setBackground(Color.ORANGE);
        zone5 = new JPanel();
        zone5.setBackground(Color.BLUE);
        zone6 = new JPanel();
        zone6.setBackground(Color.BLACK);
        zone7 = new JPanel();
        zone7.setBackground(Color.BLUE);
        zone8 = new JPanel();
        zone8.setBackground(Color.WHITE);
        zone9 = new JPanel();
        zone9.setBackground(Color.YELLOW);

        add(main);
        main.add(zone1);
        main.add(zone2);
        main.add(zone3);
        main.add(zone4);
        main.add(zone5);
        main.add(zone6);
        main.add(zone7);
        main.add(zone8);
        main.add(zone9);





        /** Button panel  */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(1200,100));
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setLayout(new GridLayout(1,2));
        add(buttonPanel, BorderLayout.SOUTH);

        /** Start and stop buttons  */
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        buttonPanel.add(start);
        buttonPanel.add(stop);

        Main main = new Main();
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main.start();
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main.pause();
            }
        });




//        label = new JLabel("Hello");
//        add(label);
//        label.setPreferredSize(new Dimension(1200,800));
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }



}
