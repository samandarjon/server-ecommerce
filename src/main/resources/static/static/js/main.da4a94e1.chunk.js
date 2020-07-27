(this["webpackJsonpclient-ecommerce"]=this["webpackJsonpclient-ecommerce"]||[]).push([[0],{17:function(e,a,t){e.exports=t.p+"static/media/ssd.f0488c14.jpg"},40:function(e,a,t){e.exports=t(72)},45:function(e,a,t){},46:function(e,a,t){},71:function(e,a,t){},72:function(e,a,t){"use strict";t.r(a);var n=t(0),r=t.n(n),o=t(19),s=t.n(o),c=(t(45),t(46),function(){return r.a.createElement("footer",{className:"bg-dark text-white mt-5 p-4 text-center"},"Copyright \xa9 ",(new Date).getFullYear()," Ecommerce.uz")}),l=t(8),i=t(1),m=t(21),u=t.n(m),d=t(5),p=t(3),h=t(6),g=t(7),b=t(13),E=t(10),v=t.n(E),f=function(e){e?v.a.defaults.headers.common.Authorization=e:delete v.a.defaults.headers.common.Authorization},N=function(e){return{type:"SET_CURRENT_USER",payload:e}},y=function(){return function(e){localStorage.removeItem("jwtToken"),f(!1),e(N({}))}},w=function(e){Object(g.a)(t,e);var a=Object(h.a)(t);function t(){var e;return Object(d.a)(this,t),(e=a.call(this)).state={categories:[]},v.a.get("/api/categories").then((function(a){console.log(a.data._embedded.categories),e.setState({categories:a.data._embedded.categories})})).catch((function(e){return console.log(e.response)})),e}return Object(p.a)(t,[{key:"onLogoutClick",value:function(e){e.preventDefault(),this.props.logoutUser()}}]),Object(p.a)(t,[{key:"render",value:function(){var e=this.props.auth,a=e.isAuthenticated,t=(e.user,r.a.createElement("ul",{className:"navbar-nav ml-auto"},r.a.createElement("li",{className:"nav-item dropdown"},r.a.createElement("a",{className:"nav-link dropdown-toggle",href:"#",id:"navbarDropdown",role:"button","data-toggle":"dropdown","aria-haspopup":"true","aria-expanded":"false"},"Account"),r.a.createElement("div",{className:"dropdown-menu mr-5","aria-labelledby":"navbarDropdown"},r.a.createElement("a",{className:"dropdown-item",href:"#"},"Dashboard"),r.a.createElement("a",{className:"dropdown-item",href:"#"},"My orders"),r.a.createElement("a",{className:"dropdown-item",href:"#"},"Setting"),r.a.createElement("button",{onClick:this.onLogoutClick.bind(this),className:"nav-link logout"},"Log out"))))),n=r.a.createElement("ul",{className:"navbar-nav ml-auto"},r.a.createElement("li",{className:"nav-item"},r.a.createElement(l.b,{className:"nav-link",to:"/register"},"Sign Up")),r.a.createElement("li",{className:"nav-item"},r.a.createElement(l.b,{className:"nav-link",to:"/login"},"Login")));return r.a.createElement("nav",{className:"navbar navbar-expand-lg navbar-light bg-light"},r.a.createElement("a",{className:"navbar-brand"},"Ecommerce"),r.a.createElement("button",{className:"navbar-toggler",type:"button","data-toggle":"collapse","data-target":"#navbarSupportedContent","aria-controls":"navbarSupportedContent","aria-expanded":"false","aria-label":"Toggle navigation"},r.a.createElement("span",{className:"navbar-toggler-icon"})),r.a.createElement("div",{className:"collapse navbar-collapse",id:"navbarSupportedContent"},r.a.createElement("ul",{className:"navbar-nav mr-auto"},r.a.createElement("li",{className:"nav-item active"},r.a.createElement(l.b,{to:"/",className:"nav-link",href:"#"},"Home ",r.a.createElement("span",{className:"sr-only"},"(current)"))),r.a.createElement("li",{className:"nav-item dropdown"},r.a.createElement("a",{className:"nav-link dropdown-toggle",href:"#",id:"navbarDropdown",role:"button","data-toggle":"dropdown","aria-haspopup":"true","aria-expanded":"false"},"Category"),r.a.createElement("div",{className:"dropdown-menu","aria-labelledby":"navbarDropdown"},this.state.categories.map((function(e){return r.a.createElement(l.b,{className:"dropdown-item",to:"/product/"+e.id},e.name)})))),r.a.createElement("li",{className:"nav-item"},r.a.createElement("a",{className:"nav-link",href:"#"},"Contact"))),a?t:n))}}]),t}(n.Component),S=Object(b.b)((function(e){return{auth:e.auth}}),{logoutUser:y})(w),k=t(12),O=t(14),j=t(11),C=t.n(j),x=t(22),R=t.n(x),D=function(e){var a=e.name,t=e.placeholder,n=e.value,o=e.type,s=(e.label,e.error),c=e.info,l=e.onChange,i=e.disabled;return r.a.createElement("div",{className:"form-group"},r.a.createElement("input",{type:o,className:R()("form-control form-control-lg",{"is-invalid":s}),placeholder:t,name:a,value:n,onChange:l,disabled:i}),c&&r.a.createElement("small",{className:"form-text text-muted"},c),s&&r.a.createElement("div",{className:"invalid-feedback"},s))};D.defaultProps={type:"text"};var _=D,T=function(e){Object(g.a)(t,e);var a=Object(h.a)(t);function t(){var e;return Object(d.a)(this,t),(e=a.call(this)).state={firstName:"",lastName:"",password:"",password2:"",phoneNumber:"",errors:""},e.onChange=e.onChange.bind(Object(O.a)(e)),e.onSubmit=e.onSubmit.bind(Object(O.a)(e)),e}return Object(p.a)(t,[{key:"componentDidMount",value:function(){this.props.auth.isAuthenticated&&this.props.history.push("/dashboard")}},{key:"componentWillReceiveProps",value:function(e){e.errors&&this.setState({errors:e.errors})}},{key:"onChange",value:function(e){this.setState(Object(k.a)({},e.target.name,e.target.value))}},{key:"onSubmit",value:function(e){e.preventDefault();var a={firstName:this.state.firstName,lastName:this.state.lastName,phoneNumber:this.state.phoneNumber,password:this.state.password,password2:this.state.password2};this.props.registerUser(a,this.props.history)}},{key:"render",value:function(){var e=this.state.errors;return r.a.createElement("div",{className:"register"},r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"row"},r.a.createElement("div",{className:"col-md-8 m-auto"},r.a.createElement("h1",{className:"display-4 text-center"},"Sign Up"),r.a.createElement("p",{className:"lead text-center"},"Create your ecommerce account"),e.message&&r.a.createElement("p",{className:"text-danger"},e.message),r.a.createElement("form",{noValidate:!0,onSubmit:this.onSubmit},r.a.createElement(_,{placeholder:"Phone number",name:"phoneNumber",value:this.state.phoneNumber,onChange:this.onChange,error:e.phoneNumber}),r.a.createElement(_,{placeholder:"First name",name:"firstName",value:this.state.firstName,onChange:this.onChange,error:e.firstName}),r.a.createElement(_,{placeholder:"Last name",name:"lastName",value:this.state.lastName,onChange:this.onChange,error:e.lastName}),r.a.createElement(_,{type:"password",placeholder:"Password",name:"password",value:this.state.password,onChange:this.onChange,error:e.password}),r.a.createElement(_,{type:"password",placeholder:"Confirm password",name:"password2",value:this.state.password2,onChange:this.onChange,error:e.password2}),r.a.createElement("input",{type:"submit",className:"btn btn-info btn-block mt-4"}))))))}}]),t}(n.Component);T.protoTypes={registerUser:C.a.func.isRequired,auth:C.a.object.isRequired,errors:C.a.object.isRequired};var L=Object(b.b)((function(e){return{auth:e.auth,errors:e.errors}}),{registerUser:function(e,a){return function(t){v.a.post("/api/auth/register",e).then((function(e){return a.push("/login")})).catch((function(e){return t({type:"GET_ERRORS",payload:e.response.data})}))}}})(Object(i.e)(T)),A=function(e){Object(g.a)(t,e);var a=Object(h.a)(t);function t(){var e;return Object(d.a)(this,t),(e=a.call(this)).state={name:"",username:"",password:"",errors:""},e.onChange=e.onChange.bind(Object(O.a)(e)),e.onSubmit=e.onSubmit.bind(Object(O.a)(e)),e}return Object(p.a)(t,[{key:"componentDidMount",value:function(){this.props.auth.isAuthenticated&&this.props.history.push("/dashboard")}},{key:"componentWillReceiveProps",value:function(e,a){e.auth.isAuthenticated&&this.props.history.push("/dashboard"),e.errors&&this.setState({errors:e.errors})}},{key:"onSubmit",value:function(e){e.preventDefault();var a={username:this.state.username,password:this.state.password};this.props.loginUser(a)}},{key:"onChange",value:function(e){this.setState(Object(k.a)({},e.target.name,e.target.value))}},{key:"render",value:function(){var e=this.state.errors;return r.a.createElement("div",{className:"login"},r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"row"},r.a.createElement("div",{className:"col-md-8 m-auto"},r.a.createElement("h1",{className:"display-4 text-center"},"Log In"),r.a.createElement("p",{className:"lead text-center"},"Sign in to your DevConnector account"),r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement(_,{placeholder:"Username",name:"username",type:"text",value:this.state.username,onChange:this.onChange,error:e.username?e.username:e.message}),r.a.createElement(_,{placeholder:"Password",name:"password",type:"password",value:this.state.password,onChange:this.onChange,error:e.password}),r.a.createElement("input",{type:"submit",className:"btn btn-info btn-block mt-4"}))))))}}]),t}(n.Component),U=Object(b.b)((function(e){return{auth:e.auth,errors:e.errors}}),{loginUser:function(e){return function(a){v.a.post("/api/auth/login",e).then((function(e){var t=e.data.token;localStorage.setItem("jwtToken",t),f(t);var n=u()(t);a(N(n))})).catch((function(e){return a({type:"GET_ERRORS",payload:e.response.data})}))}}})(A),I=(t(71),t(17)),P=t.n(I),G=function(e){var a=e.title,t=e.description,n=(e.img,e.price),o=e.id;e.addBasket,e.bayProduct;return r.a.createElement("div",{key:o,className:"card"},r.a.createElement("img",{className:"card-img-top",src:P.a,alt:"Card image cap"}),r.a.createElement("div",{className:"card-body"},r.a.createElement("h5",{className:"card-title"},a),r.a.createElement("p",{className:"card-text"},t),r.a.createElement("p",{className:"card-text"},r.a.createElement("h4",{className:"text-muted"},"Price: ",n+" $")),r.a.createElement("p",{className:"card-text text-center"},r.a.createElement("button",{className:"btn btn-danger fs"},r.a.createElement("i",{className:"fas fa-shopping-basket"})," Add to basket"),r.a.createElement(l.b,{className:" ml-2 btn btn-info",to:"product/"+o},r.a.createElement("i",{className:"fas fa-eye"})," Preview"))))},q=function(e){Object(g.a)(t,e);var a=Object(h.a)(t);function t(){return Object(d.a)(this,t),a.apply(this,arguments)}return Object(p.a)(t,[{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"row"},r.a.createElement("div",{className:"col-md-12"},r.a.createElement("div",{className:"card-deck mt-2"},r.a.createElement("div",{className:"card-columns"},r.a.createElement(G,{title:"SSD m2 Evo920",description:" Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam, nemo?",price:"100",id:"1"}),r.a.createElement(G,{title:"SSD m2 Evo920",description:" Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam, nemo?",price:"100"}),r.a.createElement(G,{title:"SSD m2 Evo920",description:" Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam, nemo?",price:"100",id:"1"}),r.a.createElement(G,{title:"SSD m2 Evo920",description:" Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam, nemo?",price:"100"}),r.a.createElement(G,{title:"SSD m2 Evo920",description:" Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam, nemo?",price:"100"}),r.a.createElement(G,{title:"SSD m2 Evo920",description:" Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam, nemo?",price:"100"}))))))}}]),t}(n.Component),z=t(15),B=t(39),M=t(18),V=function(e){return void 0===e||null===e||"object"===typeof e&&0===Object.keys(e).length||"string"===typeof e&&0===e.trim().length},W={isAuthenticated:!1,user:{}},X={},F={categories:[]},$=Object(z.c)({auth:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:W,a=arguments.length>1?arguments[1]:void 0;switch(a.type){case"SET_CURRENT_USER":return Object(M.a)({},e,{isAuthenticated:!V(a.payload),user:a.payload});default:return e}},categories:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:F,a=arguments.length>1?arguments[1]:void 0;switch(a.type){case"GET_CATEGORIES":return Object(M.a)({},e,{categories:a.payload});default:return Object(M.a)({},e)}},errors:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:X,a=arguments.length>1?arguments[1]:void 0;switch(a.type){case"GET_ERRORS":return a.payload;case"CLEAR_ERRORS":return{};default:return e}}}),H=[B.a],J=Object(z.e)($,{},Object(z.d)(z.a.apply(void 0,H),window.__REDUX_DEVTOOLS_EXTENSION__&&window.__REDUX_DEVTOOLS_EXTENSION__())),Y=function(e){var a=e.name,t=e.placeholder,n=e.value,o=e.error,s=e.info,c=e.onChange;return console.log(n),r.a.createElement("div",{className:"form-group"},r.a.createElement("textarea",{className:R()("form-control form-control-lg",{"is-invalid":o}),placeholder:t,name:a,value:n,onChange:c}),s&&r.a.createElement("small",{className:"form-text text-muted"},s),o&&r.a.createElement("div",{className:"invalid-feedback"},o))},K=function(e){Object(g.a)(t,e);var a=Object(h.a)(t);function t(){var e;Object(d.a)(this,t);for(var n=arguments.length,r=new Array(n),o=0;o<n;o++)r[o]=arguments[o];return(e=a.call.apply(a,[this].concat(r))).state={amount:0,message:""},e}return Object(p.a)(t,[{key:"onChange",value:function(e){console.log(e.target.value),this.setState(Object(k.a)({},e.target.name,e.target.value))}},{key:"render",value:function(){var e=this;return r.a.createElement("div",null,r.a.createElement("div",{className:"row my-4"},r.a.createElement("div",{className:"col-md col-sm-12"},r.a.createElement("img",{src:P.a,alt:"this is a product images",className:"img-fluid"})),r.a.createElement("div",{className:"col-md col-sm-12"},r.a.createElement("h4",null,r.a.createElement("b",null,"Title: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus ex magnam minima nihild obcaecati quod, ratione. Hic minima nesciunt reprehenderit!")),r.a.createElement("h5",{className:"text-muted"},r.a.createElement("b",null," Price: 100 $ ")),r.a.createElement("p",null,"Desciption: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aut beatae esse explicabo id ipsam libero, officia perspiciatis quibusdam tenetur."),r.a.createElement("ul",{className:"list-group list-group-flush my-3"},r.a.createElement("li",{className:"list-group-item"},"Storge: 64GB"),r.a.createElement("li",{className:"list-group-item"},"Display Size: 12"),r.a.createElement("li",{className:"list-group-item"},"Morbi leo risus"),r.a.createElement("li",{className:"list-group-item"},"Porta ac consectetur ac"),r.a.createElement("li",{className:"list-group-item"},"Vestibulum at eros")),r.a.createElement("div",{className:"input-group mb-3"},r.a.createElement("div",{className:"input-group-prepend"},r.a.createElement("span",{className:"input-group-text",id:"inputGroup-sizing-default"},"Amount")),r.a.createElement("input",{type:"number",name:"amount",className:"form-control",defaultValue:0,onChange:function(a){return e.onChange(a)}})),r.a.createElement(l.b,{className:"btn btn-info btn-block",to:"/order/product_id"},"Buy"),r.a.createElement("button",{className:"btn btn-danger btn-block"},"Add to basket"))),r.a.createElement("div",{className:""},r.a.createElement("div",{className:"col-md-12"},r.a.createElement("h6",null,"Feedback"),r.a.createElement("div",{className:"form-group"},r.a.createElement(Y,{placeholder:"Product to feedback",value:this.state.message,name:"message",onChange:function(a){return e.onChange(a)},error:this.state.message})),r.a.createElement("button",{type:"submit",className:"btn btn-dark"},"Submit")),r.a.createElement("div",{className:"col-md-12"},r.a.createElement("ul",{className:"list-group list-group-flush my-3"},r.a.createElement("li",{className:"list-group-item"},r.a.createElement("div",{className:"feedback-group"},r.a.createElement("img",{src:P.a,width:"80px",className:"img-fluid img"}),r.a.createElement("h6",null,"Samandar Akbarov")),r.a.createElement("p",null,"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est, maiores?"))))))}}]),t}(n.Component),Q=function(e){Object(g.a)(t,e);var a=Object(h.a)(t);function t(){return Object(d.a)(this,t),a.apply(this,arguments)}return Object(p.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,"order")}}]),t}(n.Component);var Z=function(){if(localStorage.jwtToken){f(localStorage.jwtToken);var e=u()(localStorage.jwtToken);J.dispatch(N(e));var a=Date.now()/1e3;e.exp<a&&(J.dispatch(y()),window.location.href="/login")}return r.a.createElement(b.a,{store:J},r.a.createElement(l.a,null,r.a.createElement("div",{className:"App"},r.a.createElement(S,null),r.a.createElement(i.a,{exact:!0,path:"/",component:q}),r.a.createElement("div",{className:"container"},r.a.createElement(i.a,{exact:!0,path:"/register",component:L}),r.a.createElement(i.a,{exact:!0,path:"/login",component:U}),r.a.createElement(i.a,{exact:!0,path:"/product/:id",component:K}),r.a.createElement(i.a,{exact:!0,path:"/order/:id",component:Q})),r.a.createElement(c,null))))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));v.a.defaults.baseURL="http://localhost:8080",s.a.render(r.a.createElement(r.a.StrictMode,null,r.a.createElement(Z,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[40,1,2]]]);
//# sourceMappingURL=main.da4a94e1.chunk.js.map