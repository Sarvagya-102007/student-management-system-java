import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final StudentManager manager =
            new StudentManager();

    public static void main(String[] args) {

        showWelcome();

        while (true) {

            showMenu();

            int choice = InputValidator.getInt(
                    scanner,
                    "Enter your choice: ",
                    1,
                    9
            );

            System.out.println();

                        switch (choice) {
                                case 1 -> addStudent();
                                case 2 -> viewAllStudents();
                                case 3 -> searchStudent();
                                case 4 -> updateStudent();
                                case 5 -> deleteStudent();
                                case 6 -> showAcademicPerformance();
                                case 7 -> showAttendance();
                                case 8 -> generateReport();
                                case 9 -> {
                                        exitProgram();
                                        return;
                                }
                        }

            System.out.println(
                    "\nPress Enter to continue...");

            scanner.nextLine();
        }
    }

    private static void showWelcome() {

        System.out.println();
        System.out.println(
                "==========================================");
        System.out.println(
                "        STUDENT MANAGEMENT SYSTEM");
        System.out.println(
                "==========================================");
        System.out.println();
    }

    private static void showMenu() {

        System.out.println(
                "------------- MAIN MENU ----------------");

        System.out.println(
                "1. Add Student");

        System.out.println(
                "2. View All Students");

        System.out.println(
                "3. Search Student");

        System.out.println(
                "4. Update Student");

        System.out.println(
                "5. Delete Student");

        System.out.println(
                "6. Academic Performance");

        System.out.println(
                "7. Attendance Management");

        System.out.println(
                "8. Generate Report");

        System.out.println(
                "9. Exit");

        System.out.println(
                "----------------------------------------");
    }

    private static void addStudent() {

        System.out.println(
                "------------- ADD STUDENT -------------");

        String id = InputValidator.getNonEmptyString(
                scanner,
                "Student ID: "
        );

        if (manager.findStudent(id) != null) {

            System.out.println(
                    "A student with this ID already exists.");

            return;
        }

        String name = InputValidator.getNonEmptyString(
                scanner,
                "Name: "
        );

        String course = InputValidator.getNonEmptyString(
                scanner,
                "Course: "
        );

        int semester = InputValidator.getInt(
                scanner,
                "Semester (1-8): ",
                1,
                8
        );

        String email = InputValidator.getEmail(
                scanner,
                "Email: "
        );

        String phone = InputValidator.getPhone(
                scanner,
                "Phone: "
        );

        double cgpa = InputValidator.getDouble(
                scanner,
                "CGPA (0-10): ",
                0,
                10
        );

        int totalClasses = InputValidator.getInt(
                scanner,
                "Total Classes: ",
                0,
                1000
        );

        int attendedClasses = InputValidator.getInt(
                scanner,
                "Attended Classes: ",
                0,
                totalClasses
        );

        Student student = new Student(
                id,
                name,
                course,
                semester,
                email,
                phone,
                cgpa,
                totalClasses,
                attendedClasses
        );

        if (manager.addStudent(student)) {

            System.out.println(
                    "\nStudent added successfully.");

        } else {

            System.out.println(
                    "\nUnable to add student.");
        }
    }

    private static void viewAllStudents() {

        System.out.println(
                "------------- ALL STUDENTS -------------");

        ArrayList<Student> students =
                manager.getStudents();

        if (students.isEmpty()) {

            System.out.println(
                    "No student records found.");

            return;
        }

        printStudentTable(students);
    }

    private static void searchStudent() {

        System.out.println(
                "------------- SEARCH STUDENT -----------");

        String keyword =
                InputValidator.getNonEmptyString(
                        scanner,
                        "Enter ID, name, course or email: "
                );

        ArrayList<Student> result =
                manager.searchStudents(keyword);

        if (result.isEmpty()) {

            System.out.println(
                    "No matching student found.");

            return;
        }

        printStudentTable(result);
    }

    private static void updateStudent() {

        System.out.println(
                "------------- UPDATE STUDENT -----------");

        String id =
                InputValidator.getNonEmptyString(
                        scanner,
                        "Enter Student ID: "
                );

        Student student = manager.findStudent(id);

        if (student == null) {

            System.out.println(
                    "Student not found.");

            return;
        }

        System.out.println(
                "\nEnter the updated details.");

        String name =
                InputValidator.getNonEmptyString(
                        scanner,
                        "Name: "
                );

        String course =
                InputValidator.getNonEmptyString(
                        scanner,
                        "Course: "
                );

        int semester =
                InputValidator.getInt(
                        scanner,
                        "Semester (1-8): ",
                        1,
                        8
                );

        String email =
                InputValidator.getEmail(
                        scanner,
                        "Email: "
                );

        String phone =
                InputValidator.getPhone(
                        scanner,
                        "Phone: "
                );

        double cgpa =
                InputValidator.getDouble(
                        scanner,
                        "CGPA (0-10): ",
                        0,
                        10
                );

        int totalClasses =
                InputValidator.getInt(
                        scanner,
                        "Total Classes: ",
                        0,
                        1000
                );

        int attendedClasses =
                InputValidator.getInt(
                        scanner,
                        "Attended Classes: ",
                        0,
                        totalClasses
                );

        student.setName(name);
        student.setCourse(course);
        student.setSemester(semester);
        student.setEmail(email);
        student.setPhone(phone);
        student.setCgpa(cgpa);
        student.setTotalClasses(totalClasses);
        student.setAttendedClasses(attendedClasses);

        manager.updateStudent(student);

        System.out.println(
                "\nStudent updated successfully.");
    }

    private static void deleteStudent() {

        System.out.println(
                "------------- DELETE STUDENT -----------");

        String id =
                InputValidator.getNonEmptyString(
                        scanner,
                        "Enter Student ID: "
                );

        Student student = manager.findStudent(id);

        if (student == null) {

            System.out.println(
                    "Student not found.");

            return;
        }

        System.out.println(
                "Student: " + student.getName());

        System.out.print(
                "Are you sure? (yes/no): ");

        String confirmation =
                scanner.nextLine().trim();

        if (confirmation.equalsIgnoreCase("yes")) {

            if (manager.deleteStudent(id)) {

                System.out.println(
                        "Student deleted successfully.");

            } else {

                System.out.println(
                        "Unable to delete student.");
            }

        } else {

            System.out.println(
                    "Delete operation cancelled.");
        }
    }

    private static void showAcademicPerformance() {

        System.out.println(
                "--------- ACADEMIC PERFORMANCE --------");

        ArrayList<Student> students =
                manager.getStudents();

        if (students.isEmpty()) {

            System.out.println(
                    "No student records found.");

            return;
        }

        System.out.printf(
                "%-12s %-22s %-8s %-8s%n",
                "ID",
                "Name",
                "CGPA",
                "Grade"
        );

        System.out.println(
                "-----------------------------------------------");

        for (Student student : students) {

            System.out.printf(
                    "%-12s %-22s %-8.2f %-8s%n",
                    student.getId(),
                    student.getName(),
                    student.getCgpa(),
                    student.getGrade()
            );
        }

        System.out.println(
                "\nAverage CGPA: "
                        + String.format(
                        "%.2f",
                        manager.getAverageCGPA()));
    }

    private static void showAttendance() {

        System.out.println(
                "----------- ATTENDANCE ----------------");

        ArrayList<Student> students =
                manager.getStudents();

        if (students.isEmpty()) {

            System.out.println(
                    "No student records found.");

            return;
        }

        System.out.printf(
                "%-12s %-22s %-15s %-12s%n",
                "ID",
                "Name",
                "Attendance",
                "Status"
        );

        System.out.println(
                "------------------------------------------------");

        for (Student student : students) {

            System.out.printf(
                    "%-12s %-22s %-14.2f %-12s%n",
                    student.getId(),
                    student.getName(),
                    student.getAttendance(),
                    student.getAttendanceStatus()
            );
        }

        System.out.println(
                "\nAverage Attendance: "
                        + String.format(
                        "%.2f%%",
                        manager.getAverageAttendance()));
    }

    private static void generateReport() {

        System.out.println(
                "------------- REPORT ------------------");

        if (manager.getStudents().isEmpty()) {

            System.out.println(
                    "No student records available.");

            return;
        }

        ReportGenerator.generateReport(
                manager.getStudents());
    }

    private static void printStudentTable(
            ArrayList<Student> students) {

        System.out.printf(
                "%-10s %-18s %-15s %-6s %-22s %-12s %-7s %-11s%n",
                "ID",
                "Name",
                "Course",
                "Sem",
                "Email",
                "Phone",
                "CGPA",
                "Attendance"
        );

        System.out.println(
                "------------------------------------------------------------------------------------------------");

        for (Student student : students) {

            System.out.printf(
                    "%-10s %-18s %-15s %-6d %-22s %-12s %-7.2f %-10.2f%%%n",
                    student.getId(),
                    student.getName(),
                    student.getCourse(),
                    student.getSemester(),
                    student.getEmail(),
                    student.getPhone(),
                    student.getCgpa(),
                    student.getAttendance()
            );
        }
    }

    private static void exitProgram() {

        System.out.println();

        System.out.println(
                "==========================================");

        System.out.println(
                "       Thank you for using the");

        System.out.println(
                "       Student Management System");

        System.out.println(
                "==========================================");
    }
}