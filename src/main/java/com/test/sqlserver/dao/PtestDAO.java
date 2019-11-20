package com.test.sqlserver.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface PtestDAO {

//    大汇总
    String queryShui();
    String queryLu();
    String queryWen();
//    每月的汇总
    String queryShuiLike(String ymd);
    String queryLuLike(String ymd);
    String queryWenLike(String ymd);
//    门票类型汇总
    String queryShuiKindLike(String kind);
    String queryLuKindLike(String kind);
    String queryWenKindLike(String kind);
//   查询表中不同的门票名称
    Set<String> queryLuKindName();
    Set<String> queryWenKindName();
    Set<String> queryShuiKindName();
}
