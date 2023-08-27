package com.system.Controllers;

import com.system.Models.Glasses;
import com.system.Enums.GlassesStatus;
import com.system.Models.Lenses;
import com.system.Enums.LensesStatus;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OpticianController {
    @FXML
    TextField lensesId;
    ChoiceBox lensesType;
    public void onLensesButtonClick(ActionEvent actionEvent) {
        boolean check = false;
        try {
            Integer.parseInt(lensesId.getText());
            check = true;
        } catch (Exception e) {}
        if (check) {
            Lenses lenses = Lenses.getExtent().stream()
                    .filter(l -> l.getLensesId()==(Integer.parseInt(lensesId.getText())))
                    .collect(Collectors.toCollection(ArrayList::new))
                    .get(0);

            if(lensesType.getValue().toString().equals("TO_DO")) {
                Lenses.removeLenses(lenses);
                Lenses.addLenses(new Lenses(lenses.getLensesId(), lenses.getType(), lenses.getPrice(), lenses.getLeftLens(),
                        lenses.getRightLens(), LensesStatus.TO_DO));
            }
            if(lensesType.getValue().toString().equals("IN_PROGRESS")) {
                Lenses.removeLenses(lenses);
                Lenses.addLenses(new Lenses(lenses.getLensesId(), lenses.getType(), lenses.getPrice(), lenses.getLeftLens(),
                        lenses.getRightLens(), LensesStatus.IN_PROGRESS));
            }
            if(lensesType.getValue().toString().equals("DONE")) {
                Lenses.removeLenses(lenses);
                Lenses.addLenses(new Lenses(lenses.getLensesId(), lenses.getType(), lenses.getPrice(), lenses.getLeftLens(),
                        lenses.getRightLens(), LensesStatus.DONE));
            }
        }
    }

    @FXML
    ListView lensesList;
    public void onLensesListButtonClick(ActionEvent event) {
        lensesList.setItems((ObservableList) Lenses.getExtent());
    }

    @FXML
    TextField glassesId;
    ChoiceBox glassesStatus;
    public void onGlassesButtonClick(ActionEvent actionEvent) {
        boolean check = false;
        try {
            Integer.parseInt(glassesId.getText());
            check = true;
        } catch (Exception e) {}
        if (check) {
            Glasses glasses = Glasses.getExtent().stream()
                    .filter(a -> a.getGlassesId()==(Integer.parseInt(glassesId.getText())))
                    .collect(Collectors.toCollection(ArrayList::new))
                    .get(0);

            if(glassesStatus.getValue().toString().equals("WAITING_FOR_LENSES")) {
                Glasses.removeGlasses(glasses);
                Glasses.addGlasses(new Glasses(glasses.getGlassesId(), glasses.getFrames(), glasses.getLenses(),
                        GlassesStatus.WAITING_FOR_LENSES));
            }
            if(glassesStatus.getValue().toString().equals("IN_PROGRESS")) {
                Glasses.removeGlasses(glasses);
                Glasses.addGlasses(new Glasses(glasses.getGlassesId(), glasses.getFrames(), glasses.getLenses(),
                        GlassesStatus.IN_PROGRESS));
            }
            if(glassesStatus.getValue().toString().equals("DONE")) {
                Glasses.removeGlasses(glasses);
                Glasses.addGlasses(new Glasses(glasses.getGlassesId(), glasses.getFrames(), glasses.getLenses(),
                        GlassesStatus.DONE));
            }
        }
    }

    @FXML
    ListView glassesList;
    public void onGlassesListButtonClick(ActionEvent event) {
        glassesList.setItems((ObservableList) Glasses.getExtent());
    }
}
