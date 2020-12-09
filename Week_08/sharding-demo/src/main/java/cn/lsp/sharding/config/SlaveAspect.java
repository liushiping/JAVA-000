package cn.lsp.sharding.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class SlaveAspect {

    @Around("@annotation(slave)")
    public Object process(ProceedingJoinPoint joinPoint, Slave slave) throws Throwable {
        try {
            log.info("==== SlaveAspect put slave flag into DbContextHolder dbContextStackHolder");
            DbContextHolder.setDbType(DbContextHolder.DbType.slave);
            return joinPoint.proceed();
        }  finally {
            DbContextHolder.popDbType();
            log.info("==== SlaveAspect pop slave flag out DbContextHolder dbContextStackHolder");
        }
    }

}
