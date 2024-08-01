
package com.demo;

import java.util.List;

import com.demo.entity.Prospects;
import com.demo.entity.Sites;

public class CustomResponse {

    private List<Sites> sites;
    private List<Prospects> prospects;

    CustomResponse(){}

    List<Sites> getAllSites() {
        return this.sites;
    }

    void setSites(List<Sites> sites) {
        this.sites = sites;
    }

    List<Prospects> getAllProspects() {
        return this.prospects;
    }

    void setProspects(List<Prospects> pro) {
        this.prospects = pro;
    }

}