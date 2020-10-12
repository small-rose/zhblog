package com.zzy.blog.web.base.page;

import java.util.List;

import lombok.Data;

/**
 *    easyui 返回数据json格式
 * @author Administrator
 *
 */
@Data
public class EasyUIDataGrid {
	
	private String title ;
	private long total = -1L;
	private List<?> rows ;
	
	private String primaryKey;
	private String columns;

}
