/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import jos.zamora.itc.oop2.pro19.handlingform.domain.Student;

/**
 *
 * @author jos1727
 */

public class StudentDaoJdbc implements StudentDao {
    
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }        

    @Override
    public List<Student> getStudentList() {
        
        List<Student> studentList = new ArrayList<Student>();
        
        String sql = "SELECT "
                + "STUDENT_ID,"
                + "CONCAT( UPPER( LEFT(FIRST_NAME, 1) ), SUBSTRING(FIRST_NAME, 2) ) firstname,"
                + "CONCAT( UPPER( LEFT(LAST_NAME, 1 ) ), SUBSTRING(LAST_NAME, 2) ) lastname,"
                + "PHONE_HOME,"
                + "PHONE_MOBILE "
                + "FROM student;";
        
        Connection conn = null;
        
        try {
        
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while ( rs.next() ) {            
                Student student = new Student();
                student.setStudentId(rs.getInt("STUDENT_ID"));
                student.setFirstName(rs.getString("firstname"));
                student.setLastName(rs.getString("lastname"));
                student.setPhoneHome(rs.getString("PHONE_HOME"));
                student.setPhoneMobile(rs.getString("PHONE_MOBILE"));
                
                studentList.add(student);
            }
            
            ps.close();
            rs.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {        
            if ( conn != null) {                
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }             
            }
        }        
        return studentList;
    }

    @Override
    public void deleteStudent(int studentId) {
        
        Connection conn = null;
        
        String sql = "DELETE "
                    + "FROM student "
                    + "WHERE STUDENT_ID = ?;";
        
        try {                        
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.executeUpdate();
            
            ps.close();           
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {            
            if ( conn != null) {                
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }        
    }

    @Override
    public Student findStudent(int studentId) {
        
        Connection conn = null;
        Student student = new Student();
        
        String sql = "SELECT "
                + "STUDENT_ID,"
                + "CONCAT( UPPER( LEFT(FIRST_NAME, 1) ), SUBSTRING(FIRST_NAME, 2) ) firstname,"
                + "CONCAT( UPPER( LEFT(LAST_NAME, 1 ) ), SUBSTRING(LAST_NAME, 2) ) lastname,"
                + "PHONE_HOME,"
                + "PHONE_MOBILE "
                + "FROM student "
                + "WHERE STUDENT_ID = ?;";               
        
        try {
        
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            
            while ( rs.next() ) {            
                student.setStudentId(rs.getInt("STUDENT_ID"));
                student.setFirstName(rs.getString("firstname"));
                student.setLastName(rs.getString("lastname"));
                student.setPhoneHome(rs.getString("PHONE_HOME"));
                student.setPhoneMobile(rs.getString("PHONE_MOBILE"));                                
            }
            
            ps.close();
            rs.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        
            if ( conn != null) {
                
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }             
            }
        }        
        return student;
    }

    @Override
    public void addStudent(Student student) {
        
        Connection conn = null;
        
        String sqlStudent = "INSERT INTO student"
                    + "(FIRST_NAME,LAST_NAME,PHONE_HOME,PHONE_MOBILE)"
                    + " VALUES"
                    + "(?,?,?,?);";
        
        try {            
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);            
                        
            PreparedStatement psStudent = conn.prepareStatement(sqlStudent);
            psStudent.setString(1, student.getFirstName());
            psStudent.setString(2, student.getLastName());
            psStudent.setString(3, student.getPhoneHome());
            psStudent.setString(4, student.getPhoneMobile());
            psStudent.executeUpdate();
            
            psStudent.close();
            conn.commit();                       
            
        } catch (SQLException e) {             
            if ( conn != null) {
                try {
                    conn.rollback();                    
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }            
        } finally {        
            if ( conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }            
        }        
    }
    
    @Override
    public void changeStudent(Student student){
        
        Connection conn = null;
        
        String sql = "UPDATE student "
                    + "SET FIRST_NAME = ?,"
                    + "LAST_NAME = ?,"
                    + "PHONE_HOME = ?,"
                    + "PHONE_MOBILE = ? "
                    + "WHERE STUDENT_ID = ?;";
        
        try {            
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getPhoneHome());
            ps.setString(4, student.getPhoneMobile());
            ps.setInt(5, student.getStudentId());
            ps.executeUpdate();
            
            ps.close();            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {            
            if ( conn != null){                
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    
}

