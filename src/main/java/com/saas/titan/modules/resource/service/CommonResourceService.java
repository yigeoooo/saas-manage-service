package com.saas.titan.modules.resource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.resource.entity.CommonResourceEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 上传资源主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:48
 */
public interface CommonResourceService extends IService<CommonResourceEntity> {
    /**
     * 统一资源上传
     * @param file 文件对象
     * @param resourceId 资源id
     */
    void commonResourcePhotoUpload(MultipartFile file, String resourceId);

    /**
     * 删除资源图片
     * @param resourceId 资源id
     */
    void commonResourcePhotoDelete(String resourceId);

    /**
     * 返回图片流
     * @param response 返回值
     * @param resourceId 资源ID
     */
    void getPhoto(HttpServletResponse response, String resourceId) throws IOException;

}

