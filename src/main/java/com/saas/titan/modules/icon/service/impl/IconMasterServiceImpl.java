package com.saas.titan.modules.icon.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.modules.icon.service.IconMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.saas.titan.modules.icon.dao.IconMasterDao;
import com.saas.titan.modules.icon.entity.IconMasterEntity;



@Service("iconMasterService")
public class IconMasterServiceImpl extends ServiceImpl<IconMasterDao, IconMasterEntity> implements IconMasterService {

   @Autowired
    private IconMasterDao iconMasterDao;

    @Override
    public Page<IconMasterEntity> getList(BasicsVo vo) {
        //构筑分页对象
        Page<IconMasterEntity> page = new Page<>();
        page.setCurrent(vo.getPage());
        page.setSize(vo.getSize());
        return iconMasterDao.selectPage(page, null);
    }
}
