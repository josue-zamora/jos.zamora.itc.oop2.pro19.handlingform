/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.service.initialize;

import java.util.ArrayList;
import java.util.List;
import jos.zamora.itc.oop2.pro19.handlingform.domain.Course;

/**
 *
 * @author jos1727
 */

public class InitializeCourseValues {

    private List courseList = new ArrayList<Course>();

    public List getCourseList() {
        return courseList;
    }

    public void setCourseList(List courseList) {
        this.courseList = courseList;
    }
    
    public InitializeCourseValues() {
        
        Course course1 = new Course();
        course1.setCourseName("Historia 2");
        course1.setCourseCode("HIS2");
        
        Course course2 = new Course();
        course2.setCourseName("Contabilidad 1");
        course2.setCourseCode("CON1");
        
        Course course3 = new Course();
        course3.setCourseName("Digitales 1");
        course3.setCourseCode("DIG1");
        
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);       
    
    }
}
