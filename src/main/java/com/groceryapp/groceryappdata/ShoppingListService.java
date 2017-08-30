package com.groceryapp.groceryappdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ShoppingListService { //use the repository to return the elements in the database
	
//	private List<ShoppingList> lists = Arrays.asList(
//			new ShoppingList(1, "Walmart"),
//			new ShoppingList(2, "Trader Joe's"),
//			new ShoppingList(3, "Costco")
//			);
	
	@Autowired
	private ShoppingListRepository repository;
	private List<ShoppingList> lists;
	
	public ShoppingListService() {
		this.lists = new ArrayList<ShoppingList>();
		this.lists.add(new ShoppingList(1, "Walmart"));
		this.lists.add(new ShoppingList(2, "Trader Joe's"));
		this.lists.add(new ShoppingList(3, "Costco"));
		
	}
	
	public void addShoppingList(ShoppingList list) {
		this.repository.save(list);
		//this.lists.add(list);
	}
	
	public void deleteShoppingList(int listId) {
		
		ShoppingList toDeleteList  = this.repository.findOne(listId);
		this.repository.delete(toDeleteList);
		
//		ShoppingList toDeleteList = getShoppingListById(listId); //"fetch request"
//		this.lists.remove(toDeleteList);
	}
	
	public void updateShoppingList(ShoppingList list) {
		ShoppingList persistedShoppingList = getShoppingListById(list.getShoppingListId());
		persistedShoppingList.setTitle(list.getTitle());
		this.repository.save(persistedShoppingList);
		
	}
	
	public List<ShoppingList> getAllShoppingLists() {
		
		List<ShoppingList> list = new ArrayList<>();
		this.repository.findAll()
		.forEach(x -> list.add(x)); //.forEach(lists::add); 
		
		return list;
	}
	
	public ShoppingList getShoppingListById(int shoppingListId) {
		
		return this.repository.findOne(shoppingListId);
		
		//return this.lists.stream().filter(x -> x.getShoppingListId() == shoppingListId).findFirst().get();
		
	}
	
	

}
