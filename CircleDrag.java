

        import javafx.application.Application;
        import javafx.geometry.Point2D;
        import javafx.scene.Scene;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Circle;
        import javafx.scene.shape.Line;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;

        public class CircleDrag extends Application {
                //Three points on the circle
        private Circle[] circle={new Circle(55, 58, 5,Color.RED),
        new Circle(140, 53, 5,Color.RED), new Circle(58, 140, 5,Color.RED)};
        //Lines that are needed to join
        private Line[] line= {new Line(),new Line(),new Line()};
        //Text are for showing angles
        private Text[] text={new Text(),new Text(),new Text()};
        //new x and new y are produced to make sure it is in the circle
        public double newX=0.0;
        public double newY=0.0;
        //Circle around which there are points
        public Circle bigcircle=new Circle( 100,100,60);
        @Override
        public void start(Stage stage) throws Exception {


                Pane pane = new Pane();
        //bigcircle specifications are mentioned
        bigcircle.setFill(Color.WHITE);
        bigcircle.setStroke(Color.BLACK);
        //bigcircle is added in pane
        pane.getChildren().add(bigcircle);
        for(int i=0;i<circle.length;i++) {
                //adding all the circles,lines and texts are added in the pane
        pane.getChildren().addAll(circle[i], line[i], text[i]);
        }


        Scene scene=new Scene(pane,500,500);
        stage.setScene(scene);
        stage.show();

        for (int j=0;j<circle.length;j++){
        int finalJ = j;

        //when the mouse is dragged the action is described
        circle[j].setOnMouseDragged(e->{
                //mouse coordinates are taken
        if (circle[finalJ].contains(e.getX(), e.getY())) {
                //finding the points on the perimeter after taking the coordinates of the mouse
        findpointsonperimeter(e.getX(),e.getY());
        //then setting the coordinates of the points
        circle[finalJ].setCenterX(newX);
        circle[finalJ].setCenterY(newY);
        //creating the lines in the circle
        computeLines();

        }});
        }
        }


        public void computeLines(){
                //finding the starting and ending points of the lines in correspondence with the small circles or points
        line[0].setStartX(circle[0].getCenterX());
        line[0].setStartY(circle[0].getCenterY());
        line[0].setEndX(circle[1].getCenterX());
        line[0].setEndY(circle[1].getCenterY());

        line[1].setStartX(circle[0].getCenterX());
        line[1].setStartY(circle[0].getCenterY());
        line[1].setEndX(circle[2].getCenterX());
        line[1].setEndY(circle[2].getCenterY());

        line[2].setStartX(circle[1].getCenterX());
        line[2].setStartY(circle[1].getCenterY());
        line[2].setEndX(circle[2].getCenterX());
        line[2].setEndY(circle[2].getCenterY());

        //finding the distance between the two points
        double a=(new Point2D(circle[2].getCenterX(),circle[2].getCenterY())).distance(circle[1].getCenterX(),circle[1].getCenterY());
        double b=(new Point2D(circle[0].getCenterX(),circle[0].getCenterY())).distance(circle[2].getCenterX(),circle[2].getCenterY());
        double c=(new Point2D(circle[0].getCenterX(),circle[0].getCenterY())).distance(circle[1].getCenterX(),circle[1].getCenterY());

        //finding the angles between the sides
        double angle[]=new double[3];
        angle[0]=Math.acos((a*a-b*b-c*c)/(-2*b*c));
        angle[1]=Math.acos((b*b-c*c-a*a)/(-2*c*a));
        angle[2]=Math.acos((c*c-b*b-a*a)/(-2*b*a));

        //setting the angles values in the text and converting it to degrees
        for(int k=0;k<angle.length;k++){
            text[k].setX(circle[k].getCenterX());
            text[k].setY(circle[k].getCenterY()-circle[k].getRadius());
            text[k].setText(String.format("%.2f", Math.toDegrees(angle[k])));
        }


        }
        public void findpointsonperimeter(double x,double y){
                //finding the angle formed withe the positive direction of x axis and line joining
                // the mouse coordinates and center
                double angle= Math.atan2(y- bigcircle.getCenterY(), x -  bigcircle.getCenterX());
                int radius=60;
                //finding new points using the parametric equation of circle
                newY=bigcircle.getCenterY()+(radius*Math.sin(angle));
                newX=bigcircle.getCenterX()+(radius*Math.cos(angle));


        }

        }
