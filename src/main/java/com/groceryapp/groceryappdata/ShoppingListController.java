package com.groceryapp.groceryappdata;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class ShoppingListController {
	
	@Autowired //automatically creates an instance of the service -- "dependency injection"
	private ShoppingListService service;
	
	
//	private List<ShoppingList> lists = Arrays.asList(
//			new ShoppingList("Walmart"),
//			new ShoppingList("Trader Joe's")
//			);
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/shoppinglist")
	public void updateShoppingList(@RequestBody ShoppingList list) {
		//return list;
		this.service.updateShoppingList(list);
	}

	
	@RequestMapping(method=RequestMethod.DELETE, value="/shoppinglist")
	public void deleteShoppingList(@RequestBody ShoppingList list) {
		//return list;
		this.service.deleteShoppingList(list.getShoppingListId());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/shoppinglist")
	public void addShoppingList(@RequestBody ShoppingList list) {
		//return list;
		this.service.addShoppingList(list);
	}
	
	
	@RequestMapping("/shoppinglist/{shoppingListId}")
	public ShoppingList getShoppingList(@PathVariable int shoppingListId) {
		//return new ShoppingList(title);
		return this.service.getShoppingListById(shoppingListId);
		
		
	}
	
	//localhost:8080/shoppinglists
	@RequestMapping("/shoppinglists")
	public List<ShoppingList> getShoppingLists() {
		
//		ShoppingList list = new ShoppingList();
//		list.setTitle("Target");
//		return list; //spring boot automatically converts this into JSON
		//return this.lists;
		return this.service.getAllShoppingLists();
		
	}
	
	
	
	//localhost:8080/
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
				
	}

}
