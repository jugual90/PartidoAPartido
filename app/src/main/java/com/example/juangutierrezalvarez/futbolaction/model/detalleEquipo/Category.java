package com.example.juangutierrezalvarez.futbolaction.model.detalleEquipo;

/**
 * Created by Juan Gutierrez on 01/07/2015.
 */
public class Category
{
    private String category_id;
    private String cat_name;
    private String year;
    private String active_year;
    private String alias;
    private String completeName;
    private String completeAlias;
    private String total_group;


    public Category(String category_id, String cat_name, String year, String active_year, String alias, String completeName, String completeAlias, String total_group) {
        this.category_id = category_id;
        this.cat_name = cat_name;
        this.year = year;
        this.active_year = active_year;
        this.alias = alias;
        this.completeName = completeName;
        this.completeAlias = completeAlias;
        this.total_group = total_group;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getActive_year() {
        return active_year;
    }

    public void setActive_year(String active_year) {
        this.active_year = active_year;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getCompleteAlias() {
        return completeAlias;
    }

    public void setCompleteAlias(String completeAlias) {
        this.completeAlias = completeAlias;
    }

    public String getTotal_group() {
        return total_group;
    }

    public void setTotal_group(String total_group) {
        this.total_group = total_group;
    }
}
