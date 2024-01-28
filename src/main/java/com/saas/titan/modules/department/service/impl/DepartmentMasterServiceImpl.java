package com.saas.titan.modules.department.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.titan.modules.department.dao.DepartmentMasterDao;
import com.saas.titan.modules.department.entity.DepartmentMasterEntity;
import com.saas.titan.modules.department.service.DepartmentMasterService;


@Service("departmentMasterService")
public class DepartmentMasterServiceImpl extends ServiceImpl<DepartmentMasterDao, DepartmentMasterEntity> implements DepartmentMasterService {



}
