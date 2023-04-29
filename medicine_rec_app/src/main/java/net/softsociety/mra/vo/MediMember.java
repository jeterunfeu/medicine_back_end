package net.softsociety.mra.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediMember {
	int membernum;
	String memberid;
	String memberpw;
	String membername;
	String email;
	String phone;
	String address;
	boolean enabled;
	String rolename;
}
