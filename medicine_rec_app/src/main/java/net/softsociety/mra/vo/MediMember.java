package net.softsociety.mra.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediMember implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -381255349641755611L;
	
	private int membernum;
	private String memberid;
	private String memberpw;
	private String membername;
	private String email;
	private String phone;
	private String address;
	boolean enabled;
	String rolename;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		return this.getMemberpw();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getMemberid();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}
}
