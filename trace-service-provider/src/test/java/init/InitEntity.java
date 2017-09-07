package init;

import com.alibaba.dubbo.common.json.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.food.safety.trace.TestSmartApplication;
import org.food.safety.trace.repository.MenuDaoTest;
import org.food.safety.trace.service.CURDService;
import org.hibernate.boot.Metadata;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetaAttribute;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.tool.hbm2x.MetaAttributeHelper;
import org.hibernate.tool.hbm2x.POJOExporter;
import org.hibernate.tool.util.MetadataHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tom on 2017/8/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Suite.SuiteClasses({
        MenuDaoTest.class
})
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.food.safety.trace")
@EnableAutoConfiguration
@Slf4j
public class InitEntity {
    public static final String PROJCET_PATH = "/work/001_code/github/java/trace/trace-service-provider/";
    public static final String OUTPUT_DIR = PROJCET_PATH + "src/main/java";
    public static final String TARGET_DIR = PROJCET_PATH + "target/classes";
    public static final String LIST_VIEW_ENTITY_NAME = "ListView";
    public static final String LIST_VIEW_KEY = "use-in-list";
    public static final String VIEW_USE_IN_SEARCH = "use-in-search";
    public static final String LIST_VIEW_FIELD_DESCRIPTION = "field-description";
    public static final String FIELD_ITEM_VALUE= "item-value";
    public static final String FIELD_ITEM_TYPE= "item-type";
    public static final String FIELD_REF_TYPE= "ref-type";

    @Autowired
    CURDService curdService;

    @Test
    @Rollback(false)
    public void init(){
        Configuration configuration = new Configuration().configure();

        POJOExporter exporter = new POJOExporter();
        exporter.setConfiguration(configuration);
        exporter.setOutputDirectory(new File(OUTPUT_DIR));
        exporter.getProperties().setProperty("ejb3", "true");
        exporter.start();

        JavaUtil.compile();

        configuration.buildSessionFactory();

        //init view list
        Metadata metadata = MetadataHelper.getMetadata(configuration);

        for (PersistentClass persistentClass : metadata.getEntityBindings()) {
            Iterator propertyIterator = persistentClass.getPropertyIterator();
            while (propertyIterator.hasNext()) {
                Property property = (Property) propertyIterator.next();
                if (property.getMetaAttributes().containsKey(LIST_VIEW_KEY)) {
                    log.debug("property:{}", property, property.getMetaAttribute(LIST_VIEW_KEY).getValue());
                }
                Map<String, Object> entity = new HashedMap();
                entity.put("entityName", persistentClass.getEntityName());
                entity.put("title", property.getMetaAttribute(LIST_VIEW_FIELD_DESCRIPTION).getValue());
                entity.put("searchable", MetaAttributeHelper.getMetaAsBool(property.getMetaAttribute(VIEW_USE_IN_SEARCH), false));
                entity.put("itemType", MetaAttributeHelper.getMetaAsString(property.getMetaAttribute(FIELD_ITEM_TYPE), "Input"));
                entity.put("itemValue", MetaAttributeHelper.getMetaAsString(property.getMetaAttribute(FIELD_ITEM_VALUE), "{}"));
                entity.put("refType", MetaAttributeHelper.getMetaAsString(property.getMetaAttribute(FIELD_REF_TYPE), ""));
                entity.put("name", property.getName());
                entity.put("fieldType", property.getType().getName());
                entity.put("rules", getRules(property));

                try {
                    log.debug("class:{}", curdService.createOrUpdte(LIST_VIEW_ENTITY_NAME, JSON.json(entity)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getRules(Property property) {
        Map<String, String> rules = new HashMap<String, String>();
        try {
            for (Object metaAttribute:property.getMetaAttributes().entrySet()){
                Map.Entry<String, MetaAttribute> map = (Map.Entry<String, MetaAttribute>) metaAttribute;
                if (map.getKey().startsWith("rules")){
                    rules.put(map.getKey().replaceAll("rules-", ""), MetaAttributeHelper.getMetaAsString(map.getValue()));
                }
            }
            return JSON.json(rules);
        } catch (IOException e) {
            return "{}";
        }
    }
}
