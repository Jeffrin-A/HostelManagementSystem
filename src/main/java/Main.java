import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HostelDatabase hostelDatabase = new HostelDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();
        Login login = new Login();
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(hostelDatabase, studentDatabase, login, scanner);
        userInterface.start();
    }
}
