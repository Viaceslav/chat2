package appProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

@SuppressWarnings("hiding")
public class ViewLoaderTest<AnchorPane, ChatController>{
    private String fxml;
    private AnchorPane pane;
    private ChatController controller;

    public ViewLoaderTest(String fxml){
        this.fxml = fxml;
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        try {
            pane=loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ChatController getController() {
        return controller;
    }

    public AnchorPane getLayout() {
        return pane;
    }

}
