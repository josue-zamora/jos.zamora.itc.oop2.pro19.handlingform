/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.web.admin;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import jos.zamora.itc.oop2.pro19.handlingform.domain.Course;
import jos.zamora.itc.oop2.pro19.handlingform.domain.Student;
import jos.zamora.itc.oop2.pro19.handlingform.repository.CourseDao;
import jos.zamora.itc.oop2.pro19.handlingform.repository.InitializeDataBaseDao;
import jos.zamora.itc.oop2.pro19.handlingform.repository.StudentDao;
import jos.zamora.itc.oop2.pro19.handlingform.service.initialize.InitializeCourseValues;
import jos.zamora.itc.oop2.pro19.handlingform.service.initialize.InitializeStudentValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jos1727
 */

@Controller
@RequestMapping("/admin/*")
public class InitializeDataBaseController {
    
    private CourseDao courseDao;
    private StudentDao studentDao;
    private InitializeDataBaseDao initializeDataBaseDao;
    private InitializeStudentValues initializeStudentValues;
    private InitializeCourseValues initializeCourseValues;
        
    @Autowired
    public InitializeDataBaseController(InitializeDataBaseDao initializeDataBaseDao, 
            InitializeStudentValues initializeStudentValues, 
            InitializeCourseValues initializeCourseValues,
            CourseDao courseDao,
            StudentDao studentDao) {
        
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.initializeDataBaseDao = initializeDataBaseDao;
        this.initializeStudentValues = initializeStudentValues;
        this.initializeCourseValues = initializeCourseValues;
    }
        
    @RequestMapping( value = { "initializeDataBase" }, method = RequestMethod.GET)
    public String InitializeDataBase (Model model){
        Date today = new Date();
        model.addAttribute("today", today);
        return "/admin/initializeDataBase";
    }    
    
    @RequestMapping( value = { "initializeDefaultValues" }, method = RequestMethod.GET )
    public String InitializeDefaultValues( Model model ) {
        
        initializeDataBaseDao.dropTables();
        initializeDataBaseDao.createTables();
        initializeDataBaseDao.insertDefaultData();
        
        List<Student> studentList = initializeStudentValues.getStudentList();
        for ( Iterator it = studentList.iterator() ; it.hasNext(); ) {
        
            Student student = (Student) it.next();
            studentDao.addStudent(student);
        }
        
        List<Course> courseList = initializeCourseValues.getCourseList();
        for ( Iterator it = courseList.iterator(); it.hasNext(); ) {
        
            Course course = (Course) it.next();
            courseDao.addCourse(course);            
        }        
                
        return "pageSuccess";        
    }
    
}
