/**
 * A Knapsack holds zero or more Items and can provide information about the
 * Items. One can add Items to a Knapsack during its lifetime, reset the
 * Knapsack, create a copy which contains Items only up to a certain weight,
 * and make various queries to the Knapsack. (Thus, the number of Items that
 * will be stored by a Knapsack object is not yet known when the new object
 * is created, and it may grow and shrink over the lifetime of a Knapsack
 * object.)
 *
 * @Ayyub Said
 */
public class Knapsack {

	/**
	 * This array list of type "Item" keeps items in itself
	 */
	private ArrayList<Item> sack;

	/* Constructors */

	/**
	 * Constructs a new Knapsack without any Items.
	 */
	public Knapsack() {
		// creating sack without any item.
		sack = new ArrayList<Item>();
	}

	/**
	 * Constructs a new Knapsack containing the non-null Items in items. The
	 * items array may be modified by the caller afterwards without affecting
	 * this Knapsack, and it will not be modified by this constructor.
	 *
	 * @param items
	 *            must not be null; non-null elements are added to the
	 *            constructed Knapsack
	 */
	public Knapsack(Item[] items) {
		this(); // calling the upper constructor which initializes the list
		// this constructor calls add All method which adds complete list to the
		// sack Object
		addAll(items);
	}

	/* Modifiers */

	/**
	 * Adds an Item e to this Knapsack if e is not null; does not modify this
	 * Knapsack otherwise. Returns true if e is not null, false otherwise.
	 *
	 * @param e
	 *            an item to be added to this Knapsack
	 * @return true if e is not null, false otherwise
	 */
	public boolean add(Item e) {
		if (e == null) {
			return false;
		} else {
			sack.add(e);
		}
		return true;
	}

	/**
	 * Adds all non-null Items in items to this Knapsack.
	 *
	 * @param items
	 *            contains the Item objects to be added to this Knapsack; must
	 *            not be null (but may contain null)
	 * @return true if at least one element of items is non-null; false
	 *         otherwise
	 */
	public boolean addAll(Item[] items) {
		// creating check variable if any of the element is non-null
		boolean nonnull = false;

		for (int i = 0; i < items.length; i++) {
			// if any of the element in items will be added.. the variable will
			// become true
			if (add(items[i])) {
				nonnull = true;
			}
		}

		return nonnull;
	}

	/**
	 * Resets this Knapsack to a Knapsack that contains 0 Items.
	 */
	public void reset() {
		// using clear function to empty the Knapsack Object "sack"
		sack.clear();
	}

	/**
	 * Removes certain Items from this Knapsack. Exactly those Items are kept
	 * whose weight in grammes is less than or equal to the specified maximum
	 * weight in grammes.
	 *
	 * @param maxItemWeightInGrammes
	 *            the maximum weight in grammes for the Items that are kept
	 */
	public void keepOnlyItemsWith(int maxItemWeightInGrammes) {
		for (int i = 0; i < sack.size(); i++) {
			if (sack.get(i).getWeightInGrammes() > maxItemWeightInGrammes) {
				sack.remove(i);
			}
		}
	}

	/* Accessors */

	/**
	 * Returns the number of non-null Items in this Knapsack.
	 *
	 * @return the number of non-null Items in this Knapsack
	 */
	public int numberOfItems() {
		int count = 0;
		for (int i = 0; i < sack.size(); i++) {
			if (sack.get(i) != null) {
				count += 1;
			}
		}
		return count;
	}

	/**
	 * Returns the total weight of the Items in this Knapsack.
	 *
	 * @return the total weight of the Items in this Knapsack.
	 */
	public int totalWeightInGrammes() {
		int total = 0;
		for (int i = 0; i < sack.size(); i++) {
			total += sack.get(i).getWeightInGrammes();
		}
		return total;
	}

	/**
	 * Returns the average weight in grammes of the (non-null) Items in this
	 * Knapsack. In case there is no Item in this Knapsack, -1.0 is returned.
	 *
	 * For example, if this Knapsack has the contents new Item("Soda", 400) and
	 * new Item("Water", 395), the result is: 397.5
	 *
	 * @return the average length of the Items in this Knapsack, or -1.0 if
	 *         there is no such Item.
	 */
	public double averageWeightInGrammes() {
		if (sack.size() == 0) {
			return -1.0;
		}
		double totalitems = sack.size();
		double sumofitems = 0;
		for (int i = 0; i < sack.size(); i++) {
			sumofitems += sack.get(i).getWeightInGrammes();
		}
		return sumofitems / totalitems;
	}

	/**
	 * Returns the greatest Item in this Knapsack according to the natural
	 * ordering of Item given by its compareTo method; null if this Knapsack
	 * does not contain any Item objects
	 *
	 * @return the greatest Item in this Knapsack according to the natural
	 *         ordering of Item given by its compareTo method; null if this
	 *         Knapsack does not contain any Item objects
	 */
	public Item greatestItem() {
		if (sack.size() == 0) {
			return null;
		}
		Item greatestitem = sack.get(0);
		for (int i = 0; i < sack.size(); i++) {
			if (greatestitem.compareTo(sack.get(i)) == -1) {
				greatestitem = sack.get(i);
			}
		}

		return greatestitem;
	}

	/**
	 * Returns a new Knapsack with exactly those Items of this Knapsack whose
	 * weight is less than or equal to the specified method parameter. Does not
	 * modify this Knapsack.
	 *
	 * @param maxItemWeightInGrammes
	 *            the maximum weight in grammes for the Items in the new
	 *            Knapsack
	 * @return a new Knapsack with exactly those Items of this Knapsack whose
	 *         weight is less than or equal to the specified method parameter
	 */
	public Knapsack makeNewKnapsackWith(int maxItemWeightInGrammes) {
		Knapsack tempsack = new Knapsack();
		for (int i = 0; i < sack.size(); i++) {
			if (sack.get(i).getWeightInGrammes() <= maxItemWeightInGrammes) {
				tempsack.add(sack.get(i));
			}
		}
		return tempsack;
	}

	/**
	 * Returns a string representation of this Knapsack. The string
	 * representation consists of a list of the Knapsack's contents, enclosed in
	 * square brackets ("[]"). Adjacent Items are separated by the characters
	 * ", " (comma and space). Items are converted to strings as by their
	 * toString() method. The representation does not mention any null
	 * references.
	 *
	 * So for
	 *
	 * Item i1 = new Item("Pen", 15); Item i2 = new Item("Letter", 20); Item i3
	 * = null; Item[] items = { i1, i2, i3, i1 }; Knapsack k = new
	 * Knapsack(items);
	 *
	 * the call k.toString() will return one of the three following Strings:
	 *
	 * "[(Pen, 15), (Pen, 15), (Letter, 20)]"
	 * "[(Pen, 15), (Letter, 20), (Pen, 15)]"
	 * "[(Letter, 20), (Pen, 15), (Pen, 15)]"
	 *
	 * @return a String representation of this Knapsack
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TO DO
		String result = "[";
		for (int i = 0; i < sack.size(); i++) {
			if (i != 0) {
				result += ", ";
			}
			result += "(" + sack.get(i).getName() + ", " + sack.get(i).getWeightInGrammes() + "g)";
		}
		result += "]";
		return result;
	}

	/* class methods */

	/**
	 * Class method to return a Knapsack with the highest total weight from an
	 * array of Knapsacks. If we have an array with a Knapsack of 3000 grammes
	 * and a Knapsack with 4000 grammes, the Knapsack with 4000 grammes is
	 * returned.
	 *
	 * Entries of the array may be null, and your method should work also in the
	 * presence of such entries. So if in the above example we had an additional
	 * third array entry null, the result would be exactly the same.
	 *
	 * If there are several Knapsacks with the same weight, it is up to the
	 * method implementation to choose one of them as the result (i.e., the
	 * choice is implementation-specific, and method users should not rely on
	 * any particular behaviour).
	 *
	 * @param knapsacks
	 *            must not be null, but may contain null
	 * @return one of the Knapsacks with the highest total weight among all
	 *         Knapsacks in the parameter array; null if there is no non-null
	 *         reference in knapsacks
	 */
	public static Knapsack heaviestKnapsack(Knapsack[] knapsacks) {
		// TO DO
		int tempindex = 0;
		int total = 0;
		int temptotal;
		for (int i = 0; i < knapsacks.length; i++) {
			temptotal = 0;
			for (int j = 0; j < knapsacks[i].sack.size(); j++) {
				temptotal += knapsacks[i].sack.get(j).getWeightInGrammes();
			}
			if (temptotal > total) {
				tempindex = i;
			}
		}
		if (tempindex != 0) {
			return knapsacks[tempindex];
		}
		return null;
	}
}
