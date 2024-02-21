/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.repository;

import java.util.List;

/**
 *
 * @author Sanjaya
 */
public interface CrudRepository<T, ID> extends SuperRepository {

    boolean save(T t) throws Exception;

    boolean update(T t) throws Exception;

    boolean delete(T t) throws Exception;

    T get(ID id) throws Exception;

    List<T> getAll() throws Exception;
}
