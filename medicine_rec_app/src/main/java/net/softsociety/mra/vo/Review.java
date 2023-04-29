package net.softsociety.mra.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	int reviewnum;
	String contents;
	int evaluate;
	int mednum;
	int membernum;
	String inputdate;
}
