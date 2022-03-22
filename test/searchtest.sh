#!/bin/bash
i=0
for FILE in "Input/search"/*.txt; do #Loop through each file
i=$(( i + 1 ))
echo "SEARCH TEST "${i}" COMPLETE"
cd ../
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/search/search_out"${i}".txt"
cat "dailyTransactions.txt" > "test/Output/search/search_dailytransaction"${i} 
cd test
done

