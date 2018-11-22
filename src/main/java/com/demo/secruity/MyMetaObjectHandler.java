package com.demo.secruity;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import javafx.application.Application;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class MyMetaObjectHandler implements MetaObjectHandler {

    protected final static Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("新增的时候干点不可描述的事情");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("更新的时候干点不可描述的事情");
    }
}
