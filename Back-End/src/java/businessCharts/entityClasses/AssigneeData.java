/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessCharts.entityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ssingh2
 */
@Entity
@Table(name = "assignee_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssigneeData.findAll", query = "SELECT a FROM AssigneeData a"),
    @NamedQuery(name = "AssigneeData.findById", query = "SELECT a FROM AssigneeData a WHERE a.id = :id"),
    @NamedQuery(name = "AssigneeData.findByAssigneeName", query = "SELECT a FROM AssigneeData a WHERE a.assigneeName = :assigneeName"),
    @NamedQuery(name = "AssigneeData.findByOpenBugs", query = "SELECT a FROM AssigneeData a WHERE a.openBugs = :openBugs"),
    @NamedQuery(name = "AssigneeData.findByClonedBugs", query = "SELECT a FROM AssigneeData a WHERE a.clonedBugs = :clonedBugs")})
public class AssigneeData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "assignee_name")
    private String assigneeName;
    @Column(name = "openBugs")
    private Integer openBugs;
    @Column(name = "clonedBugs")
    private Integer clonedBugs;
    @JoinColumn(name = "branchid", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private BranchName branchid;
    @JoinColumn(name = "parent_id", referencedColumnName = "ID")
    @ManyToOne
    private BranchName parentId;

    public AssigneeData() {
    }

    public AssigneeData(Integer id) {
        this.id = id;
    }

    public AssigneeData(Integer id, String assigneeName) {
        this.id = id;
        this.assigneeName = assigneeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public Integer getOpenBugs() {
        return openBugs;
    }

    public void setOpenBugs(Integer openBugs) {
        this.openBugs = openBugs;
    }

    public Integer getClonedBugs() {
        return clonedBugs;
    }

    public void setClonedBugs(Integer clonedBugs) {
        this.clonedBugs = clonedBugs;
    }

    public BranchName getBranchid() {
        return branchid;
    }

    public void setBranchid(BranchName branchid) {
        this.branchid = branchid;
    }

    public BranchName getParentId() {
        return parentId;
    }

    public void setParentId(BranchName parentId) {
        this.parentId = parentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssigneeData)) {
            return false;
        }
        AssigneeData other = (AssigneeData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "businessCharts.entityClasses.AssigneeData[ id=" + id + " ]";
    }
    
}
