import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class fileReader extends Application {
    // storing the count of those alphabets

    public static void main (String args[])throws IOException{

        launch(args);

    }
    @Override
    public void start(Stage stage) throws Exception {
        TextField filebox=new TextField();
        filebox.setPrefWidth(500);
        Button btView=new Button("View");
        //pane for the button and the textfield
        HBox hbox=new HBox();
        hbox.getChildren().addAll(filebox,btView);
        //pane for the scene
        BorderPane pane=new BorderPane();
        //pane for the graph
        Pane root=new Pane();
        //that is the text to show the labels of the graph
        Text text=new Text("A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z");
        Canvas canvas=new Canvas(500,500);
        btView.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int[] countalphabets=new int[26];
                //making the graphics context
                GraphicsContext gc=canvas.getGraphicsContext2D();
                //clearing it for the new graph
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                //taking the file from the textfield
                try{ java.io.File file=new java.io.File(filebox.getText());

                    //Creation of File Reader object
                    FileReader fr=new FileReader(file);
                    //Creation of BufferedReader object
                    BufferedReader br=new BufferedReader(fr);
                    int c = 0;
                    //Read char by Char
                    while((c = br.read()) != -1)
                    {
                        for(int i=65;i<91;i++) {
                            // checking if it matches with the ASCII values of the capital and small letters
                            if (c == i || c == i + 32) {
                                //increasing the count when found a match
                                countalphabets[i-65]++;
                            }
                        }
                    }

                    // swapping the array to make it from Z to A instead of A to Z.
                    for(int j=0;j<countalphabets.length/2;j++){
                        int temp=0;
                        temp = countalphabets[j];
                        countalphabets[j] = countalphabets[countalphabets.length -j -1];
                        countalphabets[countalphabets.length -j -1] = temp;}}
                catch(IOException n){
                    System.out.println(n);
                }


                //setting the x and  value sof the text
                text.setX(92);
                text.setY(30);
                text.setFont(new Font(13));
                //As the pane is flipped thats why  inverting the text inorder to get the right text is important
                text.setRotate(180);
                for(int i=0;i<26;i++){
                    //the border of the bars will be black
                    gc.setStroke(Color.BLACK);
                    //the rectangles are bar rectangles
                    gc.strokeRect(90+i*15,40,15,countalphabets[i]*3.5);}

                root.getChildren().add(canvas);
                //rotating the pane
                root.setRotate(180);
                root.getChildren().add(text);




            }
        });

        pane.setTop(root);
        pane.setBottom(hbox);
       // pane.setBottom(hbox);

        Scene scene=new Scene(pane,550,530);
        stage.setScene(scene);
        stage.show();
    }

}
