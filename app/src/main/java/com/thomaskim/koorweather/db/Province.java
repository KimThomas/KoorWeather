package com.thomaskim.koorweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by ThomasKim on 2017/1/11.
 */

public class Province extends DataSupport {
    private int id;
    private String provinceName;
    private int provinceCode;

    public Province(int id, String provinceName, int provinceCode) {
        this.id = id;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
    }

    public Province(){}

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
