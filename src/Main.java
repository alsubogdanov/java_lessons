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
        JPanel panel = new JPanel();
        JButton button = new JButton("Click me");
        button.addActionListener(e -> {
            button.setText("Clicked");
            System.out.println("Button was clicked");
        });
        panel.add(button);
        frame.add(panel);

        frame.setVisible(true);
    }

    public static void task0_2() {
        JFrame frame = getFrame();
        JPanel jPanel = new JPanel();
        frame.add(jPanel);

        ColorAction colorAction = new ColorAction(jPanel);

        JButton jButton = new JButton(colorAction);
        jButton.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton.setHorizontalAlignment(SwingConstants.RIGHT);


        JButton jButton1 = new JButton(new MyAction());
        jPanel.add(jButton);
        jPanel.add(jButton1);

        frame.setJMenuBar(createMenuBar(jPanel, colorAction));
        frame.setVisible(true);
    }

    public static void task0_3() {
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

    public static void task0_4() {
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
                restored.setText("Restored: " + restoredInt.get());
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void task0_5() {
        JFrame frame = getFrame();

        Action a = new MyAction();
        a.setEnabled(false);
        JPanel panel = new JPanel();

        JButton button = new JButton(a);
        panel.add(button);


        frame.add(panel);
        frame.setVisible(true);
    }

    public static void task0_6() {

    }


    public static void task0_7() {
    }

    public static void task0_10() {
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

    static JMenuBar createMenuBar(JPanel panel, Action colorAction) {
        JMenuBar jMenuBar = new JMenuBar();

/* =========================
   MAIN MENUS (File, Edit)
   ========================= */
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

// Mnemonic для быстрого доступа через Alt
        file.setMnemonic('F'); // Alt + F
        edit.setMnemonic('E'); // Alt + E

        jMenuBar.add(file);
        jMenuBar.add(edit);

/* =========================
   FILE MENU ITEMS
   ========================= */

// Open
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(e -> System.out.println("open"));
        file.add(open);

// Save (disabled пример)
        JMenuItem save = new JMenuItem("Save");
        file.add(save);
// Change
        JMenuItem changeColor = new JMenuItem(colorAction);
        changeColor.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
        file.add(changeColor);


/* =========================
   EDIT MENU ITEMS
   ========================= */

// простые команды
        edit.add(new JMenuItem("Cut"));
        edit.add(new JMenuItem("Copy"));
        return jMenuBar;
    }

    public static void main(String[] args) {

        task0_2();

    }
    static class MyAction extends AbstractAction {
        Icon icon = new ImageIcon(getClass().getResource("/icons/1.jpeg"));
        public MyAction(){
            putValue(Action.NAME, "Save");
            putValue(Action.SHORT_DESCRIPTION, "Save file");
            putValue(Action.SMALL_ICON, icon);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action executed");
        }
    }
    static class ColorAction extends AbstractAction {
        private JPanel panel;
        public ColorAction(JPanel panel){
            this.panel=panel;

            ImageIcon  icon = new ImageIcon(getClass().getResource("/icons/change.png"));
            Image img = icon.getImage();
            Image scaled = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

            Icon smallIcon = new ImageIcon(scaled);

            putValue(Action.NAME, "Change color");
            putValue(Action.SHORT_DESCRIPTION, "Change color");
            putValue(Action.SMALL_ICON, smallIcon);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.CYAN);
            System.out.println("Action executed");
        }
    }

}
