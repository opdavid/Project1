import Exceptions.ValidatorException;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.TemaLabXMLService;
import Validator.TemaLabValidator;
import org.junit.Test;

public class TestLabAssignment {

    private TemaLabValidator vt = new TemaLabValidator();
    private TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "D:\\vvss\\Project1\\src\\test\\java\\test2.xml");
    private TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);

    @Test
    public void testAddLabAssignment() {
        String[] tema = {"1", "descriere", "5", "3"};
        TestUtils.addEntity(tema, vt, tmsrv, tmrepo);
    }

    @Test(expected = NumberFormatException.class)
    public void testAddWithWrongParams() throws ValidatorException {
        String[] tema = {"1", "descriere", "sdf", "3"};
        tmsrv.add(tema);
    }

}
