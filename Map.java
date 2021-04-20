
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Scanner;

public class Map extends Pane {

    int UNIT=31;
    int size;
    int[][] map;
    Position start;


    Map(String text) {
        Scanner sc = new Scanner(text);
        GridPane gridPane = new GridPane();
        int row = 0;
        int column = 0;
        Integer x = Integer.parseInt(String.valueOf(sc.nextLine()));

        text = sc.nextLine();
        String textWithGap = " " + text;
        for(int i = 1; i < textWithGap.length(); i++){



            Rectangle emptyBox = new Rectangle(30,30);  emptyBox.setFill(Color.BLACK); emptyBox.setStroke(Color.BLACK);
            Rectangle blackBox = new Rectangle(30,30);  blackBox.setFill(Color.GRAY); blackBox.setStroke(Color.BLACK);
            Rectangle Stealwall = new Rectangle(30,30);  Stealwall.setFill(Color.rgb(189,190,189)); blackBox.setStroke(Color.BLACK);
            Rectangle Brickwall = new Rectangle(30,30);  Brickwall.setFill(Color.rgb(198,113,0)); blackBox.setStroke(Color.BLACK);
            Rectangle Water = new Rectangle(30,30);  Water.setFill(Color.rgb(66,65,255)); blackBox.setStroke(Color.BLACK);
            Rectangle Trees = new Rectangle(30,30);  Trees.setFill(Color.rgb(156,235,0)); blackBox.setStroke(Color.BLACK);
            if(Integer.parseInt(String.valueOf(textWithGap.charAt(i))) == 3){gridPane.add(Brickwall,column,row);}//B
            else if(Integer.parseInt(String.valueOf(textWithGap.charAt(i))) == 4){gridPane.add(Water,column,row);}//W
            else if(Integer.parseInt(String.valueOf(textWithGap.charAt(i))) == 5){gridPane.add(Trees,column,row);}//T
            else if(Integer.parseInt(String.valueOf(textWithGap.charAt(i))) == 6){gridPane.add(Stealwall,column,row);}//S
            else if(Integer.parseInt(String.valueOf(textWithGap.charAt(i))) == 0){gridPane.add(emptyBox,column,row);}
            else if(Integer.parseInt(String.valueOf(textWithGap.charAt(i))) == 1){gridPane.add(blackBox,column,row);}
            else if(Integer.parseInt(String.valueOf(textWithGap.charAt(i))) == 2){gridPane.add(emptyBox,column,row); start = new Position(column,row );}
            column++;

            if(i%x == 0){
                row++;column=0;}

        }


        size = x;

        getChildren().add(gridPane);

        int[][] arr = new int[x][x];
        int q = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(text.charAt(q)));
                q++;
            }
        }

        map = arr;

    }                                         


    public int getUnit () {
        return UNIT;
    }                               //returns Unit pixels
    public int getSize () {
        return size;
    }                           //returns map size
    public int getValue ( int x, int y){
        return map[x][y];
    }       //returns 0, 1 or 2 on a map positions
    public Position getStartPosition () {
        return start;
    }           //returns Starting position [2] of packman
    public  void setValueatPosition(int z, int s, char c)
    {
        map[z][s] = c;
    }
}
