package ljy.mvc.controller;
/**
 * @author jing:
 * @version 创建时间：2016-10-20 下午06:23:56
 * 类说明
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Token {
	 boolean saveToken() default false;
	 boolean removeToken() default false;
}

