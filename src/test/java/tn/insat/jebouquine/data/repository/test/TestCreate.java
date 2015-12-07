package tn.insat.jebouquine.data.repository.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.insat.jebouquine.configuration.JeBouquineApplication;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.repository.IClientRepository;

/**
 * Created by Devcartha on 12/7/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JeBouquineApplication.class)
public class TestCreate {

    @Autowired
    private IClientRepository clientRepository;
    @Test
    public void testCreate() throws Exception {
        Client c = new Client("Chaouechi","Souhail","09616807","00000000","chaouechi.souhail@gmail.com","Boumhel");
        clientRepository.save(c);
    }
}
