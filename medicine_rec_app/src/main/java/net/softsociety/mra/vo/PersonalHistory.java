package net.softsociety.mra.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalHistory {
	int historynum;
	int membernum;
	int signnum;
	int mednum;
	String inputdate;
}
