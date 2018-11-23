package com.ecom.dao;

import java.util.List;

import com.ecom.model.Supplier;

public interface SupplierDao
{
	public boolean add(Supplier supplier);
	public boolean delete(Supplier supplier);
	public boolean update(Supplier supplier);
	public List<Supplier> listSupplier();
	public Supplier getSupplier(int supplierId);
	
}