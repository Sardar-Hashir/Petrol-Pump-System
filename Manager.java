public class Manager {

    private String managerName;
    private int managerId;
    private int workingHours; // Renamed to reflect the actual duty (working hours)

    private static final int DEFAULT_MANAGER_ID = 1234; // Improved constant naming

    // Constructor with proper initialization
    public Manager(String managerName, int managerId, int workingHours) {
        this.managerName = managerName;
        setManagerId(managerId); // Using setter for validation
        this.workingHours = workingHours;
    }

    // Getter and Setter for managerName
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    // Getter and Setter for managerId with validation
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        if (managerId == DEFAULT_MANAGER_ID) {
            this.managerId = managerId;
        } else {
            throw new IllegalArgumentException("Please enter a correct ID.");
        }
    }

    // Getter and Setter for workingHours
    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    // Method to display manager information
    public void displayManagerInfo() {
        System.out.println("Manager Name: " + managerName);
        System.out.println("Manager ID: " + managerId);
        System.out.println("Working Hours: " + workingHours);
    }
}
