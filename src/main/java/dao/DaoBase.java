package dao;

import java.util.List;

public interface DaoBase<T extends Object> {

	public void create(T object);
	public List<T> read();
	public T read(T object);
	public void update(T object);
	public void delete(T object);
}