package com.dalu.ims.controller;

import com.dalu.ims.mapper.RoleMapper;
import com.dalu.ims.pojo.EasyUIResult;
import com.dalu.ims.pojo.Role;
import com.dalu.ims.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * @author chj
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有的角色信息
     * @return
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> queryAllUser() {
        try {
            List<Role> roleList = this.roleService.queryAll();
            return ResponseEntity.status(HttpStatus.OK).body(roleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }


    /**
     * 分页查询数据
     * @param page 页数
     * @param rows 行数
     * @return
     */
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public ResponseEntity<EasyUIResult> queryRoleList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                      @RequestParam(value = "rows", defaultValue = "10") Integer rows) {



        try {
            EasyUIResult result = this.roleService.queryItemList(page, rows);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

    }

    /**
     * 保存新增角色
     * @param role
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> saveRole(Role role) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
