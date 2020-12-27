int printf(char *format, ...);

char s[] = "abcdefgabdef";
char t[] = "ab";
int lengthS = 12;
int lengthT = 2;

int next[1000];

void computeNext() {
    int indexT = 0;
    next[indexT] = 0;
    for (int indexMoving = 1; indexMoving < lengthT + 1; ++indexMoving) {
        while (indexMoving < lengthT && indexT < lengthT && t[indexMoving] == t[indexT]) {
            ++indexT;
            ++indexMoving;
            next[indexMoving] = indexT;
        }
        if (indexMoving == lengthT) {
            next[indexMoving] = indexT;
            break;
        }
        if (t[indexMoving] != t[indexT]) {
            while (indexT != 0 && t[indexMoving] != t[indexT]) {
                indexT = next[indexT];
            }
            next[indexMoving] = indexT;
            continue;
        }
    }
}

int main() {
    computeNext();
    int indexT = 0;
    for (int indexS = 0; indexS < lengthS; ++indexS) {
        while (indexS < lengthS && indexT < lengthT && s[indexS] == t[indexT]) {
            ++indexT;
            ++indexS;
        }
        if (indexT == lengthT) {
            printf("%d\n", indexS - lengthT);
            indexT = next[indexT];
            continue;
        }
        if (indexS == lengthS) {
            break;
        }
        while (indexT != 0 && s[indexS] != t[indexT]) {
            indexT = next[indexT];
        }
    }
}