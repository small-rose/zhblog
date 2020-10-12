package com.zzy.blog.web.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckVO {
	
	private String qs ;
	private String an ;
	private String code ;
	private String mobile ;
	
	private String secpass;
	
	private String newpass;

	
	private String uname;
	private String upass;
	
	
	@Override
	public String toString() {
		return "CheckVO [qs=" + qs + ", an=" + an + ", code=" + code + ", mobile=" + mobile + ", secpass=" + secpass
				+ ", newpass=" + newpass + "]";
	}
	
}
