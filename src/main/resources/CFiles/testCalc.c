int printf(char *format, ...);

int stackData[1000 * 2];
int stackNo = 0;

char str[] = "1+(5-2)*4/(2+1)";
int lengthStr = 15;

int initStack() {
    if (stackNo >= 2) {
        return -1;
    }
    if (stackNo < 0) {
        return -1;
    }
    int ans = stackNo;
    ++stackNo;
    stackData[1000 * ans] = 0;
    return ans;
}

void push(int stack, int tar) {
    if (stack >= 2) {
        return;
    }
    if (stack < 0) {
        return;
    }
    int length = stackData[stack * 1000];
    if (length < 0) {
        return;
    }
    if (length >= 999) {
        return;
    }
    stackData[stack * 1000 + length + 1] = tar;
    stackData[stack * 1000] = length + 1;
}

int pop(int stack) {
    if (stack >= 2) {
        return -1;
    }
    if (stack < 0) {
        return -1;
    }
    int length = stackData[stack * 1000];
    if (length <= 0) {
        return 0;
    }
    stackData[stack * 1000] = length - 1;
    return stackData[stack * 1000 + length];
}

int stackEmpty(int stack) {
    if (stack >= 2) {
        return -1;
    }
    if (stack < 0) {
        return -1;
    }
    int length = stackData[stack * 1000];
    if (length == 0) {
        return 1;
    }
    return 0;
}

int getTop(int stack) {
    if (stack >= 2) {
        return -1;
    }
    if (stack < 0) {
        return -1;
    }
    int length = stackData[stack * 1000];
    if (length <= 0) {
        return 0;
    }
    return stackData[stack * 1000 + length];
}

int Priority(int s) {
    if (s == '(') {
        return 3;
    }
    if (s == '*' || s == '/') {
        return 2;
    }
    if (s == '+' || s == '-') {
        return 1;
    }
    return 0;
}

int main() {
    int numberStack = initStack();
    int operatorStack = initStack();
    int i = 0;
    int tmp = 0;
    int j;

    while (stackEmpty(operatorStack) != 1 || i < lengthStr) {
        if (str[i] >= '0' && str[i] <= '9') {
            tmp = tmp * 10 + str[i];
            tmp -= '0';
            i = i + 1;
            if (str[i] >= '0' && str[i] <= '9') {
                continue;
            } else {
                push(numberStack, tmp);
                tmp = 0;
            }
        } else {
            if (stackEmpty(operatorStack) || Priority(str[i]) > Priority(getTop(operatorStack))) {
                push(operatorStack, str[i]);
                i = i + 1;
                continue;
            }
            if (getTop(operatorStack) == '(' && str[i] != ')') {
                push(operatorStack, str[i]);
                i = i + 1;
                continue;
            }
            if (getTop(operatorStack) == '(' && str[i] == ')') {
                pop(operatorStack);
                i = i + 1;
                continue;
            }
            int ok = 0;
            if (stackEmpty(operatorStack) != 1 && str[i] == '\0') {
                ok = 1;
            }
            if (str[i] == ')' && getTop(operatorStack) != '(') {
                ok = 1;
            }
            if (Priority(str[i]) <= Priority(getTop(operatorStack))) {
                ok = 1;
            }
            if (ok) {
                int currentOperator = pop(operatorStack);
                if (currentOperator == '+') {
                    push(numberStack, pop(numberStack) + pop(numberStack));
                }
                if (currentOperator == '-') {
                    j = pop(numberStack);
                    push(numberStack, pop(numberStack) - j);
                }
                if (currentOperator == '*') {
                    push(numberStack, pop(numberStack) * pop(numberStack));
                }
                if (currentOperator == '/') {
                    j = pop(numberStack);
                    push(numberStack, pop(numberStack) / j);
                }
            }
        }
    }

    printf("%d\n", pop(numberStack));
    return 0;
}