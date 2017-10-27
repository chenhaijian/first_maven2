package com.dalu.ims.controller;

import com.dalu.ims.pojo.User;
import com.dalu.ims.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author chj
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户的数据
     * @return
     */
    @RequestMapping(value = "queryList", method = RequestMethod.GET)
    public ResponseEntity<List<User>> queryAll() {
        List<User> userList = this.userService.queryAll();
        return ResponseEntity.ok(userList);
    }

    @RequestMapping(value="queryOne1/{id}", method = RequestMethod.GET)
    public ModelAndView queryOne(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(1);
        user.setUserName("张三");
        user.setAge(21);
        user.setSex("男");
        ModelAndView mv = new ModelAndView("user");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(value = "queryOne2/{id}", method = RequestMethod.GET)
    public String queryuser(@PathVariable("id") Long id, Model model) {
        User user = new User();
        user.setSex("女");
        user.setAge(25);
        user.setUserName("李四");
        user.setId(2);
        model.addAttribute("user", user);
        return "user";
    }

    /**
     * 查询所有用户的数据
     * @return
     */
    @RequestMapping(value = "queryAll", method = RequestMethod.GET)
    public ModelAndView queryAllUser() {
        List<User> userList = this.userService.queryAll();
        ModelAndView mv = new ModelAndView("user");
        mv.addObject("userList", userList);
        return mv;
    }

    /**
     * 插入数据
     * @param user
     * @param desc
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(User user, @RequestParam("desc") String desc) {
        System.out.println("================" + desc);
        this.userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    /**
     * 跳转到登录页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/toEdit/{id}")
    public String toEdit(@PathVariable("id") Integer id , Model model) {
        User user = this.userService.queryById(id);
        model.addAttribute("user", user);
        return "toEdit";
    }

    /**
     *更新用户数据
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Void> update(User user) {

        Integer count = this.userService.update(user);
        if (count != 1) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    /**
     * 根据ID删除用户数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteById(Integer id) {
        Integer count = this.userService.deleteById(id);
        if (count != 1) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 批量删除用户
     * @param ids 用户id集合
     * @return
     */
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteBatch(String ids) {

        String[] idList = StringUtils.split(ids, ",");

//        try {
//            this.userService.deleteBatch(idList);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        boolean flag = this.userService.deleteBatch(idList);
        if(flag) {
            //删除成功
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }


}
