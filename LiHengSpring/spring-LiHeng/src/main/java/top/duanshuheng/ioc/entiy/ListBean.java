package top.duanshuheng.ioc.entiy;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class ListBean {
    private List list;
    private Set set;
    private Map map;
    private Properties properties;
    private String[] array;

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public List getList() {
        return list;
    }

    public Set getSet() {
        return set;
    }

    public Map getMap() {
        return map;
    }

    public Properties getProperties() {
        return properties;
    }

    public String[] getArray() {
        return array;
    }
}
