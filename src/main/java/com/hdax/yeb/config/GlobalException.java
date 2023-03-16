package com.hdax.yeb.config;


import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局处理异常
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public R mySqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            //return R.error("该数据有关联数据，操作失败！");
            return R.error();
        }
        return R.error();
    }
}
