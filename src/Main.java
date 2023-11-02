import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private List<Student> listStudent;
    private static int currentID = 1;
    public Main() {
        listStudent = new ArrayList<>();
    }

    public void createStudent(String name, Date birthday, String address, Double high, Double heavy,
                              Integer code, String univer, Integer year, Double point) {
        try {
            // Kiểm tra dữ liệu hợp lệ
            if ( name.isEmpty() || birthday == null || address.isEmpty() || high <= 0 || heavy <= 0 ||
                    code == null || univer.isEmpty() || year == null || point == null) {
                throw new IllegalArgumentException("Dữ liệu không hợp lệ. Vui lòng kiểm tra lại.");
            }

            // Kiểm tra điểm số hợp lệ
            if (point < Student.MIN_POINT || point > Student.MAX_POINT) {
                throw new IllegalArgumentException("Điểm số không hợp lệ. Vui lòng nhập lại trong khoảng từ "
                        + Student.MIN_POINT + " đến " + Student.MAX_POINT);
            }

            // Tạo sinh viên mới
            Student newStudent = new Student(code, univer, year, point);
            newStudent.setID(currentID++);
            newStudent.setName(name);
            newStudent.setBirthday(birthday);
            newStudent.setAddress(address);
            newStudent.setHigh(high);
            newStudent.setHeavy(heavy);

            // Thêm sinh viên vào danh sách
            listStudent.add(newStudent);

            // In thông tin sinh viên thêm mới thành công ra console
            System.out.println("Thêm sinh viên thành công:\n" + newStudent.toString());
        } catch (IllegalArgumentException e) {
            // In thông báo lỗi ra console
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public Student findStudentById(int studentId) {
        boolean found = false;

        for (Student student : listStudent) {
            if (student.getID() == studentId) {
                // In thông tin sinh viên ra console nếu tìm thấy
//                System.out.println("Sinh viên có ID " + studentId + ":\n" + student.toString() +"\n");
//                found = true;
//                break;
                return student;
            }
        }

        // Thông báo nếu không tìm thấy sinh viên
        if (!found) {
            System.out.println("Không tìm thấy sinh viên có ID " + studentId + ".");
        }
        return null;
    }
    public void updateStudentById(int studentId, String newName, Date newBirthday, String newAddress,
                                  Double newHigh, Double newHeavy, Integer newCode, String newUniver,
                                  Integer newYear, Double newPoint) {
        // Tìm sinh viên cần cập nhật
        Student studentToUpdate = findStudentById(studentId);

        if (studentToUpdate != null) {
            try {
                // Kiểm tra dữ liệu mới hợp lệ
                if (newName.isEmpty() || newBirthday == null || newAddress.isEmpty() ||
                        newHigh <= 0 || newHeavy <= 0 || newCode == null || newUniver.isEmpty() ||
                        newYear == null || newPoint == null) {
                    throw new IllegalArgumentException("Dữ liệu mới không hợp lệ. Vui lòng kiểm tra lại.");
                }

                // Kiểm tra điểm số mới hợp lệ
                if (newPoint < Student.MIN_POINT || newPoint > Student.MAX_POINT) {
                    throw new IllegalArgumentException("Điểm số mới không hợp lệ. Vui lòng nhập lại trong khoảng từ "
                            + Student.MIN_POINT + " đến " + Student.MAX_POINT);
                }

                // Cập nhật thông tin sinh viên
                studentToUpdate.setName(newName);
                studentToUpdate.setBirthday(newBirthday);
                studentToUpdate.setAddress(newAddress);
                studentToUpdate.setHigh(newHigh);
                studentToUpdate.setHeavy(newHeavy);
                studentToUpdate.setCode(newCode);
                studentToUpdate.setUniver(newUniver);
                studentToUpdate.setYear(newYear);
                studentToUpdate.setPoint(newPoint);

                // In thông tin sinh viên sau khi cập nhật ra console
                System.out.println("Cập nhật thông tin sinh viên thành công:\n" + studentToUpdate.toString());
            } catch (IllegalArgumentException e) {
                // In thông báo lỗi ra console nếu dữ liệu mới không hợp lệ
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
    public void deleteStudentById(int studentId) {
        Student studentToDelete = findStudentById(studentId);

        if (studentToDelete != null) {
            // Xóa sinh viên khỏi danh sách
            listStudent.remove(studentToDelete);

            // Thông báo xóa thành công và in thông tin sinh viên đã xóa
            System.out.println("Xóa sinh viên thành công:\n" + studentToDelete.toString());
        } else {
            // Thông báo nếu không tìm thấy sinh viên cần xóa
            System.out.println("Không tìm thấy sinh viên có ID " + studentId + ". Không có gì để xóa.");
        }
    }
    public void displayAndSortByGradePercentage() {
        // Sắp xếp danh sách sinh viên theo phần trăm học lực giảm dần
        Collections.sort(listStudent, (s1, s2) -> Double.compare(s2.getGradePercentage(), s1.getGradePercentage()));

        // Hiển thị thông tin và phần trăm học lực của các sinh viên
        for (Student student : listStudent) {
            System.out.println(student.toString());
        }
    }
    public void displayStudentsByGrade() {
        Scanner scanner = new Scanner(System.in);

        // Nhập mức học lực từ người dùng
        System.out.println("Nhập mức học lực (KEM, YEU, TRUNG_BINH, KHA, GIOI, XUAT_SAC): ");
        String inputGrade = scanner.nextLine().toUpperCase();

        // Lọc và hiển thị sinh viên theo học lực
        System.out.println("Danh sách sinh viên có học lực " + inputGrade + ":");
        for (Student student : listStudent) {
            if (student.getGrade().name().equals(inputGrade)) {
                System.out.println(student.toString());
            }
        }
    }
    public static void main(String[] args) {
//        ArrayList<Integer> listStudent = new ArrayList<>();
//        Main studentManager = new Main();
//        Date birthday = new Date();
//        birthday.setYear(2000 - 1900);
//        birthday.setMonth(0);
//        birthday.setDate(15);
//        Person person = new Person(1,"Nguyễn Xuân Hiệp",birthday,"Hưng Yên",171.0,51.5);
//        System.out.println(person);
//        Student[] students = new Student[5]; // tạo một mảng có kích thước 5 lưu trữ các đối tượng Student
//        // Khởi tạo các đối tượng Student và thêm vào mảng
//        students[0] = new Student(1, "University A", 2022, 3.5);
//        students[1] = new Student(2, "University B", 2021, 4.0);
//        students[2] = new Student(3, "University C", 2023, 3.2);
//        students[3] = new Student(4, "University D", 2022, 3.8);
//        students[4] = new Student(5, "University E", 2021, 3.7);
//
//        // In thông tin của các sinh viên trong mảng
//        for (Student student : students) {
//            System.out.println(student.toString());
//        }
        Main main = new Main();

        // Thêm sinh viên (ví dụ)
        main.createStudent( "Nguyen Van A", new Date(), "123 Street", 170.0, 60.0,
                1001, "ABC University", 2022, 8.5);
        main.createStudent( "Nguyen Van B", new Date(), "123 Street", 170.0, 60.0,
                1001, "ABC University", 2022, 5.1);
        main.findStudentById(1);
        main.findStudentById(9999); // ID không tồn tại
        main.updateStudentById(1, "Updated Name", new Date(), "456 Street", 175.0, 65.0,
                1002, "XYZ University", 2023, 9.0);
        main.deleteStudentById(2);
        System.out.println("Danh sách sinh viên theo học lực:");
        main.displayStudentsByGrade();
        FileHandler.writeToFile(main.listStudent, "students.dat");

        List<Student> loadedStudents = FileHandler.readFromFile("students.dat");
        if (loadedStudents != null) {
            System.out.println("Danh sách sinh viên sau khi đọc từ tệp:");
            for (Student student : loadedStudents) {
                System.out.println(student.toString());
            }
        }
    }
}