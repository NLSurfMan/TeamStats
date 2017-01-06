package nl.wveldhuis.ts.model;

import javafx.beans.property.SimpleStringProperty;

public class TeamStatsModel {
    private SimpleStringProperty selectedFile = new SimpleStringProperty("No file selected");

    public String getSelectedFile() {
        return selectedFile.get();
    }

    public SimpleStringProperty selectedFileProperty() {
        return selectedFile;
    }

    public void setSelectedFile(String selectedFile) {
        this.selectedFile.set(selectedFile);
    }
}
