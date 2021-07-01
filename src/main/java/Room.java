import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Room {

    private String hostelId;
    private String hostelName;
    private int roomNumber;
    private int noOfBeds;
    private int noOfStudents;
    private int status;
    private Set<Student> studentList;

    public Room(String hostelId, String hostelName, int roomNumber, int noOfBeds) {
        this.hostelId = hostelId;
        this.hostelName = hostelName;
        this.roomNumber = roomNumber;
        this.noOfBeds = noOfBeds;
        this.studentList = new HashSet<>();
        this.noOfStudents = 0;
        this.status = 0;
    }

    public String getHostelId() {
        return hostelId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public int getStatus() {
        return status;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public boolean allocateRoom(Student student) {
        if (this.noOfStudents < this.noOfBeds) {
            student.setHostelId(this.hostelId);
            student.setHostelName(this.hostelName);
            student.setRoomNumber(this.roomNumber);
            this.studentList.add(student);
            this.noOfStudents += 1;
            if (this.noOfStudents == this.noOfBeds)
                status = 1;
            return true;
        }
        return false;
    }

    public boolean vacateRoom(Student student) {
        if (studentList.remove(student)) {
            this.noOfStudents -= 1;
            return true;
        } else
            return false;
    }

    @Override
    public boolean equals(Object objectCompared) {
        if (this == objectCompared) return true;
        if (!(objectCompared instanceof Room)) return false;
        Room room = (Room) objectCompared;
        return this.roomNumber == room.roomNumber && this.noOfBeds == room.noOfBeds && this.noOfStudents == room.noOfStudents && this.status == room.status && this.hostelId.equals(room.hostelId) && this.hostelName.equals(room.hostelName) && this.studentList.equals(room.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostelId, roomNumber);
    }
}

