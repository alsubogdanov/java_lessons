import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.border.EmptyBorder;

public class Main {


    public static void task0_1(){

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());

        JTextField text1 = new JTextField(20);
        JButton bAdd = new JButton("add");
        JButton bDel = new JButton("delete");

        frame.add(text1);
        frame.add(bAdd);
        frame.add(bDel);


        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void task0_2(){
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        frame.add(new JButton("Top"), BorderLayout.NORTH);
        frame.add(new JButton("Bottom"), BorderLayout.SOUTH);
//        frame.add(new JButton("Left"), BorderLayout.WEST);
//        frame.add(new JButton("Right"), BorderLayout.EAST);
        frame.add(new JTextField(20), BorderLayout.CENTER);

        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void task0_3(){

    }
    public static void task0_4(){
        JFrame frame = new JFrame();
        Font font = new Font("NSimSun", Font.BOLD, 20);
        frame.setLayout(new BorderLayout(10,20));

        //NORTH
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(60,10,10,10));

        JLabel title = new JLabel("Login System", SwingConstants.RIGHT);
//        title.setBorder(new EmptyBorder(0,0,0,20));
        title.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(title,BorderLayout.NORTH);

        //CENTER
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());


        JLabel username = new JLabel("Username");
        JTextField text = new JTextField(10);
        JLabel passLabel = new JLabel("password");
        JPasswordField pass = new JPasswordField(10);
        JButton loginBtn = new JButton("Login");
        centerPanel.add(username);
        centerPanel.add(text);
        centerPanel.add(passLabel);
        centerPanel.add(pass);
        centerPanel.add(loginBtn);

        //SOUTH
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        southPanel.setBorder(new EmptyBorder(10,10,30,10));

        JLabel bottomText = new JLabel("Status: Not logged in");
        southPanel.add(bottomText);


        //task#0_6
        //EAST
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(3,2, 20,0));
        eastPanel.setBorder(new EmptyBorder(10,10,10,10));
//        eastPanel.setPreferredSize(new Dimension(200, frame.getHeight()));

        JLabel[] arrLabels = {
                new JLabel("Server"),
                new JLabel("ActiveActive"),
                new JLabel("Users"),
                new JLabel("5"),
                new JLabel("Mode"),
                new JLabel("Admin")
        };
        for(JLabel item: arrLabels){
            eastPanel.add(item);
        }

        //task#0_7
        //WEST
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(2,1,20,10));
        JButton upBtn = new JButton("Up");
        JButton downBtn = new JButton("Down");
        westPanel.add(upBtn);
        westPanel.add(downBtn);



        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(westPanel, BorderLayout.WEST);




        Toolkit toolkit = Toolkit.getDefaultToolkit();
        toolkit.beep();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2-400, dimension.height/2-150, 800, 300);

        frame.setSize(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void task0_5(){
    }
    public static void task0_6(){
    }
    public static void task0_7(){
    }
    public static void task0_10(){
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton btn = new JButton("submit");
        jPanel.add(btn);

        //EventHandler
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setTitle(((JButton)e.getSource()).getText());
                jPanel.setBackground(Color.RED);
            }
        });

    }
    static JFrame getFrame(){
        JFrame frame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        toolkit.beep();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2-400, dimension.height/2-150, 800, 300);

        frame.setSize(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }
    public static void task0_11(){

        JFrame jFrame = getFrame();
        JPanel menu=new JPanel();
        menu.setLayout(new BoxLayout(menu,BoxLayout.Y_AXIS));


        JButton b1 = new JButton("Home");
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b2 = new JButton("Profile");
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b3 = new JButton("Settings");
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(b1);
        menu.add(b2);
//        menu.add(Box.createVerticalStrut(20));
        menu.add(b3);
        menu.add(new JButton("Logout"));


        jFrame.add(menu);
        jFrame.setVisible(true);


    }



    public static void main(String[] args) {
//        task0_2();
//        task0_4();
//        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//        for(String item: fonts){
//            System.out.println(item);
//        }

        task0_11();



    }
}
