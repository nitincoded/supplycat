package com.enterprisecat.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Part {
	@Column(unique = true, nullable = false)
	private String code;

	@Column(nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "class")
	private PartClass partClass;

	@ManyToOne
	@JoinColumn(name = "category")
	private PartCategory partCategory;

	@ManyToOne
	@JoinColumn(name = "inventory_uom", nullable = false)
	private PartUom inventoryUom;

	private boolean trackLot;
	private boolean trackAsset;
	private boolean trackCondition;
	private BigDecimal standardPrice;
	private BigDecimal averagePrice;
	private BigDecimal lastPrice;
	private String priceType;

	@ManyToOne
	@JoinColumn(name = "commodity")
	private PartCommodity partCommodity;

	@ManyToOne
	@JoinColumn(name = "status")
	private PartStatus status;

	private Date lastStatusDate;
	private int warrantyDays;

	@ManyToOne
	@JoinColumn(name = "organization")
	private Organization organization;

	private boolean isInspectionNeeded;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Date createdOn;
	private Date updatedOn;

	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "updated_by")
	private User updatedBy;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PartClass getPartClass() {
		return partClass;
	}

	public void setPartClass(PartClass partClass) {
		this.partClass = partClass;
	}

	public PartCategory getPartCategory() {
		return partCategory;
	}

	public void setPartCategory(PartCategory partCategory) {
		this.partCategory = partCategory;
	}

	public PartUom getInventoryUom() {
		return inventoryUom;
	}

	public void setInventoryUom(PartUom inventoryUom) {
		this.inventoryUom = inventoryUom;
	}

	public boolean isTrackLot() {
		return trackLot;
	}

	public void setTrackLot(boolean trackLot) {
		this.trackLot = trackLot;
	}

	public boolean isTrackAsset() {
		return trackAsset;
	}

	public void setTrackAsset(boolean trackAsset) {
		this.trackAsset = trackAsset;
	}

	public boolean isTrackCondition() {
		return trackCondition;
	}

	public void setTrackCondition(boolean trackCondition) {
		this.trackCondition = trackCondition;
	}

	public BigDecimal getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(BigDecimal standardPrice) {
		this.standardPrice = standardPrice;
	}

	public BigDecimal getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}

	public BigDecimal getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(BigDecimal lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public PartCommodity getPartCommodity() {
		return partCommodity;
	}

	public void setPartCommodity(PartCommodity partCommodity) {
		this.partCommodity = partCommodity;
	}

	public PartStatus getStatus() {
		return status;
	}

	public void setStatus(PartStatus status) {
		this.status = status;
	}

	public Date getLastStatusDate() {
		return lastStatusDate;
	}

	public void setLastStatusDate(Date lastStatusDate) {
		this.lastStatusDate = lastStatusDate;
	}

	public int getWarrantyDays() {
		return warrantyDays;
	}

	public void setWarrantyDays(int warrantyDays) {
		this.warrantyDays = warrantyDays;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public boolean isInspectionNeeded() {
		return isInspectionNeeded;
	}

	public void setInspectionNeeded(boolean inspectionNeeded) {
		isInspectionNeeded = inspectionNeeded;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}
}