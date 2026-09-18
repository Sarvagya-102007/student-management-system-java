import java.util.ArrayList;

public class StudentManager {

    private final ArrayList<Student> students;

    public StudentManager() {
        students = FileManager.loadStudents();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {

        if (findStudent(student.getId()) != null) {
            return false;
        }

        students.add(student);
        FileManager.saveStudents(students);

        return true;
    }

    public Student findStudent(String id) {

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    public ArrayList<Student> searchStudents(String keyword) {

        ArrayList<Student> result = new ArrayList<>();

        keyword = keyword.toLowerCase();

        for (Student student : students) {

            if (student.getId().toLowerCase().contains(keyword)
                    || student.getName().toLowerCase().contains(keyword)
                    || student.getCourse().toLowerCase().contains(keyword)
                    || student.getEmail().toLowerCase().contains(keyword)) {

                result.add(student);
            }
        }

        return result;
    }

    public boolean deleteStudent(String id) {

        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        students.remove(student);

        FileManager.saveStudents(students);

        return true;
    }

    public void updateStudent(Student student) {
        FileManager.saveStudents(students);
    }

    public double getAverageCGPA() {

        if (students.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getCgpa();
        }

        return total / students.size();
    }

    public double getAverageAttendance() {

        if (students.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getAttendance();
        }

        return total / students.size();
    }
}