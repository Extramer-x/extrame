package top.extrame.common.pojo;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Page<T> {
    /**
     * 当前页码
     */
    private Integer offset;
    /**
     * 每页大小
     */
    private Integer size;
    /**
     * 总页数
     */
    private Long total;
    /**
     * 携带数据
     */
    private T data;

    public Page() {}

    public Page(Integer offset, Integer size, Long total, T data) {
        this.offset = offset;
        this.size = size;
        this.total = total;
        this.data = data;
    }
}
