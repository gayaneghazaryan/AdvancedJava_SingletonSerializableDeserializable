import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class EmployeeService {

    private static final String FILE_NAME = "src\\employee.xml";

    public static void serializeEmployee(Employee employee) {
        JAXBContext jaxbContext;
        Marshaller marshaller;
        try {
            File file = new File(FILE_NAME);
            jaxbContext = JAXBContext.newInstance(Employee.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(employee,file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Employee deSerializeEmployee() {
        JAXBContext jaxbContext ;
        Unmarshaller unmarshaller;
        Employee employee = null;
        try {
            File file = new File(FILE_NAME);
            jaxbContext = JAXBContext.newInstance(Employee.class);

            unmarshaller = jaxbContext.createUnmarshaller();

            employee = (Employee) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return employee;
    }
}