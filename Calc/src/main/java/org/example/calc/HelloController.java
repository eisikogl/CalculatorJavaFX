package org.example.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.util.Objects;

public class HelloController {
    private double num1 = 0;
    private String operator = "";
    private boolean startOfNumber = true;

    @FXML
    private Label historyLabel;
    @FXML
    private TextField display;

    @FXML
    protected void handleNumberClick(ActionEvent event)
    {
        String value = ((Button)event.getSource()).getText();
        String currentText = display.getText();
        if (startOfNumber || currentText.equals("0")) {
            display.setText(value);
            if(currentText.equals("0"))
                historyLabel.setText(value);
            else
                historyLabel.setText(historyLabel.getText() + value);
            startOfNumber = false;
        } else {
            historyLabel.setText(historyLabel.getText() + value);
            display.setText(currentText + value);
        }
    }

    @FXML
    protected void handleOperatorClick(ActionEvent event)
    {
        // If an operator is already set, do nothing.
        // This prevents chaining like "5 + 5 *"
        if (!operator.isEmpty()) {
            return;
        }

        operator = ((Button) event.getSource()).getText();
        String currentText = display.getText();
        historyLabel.setText(historyLabel.getText()+operator);
        num1 = Double.parseDouble(currentText);
        startOfNumber = true;
    }

    @FXML
    protected void handleClearClick(ActionEvent event)
    {
        num1 = 0;
        operator = "";
        startOfNumber = true;
        display.setText("0");
        historyLabel.setText("");
    }


    @FXML
    protected void handleEqualsClick(ActionEvent event)
    {
        double num2 = Double.parseDouble(display.getText());
        double store = num1;
        if(Objects.equals(operator, "*"))
            store = store * num2;
        else if(Objects.equals(operator, "/"))
            store = store / num2;
        else if(Objects.equals(operator, "+"))
            store = store + num2;
        else if(Objects.equals(operator, "-"))
            store = store - num2;
        startOfNumber = true;
        if (store == (long) store) {
            display.setText(String.valueOf((long) store));
        } else {
            display.setText(String.valueOf(store));
        }
    }


}



