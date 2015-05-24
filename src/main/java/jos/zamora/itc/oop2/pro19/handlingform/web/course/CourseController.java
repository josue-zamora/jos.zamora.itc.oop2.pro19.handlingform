/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.web.course;

import javax.servlet.http.HttpServletRequest;
import jos.zamora.itc.oop2.pro19.handlingform.domain.Course;
import jos.zamora.itc.oop2.pro19.handlingform.repository.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jos1727
 */

@Controller
@RequestMapping("/course/*")
public class CourseController {
    
    private CourseDao courseDao;
    private String modelAndView;
    
    
    @Autowired
    public CourseController(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
    
    
    @RequestMapping( value = { "courseAdd", "courseDelete", "courseChange"}, method = RequestMethod.GET)
    public String addDeleteChangeCourse (HttpServletRequest request) {
    
        modelAndView = request.getServletPath();
        return modelAndView;
    }
    
    
    @RequestMapping( value = "add", method = RequestMethod.POST)
    public String addCourse(
            @RequestParam("courseName") String courseName,
            @RequestParam("courseCode") String courseCode) {
        
        modelAndView = "/course/course";
        
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseCode(courseCode);
        courseDao.addCourse(course);
        
        return "redirect:" + modelAndView;
    }
    
    
    @RequestMapping( value = "delete", method = RequestMethod.POST ) 
    public String deleteCourse(
            @RequestParam("courseId") String courseId) {
        
        modelAndView = "/course/course";
        courseDao.removeCourse(Integer.parseInt(courseId));                
        return "redirect:" + modelAndView;
    }
    
    
    @RequestMapping( value = "find", method = RequestMethod.POST)
    public String findCourse(
            @RequestParam("courseId") String courseId,
            Model model){
        
        modelAndView = "/course/courseChange";
        model.addAttribute( "course", courseDao.findCourse(Integer.parseInt(courseId)) );        
        return modelAndView;
    }
    
    
    @RequestMapping( value = "change", method = RequestMethod.POST )
    public String changeCourse(
            @RequestParam("courseId")   String courseId,
            @RequestParam("courseName") String courseName,
            @RequestParam("courseCode") String courseCode) {
        
        modelAndView = "/course/course";
        
        Course course = new Course();
        course.setCourseId(Integer.parseInt(courseId));
        course.setCourseName(courseName);
        course.setCourseCode(courseCode);
        
        courseDao.changeCourse(course);
        return "redirect:" + modelAndView;
    }
        
    
    @RequestMapping( value = { "show", "course"}, method = RequestMethod.GET)
    public String getCourseValues(Model model) {
        
        modelAndView = "/course/course";       
        model.addAttribute("courseList", courseDao.getCourseList());
        return modelAndView;
    }    
    
}
