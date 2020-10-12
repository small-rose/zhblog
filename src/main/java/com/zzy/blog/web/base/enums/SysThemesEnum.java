package com.zzy.blog.web.base.enums;

import com.github.pagehelper.StringUtil;

/**
 * 系统样式类型
 *
 * @author zhoujf
 */
public enum SysThemesEnum {
	
	SIMPLE_STYLE("simple","main/main","default", "简易风格"),
	HUASHAO_STYLE("hulihushao","ut_main","default", "花哨风格");

    /**
     * 风格
     */
    private String style;
    
    /**
     * 首页路径
     */
    private String indexPath;
    
    /**
     * 样式
     */
    private String themes;
    /**
     * 描述
     */
    private String desc;

    private SysThemesEnum(String style, String indexPath, String themes, String desc) {
        this.style = style;
        this.indexPath = indexPath;
        this.themes = themes;
        this.desc = desc;
    }
    
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIndexPath() {
		return indexPath;
	}

	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}

	public static SysThemesEnum toEnum(String style) {
		if (StringUtil.isEmpty(style)) {
			//默认风格
			return SIMPLE_STYLE;
        }
		for(SysThemesEnum item : SysThemesEnum.values()) {
			if(item.getStyle().equals(style)) {
				return item;
			}
		}
		//默认风格
		return SIMPLE_STYLE;
	}

    public String toString() {
        return "{style: " + style + ", indexPath: " + indexPath + ", themes: " + themes + ", desc: " + desc +"}";
    }
}
