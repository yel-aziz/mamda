package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Sites;
import com.demo.entity.Users;

import com.demo.repository.SitesRepository;
import com.demo.repository.UsersRepository;

@Service
public class SiteService {

    @Autowired
    private SitesRepository SitesRepository;

    @Autowired
    private UsersRepository userrepo;

    public Sites creatSite(String officeName,String Region) {
        Sites obj = new Sites();
        obj.setActif(1);
        obj.setLibelle(officeName);
        obj.setregion(Region);
        SitesRepository.save(obj);

        return obj;

    }

    public void SetUserOffice(int officeid, int userid) {

        Sites obj = this.SitesRepository.findBySiteId(officeid);
        Users user = this.userrepo.findByUserId(userid);
        user.setSites(obj);
        user.setidsite(officeid);
        this.userrepo.save(user);

    }

    public List<Sites> getSites() {
        List<Sites> a = SitesRepository.findAll();
        return a;

    }

    public void updateStatus(int id,int status){
        Sites site = this.SitesRepository.findBySiteId(id);
        site.setActif(status);
        this.SitesRepository.save(site);
    }

    public List<Sites> getAllsitesByRegion(String reg) {
        return this.SitesRepository.findByRegion(reg);
    }

    public Sites getSiteById(int site) {
        return this.SitesRepository.findBySiteId(site);
    }

}
