import sys


def recursive(depth):
    if depth == 0:
        return '-'
        
    side = recursive(depth - 1)
    return side + ' ' * (3 ** (depth - 1)) + side


if __name__ == '__main__':
    for line in sys.stdin:
        print(recursive(int(line)))
