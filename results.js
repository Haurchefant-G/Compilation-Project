let t = [] = "abcba";
let length_t = 5;
function main() {
let first = 0, last = length_t - 1;
let is_palin = 1;
while (first< last)
{
if (t[first] == t[last] )
{
++first;
--last;
}
else
{
is_palin=0;
break;
}
}
if (is_palin)
{
alert("wow, it is palindromic!\n");
}
else
{
alert("oops, it is not palindromic!\n");
}
}
main();
