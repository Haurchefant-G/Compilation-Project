let stackData = [];
let stackNo = 0;
let str = [] = "1+(5-2)*4/(2+1)";
let lengthStr = 15;
function initStack() {
if (stackNo >= 2)
{
return -1;
}
if (stackNo < 0)
{
return -1;
}
let ans = stackNo;
++stackNo;
stackData[1000*ans]=0;
return ans;
}
function push(stack, tar) {
if (stack >= 2)
{
return ;
}
if (stack < 0)
{
return ;
}
let length = stackData[stack*1000];
if (length < 0)
{
return ;
}
if (length >= 999)
{
return ;
}
stackData[stack*1000 + length + 1]=tar;
stackData[stack*1000]=length + 1;
}
function pop(stack) {
if (stack >= 2)
{
return -1;
}
if (stack < 0)
{
return -1;
}
let length = stackData[stack*1000];
if (length <= 0)
{
return 0;
}
stackData[stack*1000]=length - 1;
return stackData[stack*1000 + length];
}
function stackEmpty(stack) {
if (stack >= 2)
{
return -1;
}
if (stack < 0)
{
return -1;
}
let length = stackData[stack*1000];
if (length == 0)
{
return 1;
}
return 0;
}
function getTop(stack) {
if (stack >= 2)
{
return -1;
}
if (stack < 0)
{
return -1;
}
let length = stackData[stack*1000];
if (length <= 0)
{
return 0;
}
return stackData[stack*1000 + length];
}
function Priority(s) {
if (s == '(')
{
return 3;
}
if (s == '*' || s == '/')
{
return 2;
}
if (s == '+' || s == '-')
{
return 1;
}
return 0;
}
function main() {
let numberStack = initStack();
let operatorStack = initStack();
let i = 0;
let tmp = 0;
let j;
while (stackEmpty(operatorStack) != 1 || i < lengthStr)
{
if (str[i] >= '0' && str[i] <= '9')
{
tmp=tmp*10 + str[i];
tmp-='0';
i=i + 1;
if (str[i] >= '0' && str[i] <= '9')
{
continue;
}
else
{
push(numberStack, tmp);
tmp=0;
}
}
else
{
if (stackEmpty(operatorStack) || Priority(str[i]) > Priority(getTop(operatorStack)))
{
push(operatorStack, str[i]);
i=i + 1;
continue;
}
if (getTop(operatorStack) == '(' && str[i] != ')')
{
push(operatorStack, str[i]);
i=i + 1;
continue;
}
if (getTop(operatorStack) == '(' && str[i] == ')')
{
pop(operatorStack);
i=i + 1;
continue;
}
let ok = 0;
if (stackEmpty(operatorStack) != 1 && str[i] == '\0')
{
ok=1;
}
if (str[i] == ')' && getTop(operatorStack) != '(')
{
ok=1;
}
if (Priority(str[i]) <= Priority(getTop(operatorStack)))
{
ok=1;
}
if (ok)
{
let currentOperator = pop(operatorStack);
if (currentOperator == '+')
{
push(numberStack, pop(numberStack) + pop(numberStack));
}
if (currentOperator == '-')
{
j=pop(numberStack);
push(numberStack, pop(numberStack) - j);
}
if (currentOperator == '*')
{
push(numberStack, pop(numberStack)*pop(numberStack));
}
if (currentOperator == '/')
{
j=pop(numberStack);
push(numberStack, pop(numberStack)/j);
}
}
}
}
alert(pop(numberStack));
return 0;
}
main();
