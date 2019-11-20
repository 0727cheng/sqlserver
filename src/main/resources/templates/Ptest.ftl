<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>测试</title>
    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/echarts.min.js"></script>
</head>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 25%;height: 600px;float: left;"></div>
<div id="main3" style="width: 25%;height: 600px;float: left;"></div>
<div id="main4" style="width: 25%;height: 600px;float: left;"></div>
<div id="main5" style="width:25%;height: 600px;float: left;"></div>

<div id="main1" style="width: 100%;height: 1000px;float: left;"></div>
<div id="main2" style="width: 100%;height: 1000px;float: left;"></div>

</body>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var myChart1 = echarts.init(document.getElementById('main1'));
    var myChart2 = echarts.init(document.getElementById('main2'));
    var myChart3 = echarts.init(document.getElementById('main3'));
    var myChart4 = echarts.init(document.getElementById('main4'));
    var myChart5 = echarts.init(document.getElementById('main5'));


    /*
    * 饼状分析数据
    * */
    //大汇总
    myChart.showLoading();
    $.get('/test/query').done(function (data) {
        myChart.hideLoading();
        myChart.setOption({
            title: {
                text: '门票统计',
                subtext: '获取数据库数据',
                left: 'center',
                top: 10
            },
            tooltip: {
                formatter: '{b} : {c} ({d}%)'
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: ['水乐园门票', '陆地乐园门票', '温泉门票']
            },
            series: [
                {
                    type: 'pie',
                    radius: '55%',
                    selectedMode: 'single',
                    center: ['50%', '50%'],
                    // roseType: 'angle',
                    data: [
                        {value: data[0], name: '水乐园门票'},
                        {value: data[1], name: '陆地乐园门票'},
                        {value: data[2], name: '温泉门票'}
                    ],
                    itemStyle: {
                        // normal: {
                        //     label: {
                        //         show: true,
                        //         formatter: '{b} : {c} ({d}%)'
                        //     },
                        //     labelLine: {
                        //         show: true
                        //     }
                        // },
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },
                    markPoint: {
                        silent: true
                    }
                }
            ]
        });
    }, "json");
    //陆地票类型分析
    myChart5.showLoading();
    $.get('/test/queryLuKind').done(function (data) {
        myChart5.hideLoading();
        var title = [];
        var kind = [];
        $.each(data, function (key, value) {
            title.push(key);
            kind.push(value);
        });
        myChart5.setOption({
            title: {
                text: '陆地乐园门票统计',
                subtext: '获取数据库数据',
                left: 'center',
                top: 10
            },
            tooltip: {
                formatter: '{b} : {c} ({d}%)'
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: title
            },
            series: [
                {
                    type: 'pie',
                    radius: '30%',
                    selectedMode: 'single',
                    center: ['50%', '50%'],
                    // roseType: 'angle',
                    data: [
                        {value: kind[0], name: title[0]},
                        {value: kind[1], name: title[1]},
                        {value: kind[2], name: title[2]},
                        {value: kind[3], name: title[3]},
                        {value: kind[4], name: title[4]},
                        {value: kind[5], name: title[5]},
                        {value: kind[6], name: title[6]},
                        {value: kind[7], name: title[7]},
                        {value: kind[8], name: title[8]},
                        {value: kind[9], name: title[9]},
                        {value: kind[10], name: title[10]},
                        {value: kind[11], name: title[11]},
                        {value: kind[12], name: title[12]},
                        {value: kind[13], name: title[13]},
                        {value: kind[14], name: title[14]},
                        {value: kind[15], name: title[15]},
                        {value: kind[16], name: title[16]},
                        {value: kind[17], name: title[17]},
                        {value: kind[18], name: title[18]},
                        {value: kind[19], name: title[19]},
                        {value: kind[20], name: title[20]}
                    ],
                    itemStyle: {
                        // normal: {
                        //     label: {
                        //         show: true,
                        //         formatter: '{b} : {c} ({d}%)'
                        //     },
                        //     labelLine: {
                        //         show: true
                        //     }
                        // },
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },
                    markPoint: {
                        silent: true
                    }
                }
            ]
        });
    }, "json");
    //水上票类型分析
    myChart3.showLoading();
    $.get('/test/queryShuiKind').done(function (data) {
        myChart3.hideLoading();
        var title = [];
        var kind = [];
        $.each(data, function (key, value) {
            title.push(key);
            kind.push(value);
        });
        myChart3.setOption({
            title: {
                text: '水上乐园门票统计',
                subtext: '获取数据库数据',
                left: 'center',
                top: 10
            },
            tooltip: {
                formatter: '{b} : {c} ({d}%)'
            },
            legend: {
                // left: 'left',
                orient: 'vertical',
                x: 'left',
                data: title
            },
            series: [
                {
                    type: 'pie',
                    radius: '30%',
                    selectedMode: 'single',
                    center: ['50%', '50%'],
                    data: [
                        {value: kind[0], name: title[0]},
                        {value: kind[1], name: title[1]},
                        {value: kind[2], name: title[2]},
                        {value: kind[3], name: title[3]},
                        {value: kind[4], name: title[4]},
                        {value: kind[5], name: title[5]},
                        {value: kind[6], name: title[6]},
                        {value: kind[7], name: title[7]},
                        {value: kind[8], name: title[8]},
                        {value: kind[9], name: title[9]}
                    ],
                    itemStyle: {
                        // normal: {
                        //     label: {
                        //         show: true,
                        //         formatter: '{b} : {c} ({d}%)'
                        //     },
                        //     labelLine: {
                        //         show: true
                        //     }
                        // },
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },
                    markPoint: {
                        silent: true
                    }
                }
            ]
        });
    }, "json");

    //温泉票类型分析
    myChart4.showLoading();
    $.get('/test/queryWenKind').done(function (data) {
        myChart4.hideLoading();
        var title = [];
        var kind = [];
        $.each(data, function (key, value) {
            title.push(key);
            kind.push(value);
        });
        myChart4.setOption({
            title: {
                text: '温泉门票统计',
                subtext: '获取数据库数据',
                left: 'center',
                top: 10
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: title
            },
            tooltip: {
                formatter: '{b} : {c} ({d}%)'
            },
            series: [
                {
                    type: 'pie',
                    radius: '30%',
                    selectedMode: 'single',
                    center: ['50%', '50%'],
                    // roseType: 'angle',
                    data: [
                        {value: kind[0], name: title[0]},
                        {value: kind[1], name: title[1]},
                        {value: kind[2], name: title[2]},
                        {value: kind[3], name: title[3]},
                        {value: kind[4], name: title[4]}
                    ],
                    itemStyle: {
                        // normal: {
                        //     label: {
                        //         show: true,
                        //         formatter: '{b} : {c} ({d}%)'
                        //     },
                        //     labelLine: {
                        //         show: true
                        //     }
                        // },
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },
                    markPoint: {
                        silent: true
                    }
                }
            ]
        });
    }, "json");

    //柱状
    myChart1.showLoading();
    $.get('/test/queryLike').done(function (data) {
        myChart1.hideLoading();
        myChart1.setOption({
            title: {
                text: '2019年门票统计',
                subtext: '获取数据库数据',
                left: 'center',
                top: 30
            },
            tooltip: {},
            legend: {
                left: 'center',
                data: ['水乐园', '陆地乐园', '温泉']//设置数据板块
                // selected: {'水乐园': false}//设置默认显示板块
            },
            dataset: {
                source: [
                    ['product', '水乐园', '陆地乐园', '温泉'],
                    ['一月', data[0][0], data[1][0], data[2][0]],
                    ['二月', data[0][1], data[1][1], data[2][1]],
                    ['三月', data[0][2], data[1][2], data[2][2]],
                    ['四月', data[0][3], data[1][3], data[2][3]],
                    ['五月', data[0][4], data[1][4], data[2][4]],
                    ['六月', data[0][5], data[1][5], data[2][5]],
                    ['七月', data[0][6], data[1][6], data[2][6]],
                    ['八月', data[0][7], data[1][7], data[2][7]],
                    ['九月', data[0][8], data[1][8], data[2][8]],
                    ['十月', data[0][9], data[1][9], data[2][9]],
                    ['十一月', data[0][10], data[1][10], data[2][10]],
                    ['十二月', data[0][11], data[1][11], data[2][11]]
                ]
            },
            xAxis: {type: 'category'},
            yAxis: {},
            series: [
                {type: 'bar'},
                {type: 'bar'},
                {type: 'bar'}
            ]
        })
    }, "json");

    //柱状
    myChart2.showLoading();
    $.get('/test/queryLike').done(function (data) {
        myChart2.hideLoading();
        myChart2.setOption({
            title: {
                text: '2019年乐园门票销量',
                subtext: '获取数据库数据',
                left: 'center',
                top: 30
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            legend: {
                left: 'center',
                data: ['水乐园门票', '陆地乐园门票', '温泉门票']
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: false,
                    data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '水乐园门票',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: data[0]
                },
                {
                    name: '陆地乐园门票',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: data[1]
                },
                {
                    name: '温泉门票',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: data[2]
                }
            ]
        });
    })

</script>
</html>
