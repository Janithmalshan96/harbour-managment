package lk.ijse.harbourmanagment.bo;

import java.util.ArrayList;

public interface CrudBO <T,ID> extends SuperBO{
    public boolean save(T entity) throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(ID id) throws Exception;
    public T search(ID id) throws Exception;
    public ArrayList<T> getAll() throws Exception;
}
