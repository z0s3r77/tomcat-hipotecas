package infraestructuracomun;

public interface ApplicationContext {

    <T> T getBean(Class<T> clazz);
    <T> void addBean(Class<T> clazz, T bean);

}
