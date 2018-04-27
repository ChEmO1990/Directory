
package com.communitytax.directory.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("network_account")
    @Expose
    private String networkAccount;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("manager")
    @Expose
    private String manager;
    @SerializedName("clone_account")
    @Expose
    private String cloneAccount;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("job_title")
    @Expose
    private String jobTitle;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("did")
    @Expose
    private String did;
    @SerializedName("ext")
    @Expose
    private String ext;
    public final static Parcelable.Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
    ;

    protected Datum(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.networkAccount = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.manager = ((String) in.readValue((String.class.getClassLoader())));
        this.cloneAccount = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.jobTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.did = ((String) in.readValue((String.class.getClassLoader())));
        this.ext = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Datum() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetworkAccount() {
        return networkAccount;
    }

    public void setNetworkAccount(String networkAccount) {
        this.networkAccount = networkAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getCloneAccount() {
        return cloneAccount;
    }

    public void setCloneAccount(String cloneAccount) {
        this.cloneAccount = cloneAccount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", networkAccount='" + networkAccount + '\'' +
                ", email='" + email + '\'' +
                ", manager='" + manager + '\'' +
                ", cloneAccount='" + cloneAccount + '\'' +
                ", location='" + location + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", startDate='" + startDate + '\'' +
                ", status='" + status + '\'' +
                ", did='" + did + '\'' +
                ", ext='" + ext + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(networkAccount);
        dest.writeValue(email);
        dest.writeValue(manager);
        dest.writeValue(cloneAccount);
        dest.writeValue(location);
        dest.writeValue(jobTitle);
        dest.writeValue(startDate);
        dest.writeValue(status);
        dest.writeValue(did);
        dest.writeValue(ext);
    }

    public int describeContents() {
        return  0;
    }

}
