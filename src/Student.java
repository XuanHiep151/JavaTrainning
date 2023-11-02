import java.io.Serializable;
public class Student extends Person implements Serializable {
    private Integer code;
    private String univer;
    private Integer year;
    private Double point;
    private Grade grade;

    public static final double MIN_POINT = 0.0;
    public static final double MAX_POINT = 10.0;

    // Khai báo hằng số cho giới hạn năm nhập học
    public static final int MIN_YEAR = 1900;
    public static final int MAX_YEAR = 2100;
    public Student() {
        super();
    }
    public Student(Integer code, String univer, Integer year) {
        super();
        this.code = code;
        this.univer = univer;
        this.year = year;
    }

    public Student(Integer code, String univer, Integer year, Double point) {
        super();
        this.code = code;
        this.univer = univer;
        this.year = year;
        this.point = point;
        updateGrade();
    }
    public double getGradePercentage() {
        // Đây là nơi bạn tính toán phần trăm tương ứng với học lực, ví dụ:
        return (double) grade.ordinal() / (double) Grade.values().length * 100.0;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getUniver() {
        return univer;
    }

    public void setUniver(String univer) {
        this.univer = univer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPoint() {
        return point;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setPoint(Double point) {
        this.point = point;
        updateGrade();
    }

    private void updateGrade() {
        if (point < 3) {
            grade = Grade.KEM;
        } else if (point < 5) {
            grade = Grade.YEU;
        } else if (point < 6.5) {
            grade = Grade.TRUNG_BINH;
        } else if (point < 7.5) {
            grade = Grade.KHA;
        } else if (point < 9) {
            grade = Grade.GIOI;
        } else {
            grade = Grade.XUAT_SAC;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", univer='" + univer + '\'' +
                ", year=" + year +
                ", point=" + point +
                ", grade=" + grade +
                ", gradePercentage=" + getGradePercentage() + "%" +
                '}' + super.toString();
    }
}
