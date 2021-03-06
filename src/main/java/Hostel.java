import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hostel {
    private final String hostelId;
    private final String hostelName;
    private final String typeOfHostel;
    private final int yearOfHostel;
    private final String wardenName;
    private final String wardenPhoneNo;
    private int noOfRooms;
    private int noOfStudents;
    private final Set<Room> roomList;

    public Hostel(String hostelId, String hostelName, String typeOfHostel, int yearOfHostel, String wardenName, String wardenPhoneNo) {
        this.hostelId = hostelId;
        this.hostelName = hostelName;
        this.typeOfHostel = typeOfHostel;
        this.yearOfHostel = yearOfHostel;
        this.wardenName = wardenName;
        this.wardenPhoneNo = wardenPhoneNo;
        this.noOfRooms = 0;
        this.noOfStudents = 0;
        roomList = new HashSet<>();
    }

    public String getHostelId() {
        return hostelId;
    }

    public String getHostelName() {
        return hostelName;
    }

    public String getTypeOfHostel() {
        return typeOfHostel;
    }

    public int getYearOfHostel() {
        return yearOfHostel;
    }

    public String getWardenName() {
        return wardenName;
    }

    public String getWardenPhoneNo() {
        return wardenPhoneNo;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public boolean addRoom(Room roomToAdd) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == roomToAdd.getRoomNumber())
                return false;
        }
        this.noOfRooms += 1;
        return roomList.add(roomToAdd);
    }

    public void addStudent() {
        this.noOfStudents += 1;
    }

    public void removeStudent() {
        this.noOfStudents -= 1;
    }

    public boolean removeRoom(int roomNo) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == roomNo)
                this.noOfRooms -= 1;
            return roomList.remove(room);
        }
        return false;
    }

    public boolean allocate(Student student) {
        for (Room room : roomList) {
            if (room.getStatus() == 0) {
                this.noOfStudents += 1;
                return room.allocateRoom(student);
            }
        }
        return false;
    }

    public boolean vacate(Student student) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == student.getRoomNumber()) {
                this.noOfStudents -= 1;
                return room.vacateRoom(student);
            }
        }
        return false;
    }

    public void printHostelDetails() {
        System.out.println("HostelId: " + hostelId);
        System.out.println("HostelName: " + hostelName);
        System.out.println("TypeOfHostel: " + typeOfHostel);
        System.out.println("YearOfHostel: " + yearOfHostel);
        System.out.println("WardenName: " + wardenName);
        System.out.println("No of Rooms: " + noOfRooms);
        System.out.println("No of Students: " + noOfStudents);
    }

    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject)
            return true;
        if (!(comparedObject instanceof Hostel))
            return false;
        Hostel hostel = (Hostel) comparedObject;
        return this.yearOfHostel == hostel.yearOfHostel && this.noOfRooms == hostel.noOfRooms && this.noOfStudents == hostel.noOfStudents && this.hostelId.equals(hostel.hostelId) && this.hostelName.equals(hostel.hostelName) && this.typeOfHostel.equals(hostel.typeOfHostel) && this.wardenName.equals(hostel.wardenName) && this.wardenPhoneNo.equals(hostel.wardenPhoneNo) && this.roomList.equals(hostel.roomList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostelId);
    }
}
