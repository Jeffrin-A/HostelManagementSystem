import java.util.Objects;

public class Student {
    private final String studentId;
    private final String studentName;
    private final String sex;
    private final String fatherName;
    private final String phoneNo;
    private final String fatherPhoneNo;
    private final int year;
    private String hostelId;
    private String hostelName;
    private int roomNumber;

    public Student(String studentId, String studentName, String sex, String fatherName, String phoneNo, String fatherPhoneNo, int year) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.sex = sex;
        this.fatherName = fatherName;
        this.phoneNo = phoneNo;
        this.fatherPhoneNo = fatherPhoneNo;
        this.year = year;
        this.hostelId="Not assigned";
        this.hostelName = "Not assigned";
        this.roomNumber = 0;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSex() {
        return sex;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getFatherPhoneNo() {
        return fatherPhoneNo;
    }

    public int getYear() {
        return year;
    }

    public String getHostelName() {
        return hostelName;
    }

    public String getHostelId() {
        return hostelId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setHostelId(String hostelId) {
        this.hostelId = hostelId;
    }

    @Override
    public boolean equals(Object objectCompared) {
        if (this == objectCompared) return true;
        if (!(objectCompared instanceof Student)) return false;
        Student student = (Student) objectCompared;
        return this.year == student.year && this.roomNumber == student.roomNumber && this.studentId.equals(student.studentId) && this.studentName.equals(student.studentName) && this.sex.equals(student.sex) && this.fatherName.equals(student.fatherName) && this.phoneNo.equals(student.phoneNo) && this.fatherPhoneNo.equals(student.fatherPhoneNo) && this.hostelName.equals(student.hostelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
