package kr.insoft.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.scheduling.annotation.EnableScheduling;

import kr.insoft.batch.annotation.SingleTask;
import kr.insoft.batch.util.SingleTaskManageMap;

@SpringBootApplication
@EnableScheduling
public class BatchSampleApplication {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(BatchSampleApplication.class, args);
		new BatchSampleApplication().findAnnotatedClasses();
	}
	
	
	/**
	 * 현 Application 클래스 하위 패키지에서
	 * SingleTask Annotation 이 선언된 클래스 필터링 
	 */
	public void findAnnotatedClasses() {
		String scanPackage = this.getClass().getPackageName();
		SingleTaskManageMap manageMap = SingleTaskManageMap.getInstance();
        ClassPathScanningCandidateComponentProvider provider = createComponentScanner();
        for (BeanDefinition beanDef : provider.findCandidateComponents(scanPackage)) {
            printMetadata(beanDef, manageMap);
        }
    }
 
    private ClassPathScanningCandidateComponentProvider createComponentScanner() {
        ClassPathScanningCandidateComponentProvider provider
                = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(SingleTask.class));
        return provider;
    }
 
    private void printMetadata(BeanDefinition beanDef, SingleTaskManageMap manageMap) {
    	
        try {
            Class<?> cl = Class.forName(beanDef.getBeanClassName());
            SingleTask findable = cl.getAnnotation(SingleTask.class);
//            System.out.printf("Found class: %s, with meta name: %n", cl.getSimpleName());
            if(findable != null) {
//            	manageMap.put(cl.getSimpleName(), false);
            	manageMap.put(cl.getName(), false);
            }
        } catch (Exception e) {
        	logger.error("// ERROR WHILE EXTRACTION ANNOTATION CLASS : " + e.getMessage());
        }
    }
}
