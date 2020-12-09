package cn.lsp.sharding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lsp.sharding.config.Master;
import cn.lsp.sharding.dao.TOrderMapper;
import cn.lsp.sharding.entity.TOrder;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/testOrder")
@Slf4j
public class TestOrderController {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Master
    @RequestMapping(value = "/shardingTest" , method = {RequestMethod.GET , RequestMethod.POST})
    public String shardingTest(@RequestParam(name = "id" , required = false) Long id) {
        //Account account = accountMapper.selectByPrimaryKey(id);
        //log.info("account:{}", JSONObject.toJSONString(account));
        TOrder order1 = new TOrder();
        TOrder order2 = new TOrder();
        order1.setAccId(3);
        order1.setOrderId(3);
        order2.setAccId(6);
        order2.setOrderId(9);
        tOrderMapper.insert(order1);
        tOrderMapper.insert(order2);
        return "shardingTest success";
    }

}
