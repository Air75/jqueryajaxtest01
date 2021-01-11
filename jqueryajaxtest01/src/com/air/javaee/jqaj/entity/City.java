package com.air.javaee.jqaj.entity;

/**
 * @Author:RenJIE(Air)
 * @Date:2021/1/11 - 7:30 下午
 * @Description:com.air.javaee.jqaj.entity
 * @version: 1.0
 */
public class City {
    private Integer id;
    private String name;
    private Integer provinceid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", provinceid=" + provinceid +
                '}';
    }
}
