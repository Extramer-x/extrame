package top.extrame.business.enums;

import lombok.Getter;

@Getter
public enum MailType {

    CAPTCHA(1,"captcha", "验证码");

    private Integer id;
    private String name;
    private String desc;

    MailType(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
