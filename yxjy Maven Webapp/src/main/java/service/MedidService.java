package service;

import java.io.Serializable;
import java.util.List;

import pojo.Medid;

public interface MedidService {
	List<Medid> find(int pid);

	Medid get(Serializable id);

	void insert(Medid medid);

	void delete(int mid);

	List<Medid> findByVideo();

	void deletevideo();

	void insertVideo(Medid medid);
	
}
