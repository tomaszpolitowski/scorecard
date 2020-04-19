package com.phonak.scorecard.service;

import com.phonak.scorecard.dao.TimeDao;
import com.phonak.scorecard.model.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {
     private final TimeDao timeDao;
@Autowired
    public TimeService(TimeDao timeDao) {
        this.timeDao = timeDao;
    }

    public int  addTime(Time time){
        return timeDao.insertTime(time);
    }
}
