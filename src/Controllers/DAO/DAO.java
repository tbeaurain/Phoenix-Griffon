package Controllers.DAO;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO <T>{
	
public Connection connect = ConnectionSQL.getInstance();
	
	public abstract T find(int id);

	public abstract T create(T obj);

	public abstract T update(T obj);

	public abstract void delete(T obj);
	
	public abstract ArrayList<T> recherche( String name);
}
