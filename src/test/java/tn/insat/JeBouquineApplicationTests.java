package tn.insat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.insat.configuration.JeBouquineApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JeBouquineApplication.class)
@WebAppConfiguration
public class JeBouquineApplicationTests {

	@Test
	public void contextLoads() {
	}

}
