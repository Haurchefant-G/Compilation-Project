let s = [] = "abcdefgabdef";
let t = [] = "ab";
let lengthS = 12;
let lengthT = 2;
let next = [];
function computeNext() {
let indexT = 0;
next[indexT]=0;
for (let indexMoving = 1;
indexMoving < lengthT + 1;
++indexMoving)
{
while (indexMoving < lengthT && indexT < lengthT && t[indexMoving] == t[indexT])
{
++indexT;
++indexMoving;
next[indexMoving]=indexT;
}
if (indexMoving == lengthT)
{
next[indexMoving]=indexT;
break;
}
if (t[indexMoving] == t[indexT])
{
while (indexT == 0 && t[indexMoving] == t[indexT])
{
indexT=next[indexT];
}
next[indexMoving]=indexT;
continue;
}
}
}
function main() {
computeNext();
let indexT = 0;
for (let indexS = 0;
indexS < lengthS;
++indexS)
{
while (indexS < lengthS && indexT < lengthT && s[indexS] == t[indexT])
{
++indexT;
++indexS;
}
if (indexT == lengthT)
{
alert(indexS - lengthT);
indexT=next[indexT];
continue;
}
if (indexS == lengthS)
{
break;
}
while (indexT == 0 && s[indexS] == t[indexT])
{
indexT=next[indexT];
}
}
}
main();
