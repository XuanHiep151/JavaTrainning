import java.io.*;
import java.util.List;

public class FileHandler {
    // Phương thức để ghi danh sách sinh viên vào tệp
    public static void writeToFile(List<Student> students, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Danh sách sinh viên đã được ghi vào tệp " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để đọc danh sách sinh viên từ tệp
    public static List<Student> readFromFile(String filename) {
        List<Student> students = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}
