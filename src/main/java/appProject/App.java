package appProject;

import java.io.IOException;
import java.util.Optional;

import javafx.scene.control.TextInputDialog;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class App extends Application {

    public static final String appName = "Sockets-JavaFX-MVC";
    //private static Scene scene;
    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException{
        /*
         * FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Chat.fxml"));
         * scene = new Scene(fxmlLoader.load(),450,600); stage.setScene(scene);
         * stage.show();
         */
        ViewLoaderTest<AnchorPane, ChatController> viewLoader = new ViewLoaderTest<>("chat.fxml");
        viewLoader.getController().setUserName(getUserName());
        viewLoader.getController().setHost("localhost");
        viewLoader.getController().setPort(10000);
        viewLoader.getController().run();
        Scene scene = new Scene(viewLoader.getLayout(),450,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle(appName);
        primaryStage.setOnHiding( e -> primaryStage_Hiding(e, viewLoader.getController()));
        primaryStage.show();
    }
    private String getUserName() {
        TextInputDialog textInputDialog = new TextInputDialog("Anonymous");
        textInputDialog.setTitle("");
        textInputDialog.setHeaderText("");
        textInputDialog.setContentText("Twoje imię");
        Optional<String> result = textInputDialog.showAndWait();
        return result.orElse("Anonymous");
    }

    private void primaryStage_Hiding(WindowEvent e, ChatController controller)
    {try {
        controller.close();
    } catch (Exception e1) {
        e1.printStackTrace();
    }}



    public static void main(String[] args) {
        launch(args);
    }
}