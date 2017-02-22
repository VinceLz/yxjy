package dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import pojo.Article;

public interface ArticleMapper {
	public List<Article>  find();
	public Article get(Serializable id);
	public Article getJj();
	public void updateJj(Map img);
	public List<Article> getArticleByPid(int pid);
	public void insert(Article article);
	public void update(Article article);
	public void delete(int aid);
	public List<Article> getArticleByKp();
	public void insertJj(Article article);
	
	List<Article> findByType(int i);
} 
