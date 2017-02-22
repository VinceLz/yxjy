package service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Product;

import service.ProductService;

import dao.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> find() {
		return productMapper.find();
	}

	@Override
	public Product get(Serializable id) {
		return productMapper.get(id);
	}

	@Override
	public void delete(int pid) {
		productMapper.delete(pid);
	}

	@Override
	public void insert(Product product) {
		productMapper.insert(product);
	}

	@Override
	public void update(Product product) {
		productMapper.update(product);
	}

}
