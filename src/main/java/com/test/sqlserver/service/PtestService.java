package com.test.sqlserver.service;

import java.util.Set;

public interface PtestService {

    String queryShui();
    String queryLu();
    String queryWen();
    String queryShuiLike(String ymd);
    String queryLuLike(String ymd);
    String queryWenLike(String ymd);
    String queryShuiKindLike(String kind);
    String queryLuKindLike(String kind);
    String queryWenKindLike(String kind);
    Set<String> queryLuKindName();
    Set<String> queryWenKindName();
    Set<String> queryShuiKindName();
}
