package tn.esprit.spring.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.services.ICourseServices;
import tn.esprit.spring.services.ISubscriptionServices;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CourseServiceImplTest {
    @Autowired
    ICourseServices cs;
    @Test
    @Order(1)
    public void testRetrieveAllCourse() {
        List<Course> listes = cs.retrieveAllCourses();

        Assertions.assertEquals(0, listes.size());
    }
}
