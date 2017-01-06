package nl.wveldhuis.ts.ui.actions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import nl.wveldhuis.ts.ui.TeamStats;
import nl.wveldhuis.ts.ui.util.TeamStatsSettings;
import nl.wveldhuis.ts.ui.util.TextResources;

import java.io.File;
import java.nio.file.Paths;

public class LoadFileAction implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(TextResources.get("actions.load.filechooser.title"));

        String lastFile = TeamStats.getInstance().getSettings().get(TeamStatsSettings.LAST_TEAMSTATS_FILE);
        if (lastFile != null) {
            File file = Paths.get(lastFile).toFile();
            fileChooser.setInitialDirectory(file.getParentFile());
            fileChooser.setInitialFileName(file.getName());
        }

        File file = fileChooser.showOpenDialog(TeamStats.getInstance().getPrimaryStage());
        if (file != null) {
            TeamStats.getInstance().getModel().setSelectedFile(file.getAbsolutePath());
        }

    }
}
