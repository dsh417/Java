package top.duanshuheng.ioc.service.impl;

import top.duanshuheng.ioc.annotation.GPService;
import top.duanshuheng.ioc.service.IDemoService;

@GPService
public class DemoService implements IDemoService {
    @Override
    public String get(String name) {
        return "My name is"+name;
    }
}
