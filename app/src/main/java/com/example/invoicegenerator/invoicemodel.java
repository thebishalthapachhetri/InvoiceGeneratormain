package com.example.invoicegenerator;
public class invoicemodel {

    private int iiid;
    // private String iid;
    private String iname;
    private String iemail;
    private String icompany;
    private String iitemname;
    private String idescription;
    private String iprice;
    private String iqty;
    private String isubtotal;
    private String itaxamount;
    private String itotal;
    private String ipaymentdate;
    private String idiscount;
    private String iamountpaid;
    private String iremark;

    public invoicemodel(int iiid, String iname, String iemail, String icompany, String iitemname, String idescription, String iprice, String iqty, String isubtotal, String itaxamount, String itotal, String ipaymentdate, String idiscount, String iamountpaid, String iremark) {
        this.iiid = iiid;
        this.iname = iname;
        this.iemail = iemail;
        this.icompany = icompany;
        this.iitemname = iitemname;
        this.idescription = idescription;
        this.iprice = iprice;
        this.iqty = iqty;
        this.isubtotal = isubtotal;
        this.itaxamount = itaxamount;
        this.itotal = itotal;
        this.ipaymentdate = ipaymentdate;
        this.idiscount = idiscount;
        this.iamountpaid = iamountpaid;
        this.iremark = iremark;
    }

    public invoicemodel() {
    }
    //tostring is necessary for printing


    @Override
    public String toString() {
        return "invoicemodel{" +
                "iiid=" + iiid +
                ", iname='" + iname + '\'' +
                ", iemail='" + iemail + '\'' +
                ", icompany='" + icompany + '\'' +
                ", iitemname='" + iitemname + '\'' +
                ", idescription='" + idescription + '\'' +
                ", iprice='" + iprice + '\'' +
                ", iqty='" + iqty + '\'' +
                ", isubtotal='" + isubtotal + '\'' +
                ", itaxamount='" + itaxamount + '\'' +
                ", itotal='" + itotal + '\'' +
                ", ipaymentdate='" + ipaymentdate + '\'' +
                ", idiscount='" + idiscount + '\'' +
                ", iamountpaid='" + iamountpaid + '\'' +
                ", iremark='" + iremark + '\'' +
                '}';
    }

    //getters and setters
    public int getIiid() {
        return iiid;
    }

    public void setIiid(int iiid) {
        this.iiid = iiid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIemail() {
        return iemail;
    }

    public void setIemail(String iemail) {
        this.iemail = iemail;
    }

    public String getIcompany() {
        return icompany;
    }

    public void setIcompany(String icompany) {
        this.icompany = icompany;
    }

    public String getIitemname() {
        return iitemname;
    }

    public void setIitemname(String iitemname) {
        this.iitemname = iitemname;
    }

    public String getIdescription() {
        return idescription;
    }

    public void setIdescription(String idescription) {
        this.idescription = idescription;
    }

    public String getIprice() {
        return iprice;
    }

    public void setIprice(String iprice) {
        this.iprice = iprice;
    }

    public String getIqty() {
        return iqty;
    }

    public void setIqty(String iqty) {
        this.iqty = iqty;
    }

    public String getIsubtotal() {
        return isubtotal;
    }

    public void setIsubtotal(String isubtotal) {
        this.isubtotal = isubtotal;
    }

    public String getItaxamount() {
        return itaxamount;
    }

    public void setItaxamount(String itaxamount) {
        this.itaxamount = itaxamount;
    }

    public String getItotal() {
        return itotal;
    }

    public void setItotal(String itotal) {
        this.itotal = itotal;
    }

    public String getIpaymentdate() {
        return ipaymentdate;
    }

    public void setIpaymentdate(String ipaymentdate) {
        this.ipaymentdate = ipaymentdate;
    }

    public String getIdiscount() {
        return idiscount;
    }

    public void setIdiscount(String idiscount) {
        this.idiscount = idiscount;
    }

    public String getIamountpaid() {
        return iamountpaid;
    }

    public void setIamountpaid(String iamountpaid) {
        this.iamountpaid = iamountpaid;
    }

    public String getIremark() {
        return iremark;
    }

    public void setIremark(String iremark) {
        this.iremark = iremark;
    }
}


