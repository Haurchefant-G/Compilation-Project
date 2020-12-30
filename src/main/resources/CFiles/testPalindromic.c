
int main() {
    char input[] = "qwertyuiopoiuytrewq";
    int len;
    scanf("%s", input);
    len = strlen(input);
    int first = 0, last = len - 1;
    int isPalindromic = 1;
    while (first < last) {
        if (input[first] == input[last]) {
            ++first;
            --last;
        } else {
            isPalindromic = 0;
            break;
        }
    }

    if (isPalindromic) {
        printf("Input text is palindromic.\n");
    } else {
        printf("Input text is not palindromic.\n");
    }
}