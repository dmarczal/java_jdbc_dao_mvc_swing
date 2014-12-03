package daoFactory;

import java.sql.Connection;

import dao.interfaces.UserDao;

public abstract class DaoFactory {

  /* 
   * There will be a method for each DAO that can be
   * created. The concrete factories will have to
   * implement these methods.
   */
  public abstract Connection openConnection();	
  public abstract UserDao getUserDao();
  
  public static DaoFactory getDatabase() {
      return new Mysql();
  }
}
