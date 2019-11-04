import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficSimulation implements ActionListener, Runnable {
    private JFrame frame = new JFrame("Traffic Simulation");
    private Roads roads = new Roads();
    private JButton start = new JButton("Start");
    private JButton stop = new JButton("Stop");

    private boolean running = false;
    private int count = 0;



    private TrafficSimulation(){
        frame.setSize(1200,800);
        frame.setLayout(new BorderLayout());
        frame.add(roads, BorderLayout.CENTER);

        Container buttons = new Container();
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
    public void actionPerformed(ActionEvent actionEvent) { //Create thread
        if (actionEvent.getSource().equals(start)){
            if (!running){
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
    public void run() { //Use the thread to update the map
        while (running) {
            roads.move();
            eventHandler();
            frame.repaint();
            try {
                Thread.sleep(100);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    private void eventHandler() { //Change traffic light and spawn cars at some set rate
        count++;
        if (count == 80) {
            roads.lightChange();
            count = 0;
        }
        if (count % 50 == 0){
            roads.spawnCar();
        }
    }
}
