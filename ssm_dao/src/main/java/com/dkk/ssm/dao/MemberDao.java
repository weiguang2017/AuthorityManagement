package com.dkk.ssm.dao;

import com.dkk.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 21:52
 * @description:
 **/
@Repository("memberDao")
public interface MemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;

}
