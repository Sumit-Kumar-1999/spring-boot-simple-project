package com.springboot.simplespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.response.ResponseStructure;
import com.springboot.simplespringboot.service.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/getMyData") //getMapping is used to fetch the data
	public String getData()
	{
		return "Hello world";
	}
	
	/*
	 * insertProduct method
	 */
	@PostMapping(value="/insertProduct") //postMapping is used to save data
	public Product insertProduct(@RequestBody Product product)
	{
		return productService.insertProduct(product);
	}
	
	/*
	 * insertMultiplrProduct
	 */
	@PostMapping(value = "/insertMultipleProduct")
	public List<Product> insertMultipleProducts(@RequestBody List<Product> products)
	{
		return productService.insertMultipleProducts(products);
	}
	/*
	 * deleteProductByid
	 */
	@DeleteMapping(value = "/deleteProduct/{productId}")
	public ResponseStructure<Product> deleteProductByid(@PathVariable int productId)
	{
		return productService.deleteProductByid(productId);
	}
	/*
	 * getProductByid
	 */
	@GetMapping(value = "/getPrudctById/{productId}")
	public ResponseStructure<Product> getProductById(@PathVariable int productId)
	{
		return productService.getProductById(productId);
	}
	/*
	 * getAllProduct
	 */
	@GetMapping(value="/getAllProduct")
	public List<Product> getAllProducts()
	{
		return productService.getAllProduct();
	}
	/*
	 * updateProduct
	 */
	@PutMapping(value="/updateProduct")
	public Product updateProduct(@RequestBody Product product)
	{
		return productService.updateProduct(product);
	}
}
