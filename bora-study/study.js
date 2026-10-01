const numbers = [1, 2, 3, 4, 5];

const result = numbers.filter((n) => n % 2 === 0).map((n) => n * 2);

//console.log(result);

const numbers2 = [];

for (let i = 0; i < numbers.length; i++) {
    const n = numbers[i];

    if (n % 2 === 0) {
        numbers2.push(n * 2);
    }
}

//console.log(numbers2);

const numbers3 = [1, 2, 3];

numbers3.push(4);

numbers3.unshift(0);

numbers3.pop();

numbers3.shift();

numbers3.splice(1, 0, 10); // 확인하기

//console.log(numbers3);

const numbers4 = new Set();

numbers4.add(5);
numbers4.add(2);
numbers4.add(2);

console.log(numbers4.has(5));
//console.log(numbers4);

const map = new Map();

map.set("name", "bora");
map.set("age", 30);

//console.log(map);

const numbers5 = [1, 2, 2, 3, 3, 3];

const unique = [...new Set(numbers5)];

//console.log(unique);
