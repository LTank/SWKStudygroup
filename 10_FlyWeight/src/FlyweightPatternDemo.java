public class FlyweightPatternDemo {
    private static final String colors[] = { "Red", "Yellow", "Black" };
    public static void main(String[] args) {

        Circle circle;

        // Prints 20 circles with random choosen colors from array + random X & Y.
        for (int i = 0; i < 10; ++i) {
            circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }

        // Just to show, that it only creates the same amount of circle object as there are colors in our array.
        System.out.println("For loop done - Now lets see our final objects:");
        System.out.println(ShapeFactory.getCircleMap());
    }

    // Chooses random color from color array
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }


}