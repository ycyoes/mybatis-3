package self;

import org.apache.ibatis.domain.misc.CustomBeanWrapperFactory;
import org.apache.ibatis.domain.misc.RichType;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.Test;

import java.util.HashMap;

public class ReflectorTest {

  @Test
  public void testGetterType() {
    RichType object = new RichType();
    if (true) {
      object.setRichType(new RichType());
      object.getRichType().setRichMap(new HashMap());
      object.getRichType().getRichMap().put("nihao", "123");
    }

    MetaObject meta = MetaObject.forObject(object, SystemMetaObject.DEFAULT_OBJECT_FACTORY, new CustomBeanWrapperFactory(), new DefaultReflectorFactory());
    Class<?> clazz = meta.getObjectWrapper().getGetterType("richType.richMap.nihao");
    System.out.println(clazz);
  }
}
