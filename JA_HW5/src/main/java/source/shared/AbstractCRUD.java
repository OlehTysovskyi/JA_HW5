package source.shared;

import java.sql.SQLException;
import java.util.List;

public interface AbstractCRUD<T>{
    T create(T t) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
    T read(Integer id);
    T update(T t);
    void delete(Integer id);

    List<T> readAll();

}
