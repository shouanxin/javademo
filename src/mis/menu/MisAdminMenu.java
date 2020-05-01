package mis.menu;

import lombok.Data;

import java.util.Set;

/**
 * 系统菜单信息
 * @author:shouanxin
 * @date:2018/7/24 0024  14:28
 */
@Data
public class MisAdminMenu extends SchemaBaseInfo{
    private static final long serialVersionUID = 5720601005245653135L;

    /** 菜单code */
    private String menuCode;

    /** 菜单名称 */
    private String menuName;

    /** 上级菜单id */
    private String parentCode;

    /** 菜单等级 */
    private String level;

    /** 是否为模板配置菜单 1:是，0：不是*/
    private Integer isTemplet = 1;
    
    /** 菜单状态 */
    private Integer status;

    /** 菜单排序 */
    private Integer sort;

    /** 权限动作。增删改查等权限，可扩展数据级权限 */
    private Set<PremissionAction> actions;

    /** 菜单路径 */
    private String path;

    /** schemaId */
    private Long schemaId;
    
    
    @Override
    public String toString() {
        return "MisAdminMenu{" +
                "menuCode='" + menuCode + '\'' +
                ", menuName='" + menuName + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", level='" + level + '\'' +
                ", status=" + status +
                ", sort=" + sort +
                ", actions=" + actions +
                ", path='" + path + '\'' +
                "} " + super.toString();
    }
}
