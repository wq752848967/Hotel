package team.hotel.dao.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��ҵ��㽻��Spring IOC����ʵ��������ʵ��spring������ʽ�������
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
