ds, ys = map(int, input().split())
dm, ym = map(int, input().split())
sun_eclipse_year = ys - ds
moon_eclipse_year = ym - dm

while sun_eclipse_year != moon_eclipse_year :
    if sun_eclipse_year < moon_eclipse_year :
        sun_eclipse_year += ys
    else : moon_eclipse_year += ym
print(sun_eclipse_year)
