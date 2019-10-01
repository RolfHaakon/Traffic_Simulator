import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
    private JLabel label;
    private JButton start, stop;

    public MainFrame() {
        super("MainFrame");

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




        label = new JLabel("Hello");
        add(label);
        label.setPreferredSize(new Dimension(1200,800));
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }



}
