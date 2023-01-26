package ru.smirnov.tasks.task12_11.windows;

import ru.smirnov.tasks.task12_11.Logic;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JTextField textField;
    private JPanel panel;
    private JButton buttonExecute;
    private JTextArea textArea;

    public Window() {
        setTitle("task12_11");
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = dimension.width / 2;
        int height = dimension.height / 2;
        setBounds(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2, width, height);

        buttonExecute.addActionListener(e -> {
            try {
                int x = Integer.parseInt(textField.getText());
                textArea.setText(Logic.resultOutput(x));
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        });
    }
}
