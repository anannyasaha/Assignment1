import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class Cardgenerator extends Application {
    String[] cards= new String[54];

    @Override
    public void start(Stage stage) throws Exception {
        //assigning every card's url in the form of string in the array of strings
        cards[0]="image/card0.jpg";
        cards[1]="image/card1.jpg";
        cards[2]="image/card2.jpg";
        cards[3]="image/card3.jpg";
        cards[4]="image/card4.jpg";
        cards[5]="image/card5.jpg";
        cards[6]="image/card6.jpg";
        cards[7]="image/card7.jpg";
        cards[8]="image/card8.jpg";
        cards[9]="image/card9.jpg";
        cards[10]="image/card10.jpg";
        cards[11]="image/card11.jpg";
        cards[12]="image/card12.jpg";
        cards[13]="image/card13.jpg";
        cards[14]="image/card14.jpg";
        cards[15]="image/card15.jpg";
        cards[16]="image/card16.jpg";
        cards[17]="image/card17.jpg";
        cards[18]="image/card18.jpg";
        cards[19]="image/card19.jpg";
        cards[20]="image/card20.jpg";
        cards[21]="image/card21.jpg";
        cards[22]="image/card22.jpg";
        cards[23]="image/card23.jpg";
        cards[24]="image/card24.jpg";
        cards[25]="image/card25.jpg";
        cards[26]="image/card26.jpg";
        cards[27]="image/card27.jpg";
        cards[28]="image/card28.jpg";
        cards[29]="image/card29.jpg";
        cards[30]="image/card30.jpg";
        cards[31]="image/card31.jpg";
        cards[32]="image/card32.jpg";
        cards[33]="image/card33.jpg";
        cards[34]="image/card34.jpg";
        cards[35]="image/card35.jpg";
        cards[36]="image/card36.jpg";
        cards[37]="image/card37.jpg";
        cards[38]="image/card38.jpg";
        cards[39]="image/card39.jpg";
        cards[40]="image/card40.jpg";
        cards[41]="image/card41.jpg";
        cards[42]="image/card42.jpg";
        cards[43]="image/card43.jpg";
        cards[44]="image/card44.jpg";
        cards[45]="image/card45.jpg";
        cards[46]="image/card46.jpg";
        cards[47]="image/card47.jpg";
        cards[48]="image/card48.jpg";
        cards[49]="image/card49.jpg";
        cards[50]="image/card50.jpg";
        cards[51]="image/card51.jpg";
        cards[52]="image/card52.jpg";
        cards[53]="image/card53.jpg";
        //randomly selecting every card
        int first=randomlyselect();
        //making sure the second card is not as same as the second one
        int second=randomlyselect();
        while(first==second){
            second=randomlyselect();
        }
        //making sure the third card is different from second one and the first
        int third=randomlyselect();
        while(third==second||third==first){
            third=randomlyselect();
        }

        HBox hbox=new HBox();
        //creating the image and imageview for the images
        Image image1=new Image(cards[first]);
         ImageView imageView1 = new ImageView(image1);
        Image image2=new Image(cards[second]);
         ImageView imageView2 = new ImageView(image2);
        Image image3=new Image(cards[third]);
         ImageView imageView3 = new ImageView(image3);
         //adding them up in the hbox. so that it appears horizontally
        hbox.getChildren().addAll(imageView1, imageView2, imageView3);
        //creating the scene and adding the pane on it.
        Scene scene= new Scene(hbox);
        stage.setScene(scene);
        stage.setTitle("Cards");
        stage.show();


    }
    //function to generate the numbers between 0 and 53
    public int randomlyselect(){

        Random rand=new Random();
        int int_Rand=rand.nextInt(54);
        return int_Rand;
    }
}

