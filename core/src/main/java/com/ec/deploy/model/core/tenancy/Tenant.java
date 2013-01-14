package com.ec.deploy.model.core.tenancy;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "list",
        query = "select tenant from Tenant as tenant"
    )
})
public class Tenant
{


    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Basic
    private String name;
    @Basic
    private String description;


    public Tenant() {

    }
    public Tenant(
        String name,
        String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Tenant) {
            final Tenant t = (Tenant) o;
            return name == null ? t.name == null : name.equals(t.name);
        }
        return false;
    }
}
