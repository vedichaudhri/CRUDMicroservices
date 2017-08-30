package com.groceryapp.groceryappdata;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class ShoppingList {

	@Id //primary key
	private int shoppingListId;
	public int getShoppingListId() {
		return shoppingListId;
	}

	public void setShoppingListId(int shoppingListId) {
		this.shoppingListId = shoppingListId;
	}

	
	private String title;
	
	public ShoppingList() { }
	
	public ShoppingList(String title) {
		this.title = title;
				
	}
	
	public ShoppingList(int shoppingListId, String title) {
		this.shoppingListId = shoppingListId;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
