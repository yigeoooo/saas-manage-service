package com.saas.titan.modules.menu.vo;

import lombok.Data;

/**
 * @author yigeoooo
 * @since date 2024/2/3
 */
@Data
public class MenuMasterAddVo {

    /**
     * 主键id
     */
    private String menuId;
    /**
     * 父级菜单id(0则无父级菜单)
     */
    private String parentMenuId;
    /**
     * 菜单路径
     */
    private String menuPath;
    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 菜单图标
     */
    private String menuIcon;

}
