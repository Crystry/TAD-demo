package com.zoo.controller;
/*
展厅方法的控制器
@author 黄浩
 */

import com.zoo.bean.Showroom;
import com.zoo.model.ShowroomDao;

import java.util.List;

public class ShowroomController {
    public void addShowroom(Showroom showroom)  {
        ShowroomDao dao=new ShowroomDao();
        dao.addShowroom(showroom);
    }
    public void updateShowroom(Showroom showroom)  {
        ShowroomDao dao=new ShowroomDao();
        dao.updateShowroom(showroom);
    }
    public void deleteShowroom(String showroomName)  {
        ShowroomDao dao=new ShowroomDao();
        dao.deleteShowroom(showroomName);
    }
    public List<Showroom> query() {
        ShowroomDao dao=new ShowroomDao();
        return dao.query();
    }
    public List<Showroom> query(String showroomKeeper)  {
        ShowroomDao dao=new ShowroomDao();
        return dao.query(showroomKeeper);
    }
}
