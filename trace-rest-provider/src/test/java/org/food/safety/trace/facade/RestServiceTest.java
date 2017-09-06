package org.food.safety.trace.facade;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * Created by X on 2017/4/13.
 */
@Slf4j
public class RestServiceTest {
    private SmartHttpClient client = new SmartHttpClient();
    private String name = "UserEntity";
    private String token = "token";

    @Test
    public void page() throws Exception {
        Map<String, Object> param = Maps.newHashMap();
        client.post(name + "/page", token, JSON.toJSONString(param));
    }
    @Test
    public void detail() throws Exception {
        client.get(name + "/ff8080815e22f191015e22f198aa0000", token);
    }
    @Test
    public void method() throws Exception {
        Map<String, Object> param = Maps.newHashMap();
        param.put("name", "bai");
        client.post(name + "/login", token, JSON.toJSONString(param));
    }
}
