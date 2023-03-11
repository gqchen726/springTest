package tk.tianyuge.bean.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description
 *
 * @author guoqing.chen01@hand-china.com 2022/09/14 13:38
 */
@Entity
@Table(name = "test")
public class Test {

    @Id//主键
    private Long id;
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
