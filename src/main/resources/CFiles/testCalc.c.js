let str = [];
let len = 0;
let data = [];
let stackIndex = 0;
function init() {
	if (stackIndex < 0 || stackIndex >= 2)
	{
		return -1;
	}
	let ans = stackIndex;
	++stackIndex;
	data[1000*ans]=0;
	return ans;
}
function stacktop(stack) {
	if (stack < 0 || stack >= 2)
	{
		return -1;
	}
	let num = data[stack*1000];
	if (num <= 0)
	{
		return 0;
	}
	return data[stack*1000 + num];
}
function empty(stack) {
	if (stack >= 2 || stack < 0)
	{
		return -1;
	}
	if (data[stack*1000] == 0)
	{
		return 1;
	}
	return 0;
}
function push(stack, tar) {
	if (stack >= 2 || stack < 0)
	{
		return ;
	}
	let num = data[stack*1000];
	if (num >= 999 || num < 0)
	{
		return ;
	}
	++num;
	data[stack*1000 + num]=tar;
	data[stack*1000]=num;
}
function pop(stack) {
	if (stack >= 2 || stack < 0)
	{
		return -1;
	}
	let num = data[stack*1000];
	if (num <= 0)
	{
		return 0;
	}
	data[stack*1000]=num - 1;
	return data[stack*1000 + num];
}
function priority(op) {
	if (op == '(')
	{
		return 3;
	}
	if (op == '*' || op == '/')
	{
		return 2;
	}
	if (op == '+' || op == '-')
	{
		return 1;
	}
	return 0;
}
function main() {
	let numstack = init();
	let opstack = init();
	str=prompt();
	len=str.length;
	let i = 0;
	let a;
	let b;
	let tmp = 0;
	while (i < len || empty(opstack) != 1)
	{
		if (str[i] >= '0' && str[i] <= '9')
		{
			tmp=tmp*10 + (str[i] - '0');
			++i;
			if (str[i] >= '0' && str[i] <= '9')
			{
				continue;
			}
			else
			{
				push(numstack, tmp);
				tmp=0;
			}
		}
		else
		{
			if (empty(opstack) || priority(str[i]) > priority(stacktop(opstack)))
			{
				push(opstack, str[i]);
				++i;
				continue;
			}
			if (stacktop(opstack) == '(' && str[i] != ')')
			{
				push(opstack, str[i]);
				++i;
				continue;
			}
			if (stacktop(opstack) == '(' && str[i] == ')')
			{
				pop(opstack);
				++i;
			}
			else
			{
				if ((empty(opstack) != 1 && str[i] == '\0') || (str[i] == ')' && stacktop(opstack) != '(') || (priority(str[i]) <= priority(stacktop(opstack))))
				{
					let op = pop(opstack);
					b=pop(numstack);
					a=pop(numstack);
					if (op == '+')
					{
						push(numstack, a + b);
					}
					if (op == '-')
					{
						push(numstack, a - b);
					}
					if (op == '*')
					{
						push(numstack, a*b);
					}
					if (op == '/')
					{
						push(numstack, a/b);
					}
				}
			}
		}
	}
	alert(pop(numstack));
	return 0;
}
main();
