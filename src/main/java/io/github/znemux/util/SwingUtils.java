package io.github.znemux.util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class SwingUtils {
    public static void showExceptionMessage(Component com, Exception ex) {
        JOptionPane.showMessageDialog(com, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
