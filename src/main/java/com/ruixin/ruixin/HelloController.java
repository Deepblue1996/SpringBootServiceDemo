package com.ruixin.ruixin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用于标注控制层组件(如struts中的action)，@ResponseBody和@Controller的合集
 */
@RestController
public class HelloController {

    //@Value("${minMoney}")
    //private BigDecimal minMoney;

    /**
     * 没有括号内内容的话，默认byName。与@Autowired干类似的事
     */
    @Resource
    private LimitConfig limitConfig;

//    @Autowired
//    public void setLimitConfig(LimitConfig limitConfig) {
//        this.limitConfig = limitConfig;
//    }
    //@Resource
    private LuckmoneyRepository luckmoneyRepository;

    @Autowired
    public HelloController(LuckmoneyRepository luckmoneyRepository) {
        this.luckmoneyRepository = luckmoneyRepository;
    }

    /**
     * http - Get请求
     * @return 打印在网页的内容 类型String
     */
    @GetMapping("/say")
    public String say() {
        return "HelloWorld:"+limitConfig.getDescription();
    }

    @GetMapping("/all")
    public List<Luckmoney> luckmoneyList() {
        return luckmoneyRepository.findAll();
    }
}
