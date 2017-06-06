package service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Article;

import service.ArticleService;

import dao.ArticleMapper;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Article> find() {

		return articleMapper.find();
	}

	@Override
	public Article get(Serializable id) {
		return articleMapper.get(id);
	}

	@Override
	public Article getJj() {
		return articleMapper.getJj();
	}

	@Override
	public void updateJj(Map img) {
		articleMapper.updateJj(img);
	}

	@Override
	public List<Article> getArticleByPid(int pid) {
		return articleMapper.getArticleByPid(pid);
	}

	@Override
	public void insert(Article article) {
		articleMapper.insert(article);
	}

	@Override
	public void update(Article article) {
		articleMapper.update(article);
	}

	@Override
	public void delete(int aid) {
		articleMapper.delete(aid);
	}

	@Override
	public List<Article> getArticleByKp() {
		return articleMapper.getArticleByKp();
	}

	@Override
	public void insertJj(Article article) {
		articleMapper.insertJj(article);
	}

	@Override
	public List<Article> findByType(int i) {
		return articleMapper.findByType(i);
	}

	@Override
	public List<Article> getClassByPid(int pid) {
		return articleMapper.getClassByPid(pid);
	}

	@Override
	public void deleteByPid(int pid) {
		articleMapper.deleteByPid(pid);
	}

	

}
