package dao;

import java.util.List;

import pojo.Home;


public interface HomeMapper {
	
	List<Home> getHome(int i);

	void deleteImg(int hid);
	Home getById(int hid);

	void insert(Home product);
	
}
