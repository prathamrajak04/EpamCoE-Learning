window.onload=function(){
alert("Welcome to XYZ Bank");
page();
}

function page(){

let a=document.getElementById("app");

a.innerHTML=`<div id="main">
<h1 id="head">Welcome Customer</h1>

<div id="steps">
<h3>Follow the below Steps to get Diwali Coupon</h3>

<ol id="list">
<li>Enter Customer ID.</li>
<li>Click Validate Customer.</li>
<li>Generate Coupon.</li>
</ol>

<button id="reg">Click Here To Register</button>
</div>

<label>Enter Customer ID</label>

<input type="text" id="txt">

<button id="val">Validate Customer</button>

<button id="gen">Generate Coupon</button>

</div>`;

head.onmouseover=function(){
alert("Welcome to XYZ Bank");
}

reg.onclick=function(){
list.style.display=list.style.display=="none"?"block":"none";
}

val.onclick=function(){
check();
}

gen.onclick=function(){
coupon();
}

}

function show(msg,color){

document.body.innerHTML=
`<div class="result">

<h2>XYZ BANK</h2>

<h1 style="color:${color}">${msg}</h1>

<button onclick="location.reload()">Back</button>

</div>`;

}
function check(){
let x=txt.value.trim().toLowerCase();

if(x=="")
show("Customer ID cannot be blank","red");

else if(x.includes("xyz"))
show("Valid Customer","green");

else
show("Invalid Customer","red");

}
function coupon(){

let x=txt.value.trim().toLowerCase();

if(x=="")
return show("Customer ID cannot be blank","red");

if(!x.includes("xyz"))
return show("Invalid Customer","red");

let c=[
"SAVE100",
"BANK200",
"XYZ500",
"MEGA700",
"DIWALI999"
];
show("Coupon : "+c[Math.floor(Math.random()*c.length)],"green");
}