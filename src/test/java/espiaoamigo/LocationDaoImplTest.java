package espiaoamigo;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.espiaoamigo.dao.impl.LocationDaoImpl;
import br.com.espiaoamigo.model.Location;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springconfiguration-test.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@Transactional
public class LocationDaoImplTest {
	
	@Autowired
	private LocationDaoImpl locationDao; 
	
	@Test
	public void testFindAll() {
		List<Location> findAll = locationDao.findAll();
		
		System.out.println(findAll.size());
	}
}
