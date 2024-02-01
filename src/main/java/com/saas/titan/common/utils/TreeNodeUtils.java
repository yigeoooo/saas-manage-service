package com.saas.titan.common.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.saas.titan.common.tableField.TableField;

import java.util.List;
import java.util.Map;

/**
 * 树形节点封装工具类
 * @author yigeoooo
 * @since date 2024/1/30
 */
public class TreeNodeUtils {


    /**
     * 获取树形节点
     * @param nodeList 节点list
     * @return List树形节点
     */
    public static List<Tree<String>> getTree(List<TreeNode<String>> nodeList) {
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名 都要默认值的
//        treeNodeConfig.setWeightKey("order");
//        treeNodeConfig.setIdKey("rid");
        // 最大递归深度
        treeNodeConfig.setDeep(3);
        //转换器
        return TreeUtil.build(nodeList, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setWeight(treeNode.getWeight());
                    tree.setName(treeNode.getName());
                    Map<String, Object> map = treeNode.getExtra();
                    // 扩展属性 ...
                    tree.putExtra(TableField.MenuContentMaster.MENU_PATH,
                            map.get(TableField.MenuContentMaster.MENU_PATH));
                    tree.putExtra(TableField.MenuContentMaster.MENU_ICON,
                            map.get(TableField.MenuContentMaster.MENU_ICON));
                });
    }

    //测试树形节点工具
    public static void main(String[] args) {
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
        nodeList.add(new TreeNode<>("1", "0", "系统管理", 5));
        nodeList.add(new TreeNode<>("11", "1", "用户管理", 222222));
        nodeList.add(new TreeNode<>("111", "11", "用户添加", 0));
        nodeList.add(new TreeNode<>("2", "0", "店铺管理", 1));
        nodeList.add(new TreeNode<>("21", "2", "商品管理", 44));
        nodeList.add(new TreeNode<>("221", "21", "食品管理", 2));
        nodeList.add(new TreeNode<>("2211", "221", "饮品管理", 2));
        nodeList.add(new TreeNode<>("2212", "221", "蛋糕管理", 2));
        nodeList.add(new TreeNode<>("2213", "221", "xx管理", 2));
        nodeList.add(new TreeNode<>("22112", "21", "yy管理", 2));
        List<Tree<String>> tree = getTree(nodeList);
        System.out.println(tree.size());
        System.out.println(tree);
    }

}
