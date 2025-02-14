LAMBDA = int(input())
res = ""
if 620 <= LAMBDA <= 780 : res = "Red"
elif 590 <= LAMBDA < 620 : res = "Orange"
elif 570 <= LAMBDA < 590 : res = "Yellow"
elif 495 <= LAMBDA < 570 : res = "Green"
elif 450 <= LAMBDA < 495 : res = "Blue"
elif 425 <= LAMBDA < 450 : res = "Indigo"
elif 380 <= LAMBDA < 425 : res = "Violet"
print(res)
