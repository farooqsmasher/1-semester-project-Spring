package com.studinfosys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "downloads")
public class Download {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_name")
	private TblUser tblUser;
	
	@ManyToOne
	@JoinColumn(name = "file_id")
	private UploadFile file;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "download_date")
	private Date downloadDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TblUser getTblUser() {
		return tblUser;
	}

	public void setTblUser(TblUser tblUser) {
		this.tblUser = tblUser;
	}

	public UploadFile getFile() {
		return file;
	}

	public void setFile(UploadFile file) {
		this.file = file;
	}

	public Date getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}

	
	
	
	
	
}
