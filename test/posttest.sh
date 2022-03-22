#!/bin/bash
i=0
for FILE in "Input/post"/*.txt; do #Loop through each file
i=$(( i + 1 ))
echo "POST TEST "${i}" COMPLETE"
cd ../
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/post/post_out"${i}".txt"
cat "dailyTransactions.txt" > "test/Output/post/post_dailytransaction"${i} 
cd test
done

