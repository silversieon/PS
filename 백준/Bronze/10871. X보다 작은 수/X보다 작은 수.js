let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let inputs = [];
inputs = input[0].split(' ');

let total = Number(inputs[0]);
let limit = Number(inputs[1]);

let numbers = [];
numbers = input[1].split(' ');
let result ='';
for(let i=0; i<total; i++){
    if(numbers[i]<limit){
        result += numbers[i] + ' ';
    }
}
console.log(result);