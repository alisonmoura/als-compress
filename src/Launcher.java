import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("ALS Compress");
        window.setScene(getRootScene(window));
        window.show();
    }

    private Scene getRootScene(Stage root){

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text title = new Text("ALS Compress");
        title.setId("title");

        Label uploadLabel = new Label("Compress file:");
        uploadLabel.setId("label-upload");

        final FileChooser fileChooser = new FileChooser();

        Button btnUploadFile = new Button("Select file");
        btnUploadFile.setId("btn-upload");
        btnUploadFile.setOnAction(e -> {
            configureFileChooser(fileChooser);
            File uploadedFile = fileChooser.showOpenDialog(root);
            if(uploadedFile != null) openFile(uploadedFile);
        });

        grid.add(title,0,0,2,1);
        grid.add(uploadLabel,0,1);
        grid.add(btnUploadFile,1,1);

        Scene scene = new Scene(grid, 1000, 400);
        scene.getStylesheets().add(Launcher.class.getResource("css/style.css").toExternalForm());

        return scene;
    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("Select file to compact");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TEXT", "*.txt")
        );
    }

    private void openFile(File file) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String all = sb.toString();
            System.out.println(all);
        } catch (FileNotFoundException e) {
            logg(e);
            e.printStackTrace();
        } catch (IOException e) {
            logg(e);
            e.printStackTrace();
        }
    }

    private void logg(Exception e){
        Logger.getLogger(
                Launcher.class.getName()).log(
                Level.SEVERE, null, e
        );
    }
}
