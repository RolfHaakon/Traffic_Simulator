import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class test extends JFrame implements ActionListener{
    public int x = 20 ,direction = 1;

    public test(){
        setSize(400, 200);
        setTitle("Moving Car");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JButton move = new JButton("Move the car");
        move.addActionListener(this);
        add(move , BorderLayout.SOUTH);
        setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(x, 80, 80, 50);
        g.drawOval(x, 130, 30, 30);
        g.drawOval(x+50, 130, 30, 30);
    }
    public void actionPerformed(ActionEvent e){
        MyThread ex = new MyThread();
        ex.start();
    }



    private class MyThread extends Thread {
        public void run(){
            while(true){
                if(x >= getWidth()-70)
                    direction = -1;
                else if (x <= 0)
                    direction = 1 ;
                x += direction *10;

                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    System.exit(0);
                }
                repaint();
            }
        }
    }



    public static void main(String []args){
        new test();

    }
}
