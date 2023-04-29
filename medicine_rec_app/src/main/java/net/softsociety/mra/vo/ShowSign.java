package net.softsociety.mra.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowSign {
	int signnum;
	String signpart;
	String signfirst;
	String signsecond;
	int mednum;
}
