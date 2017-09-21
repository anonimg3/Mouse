import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> {
            mouse();
        }).start();
    }

    public static void mouse() {
        int x, y;

        System.out.println("Please insert mouse position:");

        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.print("X:");
                x = scanner.nextInt();
                System.out.print("Y:");
                y = scanner.nextInt();

                try {
                    Robot robot = new Robot();
                    x = checkX(x);
                    y = checkY(y);
                    robot.mouseMove(x, y);
                } catch (AWTException e) {
                    e.printStackTrace();
                }

            } catch (InputMismatchException e) {
                System.err.println("This is not a number!");
            }
            System.out.println("Please insert 'q' to close");
            while (scanner.next().compareTo("q") != 0) ;
        }
    }

    public static int checkX(int x) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (x < 0) return 0;
        else if (x > screenSize.getWidth()) return (int) screenSize.getWidth();
        else return x;
    }


    public static int checkY(int y) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (y < 0) return 0;
        else if (y > screenSize.getHeight()) return (int) screenSize.getHeight();
        else return y;
    }


}
