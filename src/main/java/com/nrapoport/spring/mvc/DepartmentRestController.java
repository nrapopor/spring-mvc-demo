/**
 * @author nrapopor - Nick Rapoport
 * @copyright Copyright 2017 ( Feb 27, 2017 ) Nick Rapoport all rights reserved.
 */
package com.nrapoport.spring.mvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nrapoport.mybatis.domain.Department;
import com.nrapoport.mybatis.mappers.DepartmentMapper;

/**
 * <DL>
 * <DT>Description:</DT>
 * <DD>TODO add description</DD>
 * <DT>Date:</DT>
 * <DD>Feb 27, 2017</DD>
 * </DL>
 *
 * @author nrapopor - Nick Rapoport
 *
 */
@RestController
public class DepartmentRestController implements InitializingBean, ApplicationContextAware {
    /**
     * <DL>
     * <DT>ALL</DT>
     * <DD>TODO add ALL description</DD>
     * </DL>
     */
    public static final String ALL = "ALL";

    @SuppressWarnings("unused")
    private static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(DepartmentRestController.class);
    //private static final String PLACEHOLDER_FMT="{ \"place-holder\" : { \"id\" : \"%1$s\", \"name\" : \"%2$s\" } }";

    @Autowired
    private DepartmentMapper departmentMapper;

    private ApplicationContext ctx;

    /**
     * <DL>
     * <DT>Description:</DT>
     * <DD>DepartmentRestController Constructor</DD>
     * <DT>Date:</DT>
     * <DD>Feb 28, 2017</DD>
     * </DL>
     */
    public DepartmentRestController() {
        super();
    }

    /** {@inheritDoc} */
    @Override
    public void afterPropertiesSet() throws Exception {
        //setDepartmentMapper(getApplicationContext().getBean(DepartmentMapper.class));
    }

    @RequestMapping(method = { RequestMethod.GET }, path = "/department/{id}/")
    public @ResponseBody List<Department> departmentId(@PathVariable("id") final String id) {
        List<Department> results = Arrays.asList(new Department[] { new Department("d000", "Nothing Found") });
        if (id.equalsIgnoreCase(ALL)) {
            return departments();
        } else if (id.startsWith("d") && id.length() == 4) {
            final Department dept = getDepartmentMapper().findById(id);
            if (dept != null && dept.getDeptNo() != null && dept.getDeptNo().trim().equals(id)) {
                results = Arrays.asList(new Department[] { dept });
            }
        }
        return results;
        //return String.format(PLACEHOLDER_FMT, id,name);
    }

    @RequestMapping(method = { RequestMethod.GET }, path = "/department")
    public @ResponseBody List<Department> departmentName(
        @RequestParam(required = false, value = "name", defaultValue = ALL) final String name) {
        //List<Department> results = Arrays.asList(new Department[] {new Department("d000", "Nothing Found")});
        List<Department> results = null;
        if (name.equalsIgnoreCase(ALL)) {
            return departments();
        } else {
            results = getDepartmentMapper().findByName(name);
            if (results == null || results.isEmpty()) {
                results = Arrays.asList(new Department[] { new Department("d000", "Nothing Found") });
            }
        }
        return results;
        //return String.format(PLACEHOLDER_FMT, id,name);
    }

    @RequestMapping(method = { RequestMethod.GET }, path = "/departments")
    public @ResponseBody List<Department> departments() {
        List<Department> results = Arrays.asList(new Department[] { new Department("d000", "Nothing Found") });
        results = getDepartmentMapper().getAll();
        return results;
    }

    /**
     * <DL>
     * <DT>Description:</DT>
     * <DD>Getter for the ctx property</DD>
     * <DT>Date:</DT>
     * <DD>Feb 28, 2017</DD>
     * </DL>
     * 
     * @return the value of ctx field
     */
    public ApplicationContext getApplicationContext() {
        return ctx;
    }

    /**
     * <DL>
     * <DT>Description:</DT>
     * <DD>Getter for the departmentMapper property</DD>
     * <DT>Date:</DT>
     * <DD>Feb 27, 2017</DD>
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
     * <DD>Setter for the ctx property</DD>
     * <DT>Date:</DT>
     * <DD>Feb 28, 2017</DD>
     * </DL>
     * 
     * @param aCtx
     *            new value for the ctx property
     */
    @Override
    public void setApplicationContext(final ApplicationContext aCtx) {
        ctx = aCtx;
    }

    /**
     * <DL>
     * <DT>Description:</DT>
     * <DD>Setter for the departmentMapper property</DD>
     * <DT>Date:</DT>
     * <DD>Feb 27, 2017</DD>
     * </DL>
     * 
     * @param aDepartmentMapper
     *            new value for the departmentMapper property
     */
    public void setDepartmentMapper(final DepartmentMapper aDepartmentMapper) {
        //departmentMapper = aDepartmentMapper;
    }

}
