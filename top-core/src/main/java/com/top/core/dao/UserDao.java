package com.top.core.dao;

import com.google.common.base.Optional;
import com.top.core.domain.UserInfoEntity;
import org.springframework.stereotype.Repository;
import org.triiskelion.tinyspring.dao.AbstractDao;

import static org.triiskelion.tinyspring.dao.TinyPredicate.equal;

/**
 * @author Sebastian MA
 */
@Repository
public class UserDao extends AbstractDao<UserInfoEntity> {

	@Override
	protected Class<UserInfoEntity> getEntityClass() {

		return UserInfoEntity.class;
	}

	public Optional<UserInfoEntity> findByMobile(String mobile) {

		return beginQuery().ignoreNull(false)
		                   .select()
		                   .where(equal("mobile", mobile))
		                   .getFirstResult();
	}

}
