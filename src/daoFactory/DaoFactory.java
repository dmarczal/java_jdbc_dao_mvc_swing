package daoFactory;

import java.sql.Connection;

import dao.concrete.MysqlUserDao;

public abstract class DaoFactory {

  /* 
   * There will be a method for each DAO that can be
   * created. The concrete factories will have to
   * implement these methods.
   */
  public abstract Connection openConnection();	
  public abstract MysqlUserDao getUserDao();
  
  public static DaoFactory getMysql() {
      return new Mysql();
  }
}
