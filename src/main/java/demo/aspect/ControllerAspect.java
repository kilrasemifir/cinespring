package demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile("dev")
public class ControllerAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger("Controllers");
	
	@Before("execution(* demo.controllers.*Controller.*(..))")
	public void logBeforeController(JoinPoint jp) {
		LOGGER.debug("NEW REQUEST"+jp.getSignature());
	}
	
	@After("execution(* demo.controllers.*Controller.*(..))")
	public void logAFterController(JoinPoint jp) {
		LOGGER.debug("After REQUEST"+jp.getSignature());
	}
}
