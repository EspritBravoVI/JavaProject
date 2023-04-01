package service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IService<T> {


   void ajouter(T t) throws SQLException;
   boolean supprimer(T t) throws SQLException;
   boolean modifier (T t) throws SQLException;
   List<T> readAll() throws SQLException;
   T findbyId(int id) throws SQLException;

}

