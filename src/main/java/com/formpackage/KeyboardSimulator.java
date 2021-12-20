package com.formpackage;
import com.github.kwhat.jnativehook.GlobalScreen;
import javax.swing.*;
import java.awt.event.*;

public class KeyboardSimulator extends JFrame{
    private JTextField textField1;
    private JButton executeButton;
    private JPanel panelMain;

    public KeyboardSimulator() {
        executeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Controller().execute(textField1.getText(), true);
            }
        });
    }

    public void keyListener(){
        try{
            GlobalScreen.registerNativeHook();
        }catch (Exception e){
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener(this.textField1));
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("KeyboardSimulator");
        KeyboardSimulator kbs = new KeyboardSimulator();
        jFrame.setContentPane(kbs.panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        kbs.keyListener();
    }
}