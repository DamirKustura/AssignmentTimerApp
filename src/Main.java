import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static LocalTime count = LocalTime.now();
    static Timer timer;
    JFrame frame = new JFrame("Assignment - Damir");
    JButton start = new JButton("Start");
    JButton stop = new JButton("Stop");
    JButton restart = new JButton("Restart");
    JButton colorCh = new JButton("Choose color: ");
    JLabel l = new JLabel("LocalTime is: ");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    ImageIcon image = new ImageIcon("icon.png");


    Main(){

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        l.setText("LocalTime is: " + LocalTime.now().format(dtf));
                    }
                });
                timer.start();
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        colorCh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color backgroundcolor = JColorChooser.showDialog(null, "Choose color: ", Color.RED);

                if(backgroundcolor != null){
                    l.setForeground(backgroundcolor);
                }
            }
        });

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timer.isRunning()){
                    timer.stop();
                }
                l.setText("Localtime: " + LocalTime.now().format(dtf));
            }
        });

        start.setBounds(20, 100, 130,40);
        stop.setBounds(230,100,130,40);
        restart.setBounds(20,150,130,40);
        l.setBounds(120,30,150,100);
        l.setFont(new Font("MV Boli",Font.PLAIN,12));
        colorCh.setBounds(230,150,130,40);

        frame.add(start);
        frame.add(stop);
        frame.add(restart);
        frame.add(colorCh);
        frame.add(l);
        frame.setLayout(null);
        frame.setSize(400,350);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(123, 50, 250));
        frame.setIconImage(image.getImage());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Welcome to Timer App");



        Object[] options = {"Settings", "Close"};
        int opt = JOptionPane.showOptionDialog(f, "Choose option: ", "Welcome to timer app",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(opt == JOptionPane.YES_OPTION){
            new Main();
        }
        if(opt == JOptionPane.NO_OPTION){
            System.exit(0);
        }
    }




}
