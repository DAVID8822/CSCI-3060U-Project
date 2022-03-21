#!/bin/bash
#readarray  a < $FILE 
#echo "${a[@]}"  | java otbnb.java  rentals.txt users.txt dailyTransactions.txt  
i=0
for FILE in "Input/create"/*.txt; do #Loop through each file
i=$(( i + 1 ))
cd ../
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/create/create_out"${i}".txt"
cd test
done

