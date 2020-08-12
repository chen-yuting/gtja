<%@page import="javassist.ClassPath"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>后台管理导航</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
 <link rel="stylesheet"
        href="${pageContext.request.contextPath }/layuiAdmin/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet"
        href="${pageContext.request.contextPath }/layuiAdmin/layuiadmin/style/admin.css" media="all">
  
  <script>
  /^http(s*):\/\//.test(location.href) || alert('请先部署到 localhost 下再访问');
  </script>
</head>
<body class="layui-layout-body">
  
  <div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left">
          <li class="layui-nav-item layadmin-flexible" lay-unselect>
            <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
              <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
            </a>
          </li>
          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;" layadmin-event="refresh" title="刷新">
              <i class="layui-icon layui-icon-refresh-3"></i>
            </a>
          </li>
        </ul>
        <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
          
          <li class="layui-nav-item" lay-unselect>
            <a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">
              <i class="layui-icon layui-icon-notice"></i>  
              
              <!-- 如果有新消息，则显示小圆点 -->
              <span class="layui-badge-dot"></span>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="theme">
              <i class="layui-icon layui-icon-theme"></i>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="note">
              <i class="layui-icon layui-icon-note"></i>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="fullscreen">
              <i class="layui-icon layui-icon-screen-full"></i>
            </a>
          </li>
          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;">
              <cite>
                <c:choose>
						<c:when test="${user != null }">${user.accounts }</c:when>
				</c:choose>
              </cite>       
            </a>
            <c:if test="${user != null }">
	            <dl class="layui-nav-child">
	              <dd><a lay-href="set/user/info.html">基本资料</a></dd>
	              <dd><a lay-href="set/user/password.html">修改密码</a></dd>
	              <hr>
	              <dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>
	            </dl>
            </c:if>
          </li>
        </ul>
      </div>
      
      <!-- 侧边菜单 -->
      <div class="layui-side layui-side-menu">
        <div class="layui-side-scroll">
          <div class="layui-logo" lay-href="home/console.html">
            <a href="${pageContext.request.contextPath }/layuiAdmin.std-v1.2.1/src/views/index.jsp">国泰君安后台管理系统</a>
          </div>
          
          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a lay-href="${pageContext.request.contextPath }/layuiAdmin.std-v1.2.1/my/list.jsp" lay-tips="客群数据管理" lay-direction="2">
                <i class="layui-icon layui-icon-home"></i>
                <cite>客群数据管理</cite>
              </a>
              <!--  导航栏嵌套二级菜单
              <dl class="layui-nav-child">
                <dd data-name="console" class="layui-this">
                  <a lay-href="home/console.html">控制台</a>
                </dd>
                <dd data-name="console">
                  <a lay-href="home/homepage1.html">主页一</a>
                </dd>
                <dd data-name="console">
                  <a lay-href="home/homepage2.html">主页二</a>
                </dd>
              </dl>
              -->
            </li>
            <li data-name="component" class="layui-nav-item">
              <a href="javascript:;" lay-tips="*客群数据流水管理" lay-direction="2">
                <i class="layui-icon layui-icon-component"></i>
                <cite>*客群数据流水管理</cite>
              </a>
              <!--  导航栏嵌套三级菜单
              <dl class="layui-nav-child">
                <dd data-name="grid">
                  <a href="javascript:;">栅格</a>
                  <dl class="layui-nav-child">
                    <dd data-name="list"><a lay-href="component/grid/list.html">等比例列表排列</a></dd>
                    <dd data-name="mobile"><a lay-href="component/grid/mobile.html">按移动端排列</a></dd>
                    <dd data-name="mobile-pc"><a lay-href="component/grid/mobile-pc.html">移动桌面端组合</a></dd>
                    <dd data-name="all"><a lay-href="component/grid/all.html">全端复杂组合</a></dd>
                    <dd data-name="stack"><a lay-href="component/grid/stack.html">低于桌面堆叠排列</a></dd>
                    <dd data-name="speed-dial"><a lay-href="component/grid/speed-dial.html">九宫格</a></dd>
                  </dl>
                </dd>
              </dl>
               -->
            </li>
            <li data-name="template" class="layui-nav-item">
              <a href="javascript:;" lay-tips="*客群归属管理" lay-direction="2">
                <i class="layui-icon layui-icon-template"></i>
                <cite>*客群归属管理</cite>
              </a>
            </li>
            <li data-name="app" class="layui-nav-item">
              <a href="javascript:;" lay-tips="*后台数据管理" lay-direction="2">
                <i class="layui-icon layui-icon-app"></i>
                <cite>*后台数据管理</cite>
              </a>
            </li>
            <li data-name="senior" class="layui-nav-item">
              <a href="javascript:;" lay-tips="*报表管理" lay-direction="2">
                <i class="layui-icon layui-icon-senior"></i>
                <cite>*报表管理</cite>
              </a>
            </li>
            <li data-name="user" class="layui-nav-item">
              <a href="javascript:;" lay-tips="*权限管理" lay-direction="2">
                <i class="layui-icon layui-icon-user"></i>
                <cite>*权限管理</cite>
              </a>
            </li>
            <li data-name="set" class="layui-nav-item">
              <a lay-href="${pageContext.request.contextPath }/manage/user/user_list.jsp" lay-tips="系统用户管理" lay-direction="2">
                <i class="layui-icon layui-icon-set"></i>
                <cite>系统用户管理</cite>
              </a>
            </li>
          </ul>
        </div>
      </div>

      <!-- 页面标签 -->
      <div class="layadmin-pagetabs" id="LAY_app_tabs">
        <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-down">
          <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
            <li class="layui-nav-item" lay-unselect>
              <a href="javascript:;"></a>
              <dl class="layui-nav-child layui-anim-fadein">
                <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
              </dl>
            </li>
          </ul>
        </div>
        <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
          <ul class="layui-tab-title" id="LAY_app_tabsheader">
            <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
          </ul>
        </div>
      </div>
      
      
      <!-- 主体内容 -->
      <div class="layui-body" id="LAY_app_body">
        <div class="layadmin-tabsbody-item layui-show">
          <iframe src="${pageContext.request.contextPath }/manage/welcome.jsp" frameborder="0" class="layadmin-iframe"></iframe>
        </div>
      </div>
      
      <!-- 辅助元素，一般用于移动设备下遮罩 -->
      <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
  </div>

    <script src="${pageContext.request.contextPath }/layuiAdmin/layuiadmin/layui/layui.js"></script>
  <script>
  layui.config({
    base: '${pageContext.request.contextPath }/layuiAdmin/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use('index');
  </script>
  
  <!-- 百度统计 -->
  <script>
  var _hmt = _hmt || [];
  (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc";
    var s = document.getElementsByTagName("script")[0]; 
    s.parentNode.insertBefore(hm, s);
  })();
  </script>
</body>
</html>


