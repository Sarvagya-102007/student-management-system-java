import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReportGenerator {

    public static void generateReport(
            ArrayList<Student> students) {

        String fileName = "student_report.csv";

        try (FileWriter writer =
                     new FileWriter(fileName)) {

            writer.append(
                    "ID,Name,Course,Semester,Email,Phone,CGPA,Grade,Attendance,Status\n");

            for (Student student : students) {

                writer.append(student.getId()).append(",");
                writer.append(student.getName()).append(",");
                writer.append(student.getCourse()).append(",");
                writer.append(
                        String.valueOf(student.getSemester()))
                        .append(",");
                writer.append(student.getEmail()).append(",");
                writer.append(student.getPhone()).append(",");
                writer.append(
                        String.valueOf(student.getCgpa()))
                        .append(",");
                writer.append(student.getGrade()).append(",");
                writer.append(
                        String.format(
                                "%.2f",
                                student.getAttendance()))
                        .append(",");
                writer.append(
                        student.getAttendanceStatus())
                        .append("\n");
            }

            System.out.println(
                    "Report generated successfully.");

            System.out.println(
                    "File: " + fileName);

        } catch (IOException e) {

            System.out.println(
                    "Unable to generate report.");
        }
    }
}