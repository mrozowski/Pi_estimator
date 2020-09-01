package estimate_pi;

import javafx.scene.shape.Circle;


public class Point extends Circle{
    private final double x;
    private final double y;

    public Point(double x, double y){
        super(x * 300, y * 300, 1);
        this.x = x;
        this.y = y;
        //I multiply x and y by 300 to display it on the canvas who is going to have 300 x 300 pixels
        //original x and y will be needed to easier calculate distance of point
    }

    public double getX() {
        return x;
    }

    public double getY() {
        //x = 0 and y = 0 indicates the top left corner but the center of a big circle is in the bottom left corner
        //so i have to change a bit y to mach area of circle
        return 1-y;
    }

    public void insideCircle(){
        //This method is call when point is inside a blue circle
        //It change color of point from black to white
        this.setFill(javafx.scene.paint.Color.WHITE);
    }


}
