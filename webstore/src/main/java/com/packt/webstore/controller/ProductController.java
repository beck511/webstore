package com.packt.webstore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model,@PathVariable("category") String category) {
	  List<Product> products =productService.getProductsByCategory(category);

	  if (products == null || products.isEmpty()) {
	    throw new NoProductsFoundUnderCategoryException();
	  }

	  model.addAttribute("products", products);
	  return "products";
	}
	
	@RequestMapping("/filter/{ByCriteria}")
	  public String getProductsByFilter(@MatrixVariable(pathVar= "ByCriteria") Map<String,List<String>> filterParams,Model model) {
	    model.addAttribute("products", productService.getProductsByFilter(filterParams));
	    return "products";
	  }
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
	  model.addAttribute("product", productService.getProductById(productId));
	  return "product";
	}
	@RequestMapping("products/tablet/price;low=200;high=400?{manufacturer}")
			public String filterManufacturer(@MatrixVariable(pathVar= "manufacturer")Map<String,List<String>> filterParams,Model model){
				return "manufacturer";
		
		
	}
	@RequestMapping("/all")
	public String allProducts(Model model) {
	  model.addAttribute("products", productService.getAllProducts());
	  
	return "products";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
	   Product newProduct = new Product();
	   model.addAttribute("newProduct", newProduct);
	   return "addProduct";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, ModelMap map, BindingResult result, HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		MultipartFile productImage = productToBeAdded.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println(rootDirectory);
				
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
		      	productImage.transferTo(new File(rootDirectory+"resources\\images\\"+productToBeAdded.getProductId() + ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		       MultipartFile pdf = productToBeAdded.getPdf();
				String root2Directory = request.getSession().getServletContext().getRealPath("/");
						
					if (pdf!=null && !pdf.isEmpty()) {
				       try {
				      	pdf.transferTo(new File(root2Directory+"resources\\pdf\\"+productToBeAdded.getProductId() + ".pdf"));
				       } catch (Exception e) {
						throw new RuntimeException("PDF add fail!", e);
				   }
		   }

		
	   	productService.addProduct(productToBeAdded);
		}
			return "redirect:/products";
	}
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
	   binder.setDisallowedFields("unitsInOrder", "discontinued");
	   binder.setAllowedFields("productId","name","unitPrice","description","manufacturer","category","unitsInStock", "productImage", "pdf");
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req,ProductNotFoundException exception) {
	  ModelAndView mav = new ModelAndView();
	  mav.addObject("invalidProductId", exception.getProductId());
	  mav.addObject("exception", exception);
	  mav.addObject("url",req.getRequestURL()+"?"+req.getQueryString());
	  mav.setViewName("productNotFound");
	  return mav;
	}
}