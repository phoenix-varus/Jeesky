package org.iskycode.jeesky.adm.entity;

import org.hibernate.annotations.GenericGenerator;
import org.iskycode.jeesky.sys.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author phoenix
 *
 *         权限实体类
 */
@Entity
@Table(name = "sys_permission")
public class Permission extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	// 权限标识
	private String name;
	// 权限描述
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
