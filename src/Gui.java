import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
/***
 * Gui
 *
 * @author Alina Halmesalo Sundberg
 * @version 1.0
 */

public class Gui implements ActionListener {
    private JFrame window;
    private JPanel panel;
    private JTextField resultField;
    private CalculatorHandler calculatorHandler;

    public Gui(){
        calculatorHandler = new CalculatorHandler();
        createGuiWindow();
        createResultField();
        createButtons();

        this.window.show();
    }

    public void createGuiWindow(){
        this.window = new JFrame("Alina's Calculator");
        this.window.setSize(200,220);
        this.panel = new JPanel();
        this.panel.setBackground(Color.lightGray);
        this.window.add(this.panel);
    }

    public void createResultField(){
        this.resultField = new JTextField(16);
        this.resultField.setEditable(false);
        this.panel.add(this.resultField);
    }

    public void createButtons(){
        List<String> buttonNamesList = Arrays.asList("+", "-", "*", "/", "=",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "C");
        for(String buttonName: buttonNamesList){
            JButton tempButton = new JButton(buttonName);
            tempButton.addActionListener(this);
            this.panel.add(tempButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String clickedButton = e.getActionCommand();
        calculatorHandler.setCountedNumber(clickedButton);
        resultField.setText(calculatorHandler.getCountedNumber());
    }
}
