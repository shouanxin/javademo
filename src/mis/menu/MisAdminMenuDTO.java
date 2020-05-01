package mis.menu;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author:shouanxin
 * @date:2018/7/25 0025  15:31
 */
@Data
public class MisAdminMenuDTO extends MisAdminMenu{

    /** 是否有权限 0：否，1：是*/
    private Integer hasPremission = 0;

    /** 下级菜单 */
    List<MisAdminMenuDTO> nextMenu;

    public static MisAdminMenuDTO adapter(MisAdminMenu menu){
        MisAdminMenuDTO misAdminMenuDTO = new MisAdminMenuDTO();
        BeanUtils.copyProperties(menu,misAdminMenuDTO);
        return misAdminMenuDTO;
    }

}
