import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class fileReader extends Application {
    //I am storing the count of those alphabets
    public static int[] countalphabets=new int[26];
    public static void main (String args[])throws IOException{
        java.io.File file=new java.io.File("C:\\Users\\Anannya\\IdeaProjects\\AssignmentTask2\\src\\save.txt");
        FileReader fr=new FileReader(file);   //Creation of File Reader object
        BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;
        while((c = br.read()) != -1)         //Read char by Char
        {
            for(int i=65;i<91;i++) {
                if (c == i || c == i + 32) {  //I am checking if it matches with the ASCII values of the capital and small letters
                    countalphabets[i-65]++;   //increasing the count when foound a match
                }
            }
        }

       //I am swapping the array to make it from Z to A instead of A to Z.
        for(int j=0;j<countalphabets.length/2;j++){
            int temp=0;
            temp = countalphabets[j];
            countalphabets[j] = countalphabets[countalphabets.length -j -1];
            countalphabets[countalphabets.length -j -1] = temp;}

        launch(args);

    }
    @Override
    public void start(Stage stage) throws Exception {
        //I will be making the bar chart in canvas
        Canvas canvas=new Canvas(500,500);
        //To label the barchart I am gonna take the alphabets in a text form
        Text text=new Text("A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z");
        //setting the x and  value sof the text
        text.setX(92);
        text.setY(30);
        text.setFont(new Font(13));
        //As I will be flipping the pane thats why I inverting the text inorder to get the right text
        text.setRotate(180);
        GraphicsContext gc=canvas.getGraphicsContext2D();
        for(int i=0;i<26;i++){
            //the border of the bars will be black
            gc.setStroke(Color.BLACK);
            //the rectangles are bar rectangles
            gc.strokeRect(90+i*15,40,15,countalphabets[i]*3.5);}

        Pane root=new Pane();
        root.getChildren().add(canvas);
        //rotating the pane
        root.setRotate(180);
        root.getChildren().add(text);
        Scene scene=new Scene(root,500,500);
        stage.setScene(scene);
        stage.show();
    }

}
