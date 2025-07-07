import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AJPetrolPumpGUI {
    public static void main(String[] args) {
        // Start with the Welcome Interface

        new WelcomeInterface(); 
    }
}

// Welcome Interface
class WelcomeInterface {
    public WelcomeInterface() {
        JFrame frame = new JFrame("Welcome");
        frame.setSize(600, 400);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to AJ Petrol Pump System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Algerian", Font.PLAIN, 28));
        welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);

        JButton proceedButton = new JButton("Main Menu");
        proceedButton.setFont(new Font("Algerian", Font.PLAIN, 18));
        proceedButton.setBackground(Color.white);
        proceedButton.setForeground(Color.black);
        proceedButton.addActionListener(e -> {
            
            // Close the Welcome Interface
            frame.dispose(); 
            // Open the Main Menu
            new MainMenu(); 
        });

        frame.add(welcomeLabel, BorderLayout.CENTER);
        frame.add(proceedButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

// Main Menu
class MainMenu {
    public MainMenu() {
        JFrame frame = new JFrame("AJ Petrol Station");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JButton workerButton = new JButton("Worker");
        workerButton.setFont(new Font("Algerian", Font.PLAIN, 14));
        workerButton.setBackground(Color.white);
        workerButton.setForeground(Color.black);
        JButton carWashButton = new JButton("Car Wash");
        carWashButton.setFont(new Font("Algerian", Font.PLAIN, 14));
        carWashButton.setBackground(Color.white);
        carWashButton.setForeground(Color.black);
        JButton managerButton = new JButton("Manager");
        managerButton.setFont(new Font("Algerian", Font.PLAIN, 14));
        managerButton.setBackground(Color.white);
        managerButton.setForeground(Color.black);
        JButton tuckshopButton = new JButton("Tuckshop");
        tuckshopButton.setFont(new Font("Algerian", Font.PLAIN, 14));
        tuckshopButton.setBackground(Color.white);
        tuckshopButton.setForeground(Color.black);
        JButton fuelButton = new JButton("Fuel");
        fuelButton.setFont(new Font("Algerian", Font.PLAIN, 14));
        fuelButton.setBackground(Color.white);
        fuelButton.setForeground(Color.black);

        frame.add(workerButton);
        frame.add(carWashButton);
        frame.add(managerButton);
        frame.add(tuckshopButton);
        frame.add(fuelButton);

        workerButton.addActionListener(e -> new WorkerLoginInterface());
        carWashButton.addActionListener(e -> new CarWashInterface());
        managerButton.addActionListener(e -> new ManagerLoginInterface());
        tuckshopButton.addActionListener(e -> new TuckshopInterface());
        fuelButton.addActionListener(e -> new FuelInterface());

        frame.setVisible(true);
    }

    public class WorkerLoginInterface {
        public WorkerLoginInterface() {
            JFrame frame = new JFrame("Worker Login");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new GridLayout(4, 2, 15, 15));

            JLabel idLabel = new JLabel("Login ID:");
            JTextField idField = new JTextField();
            JLabel passwordLabel = new JLabel("Password:");
            JPasswordField passwordField = new JPasswordField();
            JButton loginButton = new JButton("Login");
            JButton returnButton = new JButton("return");

            frame.add(idLabel);
            frame.add(idField);
            frame.add(passwordLabel);
            frame.add(passwordField);
            frame.add(new JLabel());
            frame.add(new JLabel());
            frame.add(loginButton);
            loginButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            loginButton.setBackground(Color.white);
            loginButton.setForeground(Color.black);
            frame.add(returnButton);
            returnButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            returnButton.setBackground(Color.white);
            returnButton.setForeground(Color.black);

            loginButton.addActionListener(e -> {
                try {
                    int loginId = Integer.parseInt(idField.getText().trim());
                    String password = new String(passwordField.getPassword()).trim();

                    // Validate credentials (example: Login ID = 1 & 2, Password = "W123")
                    if (loginId == 1 && password.equals("12345")) {
                        frame.dispose();
                        new WorkerInterface();
                    }
                    else if (loginId == 2 && password.equals("12345")) {
                            frame.dispose();
                            new WorkerInterface(); 
                    } else {
                        throw new IllegalArgumentException("Invalid Login ID or Password.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Login ID.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            returnButton.addActionListener(e -> frame.dispose());

            frame.setVisible(true);
        }
    }

    public class WorkerInterface {
        public WorkerInterface() {
            JFrame frame = new JFrame("Worker");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new GridLayout(8, 1, 15, 15));
    
            JTextField nameField = new JTextField();
            JComboBox<String> dutyComboBox = new JComboBox<>(new String[]{"Carwash", "Petrol Refill"});
            dutyComboBox.setFont(new Font("Algerian", Font.PLAIN, 14));
            JTextField hoursField = new JTextField();
            JTextField rateField = new JTextField();
            JButton submitButton = new JButton("Submit");
            submitButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            JButton clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            JButton ShowsavedataButton = new JButton("Show Save Data");
            ShowsavedataButton.setFont(new Font("Algerian", Font.PLAIN, 14));
    
            frame.add(new JLabel("Name:"));
            frame.add(nameField);
            frame.add(new JLabel("Duty:"));
            frame.add(dutyComboBox);
            frame.add(new JLabel("Hours Worked:"));
            frame.add(hoursField);
            frame.add(new JLabel("Hourly Rate:"));
            frame.add(rateField);
            frame.add(submitButton);
            submitButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            submitButton.setBackground(Color.white);
            submitButton.setForeground(Color.black);
            frame.add(clearButton);
            clearButton.setBackground(Color.white);
            clearButton.setForeground(Color.black);
            frame.add(ShowsavedataButton);
            ShowsavedataButton.setBackground(Color.white);
            ShowsavedataButton.setForeground(Color.black);
    
            submitButton.addActionListener(e -> {
                try {
                    String name = nameField.getText().trim();

                    if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(frame,
                                "Please enter a valid name (Alphabets and spaces only).",
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String duty = (String) dutyComboBox.getSelectedItem();
                    int hoursWorked = Integer.parseInt(hoursField.getText().trim());
                    double hourlyRate = Double.parseDouble(rateField.getText().trim());
                    
    
                    // Connect to the database and insert worker data
                    String insertSQL = "INSERT INTO worker (name, duty, hours_worked, hourlyrate) VALUES (?, ?, ?, ?)";
    
                    try (Connection connection = DBConnection.getConnection()) {
                        var stmt = connection.prepareStatement(insertSQL);
                        stmt.setString(1, name);
                        stmt.setString(2, duty);
                        stmt.setInt(3, hoursWorked);
                        stmt.setDouble(4, hourlyRate);
    
                        int rowsAffected = stmt.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(frame, "Worker data saved successfully!");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving worker data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter valid numeric values for Hours Worked and Hourly Rate.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            clearButton.addActionListener(e -> {
                nameField.setText("");
                hoursField.setText("");
                rateField.setText("");
                dutyComboBox.setSelectedIndex(0);
            });
    
            ShowsavedataButton.addActionListener(e -> {
                // Connect to the database and fetch worker data
                String fetchSQL = "SELECT * FROM worker";
    
                try (Connection connection = DBConnection.getConnection()) {
                    var stmt = connection.createStatement();
                    var rs = stmt.executeQuery(fetchSQL);
    
                    StringBuilder data = new StringBuilder("Worker Data:\n");
    
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String duty = rs.getString("duty");
                        int hoursWorked = rs.getInt("hours_worked");
                        double hourlyRate = rs.getDouble("hourlyrate");
    
                        data.append("Name: ").append(name)
                            .append(", Duty: ").append(duty)
                            .append(", Hours Worked: ").append(hoursWorked)
                            .append(", Hourly Rate: ").append(hourlyRate)
                            .append("\n");
                    }
    
                    if (data.length() > "Worker Data:\n".length()) {
                        JOptionPane.showMessageDialog(frame, data.toString());
                    } else {
                        JOptionPane.showMessageDialog(frame, "No worker data found.");
                    }
    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error Showing worker data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            frame.setVisible(true);
        }
    }
    

    // Car Wash Interface

    public class CarWashInterface {
        public CarWashInterface() {
            JFrame frame = new JFrame("Car Wash");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new GridLayout(7, 1, 15, 15));
    
            JTextField carNameField = new JTextField();
            JComboBox<String> washTypeComboBox = new JComboBox<>(new String[]{"full", "inner", "outer"});
            washTypeComboBox.setFont(new Font("Algerian", Font.PLAIN, 14));
            JTextField carModelField = new JTextField();
            JButton submitButton = new JButton("Submit");
            submitButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            JButton clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            JButton washDetailButton = new JButton("Show Save Data");
            washDetailButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            frame.add(new JLabel("Car Name:"));
            frame.add(carNameField);
            frame.add(new JLabel("Wash Type:"));
            frame.add(washTypeComboBox);
            frame.add(new JLabel("Car Model (1800-2024):"));
            frame.add(carModelField);
            frame.add(submitButton);
            submitButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            submitButton.setBackground(Color.white);
            submitButton.setForeground(Color.black);
            frame.add(clearButton);
            clearButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            clearButton.setBackground(Color.white);
            clearButton.setForeground(Color.black);
            frame.add(washDetailButton);
            washDetailButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            washDetailButton.setBackground(Color.white);
            washDetailButton.setForeground(Color.black);
    
            // Submit button action
            submitButton.addActionListener(e -> {
                try {
                    String carName = carNameField.getText().trim();
                    String washType = (String) washTypeComboBox.getSelectedItem();
                    int carModel = Integer.parseInt(carModelField.getText().trim());

                    if (carModel < 1800 || carModel > 2024) {
                        JOptionPane.showMessageDialog(frame,
                                "Car Model must be between 1800 and 2024.",
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                        return; // Stop further execution
                    }
            
    
                    // Calculate price based on wash type
                    int price = switch (washType) {
                        case "full" -> CarWash.FULL_WASH_PRICE;
                        case "inner" -> CarWash.INNER_WASH_PRICE;
                        case "outer" -> CarWash.OUTER_WASH_PRICE;
                        default -> 0;
                    };
    
                    // Insert car wash data into the database
                    String insertSQL = "INSERT INTO car_wash (car_name, wash_type, car_model, price) VALUES (?, ?, ?, ?)";
    
                    try (Connection connection = DBConnection.getConnection()) {
                        var stmt = connection.prepareStatement(insertSQL);
                        stmt.setString(1, carName);
                        stmt.setString(2, washType);
                        stmt.setInt(3, carModel);
                        stmt.setInt(4, price);
    
                        int rowsAffected = stmt.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(frame, "Car wash details saved successfully!");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving car wash details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter a valid numeric value for Car Model.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            // Clear button action
            clearButton.addActionListener(e -> {
                carNameField.setText("");
                carModelField.setText("");
                washTypeComboBox.setSelectedIndex(0);
            });
    
            // Wash Detail button action
            washDetailButton.addActionListener(e -> {
                String fetchSQL = "SELECT * FROM car_wash";
    
                try (Connection connection = DBConnection.getConnection()) {
                    var stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(fetchSQL);
    
                    // Use StringBuilder to compile the fetched data
                    StringBuilder data = new StringBuilder("Car Wash Details:\n\n");
                    while (rs.next()) {
                        String carName = rs.getString("car_name");
                        String washType = rs.getString("wash_type");
                        int carModel = rs.getInt("car_model");
                        int price = rs.getInt("price");
    
                        data.append("Car Name: ").append(carName)
                            .append("\nWash Type: ").append(washType)
                            .append("\nCar Model: ").append(carModel)
                            .append("\nPrice: ").append(price)
                            .append("\n\n");
                    }
    
                    // Display the data in a JOptionPane
                    if (data.length() > "Car Wash Details:\n\n".length()) {
                        JOptionPane.showMessageDialog(frame, data.toString());
                    } else {
                        JOptionPane.showMessageDialog(frame, "No car wash data found.");
                    }
    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error fetching car wash data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            frame.setVisible(true);
        }
    }

    public class ManagerLoginInterface {
    public ManagerLoginInterface() {
        JFrame frame = new JFrame("Manager Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 15, 15));

        JLabel idLabel = new JLabel("Login ID:");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Algerian", Font.PLAIN, 14));
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Algerian", Font.PLAIN, 14));
        frame.add(idLabel);
        frame.add(idField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel()); // Placeholder for alignment
        frame.add(new JLabel());
        frame.add(loginButton);
        loginButton.setFont(new Font("Algerian", Font.PLAIN, 14));
        frame.add(cancelButton);
        cancelButton.setFont(new Font("Algerian", Font.PLAIN, 14));

        loginButton.setBackground(Color.white);
        loginButton.setForeground(Color.black);
        cancelButton.setBackground(Color.white);
        cancelButton.setForeground(Color.black);

        // Action Listener for Login Button
        loginButton.addActionListener(e -> {
            try {
                int loginId = Integer.parseInt(idField.getText().trim());
                String password = new String(passwordField.getPassword()).trim();

                // Validate credentials (example: Login ID = 12, Password = "AJ123")
                if (loginId == 12 && password.equals("AJ123")) {
                    frame.dispose(); // Close the login window
                    new ManagerInterface(); // Open Manager Interface
                } else {
                    throw new IllegalArgumentException("Invalid Login ID or Password.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Login ID.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action Listener for Cancel Button
        cancelButton.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}

    // Manager Interface
    public class ManagerInterface {
        public ManagerInterface() {
            JFrame frame = new JFrame("Manager");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new GridLayout(5, 3, 15, 15));
    
            JTextField managerNameField = new JTextField();
            JTextField managerIdField = new JTextField();
            JTextField workingHoursField = new JTextField();
            JButton submitButton = new JButton("Submit");
            JButton clearButton = new JButton("Clear");
    
            frame.add(new JLabel("Manager Name:"));
            frame.add(managerNameField);
            frame.add(new JLabel("Manager ID:"));
            frame.add(managerIdField);
            frame.add(new JLabel("Working Hours:"));
            frame.add(workingHoursField);
            frame.add(new JLabel());
            frame.add(submitButton);
            submitButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            submitButton.setBackground(Color.white);
            submitButton.setForeground(Color.black);
            frame.add(new JLabel());
            frame.add(clearButton);
            clearButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            clearButton.setBackground(Color.white);
            clearButton.setForeground(Color.black);
    
            // Submit button action
            submitButton.addActionListener(e -> {
                try {
                    String name = managerNameField.getText().trim();
                    int id = Integer.parseInt(managerIdField.getText().trim());
                    int hours = Integer.parseInt(workingHoursField.getText().trim());
    
                    if (id != 1234) {
                        JOptionPane.showMessageDialog(frame, "ID must be 1234.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
    
                    Manager manager = new Manager(name, id, hours);
    
                    // Display Manager details in a new frame
                    JFrame infoFrame = new JFrame("Manager Details");
                    infoFrame.setSize(400, 300);
                    infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    infoFrame.setLayout(new BorderLayout());
    
                    JTextArea infoTextArea = new JTextArea();
                    infoTextArea.setText(
                            "MANAGER NAME: " + manager.getManagerName() + "\n" +
                            "MANAGER ID: " + manager.getManagerId() + "\n" +
                            "WORKING HOURS: " + manager.getWorkingHours()
                    );
                    infoTextArea.setEditable(false);
                    infoFrame.add(new JScrollPane(infoTextArea), BorderLayout.CENTER);
    
                    infoFrame.setVisible(true);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID and Working Hours.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            // Clear button action
            clearButton.addActionListener(e -> {
                managerNameField.setText(""); // Clear the Manager Name field
                managerIdField.setText("");   // Clear the Manager ID field
                workingHoursField.setText(""); // Clear the Working Hours field
            });
    
            frame.setVisible(true);
        }
    }
    // Tuckshop Interface
    class TuckshopInterface {
        private static final String price = null;
        
                public TuckshopInterface() {
                    JFrame frame = new JFrame("Tuckshop");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel itemsLabel = new JLabel("Select Item:");
        JComboBox<String> itemsComboBox = new JComboBox<>(new String[]{"Biscuit", "Bubble", "Cold Drink", "Chocolate"});
        itemsComboBox.setFont(new Font("Algerian", Font.PLAIN, 14));

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Algerian", Font.PLAIN, 14));
        JLabel resultLabel = new JLabel("Total Price: PKR 0.00", JLabel.CENTER);

        frame.add(itemsLabel);
        frame.add(itemsComboBox);
        itemsComboBox.setBackground(Color.white);
        itemsComboBox.setForeground(Color.black);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(new JLabel());
        frame.add(calculateButton);
        calculateButton.setBackground(Color.white);
        calculateButton.setForeground(Color.black);
        
        frame.add(resultLabel);

        calculateButton.addActionListener(e -> {
            try {
                String item = (String) itemsComboBox.getSelectedItem();
                int quantity = Integer.parseInt(quantityField.getText());

                double pricePerItem = switch (item) {
                    case "Biscuit" -> 60.0;
                    case "Bubble" -> 10.0;
                    case "Cold Drink" -> 120.0;
                    case "Chocolate" -> 250.0;
                    default -> 0.0;
                };

                double totalPrice = quantity * pricePerItem;
                resultLabel.setText("Total Price: PKR " + String.format("%.2f", totalPrice));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid quantity!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
    class FuelInterface {
        public FuelInterface() {

        JFrame frame = new JFrame("Fuel Price Calculator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

            // Input fields
            JTextField quantityField = new JTextField();
            JComboBox<String> fuelComboBox = new JComboBox<>(new String[] { "Petrol", "Diesel" });
            fuelComboBox.setFont(new Font("Algerian", Font.PLAIN, 14));
            JButton calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font("Algerian", Font.PLAIN, 14));
            JLabel resultLabel = new JLabel("Total Price: PKR 0.00", JLabel.CENTER);

            // Add components to frame
            frame.add(new JLabel("Enter Quantity (liters):"));
            frame.add(quantityField);
            frame.add(new JLabel("Select Fuel Type:"));
            frame.add(fuelComboBox);
            fuelComboBox.setBackground(Color.white);
            fuelComboBox.setForeground(Color.black);
            frame.add(calculateButton);
            calculateButton.setBackground(Color.white);
            calculateButton.setForeground(Color.black);
            frame.add(resultLabel);

            // Add action listener for the button
            calculateButton.addActionListener(e -> {
                try {
                    double quantity = Double.parseDouble(quantityField.getText());
                    String selectedFuel = (String) fuelComboBox.getSelectedItem();

                    Fuel fuel;
                    if ("Petrol".equals(selectedFuel)) {
                        fuel = new Petrol();
                    } else {
                        fuel = new Diesel();
                    }


              double price = fuel.calculatePrice(quantity);

                    resultLabel.setText("Total Price: PKR " + String.format("%.2f", price));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                "Please enter a valid quantity!",
                "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
            });

            frame.setVisible(true);
        }
    }
    public class DBConnection {
        public static Connection getConnection() throws SQLException {
            try {
                // Load the MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/aj_petrol_pump_system", "root", "");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new SQLException("Database connection failed.");
            }
        }
    }
    
}
