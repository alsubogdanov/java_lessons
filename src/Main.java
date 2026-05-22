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
        panel.setFocusable(true);


        JButton button = new JButton("Click me");

        KeyStroke keyStroke = KeyStroke.getKeyStroke("SPACE");

        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, "changeColor");

        ActionMap actionMap = panel.getActionMap();

        Action action = new ColorAction(panel);

        actionMap.put("changeColor", action);


        panel.add(button);
        frame.add(panel);

        frame.setVisible(true);
        panel.requestFocusInWindow();
    }

    public static void task0_2() {
        JFrame frame = getFrame();
        JPanel panel = new JPanel();

        KeyStroke keyStrokeRed = KeyStroke.getKeyStroke("ctrl  R");
        KeyStroke keyStrokeGreen = KeyStroke.getKeyStroke("ctrl  G");

        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStrokeRed, "changeColorRed");
        inputMap.put(keyStrokeGreen, "changeColorGreen");

        ActionMap actionMap = panel.getActionMap();

        Action actionRed = new ChangeColorAction(panel,"RED");
        Action actionGreen = new ChangeColorAction(panel,"GREEN");

        actionMap.put("changeColorRed", actionRed);
        actionMap.put("changeColorGreen", actionGreen);


        frame.add(panel);

        frame.setVisible(true);
    }

    public static void task0_3() {
        JFrame frame = getFrame();
        JPanel panel = new JPanel();
//        panel.setFocusable(true);
        JLabel label = new JLabel("0");
        panel.add(label);


        KeyStroke keyStroke = KeyStroke.getKeyStroke("SPACE");

        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, "counter inc");

        ActionMap actionMap = panel.getActionMap();
        Action action = new CounterAction(label);
        actionMap.put("counter inc", action);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void task0_4() {
        JFrame frame = getFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        JTextArea textArea=new JTextArea(5, 10);
        textArea.setLineWrap(true); //переносит текст на новую строку
        textArea.setWrapStyleWord(true); // перенос по словам (а не по символам)
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);


        bindKey(panel, "ctrl S", "save and print", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                System.out.println("Text: "+ text);
            }
        });
        bindKey(panel, "ESCAPE", "clear", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        bindKey(panel, "ctrl L", "change bg", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.WHITE);
            }
        });


        frame.add(panel);
        frame.setVisible(true);
    }

    public static void task0_5() {

        JFrame frame = getFrame();
        JPanel panel = new JPanel();

        //TextArea
        JTextArea textArea=new JTextArea(5, 10);
        textArea.setLineWrap(true); //переносит текст на новую строку
        textArea.setWrapStyleWord(true); // перенос по словам (а не по символам)

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        //Action
        Action clear = new ClearAction(textArea);
        JMenuBar menuBar = createMenuBar(panel, clear);
        frame.setJMenuBar(menuBar);

        //Btn
        JButton button=new JButton(clear);
        panel.add(button);


        bindKey(panel, "ctrl L", "clearText", clear);


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

    static JMenuBar createMenuBar(JPanel panel, Action action) {
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
        JMenuItem clear = new JMenuItem(action);
        clear.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
        file.add(clear);


/* =========================
   EDIT MENU ITEMS
   ========================= */

// простые команды
        edit.add(new JMenuItem("Cut"));
        edit.add(new JMenuItem("Copy"));
        return jMenuBar;
    }

    static void bindKey(JComponent component, String key, String actionName, Action action) {

        KeyStroke keyStroke = KeyStroke.getKeyStroke(key);

        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, actionName);

        ActionMap actionMap = component.getActionMap();
        actionMap.put(actionName, action);
    }
    public static void main(String[] args) {

        task0_5();

    }
    static class CounterAction extends AbstractAction {
        private JLabel counter;
        public CounterAction(JLabel counter){
            this.counter=counter;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            counter.setText(Integer.parseInt(counter.getText())+1+"");
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
    static class ChangeColorAction extends AbstractAction {
        private JPanel panel;
        private String color;
        public ChangeColorAction(JPanel panel, String color){
            this.panel=panel;
            this.color=color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("sdf");
            switch (color){
                case "RED"->panel.setBackground(Color.RED);
                case "GREEN"->panel.setBackground(Color.GREEN);
            }
        }
    }
    static class ClearAction extends AbstractAction {
        private JTextArea textArea;
        public ClearAction(JTextArea textArea){
            this.textArea=textArea;
            putValue(NAME, "Clear");
            putValue(SHORT_DESCRIPTION, "Clear textarea");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
        }
    }

}
