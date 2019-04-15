import Exceptions.ValidatorException;
import Repository.XMLFileRepository.AbstractXMLRepo;
import Service.XMLFileService.AbstractXMLService;
import Validator.IValidator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestUtils {

    public static void addEntity(String[] entity, IValidator validator, AbstractXMLService service, AbstractXMLRepo repo){
        try {
            service.add(entity);
            assertEquals(1, repo.getSize());
        } catch (ValidatorException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
