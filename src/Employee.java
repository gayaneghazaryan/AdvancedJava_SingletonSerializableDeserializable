import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serial;
import java.io.Serializable;

@XmlRootElement
public class Employee implements Serializable {
    private static final long serialVersionID = 123454678L;

    private String name;
    private int salary;
    private static volatile Employee singleInstance;

    private Employee() {
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static Employee getInstance() {
        if(singleInstance == null) {
            synchronized (Employee.class) {
                if(singleInstance == null) {
                    singleInstance = new Employee();
                }
            }
        }
        return singleInstance;
    }

    @Serial
    protected Object readResolve() {
        return singleInstance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}
