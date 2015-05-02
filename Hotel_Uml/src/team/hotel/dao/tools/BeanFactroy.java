package team.hotel.dao.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 把业务层交给Spring IOC容器实例化，以实现spring的声明式事务管理
 * @author yellowbaby
 *
 */
public final class BeanFactroy {

	private static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	public static Object getBeanByName(String name) {
		return context.getBean(name);
	}
}
