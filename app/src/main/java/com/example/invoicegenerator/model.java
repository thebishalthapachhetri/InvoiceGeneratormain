package com.example.invoicegenerator;



public class model {

    private int cid;
    private String cname;
    private String cemail;
    private String ccompany;
    // constructor


    public model(int cid, String cname, String cemail, String ccompany) {
        this.cid = cid;
        this.cname = cname;
        this.cemail = cemail;
        this.ccompany = ccompany;
    }

    public model() {
    }
    // to string is necessary to print the content


    @Override
    public String toString() {
        return "model{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cemail='" + cemail + '\'' +
                ", ccompany='" + ccompany + '\'' +
                '}';
    }

    // getters and setters
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCcompany() {
        return ccompany;
    }

    public void setCcompany(String ccompany) {
        this.ccompany = ccompany;
    }
}
