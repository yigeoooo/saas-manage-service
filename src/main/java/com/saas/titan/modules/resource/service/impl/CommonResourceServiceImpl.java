package com.saas.titan.modules.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.exception.BusinessException;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.common.utils.ShiroUtils;
import com.saas.titan.modules.resource.service.CommonResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import com.saas.titan.modules.resource.dao.CommonResourceDao;
import com.saas.titan.modules.resource.entity.CommonResourceEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
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

    @Override
    public void getPhoto(HttpServletResponse response, String resourceId) throws IOException {
        //查询读取文件
        QueryWrapper<CommonResourceEntity> query = new QueryWrapper<>();
        query.eq(TableField.CommonResource.IS_DELETED, Constant.STR_ZERO);
        query.eq(TableField.CommonResource.STATUS, Constant.ONE);
        query.eq(TableField.CommonResource.RESOURCE_ID, resourceId);
        CommonResourceEntity entity = commonResourceDao.selectOne(query);
        //拼接文件路径
        String basePath = entity.getFilePath() + resourceId + entity.getFileSuffix();
        InputStream in = getImgInputStream(basePath);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

    /**
     * 获得图片流
     * @param basePath 图影地址
     * @return InputStream 输入流
     * @throws IOException io异常
     */
    private InputStream getImgInputStream(String basePath) throws IOException {
        return Files.newInputStream(new File(basePath).toPath());
    }
}
