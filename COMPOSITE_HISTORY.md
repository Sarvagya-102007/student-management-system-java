# Composite History – Student Management System

## Project Overview

The Student Management System was developed as a Java-based project to provide a simple and organized way to manage student records. The main idea behind the project was to create a practical application using Core Java concepts instead of depending on external frameworks or databases.

The project went through different stages during development. The initial focus was on understanding the requirements, planning the features, designing the classes, implementing the main functionality, and finally testing and improving the application.

The final version is a **CLI-based Student Management System** that runs directly in the terminal. It allows the user to manage student details, academic performance, attendance, and generate reports.

---

## Development History

### Stage 1 – Requirement Analysis

The first step was to identify what information and operations would be required in a student management application.

The main requirements identified were:

- Store student personal information
- Store course and semester details
- Store CGPA and academic information
- Manage attendance records
- Add new students
- View student records
- Search for students
- Update existing records
- Delete student records
- Calculate grades
- Calculate attendance percentage
- Generate student reports
- Store data so that it is available after restarting the program

The project was planned with simplicity in mind so that all major operations could be performed through a single application.

---

### Stage 2 – Initial Project Planning

After identifying the requirements, the project structure was planned using multiple Java classes.

The responsibilities were divided into separate files:

- `Main.java` – Handles the main menu and user interaction
- `Student.java` – Represents a student and stores student information
- `StudentManager.java` – Handles student record operations
- `FileManager.java` – Handles saving and loading student data
- `InputValidator.java` – Validates user input
- `ReportGenerator.java` – Generates the student report
- `README.md` – Contains project documentation
- `.gitignore` – Prevents generated files from being uploaded unnecessarily

This structure made the project easier to understand and maintain.

---

### Stage 3 – Student Class Development

The `Student.java` class was created first to represent individual student records.

The class contains important details such as:

- Student ID
- Student name
- Course
- Semester
- Email
- Phone number
- CGPA
- Total classes
- Attended classes

Methods were also added to calculate:

- Attendance percentage
- Grade based on CGPA
- Attendance status

The class implements `Serializable` so that student objects can be stored locally.

---

### Stage 4 – Student Management Features

The next stage focused on managing multiple student records.

`StudentManager.java` was created using `ArrayList<Student>` to store the student objects.

The following operations were implemented:

1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student

A duplicate ID check was also added so that two students cannot be stored with the same ID.

Search functionality was designed to work with multiple fields such as student ID, name, course, and email.

---

### Stage 5 – Input Validation

Input validation was added to make the application more reliable and prevent incorrect values from being entered.

The `InputValidator.java` class handles different types of input.

For example:

- Semester is restricted to a valid range
- CGPA is restricted between 0 and 10
- Phone number must contain 10 digits
- Email must follow a valid format
- Empty text input is not accepted
- Invalid numeric input is handled without crashing the program

This helped make the application more user-friendly during terminal interaction.

---

### Stage 6 – File Handling and Data Persistence

One of the important requirements was to make sure that student records were not lost when the program was closed.

For this purpose, `FileManager.java` was implemented using Java Serialization.

The application stores student records in:

`students.dat`

Whenever a student is added, updated, or deleted, the updated list is saved to the file.

When the application starts again, the previously saved records are loaded automatically.

This allows the application to maintain student data between different program executions without using a database.

---

### Stage 7 – Academic Performance Module

Academic performance functionality was added to make the system more useful than a basic record management program.

The system uses the student's CGPA to determine the corresponding grade.

The grade structure used in the project is:

| CGPA Range | Grade |
|------------|-------|
| 9.0 – 10.0 | A+ |
| 8.0 – 8.99 | A |
| 7.0 – 7.99 | B+ |
| 6.0 – 6.99 | B |
| 5.0 – 5.99 | C |
| Below 5.0 | F |

The system can also calculate the average CGPA of all students stored in the application.

---

### Stage 8 – Attendance Management

Attendance management was added as another major feature.

The attendance percentage is calculated using:

`Attendance Percentage = (Attended Classes / Total Classes) × 100`

The system also provides an attendance status:

- **Good** – 75% or above
- **Warning** – 60% to below 75%
- **Low** – below 60%

The average attendance of all students can also be calculated.

This feature helps combine academic and attendance information within the same system.

---

### Stage 9 – Report Generation

A report generation feature was implemented using `ReportGenerator.java`.

The system creates a CSV file named:

`student_report.csv`

The generated report contains information such as:

- Student ID
- Name
- Course
- Semester
- Email
- Phone
- CGPA
- Grade
- Attendance
- Attendance Status

The CSV format makes the report easy to open and view in spreadsheet applications.

---

### Stage 10 – CLI Interface

The project was finalized as a terminal-based application.

The main menu provides the following options:

```text
==========================================
        STUDENT MANAGEMENT SYSTEM
==========================================

------------- MAIN MENU ----------------
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Academic Performance
7. Attendance Management
8. Generate Report
9. Exit
----------------------------------------
Enter your choice: