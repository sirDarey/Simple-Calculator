/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author USER
 */
public class Controller {
  @FXML
    private TextField inputScreen;
    
    @FXML
    private Label labelWorkings;
    
    private double x = 0, y = 0, ans = 0; 
    private int status = 1, recur = 0, saveLastEntry = 1;
    private String operator = "";   

    @FXML
    private void screenKeyEvent(KeyEvent event) {
        event.consume();
    }
    
    private Double otherOperations () {
        recur = 0; status = 1;
        x = Double.parseDouble(inputScreen.getText());
        return x;
    }

    @FXML
    private void ClickedPercent(ActionEvent event) {
        inputScreen.setText(String.valueOf(otherOperations ()/100));
        labelWorkings.setText(String.valueOf(x) +"% =");
        x = Double.parseDouble(inputScreen.getText());
    }

    @FXML
    private void ClickedClear(ActionEvent event) {
        x = 0; y = 0; ans = 0; status = 1; recur = 0; saveLastEntry = 1;
        labelWorkings.setText("0");
        inputScreen.setText("0");
    }
    
   
    @FXML
    private void ClickedInverse(ActionEvent event) {     
        otherOperations();
        inputScreen.setText(String.valueOf(1/otherOperations ()));
        labelWorkings.setText("1/"+String.valueOf(x) +" =");
        x = Double.parseDouble(inputScreen.getText());
    }

    @FXML
    private void ClickedSquareRoot(ActionEvent event) {
        otherOperations();
        inputScreen.setText(String.valueOf(Math.sqrt(otherOperations ())));
        labelWorkings.setText("√"+String.valueOf(x) +" =");
        x = Double.parseDouble(inputScreen.getText());
    }

    @FXML
    private void ClickedSquare(ActionEvent event) {
        otherOperations();
        inputScreen.setText(String.valueOf(Math.pow(otherOperations (), 2)));
        labelWorkings.setText("sqr("+String.valueOf(x) +") =");
        x = Double.parseDouble(inputScreen.getText());
    }

    @FXML
    private void ClickedDivide(ActionEvent event) {
        doOperation(operator);
        operator = "/";
        labelWorkings.setText(x +" / ");
    }

    @FXML
    private void ClickedTImes(ActionEvent event) {
        doOperation(operator);            
        operator = "*";
        labelWorkings.setText(x +" * ");
        
    }

    @FXML
    private void ClickedMinus(ActionEvent event) {
        doOperation(operator);            
        operator = "-";
        labelWorkings.setText(x +" - ");
    }
    
     @FXML
    private void ClickedPlus(ActionEvent event) {
        doOperation(operator);
        operator = "+";
        labelWorkings.setText(x +" + ");
    }

    @FXML
    private void ClickedEquals(ActionEvent event) {
        recur = 1;
        doOperation(operator);
        labelWorkings.setText(x +" = ");
    } 
    
    
    private void getNumEntry (String num) {
        recur = 1; saveLastEntry = 1;
        
        if (status ==1) {
            inputScreen.setText(num);
            status = 0;
        }else {
            inputScreen.setText(inputScreen.getText()+num);
        }
    }
    
    private void doOperation (String operator) {
       
        status = 1;
        
        if (x == 0) {
            x = Double.parseDouble(inputScreen.getText());
        } else {
            if (recur ==1) {
                if (saveLastEntry ==  1) {
                    y = Double.parseDouble(inputScreen.getText());
                    saveLastEntry = 0;
                }
                
                switch (operator) {
                    case "+" : 
                        ans = x + y; 
                        inputScreen.setText(String.valueOf(ans)); break; 
                    case "-" : 
                        ans = x - y; 
                        inputScreen.setText(String.valueOf(ans)); break;
                    case "*" : 
                        ans = x * y; 
                        inputScreen.setText(String.valueOf(ans)); break;
                    case "/" :  
                        if (y == 0) {
                            inputScreen.setText("Math Error");
                            ans = 0; status = 1; y = 0; saveLastEntry = 1; break;
                        } else {
                            ans = x / y; 
                            inputScreen.setText(String.valueOf(ans));break;
                        }
                }
                
                x = ans;
                recur = 0;
            }      
        } 
    }
   
    
    @FXML
    private void Clicked1(ActionEvent event) {
        getNumEntry("1");
    }

    @FXML
    private void Clicked2(ActionEvent event) {
        getNumEntry("2");
    }

    @FXML
    private void Clicked3(ActionEvent event) {
        getNumEntry("3");
    }
    
    @FXML
    private void Clicked4(ActionEvent event) {
        getNumEntry("4");
    }

    @FXML
    private void Clicked5(ActionEvent event) {
        getNumEntry("5");
    }

    @FXML
    private void Clicked6(ActionEvent event) {
        getNumEntry("6");
    }

    @FXML
    private void Clicked7(ActionEvent event) {
        getNumEntry("7");
    }

    @FXML
    private void Clicked8(ActionEvent event) {
        getNumEntry("8");
    }

    @FXML
    private void Clicked9(ActionEvent event) {
        getNumEntry("9");
    }

    @FXML
    private void Clicked0(ActionEvent event) {
        getNumEntry("0");
    }

    @FXML
    private void ClickedDecimal(ActionEvent event) {
        getNumEntry(".");
    }

    @FXML
    private void ClickedBackSpace(ActionEvent event) {
        String value = inputScreen.getText();
        int length = inputScreen.getText().length()-1;
        
        if (length>0) 
            value = value.substring(0, length);
        else {
            value = "0";
            status = 1;
        }
        
        inputScreen.setText(value);
    }
   
}
