package org.iskycode.jeesky.cms.service;

import org.iskycode.jeesky.cms.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author phoenix
 *
 *         人物业务处理层
 */
@Service
public class PersonService {

	@Autowired
	PersonDao personDao;
}
