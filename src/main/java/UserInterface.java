import java.util.Scanner;

public class UserInterface {
    private final HostelDatabase hostelDatabase;
    private final Scanner scanner;
    private final StudentDatabase studentDatabase;
    private final Login login;

    public UserInterface(HostelDatabase hostelDatabase, StudentDatabase studentDatabase, Login login, Scanner scanner) {
        this.hostelDatabase = hostelDatabase;
        this.studentDatabase = studentDatabase;
        this.login = login;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("Login");
            System.out.println("1-Admin");
            System.out.println("2-Student");
            System.out.println("3-Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.print("Login ID: ");
                String adminId = (scanner.nextLine());
                System.out.print("Password: ");
                String adminPassword = scanner.nextLine();
                boolean check = login.checkIfAdmin(adminId, adminPassword);
                if (!check) {
                    System.out.println("Login ID or Password is incorrect");
                    continue;
                }
                while (true) {
                    System.out.println("1-Add Hostel");
                    System.out.println("2-Add Room");
                    System.out.println("3-Allocate Room");
                    System.out.println("4-Vacate Room");
                    System.out.println("5-View Hostel");
                    System.out.println("6-View All Hostels");
                    System.out.println("7-View Student");
                    System.out.println("8-View All Students");
                    System.out.println("9-Log Out");
                    System.out.print("Choice: ");
                    int actionAdmin = Integer.parseInt(scanner.nextLine());
                    if (actionAdmin == 1) {
                        System.out.print("Hostel Id: ");
                        String hostelId = scanner.nextLine();
                        System.out.print("Hostel Name: ");
                        String hostelName = scanner.nextLine();
                        System.out.print("Type Of Hostel(M/F): ");
                        String typeOfHostel = scanner.nextLine();
                        System.out.print("Year Of Hostel(1/2/3/4): ");
                        int yearOfHostel = Integer.parseInt(scanner.nextLine());
                        System.out.print("Warden Name: ");
                        String wardenName = scanner.nextLine();
                        System.out.print("Warden PhoneNo: ");
                        String wardenPhoneNo = scanner.nextLine();
                        Hostel hostel = new Hostel(hostelId, hostelName, typeOfHostel, yearOfHostel, wardenName, wardenPhoneNo);
                        boolean success=hostelDatabase.addHostel(hostel);
                        if(success)
                            System.out.println("Hostel added successfully");
                        else
                            System.out.println("Hostel couldn't be added");
                    } else if (actionAdmin == 2) {
                        System.out.print("Hostel Id: ");
                        String hostelId = scanner.nextLine();
                        System.out.print("Hostel Name: ");
                        String hostelName = scanner.nextLine();
                        System.out.print("Room number: ");
                        int roomNumber = Integer.parseInt(scanner.nextLine());
                        System.out.print("No of Beds: ");
                        int noOfBeds = Integer.parseInt(scanner.nextLine());
                        Room room = new Room(hostelId, hostelName, roomNumber, noOfBeds);
                        boolean success= hostelDatabase.addRoom(hostelId, room);
                        if(success)
                            System.out.println("Room added successfully");
                        else
                            System.out.println("Room couldn't be added");
                    } else if (actionAdmin == 3) {
                        System.out.println("Students to be approved:-");
                        studentDatabase.printNonAllocated();
                        System.out.println("Enter Student IDs to be approved:-");
                        while (true) {
                            String id = scanner.nextLine();
                            if (id.equals(""))
                                break;
                            Student student = studentDatabase.find(id);
                            hostelDatabase.addStudent(student);
                        }
                    } else if (actionAdmin == 4) {
                        System.out.print("Student Id: ");
                        String id = scanner.nextLine();
                        Student student = studentDatabase.find(id);
                        hostelDatabase.removeStudent(student);
                    } else if (actionAdmin == 5) {
                        System.out.print("Hostel ID: ");
                        String hostelId = scanner.nextLine();
                        hostelDatabase.printHostelDetails(hostelId);
                    } else if (actionAdmin == 6) {
                        hostelDatabase.printHostelsDetails();
                    } else if (actionAdmin == 7) {
                        System.out.print("Student ID: ");
                        String studentId = scanner.nextLine();
                        studentDatabase.printStudent(studentId);
                    } else if (actionAdmin == 8) {
                        studentDatabase.printStudents();
                    } else if (actionAdmin == 9)
                        break;
                    else
                        System.out.println("Wrong choice");

                }
            } else if (choice == 2) {
                while (true) {
                    System.out.println("1-Apply for hostel");
                    System.out.println("2-View Details");
                    System.out.println("3-Exit");
                    int ch = Integer.parseInt(scanner.nextLine());
                    if (ch == 1) {
                        System.out.print("Student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Student Name: ");
                        String studentName = scanner.nextLine();
                        System.out.print("Sex: ");
                        String sex = scanner.nextLine();
                        System.out.print("Year: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.print("Phone No: ");
                        String phoneNo = scanner.nextLine();
                        System.out.print("Father Name: ");
                        String fatherName = scanner.nextLine();
                        System.out.print("Father Phone No: ");
                        String fatherPhoneNo = scanner.nextLine();
                        Student student = new Student(studentId, studentName, sex, fatherName, phoneNo, fatherPhoneNo, year);
                        studentDatabase.addStudent(student);
                    } else if (ch == 2) {
                        System.out.print("Student ID: ");
                        String studentId = (scanner.nextLine());
                        boolean check = login.checkIfStudent(studentId, studentDatabase);
                        if (!check) {
                            System.out.println("Register first and then login");
                            break;
                        }
                        studentDatabase.printStudent(studentId);
                    } else {
                        break;
                    }
                }
            } else if (choice == 3)
                break;
            else {
                System.out.println("Invalid Login");
            }
        }
    }

}


