package sample;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller {
    public TextArea unos;
    public TextArea rezultat;
    public ChoiceBox chiceArtikli;
    public Spinner spKolicina;
    public TextArea aktuelniRacun;

    private ArrayList<Artikal> artikli = new ArrayList<>();
    private ObserbavleList<Artikal> observableList = FXCollections.observableArrayList();

    @Override//
    public void initialize(URL location, ResourceBundle resources){
        observableList.setAll(artikli);
        chiceArtikli.setItems(observableList);
    }



    public void dodajArtikle(ActionEvent actionEvent){
        String[] ArtikliStr = unos.getText().split("\n");

                for(String linija : artikli)
                    artikli.add(new Artikal(linija));

                Artikal.izbaciDuplikate(artikli);
                observableList.clear();
                observableList.setAll(artikli);
                chiceArtikli.getSelectionModel().selectFirst();

                String res = "";

                for(Artikal artikal: artikli){
                    res += artikal + "\n";
                }
                rezultat.setText(res);
    }

    public void obracunaj(ActionEvent actionEvent){

    }
}
