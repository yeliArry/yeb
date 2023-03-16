package com.hdax.yeb.controller;

import com.hdax.yeb.dao.TadminDao;
import com.hdax.yeb.entity.Tadmin;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class TadminController {
    String role = "";
    @Resource
    private TadminDao tadminDao;

    //    public class LoginController {
//        @Resource
//        private PersonDao personDao ;
//
//        //用户的角色
//        private String role ;
//        //login
//        @RequestMapping("/login")
//        public R login( Person person) {
//            //用户名
//            String username = person.getUsername();
//            //密码
//            String password = person.getPassword();
//
//            Person person1 = personDao.login(username,password) ;
//
//            role = person1.getRole() ;
//
//            return R.ok() ;
//        }
//        //info
//        @RequestMapping("info")
//        public R getInfo(){
//            List<String> roles = new ArrayList<>() ;
//            roles.add(role) ;
//            return  R.ok().data("roles",roles);
//        }
//
//        @GetMapping("logout")
//        public R logout(){
//            return R.ok().data("token","admin");
//        }
    @RequestMapping("login")
    public R login(Tadmin tadmin) {
        Tadmin login = tadminDao.login(tadmin.getUsername(), tadmin.getPassword());
        role = login.getRole();
        return R.ok();
    }


    @GetMapping("info")
    public R getInfo(Tadmin tadmin) {
        List<String> roles = new ArrayList<>();
        roles.add(role);
        return R.ok().data("roles", roles);
    }

    @GetMapping("logout")
    public R logout() {
        return R.ok().data("token", "admin");
    }

    @RequestMapping("get")
    public R get() {
        return R.ok().data("list", tadminDao.selectList(null));
    }

    @RequestMapping("query01")
    public R query01(String name) {
        return R.ok().data("list", tadminDao.query01(name));
    }

    @RequestMapping("del")
    public R del(int id) {
        tadminDao.deleteById(id);
        return R.ok().data("list", tadminDao.query01(null));
    }
}
