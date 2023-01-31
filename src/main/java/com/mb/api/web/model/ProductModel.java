package com.mb.api.web.model;

public class ProductModel
{
	
	private String name;
	
	
	private String description;
	
	
	private String code;
	
	private Double unitPrice;
	
	private Integer stocks;
	
	private Integer productCategoryId;
	
	

	public ProductModel() {}

	public ProductModel(String name,  String description, Double unitPrice, Integer stocks)
	{
		super();
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public Double getUnitPrice()
	{
		return unitPrice;
	}

	public Integer getStocks()
	{
		return stocks;
	}
	public Integer getProductCategoryId()
	{
		return productCategoryId;
	}
}
