package service;

import pojo.Address;

public interface AddressService {
	Address get();
	void insert(Address address);
	void update(Address address);
}
