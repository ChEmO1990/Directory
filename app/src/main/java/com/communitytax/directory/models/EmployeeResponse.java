
package com.communitytax.directory.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeResponse implements Parcelable
{

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    public final static Parcelable.Creator<EmployeeResponse> CREATOR = new Creator<EmployeeResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EmployeeResponse createFromParcel(Parcel in) {
            return new EmployeeResponse(in);
        }

        public EmployeeResponse[] newArray(int size) {
            return (new EmployeeResponse[size]);
        }

    }
    ;

    protected EmployeeResponse(Parcel in) {
        in.readList(this.data, (Datum.class.getClassLoader()));
    }

    public EmployeeResponse() {
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "data=" + data +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}
