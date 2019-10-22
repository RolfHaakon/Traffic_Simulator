import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficSimulation implements ActionListener, Runnable {
    String fileName = "Untitled";
    JFrame frame = new JFrame("Traffic Simulation");
    Roads roads = new Roads();
    JButton start = new JButton("Start");
    JButton stop = new JButton("Stop");
    Container buttons = new Container();

    boolean running = false;
    static boolean xTL = false;
    int count = 0;



    public TrafficSimulation(){
        frame.setSize(1200,800);
        frame.setLayout(new BorderLayout());
        frame.add(roads, BorderLayout.CENTER);

        buttons.setLayout(new GridLayout(1,2));
        buttons.add(start);
        start.addActionListener(this);
        buttons.add(stop);
        stop.addActionListener(this);
        frame.add(buttons, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        roads.initDraw(); //Initial map

        frame.repaint();


    }

    public static void main(String[] args) {
        new TrafficSimulation();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(start)){
            if (running == false){
                running = true;
                Thread thread = new Thread(this);
                thread.start();
            }
        }
        if (actionEvent.getSource().equals(stop)){
            running = false;
        }
    }

    @Override
    public void run() {
        while (running == true) {
            roads.move();
            TLchange();
            frame.repaint();
            try {
                Thread.sleep(100);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void TLchange() {
        count++;
        if (count == 70) {
            roads.lightChange();
            System.out.println("TLCHANGE");
            count = 0;
        }
    }

}
