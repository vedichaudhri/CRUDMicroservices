package com.groceryapp.groceryappdata;

import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<ShoppingList,Integer> { //allows you to communicate with the database
	
	//getAllShoppingLists
	//getShoppingList(int id)
	//updateShoppingList(ShoppingList list) 

}
