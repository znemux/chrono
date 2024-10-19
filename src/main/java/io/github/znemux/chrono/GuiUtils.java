package io.github.znemux.chrono;

import java.awt.Component;
import javax.swing.JOptionPane;

public class GuiUtils {
    public static void showExceptionMessage(Component com, Exception ex) {
        JOptionPane.showMessageDialog(com, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
