import java.util.ArrayList;

public class HostelDatabase {
    private final ArrayList<Hostel> hostelList;

    public HostelDatabase() {
        hostelList = new ArrayList<>();
    }

    public boolean addHostel(Hostel hostel) {
        if (!(hostelList.contains(hostel))) {
            hostelList.add(hostel);
            return true;
        }
        return false;
    }

    public boolean removeHostel(String hostelId) {
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(hostelId)) {
                hostelList.remove(hostel);
                return true;
            }
        }
        return false;
    }

    public boolean addRoom(String hostelId, Room room) {
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(hostelId)) {
                hostel.addRoom(room);
                return true;
            }
        }
        return false;
    }

    public boolean removeRoom(String hostelId, int roomNo) {
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(hostelId)) {
                hostel.removeRoom(roomNo);
                return true;
            }
        }
        return false;
    }

    public boolean addStudent(Student student) {
        for (Hostel hostel : hostelList) {
            if (hostel.getTypeOfHostel().equals(student.getSex()) && hostel.getYearOfHostel() == student.getYear()) {
                hostel.allocate(student);
                return true;
            }
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        String hostelName = student.getHostelName();
        for (Hostel hostel : hostelList) {
            if (hostel.getHostelId().equals(hostelName)) {
                hostel.vacate(student);
                return true;
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


