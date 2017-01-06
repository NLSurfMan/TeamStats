package nl.wveldhuis.ts.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TeamStatsModel {
    private StringProperty selectedFile = new SimpleStringProperty("No file selected");

    public String getSelectedFile() {
        return selectedFile.get();
    }

    public StringProperty selectedFileProperty() {
        return selectedFile;
    }

    public void setSelectedFile(String selectedFile) {
        this.selectedFile.set(selectedFile);
    }
}
