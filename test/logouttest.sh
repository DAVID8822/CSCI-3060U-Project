#!/bin/bash
i=0
for FILE in "Input/logout"/*.txt; do #Loop through each file
i=$(( i + 1 ))
echo "LOGOUT TEST "${i}" COMPLETE"
cd ../
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/logout/logout_out"${i}".txt"
cat "dailyTransactions.txt" > "test/Output/logout/logout_dailytransaction"${i} 
cd test
done

