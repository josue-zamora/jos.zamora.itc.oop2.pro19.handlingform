/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.repository;

/**
 *
 * @author jos1727
 */

public interface InitializeDataBaseDao {

    public void createTables();
    public void dropTables();
    public void insertDefaultData();
    
}
