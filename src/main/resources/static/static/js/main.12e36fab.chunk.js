(this.webpackJsonprps=this.webpackJsonprps||[]).push([[0],{32:function(e,t,n){e.exports=n(45)},37:function(e,t,n){},38:function(e,t,n){},45:function(e,t,n){"use strict";n.r(t);var a=n(0),r=n.n(a),c=n(9),o=n.n(c),l=(n(37),n(38),n(26)),i=n.n(l),u=n(28),s=n(13),m=n(5),p=n(18),h=n.n(p),b=n(69),f=n(78),d=n(79),O=function(e){e.name;var t=e.allHistory;return r.a.createElement("div",null,r.a.createElement("h3",null,"History"),r.a.createElement(b.a,{component:"nav","aria-label":"history list"},t.map((function(e){return r.a.createElement(f.a,null,r.a.createElement(d.a,{primary:h()(e.date).format("LLL")+": "+e.winner+" wins best of 3"}))}))))},E=function(e){var t,n=e.Player1Input,c=e.Player2Input,o=Object(a.useState)(""),l=Object(m.a)(o,2),p=l[0],b=l[1],f=Object(a.useState)(""),d=Object(m.a)(f,2),E=d[0],j=d[1],v=Object(a.useState)(n),g=Object(m.a)(v,2),y=g[0],w=g[1],S=Object(a.useState)(c),C=Object(m.a)(S,2),N=C[0],P=C[1],x=Object(a.useState)([]),A=Object(m.a)(x,2),k=A[0],I=A[1],R=Object(a.useState)(),L=Object(m.a)(R,2),U=L[0],H=L[1],T=Object(a.useState)(),B=Object(m.a)(T,2),J=B[0],W=B[1],q=Object(a.useState)(0),D=Object(m.a)(q,2),K=D[0],G=D[1],M=Object(a.useState)(),X=Object(m.a)(M,2),$=(X[0],X[1],Object(a.useState)(0)),z=Object(m.a)($,2),F=z[0],Q=z[1],V=Object(a.useState)(0),Y=Object(m.a)(V,2),Z=Y[0],_=Y[1],ee=Object(a.useState)([]),te=Object(m.a)(ee,2),ne=te[0],ae=te[1],re=Object(a.useState)(!1),ce=Object(m.a)(re,2),oe=ce[0],le=ce[1],ie=Object(a.useState)(!1),ue=Object(m.a)(ie,2),se=ue[0],me=ue[1],pe=Object(a.useState)(""),he=Object(m.a)(pe,2),be=he[0],fe=he[1];function de(){return(de=Object(u.a)(i.a.mark((function e(){var t;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(H(""),W(""),w(""),P(""),!Ee(y,N)){e.next=9;break}return t={method:"POST",headers:{"Access-Control-Allow-Origin":"*","Content-Type":"application/json",Accept:"application/json"},body:JSON.stringify({player1Name:p,player1Choice:y.toUpperCase(),player2Name:E,player2Choice:N.toUpperCase(),roundId:K})},e.next=9,fetch("http://localhost:8080/game/play",t).then((function(e){return e.json()})).then((function(e){Oe(e)}));case 9:case"end":return e.stop()}}),e)})))).apply(this,arguments)}function Oe(e){var t=0,n=0;if(0!==e.winnerNumber)if(function(e){1===e&&Q(F+1);2===e&&_(Z+1)}(e.winnerNumber),1===e.winnerNumber&&(t=F+1,Q(F+1)),2===e.winnerNumber&&(n=Z+1,_(Z+1)),2===t||2===n)!function(e,t){var n=2===e?p:E;I(["Best of three: "+n+" wins"]);var a=h()().format("LLL"),r=1e3*h()(a).unix();console.log("Date object  "+r);var c=a+": "+n+" wins Best of 3";ae([].concat(Object(s.a)(ne),[c])),Q(0),_(0),console.log("history date "+a),function(e,t){var n={method:"POST",headers:{"Access-Control-Allow-Origin":"*","Content-Type":"application/json",Accept:"application/json"},body:JSON.stringify({id:0,playerOne:p,playerTwo:E,winner:t,date:e})};fetch("http://localhost:8080/game/saveHistory",n).then((function(e){return e.text()})).then((function(e){"true"===e?console.log("history was inserted"):console.log("history failed to insert")}))}(r,n),o=n,fetch("http://localhost:8080/game/saveLeaderboard/"+o).then((function(e){return e.json()})).then((function(e){console.log(e)}));var o}(t),G(0);else{le(!1);var a="Round "+(K+1)+": "+e.winnerName+" wins";I(0===K?[a]:[].concat(Object(s.a)(k),[a])),G(K+1)}else{le(!0);a="Draw. Play Again"}}function Ee(e,n){return e.toUpperCase()in t||H("Invalid throw - must be rock, paper, or scissors"),n.toUpperCase()in t||W("Invalid throw - must be rock, paper, or scissors"),""===e&&H("Required"),""===n&&W("Required"),e.toUpperCase()in t&&n.toUpperCase()in t}return function(e){e[e.ROCK=0]="ROCK",e[e.PAPER=1]="PAPER",e[e.SCISSORS=2]="SCISSORS"}(t||(t={})),Object(a.useEffect)((function(){fetch("http://localhost:8080/game/username").then((function(e){return e.text()})).then((function(e){return console.log(e),fe(e),fetch("http://localhost:8080/game/getHistory/"+e)})).then((function(e){return e.json()})).then((function(e){console.log(e),ae([].concat(Object(s.a)(ne),Object(s.a)(e)))})).catch((function(e){return console.log("Request failed",e)}))}),[]),r.a.createElement("div",null,!se&&r.a.createElement("div",null,r.a.createElement("h3",null,"Enter Player 1 and Player 2 Names: "),r.a.createElement("div",null,r.a.createElement("input",{type:"text",value:p,onChange:function(e){return b(e.target.value)}})),r.a.createElement("div",null,r.a.createElement("input",{type:"text",value:E,onChange:function(e){return j(e.target.value)}})),r.a.createElement("button",{onClick:function(){""!==p.trim()&&""!==E.trim()&&me(!0)}}," Add ")),se&&r.a.createElement("div",null,r.a.createElement("h3",null,p),r.a.createElement("input",{type:"text",value:y,onChange:function(e){return w(e.target.value)}}),r.a.createElement("div",null,U),r.a.createElement("h3",null,E),r.a.createElement("input",{type:"text",value:N,onChange:function(e){return P(e.target.value)}}),r.a.createElement("div",null,J),r.a.createElement("br",null),r.a.createElement("button",{onClick:function(){return de.apply(this,arguments)}}," Submit "),r.a.createElement("br",null),r.a.createElement("div",null,oe?r.a.createElement("div",null,"Draw. Play Again"):k.map((function(e){return r.a.createElement("div",null,e)})))),r.a.createElement("br",null),r.a.createElement(O,{name:be,allHistory:ne}))},j=n(73),v=n(77),g=n(76),y=n(74),w=n(75),S=n(71),C=n(72),N=function(){var e=Object(a.useState)([]),t=Object(m.a)(e,2),n=t[0],c=t[1];Object(a.useEffect)((function(){fetch("http://localhost:8080/game/getLeaderboard").then((function(e){return e.json()})).then((function(e){console.log(e),c([].concat(Object(s.a)(n),Object(s.a)(e)))}))}),[]);var o=Object(S.a)({root:{width:"100%"},paper:{width:"100%",overflowX:"auto",margin:"auto"},table:{margin:"auto",maxWidth:200}})();return r.a.createElement("div",{className:o.root},r.a.createElement("h3",null,"Leaderboard"),r.a.createElement(C.a,{className:o.paper},r.a.createElement(j.a,{className:o.table,"aria-label":"simple table"},r.a.createElement(y.a,null,r.a.createElement(w.a,null,r.a.createElement(g.a,null,"Name"),r.a.createElement(g.a,{align:"right"},"Games Won"))),r.a.createElement(v.a,null,n.map((function(e){return r.a.createElement(w.a,{key:e.user},r.a.createElement(g.a,{component:"th",scope:"row"},e.user),r.a.createElement(g.a,{align:"right"},e.games))}))))))};var P=function(){return r.a.createElement("div",{className:"App"},r.a.createElement(E,{Player1Input:"",Player2Input:""}),r.a.createElement("br",null),r.a.createElement(N,null))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));o.a.render(r.a.createElement(r.a.StrictMode,null,r.a.createElement(P,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[32,1,2]]]);
//# sourceMappingURL=main.12e36fab.chunk.js.map