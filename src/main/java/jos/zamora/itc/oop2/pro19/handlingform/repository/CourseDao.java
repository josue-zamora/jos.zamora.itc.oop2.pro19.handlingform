/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.repository;

import java.util.List;
import jos.zamora.itc.oop2.pro19.handlingform.domain.Course;

/**
 *
 * @author jos1727
 */

public interface CourseDao {
    
    public List<Course> getCourseList();
    public void removeCourse(int courseId);
    public Course findCourse(int courseId);
    public void addCourse(Course course);
    public void changeCourse(Course course);
    
}
