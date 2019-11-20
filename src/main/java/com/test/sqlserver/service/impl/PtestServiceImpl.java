package com.test.sqlserver.service.impl;

import com.test.sqlserver.dao.PtestDAO;
import com.test.sqlserver.service.PtestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PtestServiceImpl implements PtestService {
    @Autowired
    PtestDAO ptestDAO;

    @Override
    public String queryShui() {
        return ptestDAO.queryShui();
    }

    @Override
    public String queryLu() {
        return ptestDAO.queryLu();
    }

    @Override
    public String queryWen() {
        return ptestDAO.queryWen();
    }

    @Override
    public String queryShuiLike(String ymd) {
        return ptestDAO.queryShuiLike(ymd);
    }

    @Override
    public String queryLuLike(String ymd) {
        return ptestDAO.queryLuLike(ymd);
    }

    @Override
    public String queryWenLike(String ymd) {
        return ptestDAO.queryWenLike(ymd);
    }

    @Override
    public String queryShuiKindLike(String kind) {
        return ptestDAO.queryShuiKindLike(kind);
    }

    @Override
    public String queryLuKindLike(String kind) {
        return ptestDAO.queryLuKindLike(kind);
    }

    @Override
    public String queryWenKindLike(String kind) {
        return ptestDAO.queryWenKindLike(kind);
    }

    @Override
    public Set<String> queryLuKindName() {
        return ptestDAO.queryLuKindName();
    }

    @Override
    public Set<String> queryWenKindName() {
        return ptestDAO.queryWenKindName();
    }

    @Override
    public Set<String> queryShuiKindName() {
        return ptestDAO.queryShuiKindName();
    }

}
