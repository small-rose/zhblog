package com.zzy.blog.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.common.exception.BussException;
import com.zzy.blog.web.mapper.PicCategorieMapper;
import com.zzy.blog.web.mapper.PictureMapper;
import com.zzy.blog.web.pojo.PicCategorie;
import com.zzy.blog.web.pojo.PicCategorieQuery;
import com.zzy.blog.web.pojo.Type;
import com.zzy.blog.web.pojo.PicCategorieQuery.Criteria;

@Service
public class ImageCateService {

	@Autowired
	private PicCategorieMapper picCategorieMapper;
	@Autowired
	private PictureMapper pictureMapper;

	public List<PicCategorie> findAll(PicCategorie picate, HttpServletRequest request) {
		PicCategorieQuery example = new PicCategorieQuery();
		Criteria criteria = example.createCriteria();
		if(picate!=null){
			if(!StringUtils.isEmpty(picate.getPicCateName())){
				 criteria.andPicCateNameLike(picate.getPicCateName());
			}
			if(picate.getIsShow()!=null && picate.getIsShow()> -1 ){
				 criteria.andIsShowEqualTo(picate.getIsShow());
			}
		}
		example.setOrderByClause("id desc");
		List<PicCategorie> list = picCategorieMapper.selectByExample(example);
		return list;
	}

	public void save(PicCategorie object) {
		if(object.getId()==null) {
			//新增
			object.setIsShow(GlobleConstants.Show.IS_SHOW_Y);
			picCategorieMapper.insertSelective(object);
		}else {
			//修改
			PicCategorie record = new PicCategorie();
			record.setId(object.getId());
			record.setPicCateCode(object.getPicCateCode());
			record.setPicCateName(object.getPicCateName());
			record.setPicCateNote(object.getPicCateNote());
			record.setPicCateOrder(object.getPicCateOrder());
			picCategorieMapper.updateByPrimaryKeySelective(record);
		}
	}

	public PicCategorie getPicCategorieById(Long id) {
		return picCategorieMapper.selectByPrimaryKey(id);
	}

	public void delPicCategorieByIds(Long[] ids) throws BussException{
		for(Long id : ids) {
			long x = pictureMapper.selectByCateId(id);
			if(x>0) {
				PicCategorie tmp = picCategorieMapper.selectByPrimaryKey(id);
				throw new BussException("分类【"+tmp.getPicCateName()+"】已经被使用，禁止删除！");
			}
			picCategorieMapper.deleteByPrimaryKey(id);
		}
	}

	public void changeShow(PicCategorie picate) {
		PicCategorie record = new PicCategorie();
		record.setId(picate.getId());
		if(GlobleConstants.Show.IS_SHOW_Y.equals(picate.getIsShow())) {
			record.setIsShow(GlobleConstants.Show.IS_SHOW_N);
		}else {
			record.setIsShow(GlobleConstants.Show.IS_SHOW_Y);
		}
		picCategorieMapper.updateByPrimaryKeySelective(record);
	}

	public List<PicCategorie> findAllPicates() {
		PicCategorie categorie = new PicCategorie();
		List<PicCategorie> list = picCategorieMapper.selectPicCategorieList(categorie);
		return list;
	}
}
