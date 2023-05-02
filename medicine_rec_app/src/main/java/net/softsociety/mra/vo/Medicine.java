package net.softsociety.mra.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
	int mednum;
	String picture;
	String medname;
	String medco;
	int price;
	String takemed;
	int medcycle;
	String ingredient;
	float star;
	String note;
}
