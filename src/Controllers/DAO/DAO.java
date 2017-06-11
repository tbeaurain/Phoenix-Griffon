package Controllers.DAO;

import java.sql.Connection;

public abstract class DAO <T>{
	
public Connection connect = ConnectionSQL.getInstance();
	
	public abstract T find(int id);

	public abstract T create(T obj);

	public abstract T update(T obj);

	public abstract void delete(T obj);
	
}
