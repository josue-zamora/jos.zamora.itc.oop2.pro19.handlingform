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
import jos.zamora.itc.oop2.pro19.handlingform.domain.Course;


/**
 *
 * @author jos1727
 */

public class CourseDaoJdbc implements CourseDao {
    
    private DataSource dataSource;

    public void setDatasource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
    @Override
    public List<Course> getCourseList() {    
               
        Connection conn = null;
        List<Course> courseList = new ArrayList<Course>();
        
        String sql = "SELECT "
                    + "COURSE_ID,"
                    + "COURSE_NAME,"
                    + "COURSE_CODE "
                    + "FROM course;";
        
        try {                                    
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while ( rs.next() ) {            
                Course course = new Course();
                course.setCourseId(rs.getInt("COURSE_ID"));
                course.setCourseName(rs.getString("COURSE_NAME"));
                course.setCourseCode(rs.getString("COURSE_CODE"));
                
                courseList.add(course);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {            
            if ( conn != null ) {                
                try {                    
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        
        return courseList;
    }

    @Override
    public void removeCourse(int courseId) {
        
        Connection conn = null;
        
        String sql = "DELETE "
                     + "FROM course "
                    + "WHERE COURSE_ID = ?;";
        
        try {                                    
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, courseId);
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
    public Course findCourse(int courseId) {        
                
        Connection conn = null;
        Course course = new Course();
        
        String sql = "SELECT "
                    + "COURSE_ID,"
                    + "COURSE_NAME,"
                    + "COURSE_CODE "
                    + "FROM course "
                    + "WHERE COURSE_ID = ?;";        
                
        try {                                                
                        
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();            
            
            while ( rs.next() ) {                           
                course.setCourseId(rs.getInt("COURSE_ID"));
                course.setCourseName(rs.getString("COURSE_NAME"));
                course.setCourseCode(rs.getString("COURSE_CODE"));                              
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {            
            if ( conn != null ) {                
                try {                    
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        
        return course;
    }

    @Override
    public void addCourse(Course course) {
        
        Connection conn = null;
        
        String sqlCourse = "INSERT INTO course"
                    + "(COURSE_NAME,COURSE_CODE) "
                    + "VALUES"
                    + "(?,?);";
        
        try {        
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);                        
            
            PreparedStatement psCourse = conn.prepareStatement(sqlCourse);
            psCourse.setString(1, course.getCourseName());
            psCourse.setString(2, course.getCourseCode());
            psCourse.executeUpdate();
            
            psCourse.close();
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
    public void changeCourse(Course course) {
        
        Connection conn = null;
        
        String sql = "UPDATE "
                    + "course "
                    + "SET COURSE_NAME = ?, "
                    + "COURSE_CODE = ? "
                    + "WHERE COURSE_ID = ?;";
        
        try {                                    
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getCourseCode());
            ps.setInt(3, course.getCourseId());            
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
    
}
