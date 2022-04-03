#!/bin/bash
#This test compares the expected output of logout to the actual output
for i in {1..4}; do #Loops through each file
echo "testing expected logout and output logout $i"
diff expectedOutputs/logout/logout_dailytransaction$i output/logout/logout_dailytransaction$i #Comparing the daily transaction output to expected daily transaction
diff expectedOutputs/logout/logout_out$i.txt output/logout/logout_out$i.txt #Comparing the output files to expected output
done