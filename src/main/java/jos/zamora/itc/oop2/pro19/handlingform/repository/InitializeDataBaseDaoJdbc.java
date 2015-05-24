/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author jos1727
 */

public class InitializeDataBaseDaoJdbc implements InitializeDataBaseDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createTables() {

        Connection conn = null;
        try {

            conn = dataSource.getConnection();
            conn.setAutoCommit(false);

            String sqlStudent = "CREATE TABLE student("
                    + "STUDENT_ID integer NOT NULL AUTO_INCREMENT,"
                    + "FIRST_NAME varchar(30),"
                    + "LAST_NAME varchar(30),"
                    + "PHONE_HOME varchar(20),"
                    + "PHONE_MOBILE varchar(20),"
                    + "PRIMARY KEY(STUDENT_ID));";

            PreparedStatement psStudent = conn.prepareStatement(sqlStudent);
            psStudent.executeUpdate();
            psStudent.close();

            String sqlCourse = "CREATE TABLE course("
                    + "COURSE_ID integer NOT NULL AUTO_INCREMENT,"
                    + "COURSE_NAME varchar(30),"
                    + "COURSE_CODE varchar(30),"
                    + "PRIMARY KEY(COURSE_ID));";

            PreparedStatement psCourse = conn.prepareStatement(sqlCourse);
            psCourse.executeUpdate();
            psCourse.close();

            conn.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void dropTables() {

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);

            String sqlStudent = "DROP TABLE student;";
            PreparedStatement psStudent = conn.prepareStatement(sqlStudent);
            psStudent.executeUpdate();
            psStudent.close();

            String sqlCourse = "DROP TABLE course;";
            PreparedStatement psCourse = conn.prepareStatement(sqlCourse);
            psCourse.executeUpdate();
            psCourse.close();

            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {            
            if ( conn != null){            
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }             
        }
    }

    @Override
    public void insertDefaultData() {

        Connection conn = null;
        
        try {
            
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            
            String sqlStudent = "INSERT INTO student"
                                                + "(FIRST_NAME,LAST_NAME,PHONE_HOME,PHONE_MOBILE)"
                                                + "VALUES"
                                                + "('Gabriel','Vargas','5103939921','5103939921'),"
                                                + "('Patricia','Padilla','5107788181','5107788181'),"
                                                + "('Mike','Almada','5101239921','5101239921'),"
                                                + "('Maria','Ramirez','5109849921','5109849921');";
            
            PreparedStatement psStudent = conn.prepareStatement(sqlStudent);
            psStudent.executeUpdate();
            psStudent.close();
            
            String sqlCourse = "INSERT INTO course"
                                                + "(COURSE_NAME,COURSE_CODE)"
                                                + "VALUES"
                                                + "('Java 1','JAV1'),"
                                                + "('Math 300','MATH300'),"
                                                + "('Calculo 2','CAL2'),"
                                                + "('Geografia 56','GEO56');";
            
            PreparedStatement psCourse = conn.prepareStatement(sqlCourse);
            psCourse.executeUpdate();
            psCourse.close();
            
            conn.commit();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {            
            if ( conn != null ) {            
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }                
        }
    }
    
}
