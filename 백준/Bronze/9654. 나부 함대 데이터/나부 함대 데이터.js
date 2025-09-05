var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split(' ');
var a = parseInt(input[0]);
var b = parseInt(input[1]);

console.log(`SHIP NAME      CLASS          DEPLOYMENT IN SERVICE
N2 Bomber      Heavy Fighter  Limited    21        
J-Type 327     Light Combat   Unlimited  1         
NX Cruiser     Medium Fighter Limited    18        
N1 Starfighter Medium Fighter Unlimited  25        
Royal Cruiser  Light Combat   Limited    4         `)