package ru.job4j.tracker;
import java.util.Arrays;
import java.util.Random;
/**
 * Storage for applications
 * @author Andrei Pashchenko.
 * @version 1
 * @since 16.02.2019
 */
public class Tracker {
	private final Item[] items = new Item[100];
	private int position = 0;
	private static final Random RN = new Random();
	/**
	 * Adding new item
	 * @param item Item to add
	 * @return Added item
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[this.position++] = item;
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
		for (int index = 0; index < this.position; index++) {
			if (this.items[index].getId().equals(id)) {
				this.items[index] = item;
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
		for (int index = 0; index < this.position; index++) {
			if (this.items[index].getId().equals(id)) {
				this.position--;
				System.arraycopy(this.items, index + 1, this.items, index, this.position - index);
				this.items[this.position] = null;
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
	public Item[] findAll() {
		return Arrays.copyOf(this.items, this.position);
	}
	/**
	 * Finding item by name
	 * @param key Name to find
	 * @return Array of found items
	 */
	public Item[] findByName(String key) {
		Item[] result = new Item[this.position];
		int cutoff = 0;
		for (int index = 0; index < this.position; index++) {
			if (this.items[index].getName().equals(key)) {
				result[cutoff] = this.items[index];
				cutoff++;
			}
		}
		return Arrays.copyOf(result, cutoff);
	}
	/**
	 * Generating unique Id for new items
	 * @return Item Id
	 */
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}
}
