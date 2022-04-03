#!/bin/bash
#This test compares the expected output of post to the actual output
for i in {1..4}; do #Loops through each file
echo "testing expected post and output post $i"
diff expectedOutputs/post/post_dailytransaction$i output/post/post_dailytransaction$i #Comparing the daily transaction output to expected daily transaction
diff expectedOutputs/post/post_out$i.txt output/post/post_out$i.txt #Comparing the output files to expected output
done