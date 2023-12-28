package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	//加载servlet时的监听器，用于初始化

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//加载资源
		System.out.println("servlet被创建了");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//释放资源
	}

}
