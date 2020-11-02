package sovellus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PuolueData {

	private Map<String, Map<Integer, Double>> data;
	private final BufferedReader dataReader;

	public PuolueData() throws IOException {
		dataReader = new BufferedReader(new FileReader("puoluedata.tsv"));
		fillData();
		dataReader.close();
	}

	public Map<String, Map<Integer, Double>> getData() {
		return data;
	}

	private void fillData() throws IOException {
		this.data = new HashMap<>();

		List<String> vuodet = Arrays.asList(dataReader.readLine().split("\t"));

		String datarow = dataReader.readLine();
		while (datarow != null) {
			String[] items = datarow.split("\t");
			Map<Integer, Double> values = new HashMap<>();

			for (int i = 1; i < items.length; i++) {
				if (!isNumeric(vuodet.get(i)) || !isNumeric(items[i])) {
					continue;
				}
				values.put(Integer.parseInt(vuodet.get(i)), Double.parseDouble(items[i]));
			}


			data.put(items[0], values);

			datarow = dataReader.readLine();
		}
	}

	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
