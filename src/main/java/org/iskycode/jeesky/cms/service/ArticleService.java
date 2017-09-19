package org.iskycode.jeesky.cms.service;

import org.iskycode.jeesky.cms.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author phoenix
 *
 *         文章业务处理层
 */
@Service
public class ArticleService {

	@Autowired
	ArticleDao articleDao;
}
