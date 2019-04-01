import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Validator.StudentValidator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestStudent {

    @Test
    public void testAddStudent() {
        StudentValidator vs = new StudentValidator();
        StudentXMLRepo strepo = new StudentXMLRepo(vs, "D:\\vvss\\Project1\\src\\test\\java\\test.xml");
        StudentXMLService stsrv = new StudentXMLService(strepo);
        String[] student = {"1", "nume", "123", "asdfd", "asdfds"};
        try {
            stsrv.add(student);
            assertEquals(1,strepo.getSize());
        } catch (ValidatorException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
