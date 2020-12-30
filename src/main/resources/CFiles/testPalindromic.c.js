function main() {
	let input = [] = "qwertyuiopoiuytrewq";
	let len;
	input=prompt();
	len=input.length;
	let first = 0, last = len - 1;
	let isPalindromic = 1;
	while (first < last)
	{
		if (input[first] == input[last])
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
		alert("Input text is palindromic.\n");
	}
	else
	{
		alert("Input text is not palindromic.\n");
	}
}
main();
