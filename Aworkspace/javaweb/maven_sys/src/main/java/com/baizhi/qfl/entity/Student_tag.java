package com.baizhi.qfl.entity;

import java.io.Serializable;

public class Student_tag implements Serializable {
    private Integer sid;
    private Integer tid;

    public Student_tag() {
    }

    public Student_tag(Integer sid, Integer tid) {
        this.sid = sid;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Student_tag{" +
                "sid=" + sid +
                ", tid=" + tid +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}
