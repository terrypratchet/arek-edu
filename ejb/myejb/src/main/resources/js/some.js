console.log("hej hej");


// strict mode

function Apple(){
	this.color = 'green';
}



Apple.prototype.toString = function(){
	return this.color;
}

var apple = new Apple();
console.log(  'apple:' + apple);


var o1 = {};
var o2 = new Object();

var orange = {
		color: 'orange',
		toString : function(){
			return 'color:' + this.color;
		}
}

console.log(orange.toString());


var parent = {
	a:'I am a parent',
	m: function(){
		return this.a;
	}
};

var child = Object.create(parent); //inherits from parent
child.a='I am a child';
console.log("inheritance: " + child.m());


var o = {a: 1};

//The newly created object o has Object.prototype as its [[Prototype]]
//o has no own property named 'hasOwnProperty'
//hasOwnProperty is an own property of Object.prototype. 
//So o inherits hasOwnProperty from Object.prototype
//Object.prototype has null as its prototype.
//o ---> Object.prototype ---> null

var a = ["yo", "whadup", "?"];

//Arrays inherit from Array.prototype 
//(which has methods like indexOf, forEach, etc.)
//The prototype chain looks like:
//a ---> Array.prototype ---> Object.prototype ---> null

function f(){
return 2;
}

//Functions inherit from Function.prototype 
//(which has methods like call, bind, etc.)
//f ---> Function.prototype ---> Object.prototype ---> null

