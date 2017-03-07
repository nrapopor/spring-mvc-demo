package com.nrapoport.spring.mvc.app;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.google.gson.Gson;
import com.nrapoport.mybatis.mappers.DepartmentMapper;

@SpringBootApplication
@ComponentScan({ "com.nrapoport" })
@MapperScan("com.nrapoport.mybatis.mappers")
public class Application {

    private static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        final ApplicationContext ctx = SpringApplication.run(Application.class, args);
        Application app = null;
        try {
            app = ctx.getBean(Application.class);
        } catch (final NoSuchBeanDefinitionException ex) {
            LOG.error("caught {} Error : ", ex.getClass().getSimpleName() //$NON-NLS-1$
                , ex);
        }
        if (app != null) {
            final Gson gson = new Gson();
            final String result = gson.toJson(app.getDepartmentMapper().getAll());
            LOG.info("-----------------------------------------------");
            LOG.info("List All Departments");
            LOG.info("-----------------------------------------------");
            LOG.info(result);
            LOG.info("-----------------------------------------------");
        }

        if (LOG.isTraceEnabled()) {
            LOG.trace("-----------------------------------------------");
            LOG.trace("Let's inspect the beans provided by Spring Boot:");
            LOG.trace("-----------------------------------------------");
            final String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (final String beanName : beanNames) {
                LOG.trace(beanName);
            }
            LOG.trace("-----------------------------------------------");
        }
    }

    private DepartmentMapper departmentMapper;

    /**
     * <DL>
     * <DT>Description:</DT>
     * <DD>DepartmentRestController Constructor</DD>
     * <DT>Date:</DT>
     * <DD>Feb 28, 2017</DD>
     * </DL>
     *
     * @param aDepartmentMapper
     */
    public Application(final DepartmentMapper aDepartmentMapper) {
        super();
        setDepartmentMapper(aDepartmentMapper);
    }

    /**
     * <DL>
     * <DT>Description:</DT>
     * <DD>Getter for the departmentMapper property</DD>
     * <DT>Date:</DT>
     * <DD>Feb 28, 2017</DD>
     * </DL>
     *
     * @return the value of departmentMapper field
     */
    public DepartmentMapper getDepartmentMapper() {
        return departmentMapper;
    }

    /**
     * <DL>
     * <DT>Description:</DT>
     * <DD>Setter for the departmentMapper property</DD>
     * <DT>Date:</DT>
     * <DD>Feb 28, 2017</DD>
     * </DL>
     *
     * @param aDepartmentMapper
     *            new value for the departmentMapper property
     */
    public void setDepartmentMapper(final DepartmentMapper aDepartmentMapper) {
        departmentMapper = aDepartmentMapper;
    }

}
