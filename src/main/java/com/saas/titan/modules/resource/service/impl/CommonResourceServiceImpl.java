package com.saas.titan.modules.resource.service.impl;

import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.exception.BusinessException;
import com.saas.titan.common.utils.ShiroUtils;
import com.saas.titan.modules.resource.service.CommonResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import com.saas.titan.modules.resource.dao.CommonResourceDao;
import com.saas.titan.modules.resource.entity.CommonResourceEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

@Slf4j
@Service("commonResourceService")
public class CommonResourceServiceImpl extends ServiceImpl<CommonResourceDao, CommonResourceEntity> implements CommonResourceService {

    @Autowired
    private CommonResourceDao commonResourceDao;

    @Value("${fileUpload.basePath}")
    private String path;

    @Override
    public void commonResourcePhotoUpload(MultipartFile file, String resourceId) {
        String basePath = path + "photo";
        String fileName = Objects.requireNonNull(file.getOriginalFilename())
                .substring(Constant.ZERO, file.getOriginalFilename().indexOf("."));
        File dir = new File(basePath);
        //判断当前目录是否存在
        if (!dir.exists()) {
            //目录不存在，需要创建
            dir.mkdirs();
        }
        try {
            file.transferTo(new File(basePath + "\\" + resourceId + ".jpeg"));
            log.info("上传成功！路径是{}", basePath + "/" + resourceId + ".jpeg");
            log.info("文件资源ID是{}", resourceId);
            //存储资源信息
            CommonResourceEntity entity = new CommonResourceEntity();
            entity.setResourceId(resourceId);
            entity.setFilePath(basePath + "/");
            entity.setFileName(fileName);
            entity.setFileSuffix(".jpeg");
            entity.setFileSize(String.valueOf(file.getSize()));
            entity.setInsertUserId(ShiroUtils.getLoginId());
            entity.setUpdateUserId(ShiroUtils.getLoginId());
            entity.setInsertTime(LocalDate.now());
            entity.setUpdateTime(LocalDate.now());
            commonResourceDao.insert(entity);
        } catch (IOException e) {
            log.error("上传失败");
            throw new BusinessException("文件上传失败！");
        }
    }

    @Override
    public void commonResourcePhotoDelete(String resourceId) {
        String basePath = path + "photo";
       String photoPath =  basePath + "/" + resourceId + ".jpeg";
        File file = new File(photoPath);
        try {
            if (!file.exists()) {  // 不存在返回 false
                log.error("文件资源不存在！");
                throw new BusinessException("文件资源不存在！");
            } else {
                file.delete();
                log.info("删除成功！");
                commonResourceDao.deleteById(resourceId);
            }
        } catch (Exception e) {
            log.error("删除失败！");
            throw new BusinessException("文件删除失败！");
        }
    }
}
