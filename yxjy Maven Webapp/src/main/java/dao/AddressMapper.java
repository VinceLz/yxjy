package dao;

import pojo.Address;


public interface AddressMapper {
	Address get();
	void insert(Address address);
	void update(Address address);
}
