import java.util.ArrayList;
import java.util.Objects;

public class Room {

    private String hostelId;
    private int roomNumber;
    private int noOfBeds;
    private int noOfStudents;
    private int status;
    private ArrayList<Student> studentList;

    public Room(String hostelId, int roomNumber, int noOfBeds) {
        this.hostelId = hostelId;
        this.roomNumber = roomNumber;
        this.noOfBeds = noOfBeds;
        this.studentList = new ArrayList<>();
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
        if (this.getNoOfStudents() < this.getNoOfBeds()) {
            student.setHostelName(this.hostelId);
            student.setRoomNumber(this.roomNumber);
            this.studentList.add(student);
            this.setNoOfStudents(this.getNoOfStudents() + 1);
            if (this.noOfStudents == this.noOfBeds)
                status = 1;
            return true;
        }
        return false;
    }

    public boolean vacateRoom(Student student) {
        if (this.studentList.contains(student)) {
            this.studentList.remove(student);
            this.setNoOfStudents(this.getNoOfStudents() + 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object objectCompared) {
        if (this == objectCompared) return true;
        if (!(objectCompared instanceof Room)) return false;
        Room room = (Room) objectCompared;
        return this.roomNumber == room.roomNumber && this.noOfBeds == room.noOfBeds && this.noOfStudents == room.noOfStudents && this.status == room.status && this.hostelId.equals(room.hostelId) && this.studentList.equals(room.studentList);
    }
}

