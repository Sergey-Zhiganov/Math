import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Радиус Земли в км
    private static final double RADIUS_OF_EARTH = 6371;
    public static void main(String[] args) {
        try {
            // Создание сканнера
            Scanner scanner = new Scanner(System.in);

            // Ввод первой точки
            System.out.print("[Точка 1]\nДолгота: ");
            double lat1 = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Широта: ");
            double lon1 = scanner.nextDouble();
            scanner.nextLine();

            // Ввод второй точки
            System.out.print("[Точка 2]\nДолгота: ");
            double lat2 = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Широта: ");
            double lon2 = scanner.nextDouble();
            scanner.nextLine();
            // Вычисление
            // Превращение из градусов в радианы
            lat1 = Math.toRadians(lat1);
            lat2 = Math.toRadians(lat2);
            lon1 = Math.toRadians(lon1);
            lon2 = Math.toRadians(lon2);

            // Разница между долготами и широтами
            double lat = lat2 - lat1;
            double lon = lon2 - lon1;

            // Вычисление расстояния
            double a = Math.pow(Math.sin(lat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) *
                    Math.pow(Math.sin(lon / 2), 2);
            a = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            a = RADIUS_OF_EARTH * a;

            System.out.println("Расстояние между двумя точками = " + a + " км");
        // Обработка ошибок
        } catch (InputMismatchException e) {
            System.err.println("Ошибка: " + e);
        }
    }
}