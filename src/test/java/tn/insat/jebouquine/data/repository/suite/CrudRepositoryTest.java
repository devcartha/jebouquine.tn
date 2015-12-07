package tn.insat.jebouquine.data.repository.suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tn.insat.jebouquine.data.repository.test.TestCreate;
import tn.insat.jebouquine.data.repository.test.TestDelete;
import tn.insat.jebouquine.data.repository.test.TestRetrieve;
import tn.insat.jebouquine.data.repository.test.TestUpdate;

/**
 * Created by Devcartha on 12/7/2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestCreate.class,TestRetrieve.class,TestUpdate.class,TestDelete.class})
public class CrudRepositoryTest {

}
