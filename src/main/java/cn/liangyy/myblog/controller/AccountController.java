package cn.liangyy.myblog.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import cn.liangyy.myblog.common.dto.LoginDto;
import cn.liangyy.myblog.common.lang.Result;
import cn.liangyy.myblog.entity.User;
import cn.liangyy.myblog.service.UserService;
import cn.liangyy.myblog.utils.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * 登录
     * @param loginDto
     * @param response
     * @return
     */
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto , HttpServletResponse response){
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user,"用户不存在！");
        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.fail("密码不正确，请重试！");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expose-Headers","Authorization");
        return Result.succ(MapUtil.builder()
                .put("id",user.getId())
                .put("username",user.getUsername())
                .put("avatar",user.getAvater())
                .put("email",user.getEmail())
                .map()
        );
    }

    /**
     * 退出登录
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

}
