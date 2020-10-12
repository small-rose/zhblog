package com.zzy.blog.web.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.FileUtils;
import com.zzy.blog.web.common.exception.BussException;
import com.zzy.blog.web.config.InitValueConfig;
import com.zzy.blog.web.mapper.ArticleMapper;
import com.zzy.blog.web.mapper.PictureMapper;
import com.zzy.blog.web.pojo.Picture;

@Service
public class PictureService {
	
	@Autowired
	private InitValueConfig initValueConfig;
	@Autowired
	private PictureMapper pictureMapper;
	@Autowired
	private ArticleMapper articleMapper;
	
	
	public Long save(String rootPath,MultipartFile file) {
		// TODO Auto-generated method stub
		String filName = file.getOriginalFilename();
		String suffix = filName.substring(filName.lastIndexOf("."));
		String newName = DateUtils.getDateRandom()+suffix;
		File newFile = new File(rootPath); 
		Long id = 0l ;
		if(newFile.exists() && newFile.isFile()) {
			Picture pic = new Picture();
			pic.setPicLength(newFile.length());
			pic.setPicContent(FileUtils.getFileBytes(newFile));
			pic.setPicLocalAddress(initValueConfig.getUpload());
			pic.setAbsLocalAddress(rootPath);
			pic.setPicName(filName);
			pic.setPicNewName(newName);
			pic.setPicSuffix(suffix);
			pic.setUploadDate(DateUtils.getDateTime());
			
			pictureMapper.insertSelective(pic);
			id = pic.getId();
		}
		return id;
	}

	public int reName(Picture object) {
		// TODO Auto-generated method stub
		Picture record = new Picture();
		record.setId(object.getId());
		record.setPicName(object.getPicName());
		int x = pictureMapper.updateByPrimaryKey(record);
		return x ;
	}

	public List<Picture> getList(Long cateId) {
		List<Picture> list = pictureMapper.selecListByCateId(cateId);
		return list;
	}

	public int delete(Long[] custId) throws Exception{
		// TODO Auto-generated method stub
		int x = 0 ;
		if(custId!=null) {
			for(Long id : custId) {
				long y = articleMapper.selectArtListByImageId(id);
				if(y > 0) {
					throw new BussException("图片已经被使用"); 
				}
				pictureMapper.deleteByPrimaryKey(id);
				x ++ ;
			}
		}
		return x ;
	}

	public Picture saveWithCategryId(String rootPath, MultipartFile file, String picateId) throws Exception{
		// TODO Auto-generated method stub
		String filName = file.getOriginalFilename();
		String suffix = filName.substring(filName.lastIndexOf("."));
		String newName = DateUtils.getDateRandom()+suffix;
		File newFile = new File(rootPath + filName); 
		Long id = 0l ;
		Picture picture = null;
		if(newFile.exists() && newFile.isFile()) {
			Picture pic = new Picture();
			pic.setPicLength(newFile.length());
			pic.setPicContent(FileUtils.getFileBytes(newFile));
			pic.setPicLocalAddress(initValueConfig.getUpload());
			pic.setAbsLocalAddress(rootPath);
			pic.setPicName(filName);
			pic.setPicNewName(newName);
			pic.setPicSuffix(suffix);
			pic.setUploadDate(DateUtils.getDateTime());
			pic.setCateId(Long.valueOf(picateId));
			
			pictureMapper.insertSelective(pic);
			picture = pictureMapper.selectByPrimaryKey(pic.getId());
		}else {
			throw new BussException("图片未找到 " + rootPath); 
		}
		return picture;
	}

	
	
	
}
