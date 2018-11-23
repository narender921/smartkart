package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table
public class Supplier
{
	@Id
	 
	private String supplierId;
	private String supplierName;
	private String supplierAddress;
	private String supplierContactDetail;
	
	
	public String getSupplierId()
	{
		return supplierId;
	}
	public void setSupplierId(String supplierId)
	{
		this.supplierId = supplierId;
	}
	public String getSupplierName()
	{
		return supplierName;
	}
	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}
	public String getSupplierAddress()
	{
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) 
	{
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierContactDetail() 
	{
		return supplierContactDetail;
	}
	public void setSupplierContactDetail(String supplierContactDetail) 
	{
		this.supplierContactDetail = supplierContactDetail;
	}
	
}