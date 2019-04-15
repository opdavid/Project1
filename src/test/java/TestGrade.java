import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Test;

import java.time.LocalDateTime;

public class TestGrade {

    private TemaLabValidator vt = new TemaLabValidator();
    private TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "D:\\vvss\\Project1\\src\\test\\java\\test2.xml");
    private TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);

    private StudentValidator vs = new StudentValidator();
    private StudentXMLRepo strepo = new StudentXMLRepo(vs, "D:\\vvss\\Project1\\src\\test\\java\\test.xml");
    private StudentXMLService stsrv = new StudentXMLService(strepo);

    private NotaValidator vn = new NotaValidator();
    private NotaXMLRepo ntrepo = new NotaXMLRepo(vn, "D:\\vvss\\Project1\\src\\test\\java\\test3.xml");
    private NotaXMLService ntsrv = new NotaXMLService(ntrepo);

    @Test
    public void testAddLabAssignment() {
        String[] tema = {"1", "descriere", "5", "3"};
        TestUtils.addEntity(tema, vt, tmsrv, tmrepo);
    }

    @Test
    public void testAddStudent() {
        String[] student = {"1", "nume", "123", "asdfd", "asdfds"};
        TestUtils.addEntity(student, vs, stsrv, strepo);
    }

    @Test
    public void testAddGrade() {
        String[] grade = {"1", "1", "1", "10", String.valueOf(LocalDateTime.now())};
        TestUtils.addEntity(grade, vn, ntsrv, ntrepo);
    }

    @Test
    public void integrationTest() {
        testAddStudent();
        testAddLabAssignment();
        testAddGrade();
    }
}
