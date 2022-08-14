limit = int(input())
recode = int(input())
diff = recode - limit
if diff <= 0 : print("Congratulations, you are within the speed limit!")
else :
    fine = 100
    if diff >= 21 : fine = 270
    if diff >= 31 : fine = 500
    print("You are speeding and your fine is $%d." % (fine))
