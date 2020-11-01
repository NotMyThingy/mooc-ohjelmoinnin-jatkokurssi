package sovellus;

import java.util.HashMap;
import java.util.Map;

public class Shanghai {

	private final Map<Integer, Integer> values;

	public Shanghai() {
		this.values = new HashMap<>();

		values.put(2008, 68);
		values.put(2007, 73);
		values.put(2009, 72);
		values.put(2010, 72);
		values.put(2011, 74);
		values.put(2012, 73);
		values.put(2013, 76);
		values.put(2014, 73);
		values.put(2015, 67);
		values.put(2016, 56);
		values.put(2017, 56);
	}

	public Map<Integer, Integer> getValues() {
		return values;
	}
}
