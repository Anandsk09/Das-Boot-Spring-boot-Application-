package com.boot;

import static org.hamcrest.CoreMatchers.is;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.boot.Repository.ShipwreckRepository;
import com.boot.model.Shipwreck;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class ShipwreckRepositoryIntegrationTest {
	@Autowired
	ShipwreckRepository shipwreckRepository;

	@Test
	public void testShipwreckgetAll()
	{
		List<Shipwreck> ls=shipwreckRepository.findAll();
		
		assertThat(ls.size(),is(greaterThanOrEqualTo(0)));
	
	}

}
