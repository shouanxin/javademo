package mis.menu;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 模块通用信息bean
 * @author: bowang
 * @create: 2018-07-20 下午6:04
 **/
@Getter
@Setter
public class SchemaBaseInfo implements Serializable {
    private static final long serialVersionUID = -5551637110476734668L;

    /** id */
    private String id;

    /** 添加时间 */
    private Long addTime;

    /** 更新时间 */
    private Long updateTime;

    /** 操作人 */
    private String operator;

    //TODO 批量查询开发
    /** 0正常状态， 1删除状态， 2需要定时发布， 3定时发布成功 */
    private Integer systemStatus = 0;

    private String collectionName;

    @Override
    public String toString() {
        return "SchemaBaseInfo{" +
                "id='" + id + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", operator='" + operator + '\'' +
                ", systemStatus=" + systemStatus +
                ", collectionName=" + collectionName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SchemaBaseInfo)) {
            return false;
        }

        SchemaBaseInfo that = (SchemaBaseInfo) o;

        return systemStatus.equals(that.systemStatus);
    }

    @Override
    public int hashCode() {
        return systemStatus.hashCode();
    }
}
