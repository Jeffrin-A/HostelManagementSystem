import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
