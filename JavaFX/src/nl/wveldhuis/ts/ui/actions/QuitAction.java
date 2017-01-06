package nl.wveldhuis.ts.ui.actions;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class QuitAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            Platform.exit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
