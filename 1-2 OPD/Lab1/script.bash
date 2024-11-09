#!/bin/bash
# Creating lab0
mkdir lab0
cd lab0

# Task 1
echo "====Started 1===="
mkdir -p riolu5/abra riolu5/golduck venomoth2/metagross venomoth2/simisage wormadam4/drowzee wormadam4/drifblim wormadam4/pichu
echo "Ходы  Covet Dive Icy Wind Mud-Slap Signal Beam Sleep Talk
Snore Stealth Rock Water Pledge Water Pulse" > piplup4
echo "Способности
Overcharge Static Motor Drive" > raichu6
echo "Тип покемона  ROCK
WATER" > riolu5/kabutops
echo "Развитые способности  Rain Dish" > tentacool8
echo "weigth=17.9
height=24.0 atk=5 def=6" > venomoth2/snivy
echo "Развитые способности  Iron
Fist" > venomoth2/timburr
echo "satk=4 sdef=5 spd=4" > wormadam4/cubone
ls -lR
echo "====Finished 1===="

# Task 2
echo "====Started 2===="
chmod ug=r piplup4
chmod a=r raichu6
chmod u=wx,go=x riolu5
chmod u=rx,g=x,o=w riolu5/abra
chmod 046 riolu5/kabutops
chmod 570 riolu5/golduck
chmod ug=r tentacool8
chmod 307 venomoth2
chmod ug=r venomoth2/snivy
chmod u=wx,g=x,o=w venomoth2/metagross
chmod u=rwx,g=rw,o=r venomoth2/simisage
chmod 046 venomoth2/timburr
chmod u=rx,g=x,o=w wormadam4
chmod ug=wx,o=rx wormadam4/drowzee
chmod 664 wormadam4/cubone
chmod u=rx,g=x,o=w wormadam4/drifblim
chmod uo=wx,g=rw wormadam4/pichu
ls -lR
echo "====Finished 2===="

# Task 3
echo "====Started 3===="
# 3.1
cp raichu6 venomoth2/metagross
# 3.2
cp piplup4 venomoth2/snivypiplup
# 3.3
chmod -R u+r riolu5
cp -r riolu5 venomoth2/metagross
chmod u=wx,go=x riolu5
chmod u=rx,g=x,o=w riolu5/abra
chmod 046 riolu5/kabutops
chmod 570 riolu5/golduck
# 3.4
ln raichu6 venomoth2/snivyraichu
# 3.5
chmod u+r riolu5/kabutops
cat venomoth2/snivy riolu5/kabutops > raichu6_98
chmod 046 riolu5/kabutops
# 3.6
ln -s venomoth2 Copy_84
# 3.7
ln -s ../piplup4 riolu5/kabutopspiplup
ls -lR
echo "====Finished 3===="

# Task 4
echo "====Started 4===="
# 4.1
echo "====4.1===="
wc -m $(ls -dp ./**/d*) 2>>/tmp/err | sort -nr
# 4.2
echo "====4.2===="
ls -lit riolu5 2>>/tmp/err
# 4.3
echo "====4.3===="
cat $(ls -dp ./**/d*) | sort
# 4.4
echo "====4.4===="
ls -liR riolu5 2>/dev/null | sort -nk3
# 4.5
echo "====4.5===="
ls -lit ./**/*e  2>>/tmp/err | tail -4
# 4.6
echo "====4.6===="
cat $(ls -dp *4) 2>&1 | sort
echo "====Finished 4===="

# Task 5
echo "====Started 5===="
# 5.1
rm -f tentacool8
# 5.2
rm -f venomoth2/timburr
# 5.3
rm -f riolu5/kabutopspipl*
# 5.4
rm -f venomoth2/snivyraic*
# 5.5
chmod -R 700 riolu5
rm -rf riolu5
# 5.6
chmod 700 venomoth2
chmod -R 700 venomoth2/metagross
rm -rf venomoth2/metagross
chmod 307 venomoth2
ls -lR
echo "====Finished 5===="

# Deleting lab0
cd ..
chmod -R 700 lab0
rm -r lab0