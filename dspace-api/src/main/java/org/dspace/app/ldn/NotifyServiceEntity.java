/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.ldn;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.dspace.core.ReloadableEntity;

/**
 * Database object representing notify services
 *
 * @author Mohamed Eskander (mohamed.eskander at 4science.com)
 */
@Entity
@Table(name = "notifyservice")
public class NotifyServiceEntity implements ReloadableEntity<Integer> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notifyservice_id_seq")
    @SequenceGenerator(name = "notifyservice_id_seq", sequenceName = "notifyservice_id_seq",
        allocationSize = 1)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "ldn_url")
    private String ldnUrl;

    @OneToMany(mappedBy = "notifyService")
    private List<NotifyServiceInboundPattern> inboundPatterns;

    @OneToMany(mappedBy = "notifyService")
    private List<NotifyServiceOutboundPattern> outboundPatterns;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return URL of an informative website
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return URL of the LDN InBox
     */
    public String getLdnUrl() {
        return ldnUrl;
    }

    public void setLdnUrl(String ldnUrl) {
        this.ldnUrl = ldnUrl;
    }

    /**
     * @return The list of the inbound patterns configuration supported by the service
     */
    public List<NotifyServiceInboundPattern> getInboundPatterns() {
        return inboundPatterns;
    }

    public void setInboundPatterns(List<NotifyServiceInboundPattern> inboundPatterns) {
        this.inboundPatterns = inboundPatterns;
    }

    public List<NotifyServiceOutboundPattern> getOutboundPatterns() {
        return outboundPatterns;
    }

    public void setOutboundPatterns(List<NotifyServiceOutboundPattern> outboundPatterns) {
        this.outboundPatterns = outboundPatterns;
    }

    @Override
    public Integer getID() {
        return id;
    }
}
