package nl.wveldhuis.ts.ui;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import nl.wveldhuis.ts.ApplicationConstants;
import nl.wveldhuis.ts.model.TeamStatsModel;
import nl.wveldhuis.ts.ui.actions.LoadFileAction;
import nl.wveldhuis.ts.ui.actions.QuitAction;
import nl.wveldhuis.ts.ui.util.Settings;
import nl.wveldhuis.ts.ui.util.TextResources;

import java.util.Locale;

public class TeamStats extends Application {
    private static TeamStats INSTANCE;

    private Stage primaryStage;
    private TeamStatsModel model;
    private Settings settings;

    public static void main(String[] args) {
//        Locale.setDefault(new Locale("nl", "NL"));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        INSTANCE = this;

        this.primaryStage = primaryStage;
        this.settings = new Settings();
        this.model = new TeamStatsModel();

        primaryStage.setTitle(TextResources.get("application.title", ApplicationConstants.VERSION));

        BorderPane pane = new BorderPane();
        pane.setTop(createMenu());
        pane.setCenter(createContent());

        Scene scene = new Scene(pane, 800, 600);
        scene.getStylesheets().add("nl/wveldhuis/ts/resources/default.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        settings.save();
    }

    private Node createMenu() {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu(TextResources.get("menu.file"));
        MenuItem loadMenuItem = new MenuItem(TextResources.get("menu.open"));
        loadMenuItem.setAccelerator(KeyCombination.valueOf("CTRL+O"));
        loadMenuItem.setOnAction(new LoadFileAction());

        MenuItem quitMenuItem = new MenuItem(TextResources.get("menu.quit"));
        quitMenuItem.setAccelerator(KeyCombination.valueOf("CTRL+Q"));
        quitMenuItem.setOnAction(new QuitAction());

        fileMenu.getItems().addAll(loadMenuItem, new SeparatorMenuItem(), quitMenuItem);

        Menu helpMenu = new Menu(TextResources.get("menu.help"));

        menuBar.getMenus().addAll(
                fileMenu,
                helpMenu
        );


        return new VBox(menuBar);
    }

    private Node createContent() {
        VBox result= new VBox();

        TabPane tabs = new TabPane();
        tabs.getTabs().addListener(new ListChangeListener<Tab>() {
            @Override
            public void onChanged(Change<? extends Tab> c) {
                System.out.println(c);
            }
        });
        tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tab1 = new Tab("Table");
        Tab tab2 = new Tab("Matches");
        Tab tab3 = new Tab("Statistics");
        Tab tab4 = new Tab("Compare teams");



        tabs.getTabs().addAll(tab1, tab2, tab3, tab4);

        result.getChildren().addAll(tabs);

        return result;
    }


    public static TeamStats getInstance() {
        return INSTANCE;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Settings getSettings() {
        return settings;
    }

    public TeamStatsModel getModel() {
        return model;
    }
}
