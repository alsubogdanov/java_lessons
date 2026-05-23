import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.border.EmptyBorder;

public class Main {
//    static JFrame jFrame = getFrame();
//    static JPanel jPanel = new JPanel();


    public static void task0_1() {
        JFrame frame = getFrame();
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("0");
        jPanel.add(jLabel);
        jPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int count = Integer.parseInt(jLabel.getText());
                jLabel.setText(count+1+"");
            }
        });

        frame.add(jPanel);

        frame.setVisible(true);
    }

    public static void task0_2() {
        JFrame frame = getFrame();
        JPanel jPanel = new JPanel();
        jPanel.addMouseListener(new MouseAdapter() {


            @Override
            public void mouseEntered(MouseEvent e) {
                jPanel.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanel.setBackground(Color.WHITE);
            }
        });

        frame.add(jPanel);

        frame.setVisible(true);
    }

    public static void task0_3() {
        JFrame frame = getFrame();
        JPanel panel = new JPanel();
//
        JLabel label = new JLabel("0");
        JButton button = new JButton("Click me");
        panel.add(label);
        panel.add(button);

        button.addActionListener(e->{
            int count = Integer.parseInt(label.getText());
            label.setText(count+1+"");
        });
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setText("Hovering");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setText("Click me");
            }
        });


        frame.add(panel);
        frame.setVisible(true);
    }

    public static void task0_4() {
        JFrame frame = getFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("0");

        panel.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int count = Integer.parseInt(label.getText());
                int rotation = e.getWheelRotation();
                label.setText(count-rotation+"");
            }
        });
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void task0_5() {

        JFrame frame = getFrame();

        JPanel panel = new JPanel();

        JLabel label = new JLabel("State: ");

        panel.add(label);

        panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                label.setText("State: PRESSED");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                label.setText("State: RELEASED");
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {

                label.setText("State: DRAGGING");
            }
        });

        frame.add(panel);

        frame.setVisible(true);
    }



    static JFrame getFrame() {
        JFrame frame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        toolkit.beep();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 400, dimension.height / 2 - 150, 800, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



//        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args) {

        task0_5();

    }

}
