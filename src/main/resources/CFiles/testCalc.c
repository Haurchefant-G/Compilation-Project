int printf(char *format, ...);
int scanf(char *format, ...);

char str[];
int len = 0;

int data[1000 * 2];
int stackIndex = 0;

int init()
{
    if (stackIndex < 0 || stackIndex >= 2)
    {
        return -1;
    }
    int ans = stackIndex;
    ++stackIndex;
    data[1000 * ans] = 0;
    return ans;
}

int stacktop(int stack)
{
    if (stack < 0 || stack >= 2)
    {
        return -1;
    }
    int num = data[stack * 1000];
    if (num <= 0)
    {
        return 0;
    }
    return data[stack * 1000 + num];
}

int empty(int stack)
{
    if (stack >= 2 || stack < 0)
    {
        return -1;
    }
    if (data[stack * 1000] == 0)
    {
        return 1;
    }
    return 0;
}

void push(int stack, int tar)
{
    if (stack >= 2 || stack < 0)
    {
        return;
    }
    int num = data[stack * 1000];
    if (num >= 999 || num < 0)
    {
        return;
    }
    ++num;
    data[stack * 1000 + num] = tar;
    data[stack * 1000] = num;
}

int pop(int stack)
{
    if (stack >= 2 || stack < 0)
    {
        return -1;
    }
    int num = data[stack * 1000];
    if (num <= 0)
    {
        return 0;
    }
    data[stack * 1000] = num - 1;
    return data[stack * 1000 + num];
}

int priority(int op)
{
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

int main()
{
    int numstack = init();
    int opstack = init();

    scanf("%s", str);
    len = strlen(str);

    int i = 0;
    int a;
    int b;
    int tmp = 0;
    int calc = 0;

    while (i < len || empty(opstack) != 1)
    {
        if (str[i] >= '0' && str[i] <= '9')
        {
            tmp = tmp * 10 + (str[i] - '0');
            ++i;
            if (str[i] >= '0' && str[i] <= '9')
            {
                continue;
            }
            else
            {
                push(numstack, tmp);
                tmp = 0;
            }
        }
        else
        {
            if (empty(opstack) || priority(str[i]) > priority(stacktop(opstack)))
            {
                push(opstack, str[i]);
                ++i;
            }
            else if (stacktop(opstack) == '(' && str[i] != ')')
            {
                push(opstack, str[i]);
                ++i;
            }
            else if (stacktop(opstack) == '(' && str[i] == ')')
            {
                pop(opstack);
                ++i;
            }
            else
            {
                calc = 0;
                if ((empty(opstack) != 1 && str[i] == '\0') || (str[i] == ')' && stacktop(opstack) != '(') || (priority(str[i]) <= priority(stacktop(opstack))))
                {
                    calc = 1;
                }
                if (calc)
                {
                    int op = pop(opstack);
                    b = pop(numstack);
                    a = pop(numstack);
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
                        push(numstack, a * b);
                    }
                    if (op == '/')
                    {
                        push(numstack, a / b);
                    }
                }
            }
        }
    }

    printf("%d\n", pop(numstack));
    return 0;
}