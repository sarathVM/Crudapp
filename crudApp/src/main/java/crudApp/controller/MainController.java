package crudApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crudApp.Dao.ProductDao;
import crudApp.model.Product;

@Controller
public class MainController {
	@Autowired
	private ProductDao product;
	
	@RequestMapping("/")
	public String one(Model m) {
		List<Product> products=product.getProducts();
		m.addAttribute("products", products);
		return "index2";
	}
	@RequestMapping("/add")
	public String second(Model m) {
		m.addAttribute("title","Add Product");
		return "add";
	}
	@RequestMapping(value="/handle-product",method = RequestMethod.POST)
	public RedirectView handle(@ModelAttribute Product p,HttpServletRequest req) {
		RedirectView rv=new RedirectView();
		rv.setUrl(req.getContextPath()+"/");
		product.createProduct(p);
		return rv;
		
	}
	@RequestMapping("/delete/{productId}")		 
	public RedirectView delete(@PathVariable("productId")int productId,HttpServletRequest req) {
		RedirectView rv=new RedirectView();
		rv.setUrl(req.getContextPath()+"/");
		this.product.deleteProduct(productId);
		return rv;
		  
	}
	@RequestMapping("/update/{productId}")		 
	public String update(@PathVariable("productId")int productId,Model m) {
		Product p=product.getProduct(productId);
		m.addAttribute("p",p);
		return "update";
		  
	}		


}
