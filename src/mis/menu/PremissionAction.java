package mis.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 权限点
 * @author:shouanxin
 * @date:2018/7/28 0028  16:59
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PremissionAction implements Serializable {

    /** 名称 */
    private String name;

    /** 描述 */
    private String desc;

    /** 是否有权限 0：否，1：是*/
    private Integer hasPremission = 0;
}
