package service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Medid;

import dao.MedidMapper;

import service.MedidService;

@Service
public class MedidServiceImpl implements MedidService {

	@Autowired
	private MedidMapper medidMapper;

	@Override
	public List<Medid> find(int pid) {
		return medidMapper.find(pid);
	}

	@Override
	public Medid get(Serializable id) {
		return medidMapper.get(id);
	}

	@Override
	public void insert(Medid medid) {
		medidMapper.insert(medid);
	}

	@Override
	public void delete(int mid) {
		medidMapper.delete(mid);
	}

	@Override
	public List<Medid> findByVideo() {
		return medidMapper.findByVideo();
	}

	@Override
	public void deletevideo() {
		medidMapper.deletevideo();
	}

	@Override
	public void insertVideo(Medid medid) {
		medidMapper.insertVideo(medid);
	}

	@Override
	public List<Medid> getByPid(int pid) {
		return medidMapper.getByPid(pid);
	}

	@Override
	public void deleteByPid(int pid) {
		medidMapper.deleteByPid(pid);
	}
}
