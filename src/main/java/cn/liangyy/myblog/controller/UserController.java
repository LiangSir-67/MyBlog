package cn.liangyy.myblog.controller;


import cn.liangyy.myblog.common.lang.Result;
import cn.liangyy.myblog.entity.User;
import cn.liangyy.myblog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiangSir
 * @since 2021-03-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @RequiresAuthentication 该注解表示需要登录才能访问
     * @param id
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/{id}")
    public Object index(@PathVariable("id") Long id){
        User userinfo = userService.getById(id);
        return Result.succ("获取成功！",userinfo);
    }

    @PostMapping("save")
    public Result save(@Validated @RequestBody User user){
        return Result.succ("保存成功！",user);
    }
}
