webpackJsonp([3],{lO7g:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("el-container",{staticClass:"home-container"},[n("el-header",{staticClass:"home-header"},[n("span",{staticClass:"home_title"},[t._v("佛山+活动报名系统")]),t._v(" "),n("div",{staticStyle:{display:"flex","align-items":"center","margin-right":"7px"}},[n("el-dropdown",{on:{command:t.handleCommand}},[n("span",{staticClass:"el-dropdown-link home_userinfo",staticStyle:{display:"flex","align-items":"center"}},[t._v("\n            "+t._s(t.user.name)+"\n          ")]),t._v(" "),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",[t._v("个人中心")]),t._v(" "),n("el-dropdown-item",[t._v("设置")]),t._v(" "),n("el-dropdown-item",{attrs:{command:"logout",divided:""}},[t._v("注销")]),t._v(" "),n("el-dropdown-item",{attrs:{command:"getCurrentUser",divided:""}},[t._v("获取当前用户")])],1)],1)],1)]),t._v(" "),n("el-container",[n("el-aside",{staticClass:"home-aside",attrs:{width:"180px"}},[n("div",{staticStyle:{display:"flex","justify-content":"flex-start",width:"180px","text-align":"left"}},[n("el-menu",{staticStyle:{background:"#ececec",width:"180px"},attrs:{"unique-opened":"",router:""}},[t._l(this.routes,function(e,r){return[e.hidden?t._e():[n("el-submenu",{key:r,attrs:{index:r+""}},[n("template",{slot:"title"},[n("i",{class:e.iconCls,staticStyle:{color:"#20a0ff",width:"14px"}}),t._v(" "),n("span",{attrs:{slot:"title"},slot:"title"},[t._v(t._s(e.name))])]),t._v(" "),t._l(e.children,function(e){return n("el-menu-item",{key:e.path,staticStyle:{"padding-left":"30px","padding-right":"0px","margin-left":"0px",width:"170px","text-align":"left"},attrs:{width:"180px",index:e.path}},[t._v(t._s(e.name)+"\n                  ")])})],2)]]})],2)],1)]),t._v(" "),n("el-main",[n("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[n("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[t._v("首页")]),t._v(" "),n("el-breadcrumb-item",{domProps:{textContent:t._s(this.$router.currentRoute.name)}})],1),t._v(" "),n("keep-alive",[this.$route.meta.keepAlive?n("router-view"):t._e()],1),t._v(" "),this.$route.meta.keepAlive?t._e():n("router-view")],1)],1)],1)],1)},staticRenderFns:[]};var i=n("VU/8")({computed:{user:function(){return this.$store.state.user},routes:function(){return this.$store.state.routes}},data:function(){return{}},mounted:function(){},methods:{handleCommand:function(t){var e=this;"logout"===t?this.$confirm("注销登录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){e.getRequest("/logout"),e.$store.commit("logout"),e.$router.replace({path:"/"})}).catch(function(){e.$message({type:"info",message:"取消"})}):"getCurrentUser"===t&&e.getRequest("/getCurrentUser").then(function(t){})}}},r,!1,function(t){n("sxq6")},null,null);e.default=i.exports},sxq6:function(t,e){}});
//# sourceMappingURL=3.f73fdd055fd8fd30e402.js.map