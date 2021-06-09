package cn.liangyy.myblog.service.impl;

import cn.liangyy.myblog.entity.Blog;
import cn.liangyy.myblog.mapper.BlogMapper;
import cn.liangyy.myblog.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
