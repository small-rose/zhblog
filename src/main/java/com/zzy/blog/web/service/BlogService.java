package com.zzy.blog.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.page.Page;
import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.mapper.ArticleMapper;
import com.zzy.blog.web.pojo.Article;
import com.zzy.blog.web.pojo.ArticleCustom;
import com.zzy.blog.web.pojo.Comment;
import com.zzy.blog.web.vo.CustomIds;
import com.zzy.blog.web.vo.LikeJson;

import lombok.extern.slf4j.Slf4j;


@CacheConfig(cacheNames = "zhblogCache")
@Slf4j
@Service
public class BlogService {

	@Autowired 
	private ArticleMapper articleMapper;
	
	public PageInfo<ArticleCustom> getList(Page<ArticleCustom> page, ArticleCustom object) {
		
		//注意，使用pageHelper分页，后面要紧跟mapper查询
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<ArticleCustom> result = articleMapper.selectArticleCustom(object);
        
        PageInfo<ArticleCustom> pageInfo = new PageInfo<>(result);
		return pageInfo;
	}

	public ArticleCustom getArticleById(Long id) {
		// TODO Auto-generated method stub
		return articleMapper.selectArticleCustomByPrimaryKey(id);
	}

	@Transactional
	public void saveArticle(ArticleCustom object) {
		// TODO Auto-generated method stub
		if(object.getId()==null) {
			log.info(" add article");
			//新增
			//保存文章
			if(object.getIsDraft()==1) {
				object.setPublishDate(DateUtils.getDateTime());
			}
			object.setSaveDate(DateUtils.getDateTime());
			
			int x = articleMapper.insertSelective(object);
			//保存文章与标签关系
			String tagIds  = object.getTagIds();
			if(tagIds!=null ) {
				String[] ids = tagIds.split(",");
				Long articleId = object.getId();
				log.info(" -- -- --"+articleId);
				for(String tagId : ids) {
					
					articleMapper.insertArticleTags(articleId, Long.parseLong(tagId));
				}
			}
		}else {
			//修改
			log.info(" update article");
			Article record = new Article();
			record.setId(object.getId());
			record.setArticleTitle(object.getArticleTitle());
			record.setArticleAuthor(object.getArticleAuthor());
			record.setArticleContent(object.getArticleContent());
			record.setArticleTabloid(object.getArticleTabloid());
			record.setUpdateDate(DateUtils.getDateTime());
			
			if(object.getIsDraft()==1) {
				record.setPublishDate(DateUtils.getDateTime());
			}
			articleMapper.updateByPrimaryKeySelective(record);
			
			String tagIds  = object.getTagIds();
			if(tagIds!=null ) {
				String[] ids = tagIds.split(",");
				
				articleMapper.deleteArticleTagsByArticleId(object.getId());
				for(String tagId : ids) {
					articleMapper.insertArticleTags(object.getId(), Long.parseLong(tagId));
				}
			}
		}
	}
	
	//@Transactional
	/*public void delete(CustomIds custId) {
		// TODO Auto-generated method stub
		if(custId!=null) {
			ArticleCustom lastArticle =  null;
			ArticleCustom nextArticle =  null;
			ArticleCustom currtArticle =  null;
			for(Long id : custId.getIds()) {
				currtArticle = articleMapper.selectArticleCustomByPrimaryKey(id);
				lastArticle = articleMapper.selectArticleCustomByPrimaryKey(currtArticle.getLastArticleId());
				nextArticle = articleMapper.selectArticleCustomByPrimaryKey(currtArticle.getNextArticleId());
				//删除的博文是第一篇
				if(currtArticle.getLastArticleId()==0 || lastArticle==null) {
					ArticleCustom custom = new ArticleCustom();
					custom.setId(lastArticle.getId());
					custom.setLastArticleId(0l);
					articleMapper.updateByPrimaryKey(custom);
				}else if(currtArticle.getNextArticleId()==null || nextArticle==null) {
					//删除的博文是最后一篇
					ArticleCustom custom = new ArticleCustom();
					custom.setId(lastArticle.getId());
					custom.setNextArticleId(null);
					articleMapper.updateByPrimaryKey(custom);
				}else{
					ArticleCustom last = new ArticleCustom();
					last.setId(lastArticle.getId());
					last.setNextArticleId(nextArticle.getId());
					articleMapper.updateByPrimaryKey(last);
					
					ArticleCustom next = new ArticleCustom();
					next.setId(nextArticle.getId());
					next.setLastArticleId(lastArticle.getId());
					articleMapper.updateByPrimaryKey(next);
				}
				
				articleMapper.deleteArticleTagsByArticleId(id);
				articleMapper.deleteByPrimaryKey(id);
			}
		}
	}*/

	public List<ArticleCustom> findAll(ArticleCustom record, HttpServletRequest request) {

		List<ArticleCustom> list = articleMapper.selectArticleCustom(record);
		return list;
	}

	public void delete(CustomIds custId) {
		// TODO Auto-generated method stub
		if(custId!=null) {
			for(Long id : custId.getIds()) {
				articleMapper.deleteArticleTagsByArticleId(id);
				articleMapper.deleteByPrimaryKey(id);
			}
		}
	}

	@Cacheable(key = "#root.targetClass.simpleName+':'+#root.methodName+':'+#record")
	public List<ArticleCustom> findAllArtile(ArticleCustom record, HttpServletRequest request) {
		List<ArticleCustom> list = articleMapper.selectArticleAllCustom(record);
		return list;
	}
	@Cacheable(key = "#root.targetClass.simpleName+':'+#root.methodName+':'+#article")
	public List<ArticleCustom> findBestArtile(ArticleCustom article, HttpServletRequest request) {
		ArticleCustom record  = new ArticleCustom();
		record.setBest(GlobleConstants.Best);
		List<ArticleCustom> list = articleMapper.selectArticleAllCustom(record);
		return list;
	}
	
	@Async
	public void addViewHits(ArticleCustom article) {
		long addOne = article.getArticleHits()+1 ;
		Article record = new Article();
		record.setArticleHits(addOne);
		record.setId(article.getId());
		articleMapper.updateByPrimaryKeySelective(record );
	}

	@Cacheable(key = "#root.targetClass.simpleName+':'+#root.methodName+':'+#typeId")
	public List<ArticleCustom> findArtileByType(Long typeId, HttpServletRequest request) {

		ArticleCustom record = new ArticleCustom();
		record.setArticleType(typeId);
		List<ArticleCustom> list = articleMapper.selectArticleAllCustom(record );
		return list;
	}

	public List<ArticleCustom> findAllListGroupByYear() {
		// TODO Auto-generated method stub
		return articleMapper.selectArticleFiles();
	}

	public Article getPrevArticleById(Long id) {
		
		return articleMapper.selectPrevArticleById(id);
	}

	public Article getNextArticleById(Long id) {
		return articleMapper.selectNextArticleById(id);
	}

	public Article addArticleLike(LikeJson likeJson) {
		Article article = getArticleById(likeJson.getId());
		
		Article record = new Article();
		record.setId(article.getId());
		if(likeJson.getIsLike() > 0) {
			Integer likes = article.getLikeYes(); 
			record.setLikeYes(likes+1);
		}else {
			Integer likes = article.getLikeNo(); 
			record.setLikeNo(likes+1);
		}
		
		articleMapper.updateByPrimaryKeySelective(record);
		Article lastArticle = getArticleById(record.getId());
		return lastArticle;
	}



}
