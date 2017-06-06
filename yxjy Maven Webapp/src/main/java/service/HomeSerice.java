package service;

import java.util.List;

import pojo.Home;

public interface HomeSerice {
	List<Home> getHome(int i );
	Home getById(int hid);
	void deleteImg(int hid);
	void insert(Home product);
}
