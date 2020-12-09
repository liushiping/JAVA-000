package cn.lsp.sharding.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MasterAspect {

    @Around("@annotation(master)")
    public Object process(ProceedingJoinPoint joinPoint, Master master) throws Throwable {
        try {
            log.info("==== MasterAspect put master flag into DbContextHolder dbContextStackHolder");
            DbContextHolder.setDbType(DbContextHolder.DbType.master);
            return joinPoint.proceed();
        } finally {
            DbContextHolder.popDbType();
            log.info("==== MasterAspect pop master flag out DbContextHolder dbContextStackHolder");
        }
    }
}
