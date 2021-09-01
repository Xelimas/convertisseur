import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

    @FXML
    ComboBox<Currency> comboBox1, comboBox2;

    @FXML
    TextField textField1;

    @FXML
    Label labelResultat, labelCurrency, labelCurrency2;;

    /*
     * private double txChangeDollarEuro = 0.85d; private double txChangeLivreEuro =
     * 1.17d; private double txChangeYenEuro = 0.0077d;
     * 
     * private double txChangeEuroDollar = 1.18d; private double txChangeEuroLivre =
     * 0.86d; private double txChangeEuroYen = 129.69d;
     * 
     * private double txChangeYenDollar = 0.0091d; private double
     * txChangeLivreDollar = 1.38d;
     * 
     * private double txChangeDollarYen = 109.72d; private double
     * txChangeDollarLivre = 0.73d;
     * 
     * private double txChangeLivreYen = 151.23d; private double txChangeYenLivre =
     * 0.0066d;
     */

    @FXML
    public void onComboAction() {
        labelCurrency.setText(comboBox1.getValue().getSymbol());
    }

    @FXML
    public void onConvertAction() {

        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setMaximumFractionDigits(2);
        Currency input1 = comboBox1.getValue();
        Currency input2 = comboBox2.getValue();

        if (!labelResultat.getText().isEmpty()) {
            double input = Double.parseDouble(textField1.getText().replace(",", "."));
            double res = (input * input1.getEuroConversionRate()) / input2.getEuroConversionRate();
            labelResultat.setText(String.valueOf(df.format(res)));
            labelCurrency2.setText(comboBox2.getValue().getSymbol());
        }

        // System.out.println(comboBox1.getItems().get(0));
        /*
         * if (comboBox1.getValue() == "€" && comboBox2.getValue() == "$") { double res
         * = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeEuroDollar;
         * labelResultat.setText(String.valueOf(df.format(res)+" $")); } else if
         * (comboBox1.getValue() == "$" && comboBox2.getValue() == "€") { double res =
         * Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeDollarEuro;
         * labelResultat.setText(String.valueOf(df.format(res)+" €")); }
         * 
         * if (comboBox1.getValue() == "\u00A3" && comboBox2.getValue() == "€") { double
         * res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeLivreEuro;
         * labelResultat.setText(String.valueOf(df.format(res)+" \u00A3")); }else if
         * (comboBox1.getValue() == "€" && comboBox2.getValue() == "\u00A3") { double
         * res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeEuroLivre;
         * labelResultat.setText(String.valueOf(df.format(res)+" €")); }
         * 
         * if (comboBox1.getValue() == "\u00A5" && comboBox2.getValue() == "€") { double
         * res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeYenEuro; labelResultat.setText(String.valueOf(df.format(res)+" €"));
         * }else if (comboBox1.getValue() == "€" && comboBox2.getValue() == "\u00A5") {
         * double res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeEuroYen;
         * labelResultat.setText(String.valueOf(df.format(res)+" \u00A5")); }
         * 
         * if (comboBox1.getValue() == "\u00A5" && comboBox2.getValue() == "$") { double
         * res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeYenDollar;
         * labelResultat.setText(String.valueOf(df.format(res)+" $")); }else if
         * (comboBox1.getValue() == "$" && comboBox2.getValue() == "\u00A5") { double
         * res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeDollarYen;
         * labelResultat.setText(String.valueOf(df.format(res)+" \u00A5")); }
         * 
         * if (comboBox1.getValue() == "\u00A3" && comboBox2.getValue() == "$") { double
         * res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeLivreDollar;
         * labelResultat.setText(String.valueOf(df.format(res)+" $")); }else if
         * (comboBox1.getValue() == "$" && comboBox2.getValue() == "\u00A3") { double
         * res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeDollarLivre;
         * labelResultat.setText(String.valueOf(df.format(res)+" \u00A3")); }
         * 
         * if (comboBox1.getValue() == "\u00A3" && comboBox2.getValue() == "\u00A5") {
         * double res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeLivreYen;
         * labelResultat.setText(String.valueOf(df.format(res)+" \u00A5")); }else if
         * (comboBox1.getValue() == "\u00A5" && comboBox2.getValue() == "\u00A3") {
         * double res = Double.parseDouble(textField1.getText().replace(",", ".")) *
         * txChangeYenLivre;
         * labelResultat.setText(String.valueOf(df.format(res)+" \u00A3")); }
         */
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBox1.getItems().setAll(Currency.values());
        comboBox1.getSelectionModel().selectFirst();
        comboBox2.getItems().setAll(Currency.values());
        comboBox2.getSelectionModel().selectFirst();
        labelCurrency.setText(comboBox1.getValue().getSymbol());

        /*
         * comboBox1.getItems().removeAll(comboBox1.getItems());
         * comboBox1.getItems().addAll("€", "$", "\u00A3", "\u00A5");
         * 
         * comboBox2.getItems().removeAll(comboBox2.getItems());
         * comboBox2.getItems().addAll("€", "$", "\u00A3", "\u00A5");
         */
    }

}