var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split(' ');
const a = parseInt(input);

for(let i=1; i<10; i++){
    console.log(a, "*", i, "=", a*i)
}
