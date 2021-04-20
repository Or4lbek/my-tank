import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main  extends Application {

    static Player player;
    static TextArea text = new TextArea();
    private static Position position;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        load();
    }
    
    public static void load(){
        Stage primaryStage = new Stage();
        StackPane root = new StackPane();
        Button loadMap = new Button("Load Map");

        loadMap.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(primaryStage);

            if (file != null) {
                try {
                    text.setText(readFile(file));
                    play(text.getText());
                    primaryStage.close();
                }
                catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (InvalidMapException e1) {
                    e1.printStackTrace();
                }
            }   

        });



        root.getChildren().add(loadMap);

        primaryStage.setTitle("Map Chooser");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    
    public static void play(String text) throws FileNotFoundException, InvalidMapException {
        Stage stage = new Stage();
        
        Map map = new Map(text);
    
        DrawTank player = new DrawTank(map);
        HBox hBox = new HBox(10);
        GridPane featuresBlock = new GridPane();
        featuresBlock.setVgap(5);

        hBox.getChildren().addAll(map, featuresBlock);

        map.setOnKeyPressed(event -> {
            switch (event.getCode()) {  
                case SPACE:
                    player.fire();
                    position = player.getPosition();
                    System.out.println(player.getrotate());
                    System.out.println("fire");
                    break;
                case W:
                    player.moveUp();
                    position = player.getPosition();
                    System.out.println(position);
                    break;
                case S:
                    player.moveDown();
                    position = player.getPosition();
                    System.out.println(position);
                    break;
                case A:
                    player.moveLeft();
                    position = player.getPosition();
                    System.out.println(position);
                    break;   
                case D:
                    player.moveRight();
                    position = player.getPosition();
                    System.out.println(position);
                    break;
            }
        });
        

        Scene scene = new Scene(hBox,400,400);
        stage.setTitle("My Tank");
        stage.setScene(scene);
        stage.show();
        map.requestFocus();

    }

    private static String readFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String t = "";
        String str = "";

        String x = sc.nextLine();

        while (sc.hasNextLine()) {
            t += sc.nextLine();
        }

        for(int i = 0; i < t.length()-1; i++) {
            if(t.charAt(i) == ' ') {str = str + t.charAt(i+=1);}
            else str = str + t.charAt(i);
        }
        return x + "\n"+ str;
    }
}
