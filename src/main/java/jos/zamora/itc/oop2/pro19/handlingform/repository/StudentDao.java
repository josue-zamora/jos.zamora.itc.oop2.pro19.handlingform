/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.repository;

import java.util.List;
import jos.zamora.itc.oop2.pro19.handlingform.domain.Student;

/**
 *
 * @author jos1727
 */

public interface StudentDao {
    
    public List<Student> getStudentList();
    public void deleteStudent(int studentId);
    public Student findStudent(int studentId);
    public void addStudent(Student student);
    public void changeStudent(Student student);    
    
}
