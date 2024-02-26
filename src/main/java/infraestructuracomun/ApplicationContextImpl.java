package infraestructuracomun;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContextImpl implements ApplicationContext {


    private final Map<Class<?>, Object> beans = new HashMap<>();


    public <T> void addBean(Class<T> clazz, T bean) {

        beans.put(clazz, bean);

    }


    @Override

    public <T> T getBean(Class<T> clazz) {

        return clazz.cast(beans.get(clazz));

    }


}