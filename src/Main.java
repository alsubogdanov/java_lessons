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



    public static void task0_1(){
        JFrame frame = getFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened");
                frame.setTitle("Application Started");
            }
        });
        frame.setVisible(true);
    }
    public static void task0_2(){
        JFrame frame = getFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Закрыть программу?"
                );

                if(result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        frame.setVisible(true);
    }
    public static void task0_3(){
        JFrame frame = getFrame();
        JPanel panel = new JPanel();
        frame.addWindowListener(new WindowAdapter() {


            @Override
            public void windowActivated(WindowEvent e) {
                panel.setBackground(Color.GREEN);

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                panel.setBackground(Color.GRAY);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
    public static void task0_4(){
        JFrame frame = getFrame();
        JPanel panel = new JPanel();
        AtomicInteger minimizedInt = new AtomicInteger(0);
        AtomicInteger restoredInt = new AtomicInteger(0);
        JLabel minimized = new JLabel("Minimized: 0");
        JLabel restored = new JLabel("Restored: 0");

        panel.add(minimized);
        panel.add(restored);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowIconified(WindowEvent e) {
                minimizedInt.incrementAndGet();
                minimized.setText("Minimized: " + minimizedInt.get());
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                restoredInt.incrementAndGet();
                restored.setText("Restored: "+restoredInt.get());
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
    public static void task0_5(){
        JFrame frame = getFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter your text");
        JTextArea textArea = new JTextArea(5, 20);

        panel.add(label);
        panel.add(textArea);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String text = textArea.getText();

                if (text.isEmpty()) {
                    frame.dispose();
                    return;
                }

                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Save changes before exit?"
                );

                if (result == JOptionPane.YES_OPTION) {

                    System.out.println("Saving file...");
                    System.out.println("File content:");
                    System.out.println(text);
                    System.out.println("Saved successfully!");

                    frame.dispose();

                } else if (result == JOptionPane.NO_OPTION) {
                    frame.dispose();
                }
                // CANCEL → ничего не делаем
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void task0_6(){
        JFrame frame = getFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Your logs:");
        JTextArea textArea = new JTextArea(5,30);
        textArea.setLineWrap(true); //переносит текст на новую строку
        textArea.setWrapStyleWord(true); // перенос по словам (а не по символам)

        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(label);
        panel.add(scrollPane);

        frame.add(panel);


        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                textArea.append("\nopened");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }

            @Override
            public void windowIconified(WindowEvent e) {
                textArea.append("\nminimized");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                textArea.append("\nrestored");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }

            @Override
            public void windowActivated(WindowEvent e) {
                textArea.append("\nactivated");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                textArea.append("\ndeactivated");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
        });
        frame.setVisible(true);
    }


    public static void task0_7(){
    }
    public static void task0_10(){
    }
    static JFrame getFrame(){
        JFrame frame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        toolkit.beep();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2-400, dimension.height/2-150, 800, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        frame.setVisible(true);
        return frame;
    }
    public static void task0_11(){


    }



    public static void main(String[] args) {

        task0_6();








    }

}
