package com.saas.titan.modules.resource.controller;


import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.resource.service.CommonResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * 上传资源主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:48
 */
@RestController
@RequestMapping("/common-resource")
public class CommonResourceController {

    @Autowired
    private CommonResourceService commonResourceService;

    /**
     * 图片资源上传
     * @param file 文件对象
     * @param uuid resourceId
     * @return 统一返回值
     */
    @PostMapping("/photo/upload/{uuid}")
    public ResultInfo<String> upload(MultipartFile file,
                                     @PathVariable("uuid") String uuid) {
        commonResourceService.commonResourcePhotoUpload(file, uuid);
        return ResultInfo.build();
    }

    /**
     * 删除文件资源
     * @param uuid resourceId
     * @return 统一返回值
     */
    @DeleteMapping("/photo/upload/{uuid}")
    public ResultInfo<String> deletePhoto( @PathVariable("uuid") String uuid) {
        commonResourceService.commonResourcePhotoDelete(uuid);
        return ResultInfo.build();
    }


}
