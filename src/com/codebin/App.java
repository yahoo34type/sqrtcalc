package com.codebin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class App {
    private JButton calculate;
    private JPanel panelMain;
    private JLabel result;
    private JTextField number;
    private JComboBox Language;
    private JButton instruction;

    public App() {
        Language.addItem("Русский");
        Language.addItem("English");
        Language.addItem("中國");
        Language.addItem("Espanol");
        number.setText("0");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num_string = number.getText();
                int n = num_string.length();
                double num_double = 0;
                boolean check = true;
                for (int i = 0; i < n; i++) {
                    if (num_string.charAt(i) >= '0' && num_string.charAt(i) <= '9' || num_string.charAt(i) == '.' || num_string.charAt(i) == 'e' || num_string.charAt(i) == '-') {
                    } else {
                        check = false;
                        switch (Language.getSelectedIndex()) {
                            case 0:
                                result.setText("Ошибка");
                                break;
                            case 1:
                                result.setText("Error");
                                break;
                            case 2:
                                result.setText("一個錯誤");
                                break;
                            case 3:
                                result.setText("Un error");
                                break;
                        }
                        break;
                    }

                }
                try {
                    num_double = Double.parseDouble(num_string);
                } catch (Exception e1) {
                    check = false;
                    switch (Language.getSelectedIndex()) {
                        case 0:
                            result.setText("Ошибка");
                            break;
                        case 1:
                            result.setText("Error");
                            break;
                        case 2:
                            result.setText("一個錯誤");
                            break;
                        case 3:
                            result.setText("Un error");
                            break;
                    }
                }
                if (check && num_double >= 0)
                    result.setText(Double.toString(Math.sqrt(num_double)));
                else if (check && num_double <= 0) {
                    result.setText("±" + Double.toString(Math.sqrt(Math.abs(num_double))) + "*i");
                }
            }
        });
        Language.addActionListener(new

                                           ActionListener() {
                                               @Override
                                               public void actionPerformed(ActionEvent e) {
                                                   switch (Language.getSelectedIndex()) {
                                                       case 0:
                                                           calculate.setText("Вычислить");
                                                           result.setText("Результат");
                                                           instruction.setText("Инструкция");
                                                           break;
                                                       case 1:
                                                           calculate.setText("Calculate");
                                                           result.setText("Result");
                                                           instruction.setText("Instruction");
                                                           break;
                                                       case 2:
                                                           calculate.setText("計算");
                                                           result.setText("結果");
                                                           instruction.setText("使用说明书");
                                                           break;
                                                       case 3:
                                                           calculate.setText("Calcular");
                                                           result.setText("Resultado");
                                                           instruction.setText("Manual de instrucciones");
                                                           break;
                                                   }

                                               }
                                           });
        instruction.addActionListener(new

                                              ActionListener() {
                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      switch (Language.getSelectedIndex()) {
                                                          case 0:
                                                              JOptionPane.showMessageDialog(null, "Инструкция по пользованию калькулятором.\n" +
                                                                      "Калькулятор вычисляет квадратный корень числа. Запись числа производится в текстовое поле. Число может быть как целым, так и вещественным, а так же калькулятор выведет результат для отрицательного значения корня. Правильная запись выглядит 123 или  123.4 или 123.4e5 или -12.3 Между целой и вещественной частью числа обязательно должна стоять точка, несколько точек в числе быть не должно, как и нескольких e(eps).\n");
                                                              break;
                                                          case 1:
                                                              JOptionPane.showMessageDialog(null, "Instructions for using the calculator.\n" +
                                                                      "The calculator calculates the square root of a number. The number is written in the text box. The number can be either integer or real, and the calculator will also output the result for a negative root value. The correct entry looks like 123 or 123.4 or 123.4e5 or -12.3 There must be a dot between the integer and the real part of the number, several points in the number should not be, as well as several e (eps).");
                                                              break;
                                                          case 2:
                                                              JOptionPane.showMessageDialog(null, "使用计算器的说明。\n" +
                                                                      "计算器计算数字的平方根。 该数字将写在文本框中。 该数字可以是整数，也可以是实数，并且计算器还将为负根值输出结果。 正确的输入看起来像123或123.4或123.4e5或-12.3。在整数和数字的实数部分之间必须有一个点，数字中不应有几个点，以及几个e（eps）。");
                                                              break;
                                                          case 3:
                                                              JOptionPane.showMessageDialog(null, "nstrucciones para usar la calculadora.\n" +
                                                                      "La calculadora calcula la raíz cuadrada de un número. El número está escrito en el cuadro de texto. El número puede ser entero o real, y la calculadora también generará el resultado para un valor raíz negativo. La entrada correcta se parece a 123 o 123.4 o 123.4e5 o -12.3 Debe haber un punto entre el número entero y la parte real del número, varios puntos en el número no deberían estar, así como varios e (eps).");
                                                              break;
                                                      }
                                                  }
                                              });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Калькулятор квадратного корня");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        calculate = new JButton();
        calculate.setText("Вычислить");
        panelMain.add(calculate, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        result = new JLabel();
        result.setText("Результат");
        panelMain.add(result, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        number = new JTextField();
        number.setText("");
        panelMain.add(number, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        Language = new JComboBox();
        Language.setActionCommand("comboBoxChanged");
        Language.setToolTipText("");
        Language.setVerifyInputWhenFocusTarget(false);
        panelMain.add(Language, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        instruction = new JButton();
        instruction.setText("Инструкция");
        panelMain.add(instruction, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}

