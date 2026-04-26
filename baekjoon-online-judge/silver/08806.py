from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    res = 0
    # Input
    for _ in range(int(input())):
        nums1 = [*map(float, input().split())]
        nums2 = [*map(float, input().split())]
        # Solve
        adam_rating = nums1[0]*nums2[1] + nums1[1]*nums2[2] + nums1[2]*nums2[0]
        gosia_rating = nums2[0]*nums1[1] + nums2[1]*nums1[2] + nums2[2]*nums1[0]

        res = '='
        if adam_rating > gosia_rating:
            res = 'ADAM'
        elif adam_rating < gosia_rating:
            res = 'GOSIA'

        # Output
        print(res)
