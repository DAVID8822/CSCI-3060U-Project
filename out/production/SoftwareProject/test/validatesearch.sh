#!/bin/bash
#This test compares the expected output of search to the actual output
for i in {1..4}; do #Loops through each file
echo "testing expected search and output search $i"
diff expectedOutputs/search/search_dailytransaction$i output/search/search_dailytransaction$i #Comparing the daily transaction output to expected daily transaction
diff expectedOutputs/search/search_out$i.txt output/search/search_out$i.txt #Comparing the output files to expected output
done