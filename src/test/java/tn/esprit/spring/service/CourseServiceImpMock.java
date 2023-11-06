package tn.esprit.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.ICourseServices;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static tn.esprit.spring.entities.TypeSubscription.SEMESTRIEL;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class CourseServiceImpMock {
    @InjectMocks
    private ICourseServices courseServices;

    @Mock
    private ICourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllCourses() {
        // Create a list of mock courses
        Course course1 = new Course();
        course1.setNumCourse(1L);
        Course course2 = new Course();
        course2.setNumCourse(2L);
        List<Course> courses = Arrays.asList(course1, course2);

        // Define the behavior of the mock repository
        when(courseRepository.findAll()).thenReturn(courses);

        // Call the service method
        List<Course> result = courseServices.retrieveAllCourses();

        // Verify that the method was called and the result matches the mock data
        Mockito.verify(courseRepository, Mockito.times(1)).findAll();
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testAddCourse() {
        // Create a mock course
        Course course = new Course();
        course.setNumCourse(1L);

        // Define the behavior of the mock repository
        when(courseRepository.save(course)).thenReturn(course);

        // Call the service method
        Course result = courseServices.addCourse(course);

        // Verify that the method was called and the result matches the mock data
        Mockito.verify(courseRepository, Mockito.times(1)).save(course);
        Assertions.assertEquals(1L, result.getNumCourse());
    }

    @Test
    public void testUpdateCourse() {
        // Create a mock course
        Course course = new Course();
        course.setNumCourse(1L);

        // Define the behavior of the mock repository
        when(courseRepository.save(course)).thenReturn(course);

        // Call the service method
        Course result = courseServices.updateCourse(course);

        // Verify that the method was called and the result matches the mock data
        Mockito.verify(courseRepository, Mockito.times(1)).save(course);
        Assertions.assertEquals(1L, result.getNumCourse());
    }

    @Test
    public void testRetrieveCourse() {
        // Create a mock course
        Course course = new Course();
        course.setNumCourse(1L);

        // Define the behavior of the mock repository
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        // Call the service method
        Course result = courseServices.retrieveCourse(1L);

        // Verify that the method was called and the result matches the mock data
        Mockito.verify(courseRepository, Mockito.times(1)).findById(1L);
        Assertions.assertEquals(1L, result.getNumCourse());
    }
}



