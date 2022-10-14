package dao;

import java.util.List;

import model.Usuario;

public interface DaoBase<T extends Object> {

	public void create(T object);
	public T read(T object);
	public void update(T object);
	public void delete(T object);
}