package model;

import java.util.ArrayList;

public enum PayementType {
	CB,ESPECE,CHEQUE,NATURE,BISOUS_A_TALBOT;
	
	public static ArrayList<String> getStrings() {
		ArrayList<String> list = new ArrayList<>();
		for(PayementType p:PayementType.values()) {
			list.add(p.name());
		}
		return list;
	}
}
