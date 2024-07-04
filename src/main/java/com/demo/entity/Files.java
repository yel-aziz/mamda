package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long file_id;

    @Column(name = "prospect_id")
    private int prospectId;

    @Column(name = "filename", length = 200)
    private String fileName;

    @Column(name = "fileextension", length = 5)
    private String fileExtension;

    @Lob
    private byte[] fileContent;

    @Column(name = "user_id")
    private int userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCreation")
    private Date dateCreation;

    public long getFileId() {
        return file_id;
    }

    public void setProspectId(int prospectid) {
        this.prospectId = prospectid;
    }

    public int getProspectId() {
        return this.prospectId;
    }

    public void setFileName(String FileName) {
        this.fileName = FileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileExtension(String FileExtension) {
        this.fileExtension = FileExtension;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setDateCreation(Date date) {
        this.dateCreation = date;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }

}
