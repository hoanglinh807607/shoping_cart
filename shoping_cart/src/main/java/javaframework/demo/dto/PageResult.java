<<<<<<< HEAD:shoping_cart/src/main/java/javaframework/demo/dto/PageResult.java
package javaframework.demo.dto;
=======
package javaframework.demo.paging;
>>>>>>> nhanh2:shoping_cart/src/main/java/javaframework/demo/dto/paging/PageResult.java

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
