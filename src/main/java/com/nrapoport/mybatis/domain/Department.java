/**
 * @author nrapopor - Nick Rapoport
 * @copyright Copyright 2017 ( Feb 27, 2017 ) Nick Rapoport all rights reserved.
 */
package com.nrapoport.mybatis.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Department")
public class Department implements Serializable {
    /**
     * <DL><DT>serialVersionUID</DT> <DD>default serialVersionUID 1L</DD></DL>
     */
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    private static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Department.class);

    private String deptNo;
    private String deptName;

    /**
     * <DL><DT>Description:</DT><DD>
     * Department Constructor
     * </DD>
     * <DT>Date:</DT><DD>Feb 27, 2017</DD>
     * </DL>
     * @param aDeptNo
     * @param aDeptName
     */
    public Department(String aDeptNo, String aDeptName) {
        super();
        deptNo = aDeptNo;
        deptName = aDeptName;
    }

    /**
     * <DL><DT>Description:</DT><DD>
     * Department Constructor
     * </DD>
     * <DT>Date:</DT><DD>Feb 27, 2017</DD>
     * </DL>
     */
    public Department() {
        super();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Department { \"deptNo\" : \"" + getDeptNo() + "\", \"deptName\" : \"" + getDeptName() + "\" }";
    }

    /**
     * <DL><DT>Description:</DT><DD>
     * Getter for the deptNo property
     * </DD>
     * <DT>Date:</DT><DD>Feb 27, 2017</DD>
     * </DL>
     * @return the value of deptNo field
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     * <DL><DT>Description:</DT><DD>
     * Setter for the deptNo property
     * </DD>
     * <DT>Date:</DT><DD>Feb 27, 2017</DD>
     * </DL>
     * @param aDeptNo new value for the deptNo property
     */
    public void setDeptNo(String aDeptNo) {
        deptNo = aDeptNo;
    }

    /**
     * <DL><DT>Description:</DT><DD>
     * Getter for the deptName property
     * </DD>
     * <DT>Date:</DT><DD>Feb 27, 2017</DD>
     * </DL>
     * @return the value of deptName field
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * <DL><DT>Description:</DT><DD>
     * Setter for the deptName property
     * </DD>
     * <DT>Date:</DT><DD>Feb 27, 2017</DD>
     * </DL>
     * @param aDeptName new value for the deptName property
     */
    public void setDeptName(String aDeptName) {
        deptName = aDeptName;
    }

}
