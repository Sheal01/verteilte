package config;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Start extends Application
{
    public static Stage primaryStage;
    private static AnchorPane mainLayout;

    public static void main(String[] args)
    {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws IOException
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Main menu");

        showHauptmenu();
    }

    public void showHauptmenu() throws IOException
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Start.class.getResource("/dialog/hauptmenu/Hauptmenu.fxml"));

            mainLayout = loader.load();
            Scene scene = new Scene(mainLayout);

            primaryStage.setScene(scene);

            primaryStage.setMinHeight(500.00);
            primaryStage.setMinWidth(600.00);

            primaryStage.show();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
