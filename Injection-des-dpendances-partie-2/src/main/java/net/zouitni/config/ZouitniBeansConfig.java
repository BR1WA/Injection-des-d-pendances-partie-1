package net.zouitni.config;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

public class ZouitniBeansConfig {
    private Map<String, String> beans;

    @XmlElement
    public Map<String, String> getBeans() {
        return beans;
    }

    public void setBeans(Map<String, String> beans) {
        this.beans = beans;
    }
}
