let input = [] = "abcba";
let length_t = 5;
function main() {
let first = 0, last = length_t - 1;
let isPalindromic = 1;
while (first< last)
{
if (input[first] == input[last] )
{
++first;
--last;
}
else
{
isPalindromic=0;
break;
}
}
if (isPalindromic)
{
alert("The given text is palindromic.\n");
}
else
{
alert("The given text is not palindromic.\n");
}
}
main();
