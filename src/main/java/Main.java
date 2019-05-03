import model.Calculator;
import model.User;
import model.UserDao;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static UserDao userDao = new UserDao();

    public static void main(String[] args) {

        createUser();
        UserDao userDao = new UserDao();
        System.out.println(userDao.getAllUsers());
        System.out.println(" remove user by lastName , press lastName ");
        String lastName = scanner.next();
        userDao.deleteUser(lastName);
        System.out.println(userDao.getAllUsers());
    }


    public static void createUser() {

        String name, lastname;
        Integer age;
        System.out.println("Type a name: ");
        name = scanner.next();
        System.out.println("Type a lastname: ");
        lastname = scanner.next();
        System.out.println("Type your age: ");
        age = scanner.nextInt();
        User user = new User(name, lastname, age);

        userDao.createUser(user);
        System.out.println("Utworzono Usera: " + user.toString());
    }

    public static void calculate() {
        Integer x, y;
        System.out.println("Type first number: ");
        x = scanner.nextInt();
        System.out.println("Type second number: ");
        y = scanner.nextInt();
        System.out.println("Sum: " + Calculator.add(x, y));
        System.out.println("Subtract: " + Calculator.subtract(x, y));
        System.out.println("Multiply: " + Calculator.multiply(x, y));
        System.out.println("Divide: " + Calculator.divide(x, y));
    }
}
