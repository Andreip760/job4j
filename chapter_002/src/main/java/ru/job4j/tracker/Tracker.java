package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Storage for applications
 * @author Andrei Pashchenko.
 * @version 1
 * @since 16.02.2019
 */
public class Tracker {
	private final List<Item> items = new ArrayList<>();
	private static final Random RN = new Random();
	/**
	 * Adding new item
	 * @param item Item to add
	 * @return Added item
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items.add(item);
		return item;
	}
	/**
	 * Replacing existing item with another one
	 * @param id Id of existing item
	 * @param item New item
	 * @return True if success
	 */
	public boolean replace(String id, Item item) {
		boolean result = false;
		for (int i = 0; i < this.items.size(); i++) {
			if (this.items.get(i).getId().equals(id)) {
				item.setId(this.items.get(i).getId());
				this.items.set(i, item);
				result = true;
				break;
			}
		}
		return result;
	}
	/**
	 * Deleting existing item
	 * @param id Id of item to delete
	 * @return True if success
	 */
	public boolean delete(String id) {
		boolean result = false;
		for (int i = 0; i < this.items.size(); i++) {
			if (this.items.get(i).getId().equals(id)) {
				this.items.remove(i);
				result = true;
				break;
			}
		}
		return result;
	}
	/**
	 * Finding item by Id
	 * @param id Id to find
	 * @return Found item or null
	 */
	public Item findById(String id) {
		Item result = null;
		for (Item item : this.items) {
			if (item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
	/**
	 * Finding all existing items
	 * @return Array of existing items
	 */
	public List<Item> findAll() {
		return this.items;
	}
	/**
	 * Finding item by name
	 * @param key Name to find
	 * @return Array of found items
	 */
	public List<Item> findByName(String key) {
		List<Item> result = new ArrayList<>();
		for (Item item : this.items) {
			if (item.getName().equals(key)) {
				result.add(item);
			}
		}
		return result;
	}
	/**
	 * Generating unique Id for new items
	 * @return Item Id
	 */
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}
}
