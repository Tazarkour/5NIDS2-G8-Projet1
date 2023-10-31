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
	Skier s = new Skier("omar", "ouennich", LocalDate.now(), "ariana");

	@Test
	@Disabled
	public void testSkier() {
		Skier s = new Skier("omar", "ouennich", LocalDate.now(), "ariana");

		Mockito.when(iSkierRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
		Optional<Skier> user1 = Optional.ofNullable(skierServices.retrieveSkier(Long.valueOf(1))); // Assuming you have a method to retrieve a skier by ID.
		Assertions.assertTrue(user1.isPresent());

		// Additional assertions for Skier properties if needed
		Assertions.assertEquals("omar", user1.get().getFirstName());
		Assertions.assertEquals("ouennich", user1.get().getLastName());
		Assertions.assertEquals("ariana", user1.get().getCity());
	}
}