webpackJsonp([6],{NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n("7+uW"),a={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var o=n("VU/8")({name:"App"},a,!1,function(e){n("gsu9")},null,null).exports,s=n("/ocq");r.default.use(s.a);var u=new s.a({mode:"history",routes:[{path:"/",name:"Login",component:function(){return n.e(4).then(n.bind(null,"xJsL"))}},{path:"/home",name:"主页",component:function(){return n.e(3).then(n.bind(null,"lO7g"))}}]}),i=n("zL8q"),l=n.n(i),c=(n("tvR6"),n("mvHQ")),p=n.n(c),d=n("NYxO");r.default.use(d.a);var m=new d.a.Store({state:{user:{name:window||window.localStorage||null==window.localStorage.getItem("user")?"未登陆":JSON.parse(window.localStorage.getItem("user")).name,userface:window||window.localStorage||null==window.localStorage.getItem("user")?"":JSON.parse(window.localStorage.getItem("user")).userface,username:window||window.localStorage||null==window.localStorage.getItem("user")?"":JSON.parse(window.localStorage.getItem("user")).username,roles:window||window.localStorage||null==window.localStorage.getItem("user")?"":JSON.parse(window.localStorage.getItem("user")).roles},routes:[]},mutations:{initMenu:function(e,t){e.routes=t},login:function(e,t){e.user=t,window.localStorage.setItem("user",p()(t))},logout:function(e){window.localStorage.removeItem("user")}}}),g=n("mtWM"),f=n.n(g);f.a.interceptors.request.use(function(e){return e},function(){i.Message.error({message:"请求超时！"})}),f.a.interceptors.response.use(function(e){if(!e.status||200!==e.status||0!==e.data.ret)return e.data.msg&&i.Message.success({message:e.data.msg}),e;i.Message.error({message:e.data.msg})},function(e){504===e.response.status||404===e.response.status?i.Message.error({message:"服务器被吃了⊙﹏⊙∥"}):403===e.response.status?i.Message.error({message:"权限不足,请联系管理员!"}):401===e.response.status?i.Message.error({message:e.response.data.msg}):e.response.data.msg?i.Message.error({message:e.response.data.msg}):i.Message.error({message:"未知错误!"})});var w=function(e){return f()({method:"get",url:""+e})},h=function e(t){var r=[];return t.forEach(function(t){var a=t.path,o=t.component,s=t.name,u=t.meta,i=t.iconCls,l=t.children;l&&l instanceof Array&&(l=e(l));var c={path:a,component:function(e){o.startsWith("Home")?n.e(0).then(function(){var t=[n("2eoi")("./"+o+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):o.startsWith("Activity")?n.e(1).then(function(){var t=[n("mZ0O")("./"+o+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):o.startsWith("System")&&n.e(2).then(function(){var t=[n("LJAE")("./"+o+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe)},name:s,iconCls:i,meta:u,children:l};r.push(c)}),r};r.default.use(l.a),r.default.config.productionTip=!1,r.default.prototype.getRequest=w,r.default.prototype.postRequest=function(e,t){return f()({method:"post",url:""+e,data:t,transformRequest:[function(e){var t="";for(var n in e)t+=encodeURIComponent(n)+"="+encodeURIComponent(e[n])+"&";return t}],headers:{"Content-Type":"application/x-www-form-urlencoded"}})},r.default.prototype.postRequest2=function(e,t){return f()({method:"post",url:""+e,data:t,headers:{"Content-Type":"application/json;charset=UTF-8"}})},r.default.prototype.isNotNullORBlank=function(){for(var e=arguments.length,t=Array(e),n=0;n<e;n++)t[n]=arguments[n];for(var r=0;r<t.length;r++){var a=t[r];if(null===a||""===a||void 0===a)return i.Message.warning({message:"数据不能为空!"}),!1}return!0},u.beforeEach(function(e,t,n){var r,a;"Login"!==e.name?"未登录"===m.state.user.name?e.meta.requireAuth||null==e.name?n({path:"/",query:{redirect:e.path}}):n():(r=u,(a=m).state.routes.length>0||w("/getMenuByCurrentUserId").then(function(e){if(e&&200===e.status){var t=h(e.data.data);r.addRoutes(t),a.commit("initMenu",t)}}),n()):n()}),new r.default({el:"#app",router:u,store:m,components:{App:o},template:"<App/>"})},gsu9:function(e,t){},tvR6:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.1a1d07726f88a8a8b7a8.js.map