import java.util.HashSet;
import java.util.Set;

public class HostelDatabase {
    private final Set<Hostel> hostelList;

    public HostelDatabase() {
        hostelList = new HashSet<>();
    }

    public boolean addHostel(Hostel hostelToAdd) {
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(hostelToAdd.getHostelId()))
                return false;
        }
        return hostelList.add(hostelToAdd);
    }

    public boolean removeHostel(String hostelId) {
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(hostelId)) {
                return hostelList.remove(hostel);
            }
        }
        return false;
    }

    public boolean addRoom(String hostelId, Room room) {
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(hostelId))
                return hostel.addRoom(room);
        }
        return false;
    }

    public boolean removeRoom(String hostelId, int roomNo) {
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(hostelId)) {
               return hostel.removeRoom(roomNo);
            }
        }
        return false;
    }

    public boolean addStudent(Student student) {
        for (Hostel hostel : hostelList) {
            if (hostel.getTypeOfHostel().equalsIgnoreCase(student.getSex()) && hostel.getYearOfHostel() == student.getYear()) {
                return hostel.allocate(student);
            }
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(student.getHostelId())) {
                return hostel.vacate(student);
            }
        }
        return false;
    }

    public void printHostelsDetails() {
        if (hostelList.isEmpty())
            System.out.println("No Hostels added yet");
        else {
            for (Hostel hostel : hostelList) {
                System.out.println("Hostel Id: " + hostel.getHostelId());
                System.out.println("Hostel Name: " + hostel.getHostelName());
                System.out.println("Type of Hostel: " + hostel.getTypeOfHostel());
                System.out.println("Warden Name: " + hostel.getWardenName());
                System.out.println("Warden PhoneNo: " + hostel.getWardenPhoneNo());
                System.out.println("No of Rooms: " + hostel.getNoOfRooms());
                System.out.println("No of Students: " + hostel.getNoOfStudents());
                System.out.println();
            }
        }
    }

    public void printHostelDetails(String hostelId) {
        int flag = 0;
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(hostelId)) {
                System.out.println("Hostel Id: " + hostel.getHostelId());
                System.out.println("Hostel Name: " + hostel.getHostelName());
                System.out.println("Type of Hostel: " + hostel.getTypeOfHostel());
                System.out.println("Warden Name: " + hostel.getWardenName());
                System.out.println("Warden PhoneNo: " + hostel.getWardenPhoneNo());
                System.out.println("No of Rooms: " + hostel.getNoOfRooms());
                System.out.println("No of Students: " + hostel.getNoOfStudents());
                System.out.println();
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Hostel ID is wrong");
            System.out.println();
        }
    }
}


