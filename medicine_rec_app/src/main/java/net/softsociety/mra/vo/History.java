package net.softsociety.mra.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
	int historynum;
	int membernum;
	int mednum;
	String picture;
	String medname;
	String medco;
	String signpart;
	String signfirst;
	String signsecond;
	String inputdate;
	float star;

}
