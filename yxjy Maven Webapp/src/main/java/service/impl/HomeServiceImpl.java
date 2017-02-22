package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Home;
import service.HomeSerice;
import dao.HomeMapper;

@Service
public class HomeServiceImpl implements HomeSerice {

	@Autowired
	private HomeMapper homeMapper;

	@Override
	public List<Home> getHome(int i) {
		return homeMapper.getHome(i);
	}

}
