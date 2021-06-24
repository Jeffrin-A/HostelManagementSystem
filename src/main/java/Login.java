public class Login {
    private String adminId;
    private String adminPassword;

    public Login() {
        this.adminId = "Admin";
        this.adminPassword = "admin@7732";
    }

    public boolean checkIfAdmin(String adminId, String adminPassword) {
        return this.adminId.equals(adminId) && this.adminPassword.equals(adminPassword);
    }

    public boolean checkIfStudent(String studentId, StudentDatabase studentDatabase) {
        return studentDatabase.isStudent(studentId);
    }
}

