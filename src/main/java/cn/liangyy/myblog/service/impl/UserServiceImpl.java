package cn.liangyy.myblog.service.impl;

import cn.liangyy.myblog.entity.User;
import cn.liangyy.myblog.mapper.UserMapper;
import cn.liangyy.myblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiangSir
 * @since 2021-03-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
