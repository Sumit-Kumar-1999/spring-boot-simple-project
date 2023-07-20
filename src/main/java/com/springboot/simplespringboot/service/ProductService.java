package com.springboot.simplespringboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.simplespringboot.dao.ProductDao;
import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.response.ResponseStructure;

@Service
public class ProductService 
{
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ResponseStructure<Product> responseStructure;
	
	/*
	 * insertProduct method
	 */
	public Product insertProduct(Product product)
	{
		if(product.getProductPrice()<=40000)
		{
			return productDao.insertProduct(product);
		}
		else
		{
			return null;
		}
	}
	/*
	 * insertMultiplrProduct
	 */
	public List<Product> insertMultipleProducts(List<Product> products)
	{
		List<Product> product2 = new ArrayList<Product>();
		for (Product product : products) {
			
			if(product.getProductPrice()<=40000)
			{
				product2.add(product);
			}
		}
		return productDao.insertMultipleProducts(product2);
	}
	/*
	 * deleteProduct
	 */
	public ResponseStructure<Product> deleteProductByid(int productId)
	{
		Product product = productDao.getProductById(productId);
		if(product!=null)
		{
			productDao.deleteProductById(productId);
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Data---Success---deleted");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
		}
		else 
		{
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Given id is not found");
			responseStructure.setDescription("Data not deleted");
		}
		return responseStructure;
	}
	/*
	 * getProductById
	 */
	public ResponseStructure<Product> getProductById(int productId)
	{
		Product product = productDao.getProductById(productId);
		if(product!=null)
		{
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Operation---Success");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}
		else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Given----id----is---not----present");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}
		return responseStructure;
	}
	/*
	 * getAllProduct
	 */
	public List<Product> getAllProduct()
	{
		return productDao.getAllProduct();
	}
	/*
	 * updateProduct
	 */
	public Product updateProduct(Product product)
	{
		return productDao.updateProduct(product);
	}
	
}
