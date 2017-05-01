package com.ctinute.foody.dao;

/**
 * Created by ectn on 5/1/2017.
 */
public class ItemWhatDAO {

    /*

    private ArrayList<ItemWhat> getItemList(String query) {
        ArrayList<ItemWhat> list = new ArrayList<>();
        Cursor res =  db.rawQuery(query,null);
        if ((res.moveToFirst()) && res.getCount() > 0){
            while(!res.isAfterLast()){
                ItemWhat item = new ItemWhat();
                // TODO: change this after change item-what database
                item.setId(res.getInt(res.getColumnIndex("ID")));
                item.setImage(res.getString(res.getColumnIndex("IMG")));
                item.setFoodName("<Tên món ăn>");
                item.setLocationName(res.getString(res.getColumnIndex("NAME")));
                item.setAddress(res.getString(res.getColumnIndex("ADDRESS")));
                list.add(item);
                res.moveToNext();
            }
        }
        res.close();
        return list;
    }

    public ArrayList<ItemWhat> findItemsByFields(int cityId, int districtId, int streetId, int categoryId) {
        String query;
        if (categoryId <= 1){
            // no category (all)
            if (streetId > 0) {
                // tim theo duong
                query =  "select * from "+TABLE_NAME+ " where STREETID = "+streetId;
            }
            else if (districtId > 0) {
                // tim theo quan/huyen
                query =  "select * from "+TABLE_NAME+ " where DISTRICTID = "+districtId;
            }
            else if (cityId > 0) {
                query =  "select * from "+TABLE_NAME+ " where CITYID = "+cityId;
            }
            else
                query =  "select * from "+TABLE_NAME;    // lay het
        }
        else {
            // thim theo category
            if (streetId > 0) {
                // tim theo duong
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and STREETID = "+streetId;
            }
            else if (districtId > 0) {
                // tim theo quan/huyen
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and DISTRICTID = "+districtId;
            }
            else if (cityId > 0) {
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and CITYID = "+cityId;
            }
            else
                query =  "select * from "+TABLE_NAME+" where CATEGORYID="+categoryId;    // lay het
        }
        return getItemList(query);
    }
    */
}
