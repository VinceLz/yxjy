package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AddressMapper;

import pojo.Address;

import service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;

	@Override
	public Address get() {
		return addressMapper.get();
	}

	@Override
	public void insert(Address address) {
		addressMapper.insert(address);
	}

	@Override
	public void update(Address address) {
		addressMapper.update(address);
	}

}
