package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.text.DecimalFormat;

public class Controller {

    private double bmi;
    private double height;
    private double weight;
    DecimalFormat df = new DecimalFormat("#.0") ;

    @FXML
    private Label BMI;

    @FXML
    private TextField inputWeight;

    @FXML
    private TextField inputHeight;

    @FXML
    private Button button;

    @FXML
    private ImageView image;

    @FXML
    private Label BMIName;

    @FXML
    void initialize() {
        onlyNumber(inputWeight);
        onlyNumber(inputHeight);
   }

    private void onlyNumber(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }



    @FXML
    private void handleOnCalculate (final ActionEvent event) {
        calculate();
    }

    private void calculate() {
        if (!inputHeight.getText().isBlank() & !inputWeight.getText().isBlank())  {
            weight = Double.valueOf(inputWeight.getText());
            height = Double.valueOf(inputHeight.getText())/100;
            bmi =  weight/(height*height);
            BMI.setText(String.valueOf(df.format(bmi)));
            if (bmi < 18.5){BMIName.setText("Underweight"); image.setImage(new Image("https://thumbs.dreamstime.com/b/tall-guy-4207406.jpg"));}
            if (bmi >= 18.5 & bmi < 25){BMIName.setText("Normal weight"); image.setImage(new Image("https://st2.depositphotos.com/5178011/11602/v/950/depositphotos_116025908-stock-illustration-healthy-guy-eating-some-fruit.jpg"));}
            if (bmi >= 25 & bmi < 30){BMIName.setText("Overweight"); image.setImage(new Image("https://t4.ftcdn.net/jpg/02/12/56/67/500_F_212566776_FZHIfJoXkr1hZ2tiFd0E2mlmRVO4LViQ.jpg"));}
            if (bmi >= 30) {BMIName.setText("Obesity"); image.setImage(new Image("https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX37349421.jpg"));}
        }
    }


}
