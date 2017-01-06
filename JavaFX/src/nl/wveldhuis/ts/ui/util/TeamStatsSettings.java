package nl.wveldhuis.ts.ui.util;

import nl.wveldhuis.ts.model.TeamStatsModel;
import nl.wveldhuis.ts.ui.TeamStats;

public class TeamStatsSettings extends Settings {
    public static final String LAST_TEAMSTATS_FILE = "last_teamstats_file";

    public TeamStatsSettings() {
        TeamStatsModel tsModel = TeamStats.getInstance().getModel();

        tsModel.selectedFileProperty().addListener((observable, oldValue, newValue) -> set(LAST_TEAMSTATS_FILE, newValue));
    }


}
