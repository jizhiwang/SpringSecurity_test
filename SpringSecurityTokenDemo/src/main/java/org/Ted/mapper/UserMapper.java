package org.Ted.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.Ted.domian.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
