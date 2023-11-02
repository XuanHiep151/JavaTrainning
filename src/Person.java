import java.util.Date;

public class Person {
    private int ID;
    private String name;
    private Date birthday;
    private String address;
    private Double high;
    private Double heavy;

    public Person() {
    }

    public Person(int ID, String name, Date birthday, String address, Double high, Double heavy) {
        this.ID = ID;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.high = high;
        this.heavy = heavy;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getHeavy() {
        return heavy;
    }

    public void setHeavy(Double heavy) {
        this.heavy = heavy;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", high=" + high +
                ", heavy=" + heavy +
                '}';
    }
}
