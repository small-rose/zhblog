package com.zzy.blog.web.pojo;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageCustom extends Message{

	private static final long serialVersionUID = 3875962315263571898L;
   
	private List<MessageCustom> children = new ArrayList<>();
	
	
}