import java.util.ArrayList;
import java.util.Scanner;

public class StudentDatabase {
    private final ArrayList<Student> studentList;

    public StudentDatabase() {
        studentList = new ArrayList<>();
    }

    public boolean isStudent(String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId))
                return true;
        }
        return false;
    }

    public boolean addStudent(Student student) {
        if (!(studentList.contains(student))) {
            studentList.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String studentId) {

        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    public void printStudents() {
        if (studentList.isEmpty())
            System.out.println("No Students added yet");
        else {
            for (Student student : studentList) {
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Student Name: " + student.getStudentName());
                System.out.println("Sex: " + student.getSex());
                System.out.println("Year: " + student.getYear());
                System.out.println("Phone No: " + student.getPhoneNo());
                System.out.println("Father Name: " + student.getFatherName());
                System.out.println("Father Phone No: " + student.getFatherPhoneNo());
                System.out.println("Hostel Name: " + student.getHostelName());
                System.out.println("Room Number: " + student.getRoomNumber());
                System.out.println();
            }
        }
    }

    public void printStudent(String studentID) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentID)) {
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Student Name: " + student.getStudentName());
                System.out.println("Sex: " + student.getSex());
                System.out.println("Year: " + student.getYear());
                System.out.println("Phone No: " + student.getPhoneNo());
                System.out.println("Father Name: " + student.getFatherName());
                System.out.println("Father Phone No: " + student.getFatherPhoneNo());
                System.out.println("Hostel Name: " + student.getHostelName());
                System.out.println("Room Number: " + student.getRoomNumber());
            }
        }
    }

    public void printNonAllocated() {
        System.out.println("Students to be allocated rooms:-");
        for (Student student : studentList) {
            if (student.getRoomNumber() == 0) {
                System.out.println(student.getStudentId() + " : " + student.getStudentName());
            }
        }
    }

    public Student find(String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}




