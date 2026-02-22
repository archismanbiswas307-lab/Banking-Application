# Banking Application

A desktop-based ATM simulation application built with Java and Swing GUI framework. This application provides a complete banking system where users can perform various transactions through an ATM-like interface.

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Database Configuration](#database-configuration)
- [How to Run](#how-to-run)
- [User Guide](#user-guide)
- [File Descriptions](#file-descriptions)
- [Dependencies](#dependencies)
- [Security Notes](#security-notes)

## Features

### User Authentication
- **Login**: Users can log in using their card number and PIN
- **Sign Up**: New users can register through a three-step registration process
  - Step 1: Personal Details (Name, Father's Name, Mother's Name, DOB, Gender, Marital Status)
  - Step 2: Address & Contact Information (Address, City, State, PIN)
  - Step 3: Account Details & Verification

### Banking Transactions
- **Deposit**: Add funds to the account
- **Withdrawal**: Withdraw funds from the account
- **Fast Cash**: Quick withdrawal with preset amounts (₹100, ₹500, ₹1000, ₹2000, ₹5000, ₹10000)
- **Balance Enquiry**: Check current account balance
- **Mini Statement**: View transaction history with current balance
- **PIN Change**: Update the account PIN securely

## Project Structure

```
Banking Application/
├── Login.java                 # Login screen and authentication
├── SignUpOne.java            # First step of registration (personal details)
├── SignUpTwo.java            # Second step of registration (address/contact)
├── SignUpThree.java          # Third step of registration (account details)
├── transactions.java         # Main transaction menu screen
├── deposit.java              # Deposit transaction handler
├── withdrawl.java            # Withdrawal transaction handler
├── fastcash.java             # Fast cash withdrawal interface
├── BalanceEnquiry.java       # Balance checking functionality
├── MiniStatement.java        # Transaction history display
├── pinchange.java            # PIN change functionality
├── Conn.java                 # Database connection handler
├── lib/                      # External libraries
│   ├── mysql-connector-java-8.0.28.jar
│   └── jcalendar-tz-1.3.3-4.jar
├── icons/                    # Application images
│   ├── atm.jpg              # ATM interface background image
│   └── logo.jpg             # Bank logo
└── [*.class files]           # Compiled Java bytecode
```

## Technology Stack

- **Language**: Java
- **GUI Framework**: Swing (javax.swing)
- **Database**: MySQL
- **JDBC Driver**: MySQL Connector/J 8.0.28
- **Calendar Component**: JCalendar (jcalendar-tz-1.3.3-4.jar)
- **IDE**: Visual Studio Code (with Java extensions)

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server installed and running
- MySQL Connector/J driver (included in lib/)
- JCalendar library (included in lib/)

## Installation & Setup

### 1. Clone or Extract the Project
```bash
# Navigate to project directory
cd "e:\PROJECTS\Banking  Application"
```

### 2. Create MySQL Database

Create the required database tables:

```sql
-- Create database
CREATE DATABASE bankmanagementsystem;
USE bankmanagementsystem;

-- Login table (stores card number and PIN)
CREATE TABLE logindata (
    Card_Number VARCHAR(20) PRIMARY KEY,
    Pin_Number VARCHAR(10) NOT NULL
);

-- Bank transactions table
CREATE TABLE BANK (
    Pin_Number VARCHAR(10),
    Date DATETIME,
    Type VARCHAR(20),  -- 'Deposit', 'withdraw', 'Fast Cash'
    Amount VARCHAR(20),
    FOREIGN KEY (Pin_Number) REFERENCES logindata(Pin_Number)
);

-- User details table (for signup information)
CREATE TABLE signup1 (
    formno VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    father_name VARCHAR(50),
    mother_name VARCHAR(50),
    dob DATE,
    gender VARCHAR(20),
    marital_status VARCHAR(20),
    email VARCHAR(100),
    address VARCHAR(200),
    city VARCHAR(50),
    state VARCHAR(50),
    pin_code VARCHAR(10)
);

-- You can add more tables as needed for signup2 and signup3
```

### 3. Configure Database Connection

Update the database credentials in [Conn.java](Conn.java#L15):

```java
c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","YOUR_PASSWORD");
```

Replace `Archis123@#` with your actual MySQL root password.

### 4. Compile the Project

```bash
# Compile all Java files
javac -cp "lib/mysql-connector-java-8.0.28.jar;lib/jcalendar-tz-1.3.3-4.jar" *.java
```

## Database Configuration

**Database Name**: `bankmanagementsystem`

**Default Connection**:
- Host: localhost
- Port: 3306
- User: root
- Password: (configured in Conn.java)

**Tables**:
- `logindata`: Stores user credentials (Card_Number, Pin_Number)
- `BANK`: Stores all transactions with timestamp, type, and amount
- `signup1`: Stores personal information during registration

## How to Run

### Method 1: Command Line
```bash
java -cp ".:lib/mysql-connector-java-8.0.28.jar;lib/jcalendar-tz-1.3.3-4.jar" Login
```

### Method 2: VS Code
1. Open VS Code
2. Open the project folder
3. Install "Extension Pack for Java" by Microsoft
4. Click on the Play button to run [Login.java](Login.java)

### Method 3: Java IDE (Eclipse, IntelliJ)
1. Create a new Java project
2. Add the project files
3. Add library JAR files to the classpath
4. Run [Login.java](Login.java) as the main entry point

## User Guide

### First Time Users - Registration

1. **Launch Application**: Run the Login screen
2. **Click "SIGN UP"**: Begin the registration process
3. **Step 1 - Personal Details**:
   - Enter your name, father's name, and mother's name
   - Select date of birth from the date picker
   - Choose your gender and marital status
   
4. **Step 2 - Address & Contact**:
   - Enter email address
   - Enter full address and city
   - Select your state and PIN code
   
5. **Step 3 - Account Details**:
   - Set your initial PIN (4-6 digits)
   - Create your 16-digit card number
   - Confirm and submit

### Existing Users - Login

1. **Enter Card Number**: Your 16-digit card number
2. **Enter PIN**: Your account PIN
3. **Click "SIGN IN"**: Access your account
4. **Click "CLEAR"**: Clear the form fields

### Transaction Menu

Once logged in, you'll see the transaction menu with the following options:

- **Deposit**: Add money to your account
- **Withdrawal**: Withdraw money from your account
- **Fast Cash**: Quick withdrawal with preset amounts
- **Mini Statement**: View recent transactions and balance
- **Pin Change**: Update your PIN securely
- **Balance Enquiry**: Check current account balance
- **Exit**: Logout and exit

## File Descriptions

### Core Authentication Files

| File | Purpose |
|------|---------|
| [Login.java](Login.java) | Main login interface and credential verification |
| [SignUpOne.java](SignUpOne.java) | Registration form - Step 1 (Personal Information) |
| [SignUpTwo.java](SignUpTwo.java) | Registration form - Step 2 (Address Information) |
| [SignUpThree.java](SignUpThree.java) | Registration form - Step 3 (Account Setup) |

### Transaction Processing Files

| File | Purpose |
|------|---------|
| [transactions.java](transactions.java) | Main menu displaying all transaction options |
| [deposit.java](deposit.java) | Handles account deposits |
| [withdrawl.java](withdrawl.java) | Handles account withdrawals |
| [fastcash.java](fastcash.java) | Quick cash withdrawal with preset amounts |
| [BalanceEnquiry.java](BalanceEnquiry.java) | Displays current account balance |
| [MiniStatement.java](MiniStatement.java) | Shows transaction history and balance |
| [pinchange.java](pinchange.java) | Allows users to change their PIN |

### Database & Utility Files

| File | Purpose |
|------|---------|
| [Conn.java](Conn.java) | MySQL database connection and statement creation |

## Dependencies

### Required JAR Files (in `lib/` folder)

1. **mysql-connector-java-8.0.28.jar**
   - MySQL JDBC driver for database connectivity
   - Version: 8.0.28

2. **jcalendar-tz-1.3.3-4.jar**
   - Date picker component for registration
   - Used in SignUpOne.java for Date of Birth selection

### Java Built-in Libraries Used

- `java.awt.*` - GUI components and graphics
- `java.awt.event.*` - Event handling
- `java.sql.*` - Database operations
- `java.util.*` - Utility classes
- `java.text.*` - Text formatting and parsing
- `javax.swing.*` - Swing GUI components

## Security Notes

⚠️ **Important Security Warnings**:

1. **Credentials in Code**: The database password is hardcoded in [Conn.java](Conn.java#L13). This is NOT recommended for production systems.
   - **Better Practice**: Use environment variables or configuration files
   - **Production**: Implement proper authentication and use connection pooling

2. **SQL Injection Vulnerability**: The application uses string concatenation for SQL queries.
   - **Recommendation**: Use prepared statements to prevent SQL injection
   - Example: Use `PreparedStatement` instead of `Statement`

3. **Password Storage**: PINs should be hashed before storing in the database
   - **Current**: PINs are stored in plain text
   - **Recommendation**: Use bcrypt, PBKDF2, or similar hashing algorithms

4. **No Encryption**: Communication between application and database is not encrypted
   - **Recommendation**: Use SSL/TLS for database connections

5. **Input Validation**: Limited input validation and error handling
   - **Recommendation**: Implement comprehensive validation for all user inputs

## Building & Compiling

### Using Command Line

```bash
# Navigate to project directory
cd "e:\PROJECTS\Banking  Application"

# Compile all Java files
javac -cp "lib/mysql-connector-java-8.0.28.jar;lib/jcalendar-tz-1.3.3-4.jar" *.java

# Run the application
java -cp ".:lib/mysql-connector-java-8.0.28.jar;lib/jcalendar-tz-1.3.3-4.jar" Login
```

### Using Build Tools

Consider using Maven or Gradle for better dependency management in future versions.

## Troubleshooting

### Common Issues

1. **"No suitable driver found"**
   - Ensure `mysql-connector-java-8.0.28.jar` is in the classpath

2. **"Connection refused"**
   - Verify MySQL server is running
   - Check database credentials in [Conn.java](Conn.java)
   - Ensure database `bankmanagementsystem` exists

3. **"ClassNotFoundException for JDateChooser"**
   - Ensure `jcalendar-tz-1.3.3-4.jar` is in the classpath

4. **"Icons not found"**
   - Ensure `icons/` folder is in the same directory as compiled classes
   - Check that `atm.jpg` and `logo.jpg` exist in the icons folder

## Future Enhancements

- [ ] Implement prepared statements to prevent SQL injection
- [ ] Add transaction search and filtering
- [ ] Implement fund transfer between accounts
- [ ] Add bill payment functionality
- [ ] Implement mobile responsiveness
- [ ] Add transaction receipts/printing
- [ ] Implement two-factor authentication
- [ ] Add transaction alerts and notifications
- [ ] Create an admin panel for account management
- [ ] Add transaction history export (CSV/PDF)

## License

This is an educational project for learning Java GUI and database programming.

## Author

Developed as a Banking Application System Learning Project

## Support

For issues or questions, please review the code comments and error messages in the console output.

---

**Last Updated**: February 22, 2026
