package service;

import java.io.Serializable;
import java.util.List;

import pojo.Product;

public interface ProductService {

	public List<Product> find();
	public Product get(Serializable id);
	public void delete(int pid);
	public void insert(Product product);
	public void update(Product product);
	
}
