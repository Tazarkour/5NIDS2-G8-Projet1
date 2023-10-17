package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.SkierServicesImpl;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GestionStationSkiApplicationTests {
@Mock
	ISkierRepository iSkierRepository;
@InjectMocks
	SkierServicesImpl skierServices;
Skier s = new Skier("omar","ouennich", LocalDate.now(),"ariana");
	@Test
	void contextLoads() {
	}
	public void testskier(){
		Mockito.when(iSkierRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
		Skier user1 = (Skier) skierServices.retrieveAllSkiers();
		Assertions.assertNotNull(user1);
	}
}
