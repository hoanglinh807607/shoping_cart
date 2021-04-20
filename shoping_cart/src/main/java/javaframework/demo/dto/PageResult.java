package javaframework.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageResult<T>{
    List<T> resultList = new ArrayList<>();
    private int page;
    private int totalPage;
    private int limit;
}
