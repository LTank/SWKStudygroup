import java.util.HashMap;

public class ShapeFactory {

    private static final HashMap circleMap = new HashMap();

    static Circle circle;

    public static Shape getCircle(String color) {
        circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("New color - Creating a circle of: " + color);
        }
        return circle;
    }

    public static HashMap getCircleMap() {
        return circleMap;
    }
}