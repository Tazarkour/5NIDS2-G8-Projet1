package tn.esprit.spring.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.services.ISubscriptionServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static tn.esprit.spring.entities.TypeSubscription.SEMESTRIEL;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SubscriptionServiceImplTest {
    @Autowired
    ISubscriptionServices ss;
    @Test
    @Order(1)
    public void testRetrieveAllSubscriptions() {
        List<Subscription> listes = ss.retrieveallSubscriptions();

        Assertions.assertEquals(0, listes.size());
    }
}
