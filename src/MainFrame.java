import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JPanel main;
    MoveTraffic moveTraffic = new MoveTraffic();

    public MainFrame(){
        super("Traffic Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main = new JPanel();
        setLayout(new BorderLayout());
        main.setPreferredSize(new Dimension(1200,800));
        main.setBackground(new Color(124,252,0));
        add(main);
        pack();


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
    }

    public void paint(Graphics g){
        super.paint(g);
        System.out.println("PAINT");

        /** Paint Road */
        Roads roads = new Roads();

        for (int i=0; i<roads.verticalRoads.length; i++){
            g.setColor(Color.GRAY);
            g.fillRect(roads.verticalRoads[i][0],roads.verticalRoads[i][1],roads.roadLength,roads.roadWidth);
            g.setColor(Color.WHITE);
            g.fillRect(roads.verticalRoads[i][0],roads.verticalRoads[i][1]+22,roads.roadLength,roads.lineWidth);
        }

//        g.setColor(Color.GRAY);
//        g.fillRect(roads.verticalRoads[0][0],roads.verticalRoads[0][1],roads.roadLength,roads.roadWidth);
//        g.setColor(Color.WHITE);
//        g.fillRect(roads.verticalRoads[0][0],roads.verticalRoads[0][1]+22,roads.roadLength,roads.lineWidth);

        /** Paint Cars */
        System.out.println(moveTraffic.getX());
        g.setColor(Color.BLUE);
        g.fillRect(moveTraffic.getX(), 385, 30, 15);

    }
}
