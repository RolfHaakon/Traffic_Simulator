import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame implements ActionListener {
    private JPanel main;
    private boolean threadSuspended;
    private boolean firstStart = true;
    public int x = 0;


    public MainFrame(){
        super("Traffic Simulator");

//        this.timer = new Timer(1000/24,this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


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
        JButton refresh = new JButton("Refresh");
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        buttonPanel.add(refresh);
        buttonPanel.add(start);
        buttonPanel.add(stop);

        Main main = new Main();






//        PulseThread thread = new PulseThread();
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (threadSuspended){
                    threadSuspended = false;
                }
                MyThread thread = new MyThread();
                thread.start();
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                threadStop();
            }
        });

    }

    public void threadStop(){
        threadSuspended = true;
    }
    private class MyThread extends Thread {
        public void run(){
            while(true){
                x += 3;
                try{
                    Thread.sleep(100);

                    synchronized(this) {
                        while (threadSuspended)
                            wait();
                    }
                }catch(InterruptedException e){
                    System.exit(0);
                }
                repaint();
            }
        }
    }




    public void paint(Graphics g){
        super.paint(g);


        /** Paint Road */
        Roads roads = new Roads();

        for (int i = 0; i<roads.verticalRoadsRight.length; i++){
            g.setColor(Color.GRAY);
            g.drawLine(roads.verticalRoadsRight[i][0],roads.verticalRoadsRight[i][1],(roads.verticalRoadsRight[i][0]+roads.roadLength),roads.verticalRoadsRight[i][1]);
//            g.setColor(Color.WHITE);
//            g.fillRect(roads.verticalRoads[i][0],roads.verticalRoads[i][1]+22,roads.roadLength,roads.lineWidth);
        }

//        g.setColor(Color.GRAY);
//        g.fillRect(roads.verticalRoads[0][0],roads.verticalRoads[0][1],roads.roadLength,roads.roadWidth);
//        g.setColor(Color.WHITE);
//        g.fillRect(roads.verticalRoads[0][0],roads.verticalRoads[0][1]+22,roads.roadLength,roads.lineWidth);

        /** Paint Cars */
        g.setColor(Color.BLUE);
        g.fillRect(x, 385, 30, 15);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    /** Method for starting the simulation */
    public void startTime(){
        if (firstStart) {
            System.out.println("\nThe car will drive down Road 1, wait for the traffic light to turn green" +
                    "before continuing down road 2. After reaching the end of road 2 the car will start from the beginning\n");
//            this.timer = new Timer();
//            this.timer.schedule(new Pulse(),0,1000/24);
            firstStart = false;
        }
        else {
            resume();
        }
    }
    /** Method for pause the simulation */
    public void pause(){
//        this.timer.cancel();
    }
    /** Method for resuming the simulation */
    public void resume() {
//        this.timer = new Timer();
//        this.timer.schedule(new Pulse(),0,1000);
    }


}
