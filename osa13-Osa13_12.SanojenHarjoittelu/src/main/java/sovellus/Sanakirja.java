package sovellus;

import java.util.*;


public class Sanakirja {

	private final Map<String, String> sanaparit;

	public Sanakirja() {
		this.sanaparit = new HashMap<>();
		sanaparit.put("sana", "word");
	}

	public void lisaa(String sana, String kaannos) {
		this.sanaparit.put(sana, kaannos);
	}

	public String hae(String sana) {
		return sanaparit.get(sana);
	}


	public String arvoUusiSana() {
		Random random = new Random();
		List<String> sanat = new ArrayList<>(sanaparit.keySet());
		return sanat.get(random.nextInt(sanat.size()));
	}

}
