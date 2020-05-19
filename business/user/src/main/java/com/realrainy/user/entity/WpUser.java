package com.realrainy.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class WpUser implements Serializable {

    private static final long serialVersionUID = 2707716990635288429L;
    @Id
    private String id;
    private String name;
    private String nickName;

}
