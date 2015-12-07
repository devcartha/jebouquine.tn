package tn.insat.jebouquine.data.repository.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.insat.jebouquine.configuration.JeBouquineApplication;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.repository.IClientRepository;

import java.util.Date;

/**
 * Created by Devcartha on 12/7/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JeBouquineApplication.class)
public class TestUpdate {
    @Autowired
    private IClientRepository clientRepository;

    @Test
    public void testUpdate() throws Exception {
        Client c1 = new Client("login","password","Chaouechi","Souhail","09616807","00000000",new Date(),"chaouechi.souhail@gmail.com","Boumhel",null);
        clientRepository.save(c1);
        Client c2 = clientRepository.findOne(c1.getId());
        c2.setAdresse("Ben arous");
        clientRepository.save(c2);
    }
}
