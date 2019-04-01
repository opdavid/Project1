import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Validator.StudentValidator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestStudent {

    private StudentValidator vs = new StudentValidator();
    private StudentXMLRepo strepo = new StudentXMLRepo(vs, "D:\\vvss\\Project1\\src\\test\\java\\test.xml");
    private StudentXMLService stsrv = new StudentXMLService(strepo);

    @Test
    public void testAddStudent() {
        String[] student = {"1", "nume", "123", "asdfd", "asdfds"};
        try {
            stsrv.add(student);
            assertEquals(1,strepo.getSize());
        } catch (ValidatorException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void testStudentAlreadyExist(){
        String[] student = {"2", "nume", "123", "asdfd", "asdfds"};
        String[] student2 = {"2", "gigolo", "123", "asdfd", "asdfds"};
        try {
            stsrv.add(student);
            stsrv.add(student2);
            assertEquals(1,stsrv.getSize());
        } catch (ValidatorException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
