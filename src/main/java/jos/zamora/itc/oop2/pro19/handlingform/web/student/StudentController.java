/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.web.student;

import javax.servlet.http.HttpServletRequest;
import jos.zamora.itc.oop2.pro19.handlingform.domain.Student;
import jos.zamora.itc.oop2.pro19.handlingform.repository.StudentDao;
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
@RequestMapping("/student/*")
public class StudentController {
    
    private String modelAndView;
    private StudentDao studentDao;

    
    @Autowired
    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    
    @RequestMapping(value ={"studentAdd", "studentDelete", "studentChange"}, method = RequestMethod.GET)    
    public String addDeleteChangeStudent(HttpServletRequest request){

        String value = request.getServletPath(); 
        modelAndView = value;           
       
        return modelAndView;
    }
    
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addStudent(
            @RequestParam("firstName")   String firstName, 
            @RequestParam("lastName")    String lastName, 
            @RequestParam("phoneHome")   String phoneHome, 
            @RequestParam("phoneMobile") String phoneMobile){
        
        
        modelAndView = "/student/student";                   
        Student student = new Student();        
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPhoneHome(phoneHome);
        student.setPhoneMobile(phoneMobile);
        studentDao.addStudent(student);
      
        return "redirect:" + modelAndView;
    }
    
    
    @RequestMapping( value = "delete", method = RequestMethod.POST)
    public String deleteStudent (@RequestParam("studentId") String studentId){
        
        modelAndView = "/student/student";
        studentDao.deleteStudent(Integer.parseInt(studentId));
        return "redirect:" + modelAndView;
    }
    
    
    @RequestMapping( value = { "show", "student" }, method = RequestMethod.GET)
    public String showStudent(Model model){
    
        modelAndView = "/student/student";
        model.addAttribute("studentList", studentDao.getStudentList());
        return modelAndView;
    }
    
    
    @RequestMapping( value = "find", method = RequestMethod.POST )
    public String findStudent(
            @RequestParam("studentId") String studentId,
            Model model){
        
        
        modelAndView = "/student/studentChange";
        model.addAttribute("student", studentDao.findStudent(Integer.parseInt(studentId)));
        return modelAndView;
    }
    
    
    @RequestMapping( value = "change", method = RequestMethod.POST )
    public String changeStudent(
            @RequestParam("studentId")   String studentId,
            @RequestParam("firstName")   String firstName, 
            @RequestParam("lastName")    String lastName, 
            @RequestParam("phoneHome")   String phoneHome, 
            @RequestParam("phoneMobile") String phoneMobile){
        
        
        modelAndView = "/student/student";        
        Student student = new Student();
        student.setStudentId(Integer.parseInt(studentId));
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPhoneHome(phoneHome);
        student.setPhoneMobile(phoneMobile);
        
        studentDao.changeStudent(student);
        return "redirect:" + modelAndView;
    }       
       
    
}
