package com.formpackage;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javax.swing.*;

public class GlobalKeyListener implements NativeKeyListener {
    private JTextField textField1;

    public GlobalKeyListener(JTextField jtxt){
        this.textField1=jtxt;
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_F2) {
            System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
            new Controller().execute(textField1.getText(), false);
        }
    }
}